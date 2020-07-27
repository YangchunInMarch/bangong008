/**   
 * @Title: MainController.java
 * @Package: com.qq.handler 
 * @author: 刘紫薇
 * @date: 2020年3月19日 上午9:14:19 
 */
package com.qq.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qq.entity.Notice;
import com.qq.service.NoticeService;

/**   
* @ClassName: MainController
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 上午9:14:19 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Controller
@RequestMapping("main")
public class MainController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("toMain")
	public String toMain(Model model) {
		Notice notice = noticeService.selectOne();
		model.addAttribute("notice", notice);
		return "main";
	}
	
	@RequestMapping("help")
	public String help() {
		return "help";
	}
	
	@RequestMapping("loginout")
	public String loginout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("employee");
		return "login";
	}
	
}
