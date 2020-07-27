/**   
 * @Title: HelloController.java
 * @Package: com.qq.handler 
 * @author: 阳春三月   
 * @date: 2020年3月18日 下午12:38:00 
 */
package com.qq.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
* @ClassName: HelloController
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月18日 下午12:38:00 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
}
