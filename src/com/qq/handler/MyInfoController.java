/**   
 * @Title: MyInfoController.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月19日 上午11:09:53 
 */
package com.qq.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qq.common.BanResult;
import com.qq.common.JudgeEmpty;
import com.qq.common.MD5Util;
import com.qq.entity.Employee;
import com.qq.service.EmployeeService;

/**   
* @ClassName: MyInfoController
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 上午11:09:53 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Controller
@RequestMapping("myInfo")
public class MyInfoController {

	@Autowired
	private EmployeeService employeeService;
	
	/**   
	* @Function: myInfo
	* @Description: 通过员工的工号，获取员工信息，传递到前台
	* @param: @return  
	* @return：String
	* @throws： 
	*
	* @version: v1.0.0
	* @author: 刘紫薇
	* @date: 2020年3月19日 上午11:10:56          
	*/
	@RequestMapping("myInfo")
	public String myInfo() {
		
		return "myInfo";
	}
	
	/**   
	* @Function: alterInfo
	* @Description: 跳转到修改个人信息界面
	* @param: @return  
	* @return：String
	* @throws： 
	*
	* @version: v1.0.0
	* @author: 刘紫薇
	* @date: 2020年3月19日 下午12:12:20          
	*/
	@RequestMapping("alterInfo")
	public String alterInfo() {
		
		return "myInfoAlter";
	}
	
	/**   
	* @Function: toAlterInfo
	* @Description: 修改个人信息
	* @param: @return  
	* @return：String
	* @throws： 
	*
	* @version: v1.0.0
	* @author: 刘紫薇
	* @date: 2020年3月19日 下午12:12:34          
	*/
	@RequestMapping("toAlterInfo")
	@ResponseBody
	public BanResult toAlterInfo(String uphone,String uemail,String upass,String upassNew,HttpServletRequest request) {
		BanResult result=new BanResult();
		//获取用户输入
		System.out.println(uphone+","+uemail+","+upass+","+upassNew);
		HttpSession session=request.getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		//1.判断输入密码是否与数据库一致
		String passDB=employee.getUpass();
		if(JudgeEmpty.notEquals(MD5Util.MD5(upass), passDB)) {
			result.setSuccess(false);
			return result;
		}
		//2.更新个人信息
		employee.setUphone(uphone);
		employee.setUemail(uemail);
		employee.setUpass(MD5Util.MD5(upassNew));
		employeeService.update(employee);
		result.setSuccess(true);
		session.setAttribute("employee", employee);
		return result;
	}
	
}
