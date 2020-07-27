/**   
 * @Title: MeetingService.java
 * @Package: com.qq.service 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午1:08:43 
 */
package com.qq.service;

import java.util.List;

import com.qq.entity.Meeting;

/**   
* @ClassName: MeetingService
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午1:08:43 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
public interface MeetingService {

	//通过会议的开会人，会议的召开状态查询会议
		List<Meeting> selectByLeaderState(String leader,int mstate);
		
		void save(Meeting entity);	
	    void update(Meeting entity);
		Meeting findObjectById(Object id);
		void deleteByIds(String id);
}
