/**   
 * @Meetingroomitle: MeetingroomService.java
 * @Package: com.qq.service 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午2:05:56 
 */
package com.qq.service;

import java.util.List;

import com.qq.entity.Meetingroom;

/**   
* @ClassName: MeetingroomService
* @Description: MeetingroomODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午2:05:56 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
public interface MeetingroomService {

	//根据会议室的状态查询会议室
		List<Meetingroom> selectState(int state);
		
		  void save(Meetingroom entity);	
		  void update(Meetingroom entity);
		  Meetingroom findObjectById(Object id);
		  void deleteByIds(Object id);
		  
		  //通过会议室的名称获取会议室
		  Meetingroom findObjectByName(String roomname);
}
