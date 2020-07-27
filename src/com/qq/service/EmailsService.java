/**   
 * @Title: EmailsService.java
 * @Package: com.qq.service 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午4:14:15 
 */
package com.qq.service;

import java.util.List;

import com.qq.entity.Emails;

/**   
* @ClassName: EmailsService
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午4:14:15 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
public interface EmailsService {

	//通过 邮件的发送者与邮件的状态，获取邮件
		List<Emails> selectEmailByFromState(String esend,int estate);
		//通过 邮件的发送者，获取邮件
		List<Emails> selectEmailByFrom(String esend,String efrom);
		//保存邮件
		void save(Emails entity);	
		
		void update(Emails entity);	
		 //删除邮件 
		void deleteById(String id);
		//我发送的邮件
		List<Emails> selectEmail(String efrom);
		
		Emails findObjectById(Object id);
}
