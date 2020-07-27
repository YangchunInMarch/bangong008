/**   
 * @Title: MeetingroomDao.java
 * @Package: com.qq.dao 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午1:57:52 
 */
package com.qq.dao;

import java.util.List;

import com.qq.entity.Meetingroom;

/**   
* @ClassName: MeetingroomDao
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午1:57:52 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
public interface MeetingroomDao extends ICommonDao<Meetingroom>{

	//根据会议室的状态查询会议室
	List<Meetingroom> selectState(int state);
	  //通过会议室的名称获取会议室
	  Meetingroom findObjectByName(String roomname);
}
