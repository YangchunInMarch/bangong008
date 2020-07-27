/**   
 * @Title: UploadfileController.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午10:13:38 
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

import com.qq.common.BanUUID;
import com.qq.common.MyConstant;
import com.qq.entity.Emails;
import com.qq.entity.Employee;
import com.qq.entity.Uploadfile;
import com.qq.service.UploadfileService;

import sun.misc.BASE64Encoder;

/**   
* @ClassName: UploadfileController
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午10:13:38 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Controller
@RequestMapping("upfile")
public class UploadfileController {

	@Autowired
	private UploadfileService  uploadfileService;
	
	@RequestMapping("upfile")
	public String upfile(HttpServletRequest request) {
		return "shareFile";
	}
	
	@RequestMapping("share")
	public String share(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		List<Uploadfile> lists=uploadfileService.selectFileByDepart(employee.getDepartment());
	    model.addAttribute("lists", lists);
		return "share";
	}
	
	//selectFile
	@RequestMapping("selectFile")
	public String selectFile(String uploadfile,HttpServletRequest request,Model model) {
		System.out.println("-------"+uploadfile);
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		List<Uploadfile> lists=uploadfileService.selectFileByFileName(uploadfile, employee.getDepartment());
	    model.addAttribute("lists", lists);
	    System.out.println(lists);
		return "share";
	}
	
	//upload
	@RequestMapping("upload")
	public String upload() {
		return "shareUpload";
	}
	
	
	//upload
	@RequestMapping("uploadFile")
	public  String uploadFile(@RequestParam("uploadfile") CommonsMultipartFile uploadFile,
			@RequestParam("title") String title,	HttpServletRequest request) throws IOException {
		
		    
			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");
            
			InputStream input = uploadFile.getInputStream();

			String fileName = uploadFile.getOriginalFilename();
			String fileRoute = MyConstant.uploadPath + fileName;
			OutputStream output = new FileOutputStream(fileRoute);

			byte[] bs = new byte[1024];
			int len = 1;
			while ((len = input.read(bs)) != -1) {
				output.write(bs, 0, len);
			}
			output.close();
			input.close();
	      	
			Uploadfile uf=new Uploadfile();
			uf.setId(BanUUID.getUUID());
			uf.setUploadperson(employee.getId());
			uf.setDepartmentid(employee.getDepartment());
			uf.setUploadfile(fileName);
			uf.setTitle(title);
			uf.setUploadtime(new Date());
			uploadfileService.save(uf);
        	return "redirect:share";
	}

	@RequestMapping(value = "download", method = RequestMethod.GET)
	@ResponseBody
	public void download(@RequestParam("fileName") String fileName, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");// 只能解决post方法的乱码
		String downloadPath = MyConstant.uploadPath + fileName;
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

	//删除文件 
	@RequestMapping("deleteFile")
	public String deleteFile(String id) {
		uploadfileService.deleteByIds(id);
		return "redirect:share";
	}
	
}
