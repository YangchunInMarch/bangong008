/**   
 * @Title: SigninController.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午11:21:17 
 */
package com.qq.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qq.common.BanResult;
import com.qq.common.BanUUID;
import com.qq.common.JudgeEmpty;
import com.qq.common.MyUtils;
import com.qq.entity.Employee;
import com.qq.entity.Signin;
import com.qq.service.SigninService;

/**
 * @ClassName: SigninController
 * @Description: TODO
 *
 * @version: v1.0.0
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午11:21:17
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2020年3月20日
 *        Administrator v1.0.0 修改原因
 */
@Controller
@RequestMapping("signin")
public class SigninController {

	@Autowired
	private SigninService siginService;

	// 进入签到页面
	@RequestMapping("signin")
	public String signin() {
		return "signin";
	}

	// 进入签到页面
	@RequestMapping("signinToday")
	public String signinToday(HttpServletRequest request, Model model) {
		
		System.out.println("-signinToday---------------------");
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date d=new Date();
		String time_now = format.format(d);
		
		// 先判断，今日的打卡是否创建
		Signin sign_db = siginService.selectByEidTime(employee.getId(), time_now);
		
		
		if (JudgeEmpty.isEmpty(sign_db)) {
			// 1.没有创建，进行创建
			Signin sign = new Signin();
			sign.setId(BanUUID.getUUID());
			sign.setEmployeeid(employee.getId());
			sign.setStime(time_now);
			sign.setOffState(0);
			sign.setOnState(0);
			siginService.save(sign);
		}
		
		// 2.已经创建，不做操作
		model.addAttribute("signin", sign_db);
		return "signinToday";
	}

	// 点击打卡按钮
	@RequestMapping("signinCard")
	public String signinCard(String target, String id, HttpServletRequest request, Model model) {
		
		Signin sign = siginService.findObjectById(id);
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date d= new Date();
		String time_now=format.format(d);
		
		if (JudgeEmpty.isEquals(target, "1")) {
			// 用户点击的是打上午卡的按钮
			sign.setOnduty(time_now);
			sign.setOnState(1);
		}
		
		if (JudgeEmpty.isEquals(target, "2")) {
			// 用户点击的是打下午卡的按钮
			sign.setOffduty(time_now);
			sign.setOffState(1);
		}
		siginService.update(sign);
		model.addAttribute("signin", sign);
		return "signinToday";
	}

	// 进入签到历史页面
	@RequestMapping("signinRecent")
	public String signinRecent(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		List<Signin> lists = siginService.selectThree(employee.getId());
		model.addAttribute("lists", lists);
		return "signinRecent";
	}

	// selectSignin


	@RequestMapping("selectSignin")
	public String selectSignin(String stime,HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		List<Signin> lists = siginService.selectTime(employee.getId(), stime);
		model.addAttribute("lists", lists);
		return "signinRecent";
	}
}
