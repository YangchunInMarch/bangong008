/**   
 * @Title: GoalsController.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午2:02:07 
 */
package com.qq.handler;

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
import com.qq.entity.Employee;
import com.qq.entity.Goals;
import com.qq.service.GoalsService;

/**   
* @ClassName: GoalsController
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午2:02:07 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Controller
@RequestMapping("/goals")
public class GoalsController {

	@Autowired
	private GoalsService goalsService;
	
	/**   
	* @Function: toGoals
	* @Description: 跳转到 日程计划的页面，并从数据库提取信息
	* @param: @param request
	* @param: @param model
	* @param: @return  
	* @return：String
	* @throws： 
	*
	* @version: v1.0.0
	* @author: 刘紫薇
	* @date: 2020年3月19日 下午2:28:46          
	*/
	@RequestMapping("/goals")
	public String toGoals(HttpServletRequest request,Model model) {
	HttpSession session=request.getSession();
	Employee employee=(Employee) session.getAttribute("employee");
	List<Goals> lists=goalsService.selectUid(employee.getId());
	model.addAttribute("lists", lists);
	return "work";
	}
	
	//仅仅为了跳转到添加日程页面
	@RequestMapping("/workAdd")
	public String workAdd() {
	return "workAdd";
	}
	
	//保存 添加日程页面 的数据
	@RequestMapping("/workAddtoSave")
	@ResponseBody
	public BanResult workAddtoSave(Goals goals,HttpServletRequest request) {
		BanResult result=new BanResult();
		HttpSession session=request.getSession();
		Employee employee=(Employee) session.getAttribute("employee");	
		goals.setUid(employee.getId());
		goals.setId(BanUUID.getUUID());
		goals.setTime(new Date());
		goalsService.save(goals);
		result.setSuccess(true);
	    return result;
	}
	
	
}
