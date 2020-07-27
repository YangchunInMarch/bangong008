/**   
 * @Title: EmployeeController.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月18日 下午8:37:57 
 */
package com.qq.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qq.common.BResult;
import com.qq.common.BanResult;
import com.qq.common.JudgeEmpty;
import com.qq.common.MD5Util;
import com.qq.entity.Employee;
import com.qq.service.EmployeeService;

/**   
* @ClassName: EmployeeController
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月18日 下午8:37:57 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService  mployeeService;
	
	/**   
	* @Function: login01
	* @Description: 登录
	* @param: @param employee
	* @param: @return  
	* @return：BanResult
	* @throws： 
	*
	* @version: v1.0.0
	* @author: 刘紫薇
	* @date: 2020年3月19日 上午10:41:56          
	*/
	@RequestMapping("/login")
	@ResponseBody
	public BanResult login01(Employee employee,HttpServletRequest request) {
		BanResult result=new BanResult();
		//通过登录名获取用户数据判断登录是否成功
		
		System.out.println(employee.getId()+","+employee.getUpass());
		Employee em=mployeeService.findObjectById(employee.getId());
	
		if(JudgeEmpty.isEmpty(em)) {
			result.setSuccess(false);
			return result;
		}
		
		if(JudgeEmpty.notEquals(MD5Util.MD5(employee.getUpass()), em.getUpass())) {
			//密码输入错误
			result.setSuccess(false);
			return result;
		}
		System.out.println(em.getUname()+","+em.getUpass());
		
		result.setSuccess(true);
		HttpSession session = request.getSession();
		session.setAttribute("employee", em);
		return result;
	}
	
	/**   
	* @Function: register
	* @Description: 注册
	* @param: @param employee
	* @param: @return  
	* @return：BanResult
	* @throws： 
	*
	* @version: v1.0.0
	* @author: 刘紫薇
	* @date: 2020年3月19日 上午10:42:08          
	*/
	@RequestMapping("/register")
	@ResponseBody
	public BanResult register(Employee employee) {
		BanResult result=new BanResult();
		System.out.println(employee.getId()+","+employee.getUpass()+","+employee.getUphone());
		Employee em=mployeeService.findObjectById(employee.getId());
		//1.判断工号是否输入正确
		if(JudgeEmpty.isEmpty(em)) {
			result.setSuccess(false);
			return result;
		}
		//2.判断手机号是否输入正确
	    String phoneDB=	em.getUphone();
	    if(JudgeEmpty.notEquals(phoneDB, employee.getUphone())) {
	    	result.setSuccess(false);
			return result;
	    }
	  //3.判断密码是否为空，在没有注册的情况下，密码为空
	    if(!JudgeEmpty.isEmpty(em.getUpass())) {
	    	result.setSuccess(false);
			return result;
	    }
	  //4.更新数据库中的密码
	    em.setUpass(MD5Util.MD5(employee.getUpass()));
	    mployeeService.update(em);
	    result.setSuccess(true);
		return result;
	}
	
	
	
	//转至登录界面
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}
}
