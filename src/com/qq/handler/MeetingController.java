/**   
 * @Title: MeetingController.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午4:48:10 
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.qq.common.BanResult;
import com.qq.common.BanUUID;
import com.qq.entity.Emails;
import com.qq.entity.Employee;
import com.qq.entity.Meeting;
import com.qq.entity.Meetingroom;
import com.qq.service.EmailsService;
import com.qq.service.EmployeeService;
import com.qq.service.MeetingService;
import com.qq.service.MeetingroomService;

/**   
* @ClassName: MeetingController
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午4:48:10 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Controller
@RequestMapping("meeting")
public class MeetingController {

	@Autowired
	private MeetingService  meetingService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private MeetingroomService meetingroomService;
	@Autowired
	private EmailsService  emailsService;
	 
	//跳转至会议界面
	@RequestMapping("meeting")
	public String meeting() {
		return "meeting";
		
	}
	
	//根据会议状态，查看会议
	@RequestMapping("look")
	public String look(int mstate,HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		List<Meeting> lists=meetingService.selectByLeaderState(employee.getId(), mstate);
		model.addAttribute("lists", lists);
		return "meetingList";
	}
	
	//查看会议详情
	@RequestMapping("meetingLook")
	public String meetingLook(String id,Model model) {
		Meeting meeting = meetingService.findObjectById(id);
		model.addAttribute("meeting", meeting);	
		return "meetingLook";
	}
	
	//标记会议,
	@RequestMapping("targetMeeting")
	public String targetMeeting(String id,Model model) {
		Meeting meeting = meetingService.findObjectById(id);
		meeting.setMstate(1); //标记为已经处理
		meetingService.update(meeting); 
		//释放会议室
		//1.通过会议室的名字，找到会议室
		Meetingroom  room=meetingroomService.findObjectByName(meeting.getMroomname());
		//2.释放会议室
		room.setRoomstate(0);
		meetingroomService.update(room);
		return "redirect:look?mstate=0";
	}	
	
	//删除已经标记的会议  
	//标记会议,
	@RequestMapping("deleteMeeting")
	public String deleteMeeting(String id,Model model) {
		meetingService.deleteByIds(id);
		return "redirect:look?mstate=1";
	}	
	
	//召开会议，添加会员
	@RequestMapping("meetingAdd")
	public String meetingAdd(Model model) {
		 //会议室列表
		List<Meetingroom> lists_room=meetingroomService.selectState(0);
		
		//邀请人员列表
		List<Employee> lists_employee=employeeService.selectEmployeeByDepart("4");
		model.addAttribute("lists_room", lists_room);
		model.addAttribute("lists_employee", lists_employee);
		
		return "meetingAdd";
	}		

	//召开会议，添加会一
	@RequestMapping("meetingAddSave")
	@ResponseBody
	public BanResult meetingAddSave(Meeting meeting,HttpServletRequest request) {
		BanResult result=new BanResult();
		HttpSession session=request.getSession();
		Employee em_session=(Employee) session.getAttribute("employee");
		//添加会一
		meeting.setId(BanUUID.getUUID());
		meeting.setMtime(new Date());
		//获取邀请人的ID
		String mpeopleId=meeting.getMperson();
		//从ID中检索出，名字，并将名字存入数据库
		String[] ids=mpeopleId.split(",");
		String ping="";  //名字的字符串
		for(String id:ids) {
		  //System.out.println(str);
		 //从ID中检索出，名字,并给这个人发送邮件
			Employee employ=employeeService.findObjectById(id);
			String uname=employ.getUname();
	    	ping+=uname+",";
	    	//发送邮件
	    	Emails emails=new Emails();
	    	emails.setId(BanUUID.getUUID());
	    	emails.setEfrom(em_session.getId());
	    	emails.setEfromName(em_session.getUname());
	    	emails.setEsend(id);
	    	emails.setEsendName(uname);
	    	emails.setEtitle(meeting.getMtitle());
	    	emails.setEcontent(meeting.getMcontent());
	    	emails.setEstate(0); //未读
	    	emails.setEtime(new Date());
	    	emailsService.save(emails);
		}
		
		meeting.setMperson(ping);
		meetingService.save(meeting);
		//设置会议室的使用状态
		//通过会议室的名称，设置会议室的状态(前提，会议室的名称唯一)
		System.out.println("----------"+meeting.getMroomname());
		Meetingroom  room=meetingroomService.findObjectByName(meeting.getMroomname());
		room.setRoomstate(1);
		meetingroomService.update(room); //设置会议室的状态
		result.setSuccess(true);
		return result;
	}		
	
	
}
