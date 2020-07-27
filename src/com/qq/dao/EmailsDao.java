/**   
 * @Title: EmailsDao.java
 * @Package: com.qq.dao 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午3:57:33 
 */
package com.qq.dao;

import java.util.List;

import com.qq.entity.Emails;

/**   
* @ClassName: EmailsDao
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午3:57:33 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
public interface EmailsDao extends ICommonDao<Emails>{

	//通过 邮件的发送者与邮件的状态，获取邮件
	List<Emails> selectEmailByFromState(String esend,int estate);
	//通过 邮件的发送者，获取邮件,用于搜索
	List<Emails> selectEmailByFrom(String esend,String efromName);
	//我发送的邮件
	List<Emails> selectEmail(String efrom);
}
