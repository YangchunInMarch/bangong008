/**   
 * @Title: NoticeController.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午9:11:55 
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
import org.springframework.web.bind.annotation.RequestParam;

import com.qq.common.BanUUID;
import com.qq.common.JudgeEmpty;
import com.qq.entity.Employee;
import com.qq.entity.Notice;
import com.qq.service.NoticeService;

/**   
* @ClassName: NoticeController
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午9:11:55 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping("notice")
	public String notice() {
		return "notice";
	}
	
	//公共列表
	@RequestMapping("noticeList")
	public String noticeList(@RequestParam(required = false)String ntitle ,Model model) {
		if(JudgeEmpty.isEmpty(ntitle)) {
			List<Notice> lists=noticeService.selectAll();
			model.addAttribute("lists", lists);
		}else {
			List<Notice> lists=noticeService.selectByTitle(ntitle);
			model.addAttribute("lists", lists);
		}
		
		return "noticeList";
	}
	
	//公告详情
	@RequestMapping("lookNotice")
	public String lookNotice(String id,Model model) {
		 
			Notice notice=noticeService.findObjectById(id);
			model.addAttribute("notice", notice);
		
		return "noticeLook";
	}	
	//删除公告
	@RequestMapping("deleteNotice")
	public String deleteNotice(String id) {
		noticeService.deleteByIds(id); 
		return "redirect:noticeList";
	}
	
	//发布公告 
	@RequestMapping("noticeAdd")
	public String noticeAdd() {
		return "noticeAdd";
	}
	//发布公告 ，保存
	@RequestMapping("noticeAddSave")
	public String noticeAddSave(Notice notice,HttpServletRequest request) {
		HttpSession session=request.getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		 
		notice.setId(BanUUID.getUUID());
		notice.setNpeople(employee.getUname());
		notice.setNpeopleid(employee.getId());
		notice.setNtime(new Date());
		noticeService.save(notice);
		return "redirect:noticeList";
	}	
	
	 
}
