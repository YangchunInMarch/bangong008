/**   
 * @Title: EmployeeManagerCon.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月20日 上午10:04:06 
 */
package com.qq.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qq.common.JudgeEmpty;
import com.qq.entity.Employee;
import com.qq.service.EmployeeService;

/**   
* @ClassName: EmployeeManagerCon
* @Description: 员工管理
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 上午10:04:06 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Controller
@RequestMapping("/manager")
public class EmployeeManagerCon {

	@Autowired
	private EmployeeService  employeeService;
	
	//进入员工管理的主界面
	@RequestMapping("/employee")
	public String managerEmployee() {
		
		return "employeeManage";
	}
	
	//右边提示内容
	@RequestMapping("/right")
	public String right() {
		
		return "right";
	}
	
	//员工列表
	@RequestMapping("/employList")
	public String employList(HttpServletRequest request,Model model) {
	//	HttpSession session = request.getSession();
	//	Employee employee=(Employee) session.getAttribute("employee");
		//获取所有的员工
		List<Employee> lists= employeeService.selectAll();
		model.addAttribute("lists", lists);
		return "employList";
	}
	
	//按照部门查看员工
		@RequestMapping("/employDepart")
		public String employDepart(String depart,Model model) {
		//	HttpSession session = request.getSession();
		//	Employee employee=(Employee) session.getAttribute("employee");
			//获取所有的员工
			List<Employee> lists= employeeService.selectEmployeeByDepart(depart);
			model.addAttribute("lists", lists);
			return "employList";
		}
		
		//转至添加员工页面
		@RequestMapping("/employAdd")
		public String employAdd(Model model) {
			//格式化时间
			SimpleDateFormat format=new SimpleDateFormat("yyMMddHHmmssSSS");
			String id="A"+format.format(new Date());
			model.addAttribute("eid", id);
			return "employAdd";
		}	
		
		//保存添加员工页面
		@RequestMapping("/employSave")
		public String employSave(Employee employee,Model model) {
			employeeService.save(employee);
			model.addAttribute("em", employee);
			return "employSaveSuc";
		}	
		
		//调整部门页面
		@RequestMapping("/employAlter")
		public String employAlter() {
			return "employAlter";
		}	
	
		//调整部门页面
		@RequestMapping("/employAlterSelect")
		public String employAlterSelect(String id,Model model) {
			Employee em= employeeService.findObjectById(id);
			model.addAttribute("em", em);
			return "employAlter";
		}
				
		//调整部门页面,保存
		@RequestMapping("/employAlterSave")
		public String employAlterSave(String id,String depart,Model model) {
		  Employee em=employeeService.findObjectById(id);
		  em.setDepartment(depart);
		  employeeService.update(em);
		  model.addAttribute("em", em);
		  return "employAlterSuc";
		}			
	//转至离职页面
		@RequestMapping("/employAway")
		public String employAway(@RequestParam(required = false)String id ,Model model) {
		if(JudgeEmpty.isEmpty(id)) {
			 return "employAway";
		}
		 Employee em=employeeService.findObjectById(id);
		  model.addAttribute("em", em);
		  return "employAway";
		}	
		//提交离职信息
		@RequestMapping("/employAwaySave")
		public String employAwaySave(String id) {
		//System.out.println("需要离职的人员："+id);
		employeeService.deleteByIds(id);
		  return "employAwaySuc";
		}			
}
