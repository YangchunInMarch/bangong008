/**   
 * @Meetingitle: MeetingDao.java
 * @Package: com.qq.dao 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午12:53:04 
 */
package com.qq.dao;

import java.util.List;

import com.qq.entity.Meeting;

/**   
* @ClassName: MeetingDao
* @Description: MeetingODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午12:53:04 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
public interface MeetingDao extends ICommonDao<Meeting>{

	  
	//通过会议的开会人，会议的召开状态查询会议
	List<Meeting> selectByLeaderState(String leader,int mstate);
	
	//通过会议标题搜索会议
	
}
