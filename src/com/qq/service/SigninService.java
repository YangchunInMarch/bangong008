/**   
 * @Title: SigninService.java
 * @Package: com.qq.service 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午11:00:15 
 */
package com.qq.service;

import java.util.List;

import com.qq.entity.Signin;

/**   
* @ClassName: SigninService
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午11:00:15 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
public interface  SigninService {

	//增加
	 void save(Signin entity);	
	//修改
	 void update(Signin entity);
	
	//查询
	Signin  findObjectById(String id);
	//根据员工id，stime查询打卡
	Signin selectByEidTime(String employeeid,String stime) ;
	//获取最近30天的打卡情况
	List<Signin> selectThree(String employeeid);
	
	//根据时间查询打卡情况
	List<Signin> selectTime(String employeeid,String stime);
}
