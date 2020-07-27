/**   
 * @Title: BanInterceper.java
 * @Package: com.qq.intercepter 
 * @author: 刘紫薇
 * @date: 2020年3月21日 上午10:13:30 
 */
package com.qq.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qq.common.JudgeEmpty;
import com.qq.entity.Employee;

/**   
* @ClassName: BanInterceper
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月21日 上午10:13:30 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月21日     Administrator           v1.0.0               修改原因
*/
public class BanInterceper implements HandlerInterceptor{

	//后置通知
		@Override
		public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

		
		@Override
		public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

	    //前置通知
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

			HttpSession session=request.getSession();
			Employee employee=(Employee) session.getAttribute("employee");
			if(JudgeEmpty.isEmpty(employee)) {
				String path = request.getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
						+ path + "/";
				response.sendRedirect(basePath+"employee/toLogin");
				return false;
			}else {
				
				return true;
			}
			
		}
}
