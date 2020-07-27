/**   
 * @Title: EmailsController.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午5:12:54 
 */
package com.qq.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qq.common.BanResult;
import com.qq.common.BanUUID;
import com.qq.common.JudgeEmpty;
import com.qq.common.MyConstant;
import com.qq.entity.Emails;
import com.qq.entity.Employee;
import com.qq.service.EmailsService;
import com.qq.service.EmployeeService;

import sun.misc.BASE64Encoder;

/**
 * @ClassName: EmailsController
 * @Description: TODO
 *
 * @version: v1.0.0
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午5:12:54
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2020年3月19日
 *        Administrator v1.0.0 修改原因
 */
@Controller
@RequestMapping("/email")
public class EmailsController {

	@Autowired
	private EmailsService emailsService;
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/email") // 查看没有阅读的邮件
	public String email(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		List<Emails> lists = emailsService.selectEmailByFromState(employee.getId(), 0); // 默认加载未查看的邮件
		model.addAttribute("lists", lists);
		return "email";
	}

	@RequestMapping("/email02") // 查看已经阅读过的邮件
	public String email02(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		List<Emails> lists = emailsService.selectEmailByFromState(employee.getId(), 1); // 默认加载未查看的邮件
		model.addAttribute("lists", lists);
		return "email";
	}

	@RequestMapping("/selectEmail") // 通过发送者的姓名检索邮件
	public String selectEmail(String efromName, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		List<Emails> lists = emailsService.selectEmailByFrom(employee.getId(), efromName); // 默认加载未查看的邮件
		model.addAttribute("lists", lists);
		return "email";
	}

	@RequestMapping("/selectMe") // 我发送的邮件
	public String selectMe(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		List<Emails> lists = emailsService.selectEmail(employee.getId());
		model.addAttribute("lists", lists);
		return "email";
	}

	// lookEmail查看邮件详情
	@RequestMapping("/lookEmail")
	public String lookEmail(String id, Model model) {
		Emails emails = emailsService.findObjectById(id);
		model.addAttribute("email", emails);
		
		emails.setEstate(1);
		//将邮件标记为已读
		emailsService.update(emails);
		return "emailLook";
	}

	// 标记为已读
	@RequestMapping("/targetEmail")
	public String targetEmail(String id, Model model) {
		Emails emails = emailsService.findObjectById(id);
		emails.setEstate(1);
		emailsService.update(emails);
		return "emailLook";
	}

	// 删除邮件
	@RequestMapping("/deleteEmail")
	public String deleteEmail(String id, Model model) {
		emailsService.deleteById(id);
		return "redirect:email";
	}

	// 回信 ，发送邮件
	@RequestMapping("/replyEmail")
	public String replyEmail(String id, Model model) {
		// 通过员工ID获取员工信息
		Employee employee = employeeService.findObjectById(id);
		model.addAttribute("esend", id);
		model.addAttribute("esendName", employee.getUname());
		return "emailSend";
	}

	// 发送邮件，牵扯到文件的上传
	@RequestMapping("materialUpload")
	public ModelAndView materialUpload(Emails emails, @RequestParam(required = false)CommonsMultipartFile uploadFile,
			HttpServletRequest request) throws IOException {
		ModelAndView mv=new ModelAndView();
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");

		System.out.println("emails：" + emails.getEsend());
		System.out.println(emails.getEtitle() + "," + emails.getEcontent());
		// 上传到本地
		 
        
        	InputStream input = uploadFile.getInputStream();

    		String fileName = uploadFile.getOriginalFilename();
    		String fileRoute = MyConstant.filePath + fileName;
    		OutputStream output = new FileOutputStream(fileRoute);

    		byte[] bs = new byte[1024];
    		int len = 1;
    		while ((len = input.read(bs)) != -1) {
    			output.write(bs, 0, len);
    		}
    		output.close();
    		input.close();
    		emails.setEfile(fileName);
        
	
      
		//构建emails对象，将emails存入数据库
		emails.setId(BanUUID.getUUID());
		
		emails.setEfrom(employee.getId());
		emails.setEfromName(employee.getUname());
		//通过 emails.esend（工号）获取到接收人的姓名
		Employee em=employeeService.findObjectById(emails.getEsend());
		emails.setEsendName(em.getUname());
		emails.setEtime(new Date());
		emails.setEstate(0);
		emailsService.save(emails);
		mv.setViewName("uploadSuc");
		mv.addObject("id", emails.getId());
		return mv;
	}
	

	@RequestMapping(value = "materialDowload", method = RequestMethod.GET)
	@ResponseBody
	public void materialDowload(@RequestParam("fileName") String fileName, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");// 只能解决post方法的乱码
		String downloadPath = MyConstant.filePath + fileName;
		// System.out.println("下载文件路径:"+downloadPath);
		// 获取文件的长度
		long fileLength = new File(downloadPath).length();
		String storeName = fileName; // 存储的名字
		// 获取请求头中的浏览器信息
		String userAgent = request.getHeader("User-Agent");
		if (userAgent.contains("Firefox")) {
			BASE64Encoder encoding = new BASE64Encoder();
			storeName = "=?utf-8?B?" + encoding.encode(storeName.getBytes("utf-8")) + "?=";
		} else {
			storeName = URLEncoder.encode(storeName, "utf-8");
		}

		// 设置文件输出类型，发送给客户端-----设置响应头，告诉浏览器（setContentType，告诉浏览器当前响应文件的类型）（setHeader告诉浏览器当前文件是要下载的）
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition",
				"attachment; filename=" + new String(storeName.getBytes("utf-8"), "ISO8859-1")); // 解码从前台获取过来的文件名

		// 设置输出长度
		response.setHeader("Content-Length", String.valueOf(fileLength));
		// 获取输入流
		FileInputStream fis = new FileInputStream(downloadPath);
		// 输出流
		ServletOutputStream bos = response.getOutputStream();

		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = fis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}

		// 关闭流
		fis.close();
		bos.close();

	}

}
