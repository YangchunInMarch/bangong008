/**   
 * @Title: FreindController.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午2:54:30 
 */
package com.qq.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qq.entity.Employee;
import com.qq.service.EmployeeService;

/**   
* @ClassName: FreindController
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午2:54:30 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Controller
@RequestMapping("/friend")
public class FreindController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/friend")
	public String friend(HttpServletRequest request,Model model) {
		
		List<Employee> lists=employeeService.selectAll();
		model.addAttribute("lists", lists);
		return "friend";
	}
	
	@RequestMapping("/selectFriend")
	public String selectFriend(String uname,Model model) {
		
		List<Employee> lists=employeeService.selectName(uname);
		model.addAttribute("listsByName", lists);
		return "friend";
	}
	
	
}
