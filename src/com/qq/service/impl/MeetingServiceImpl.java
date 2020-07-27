/**   
 * @Title: MeetingServiceImpl.java
 * @Package: com.qq.service.impl 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午1:10:08 
 */
package com.qq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qq.dao.MeetingDao;
import com.qq.entity.Meeting;
import com.qq.service.MeetingService;

/**   
* @ClassName: MeetingServiceImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午1:10:08 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Transactional
@Service("meetingService")
public class MeetingServiceImpl implements MeetingService{

	@Autowired
	private MeetingDao meetingDao;

	/** 
	* @see com.qq.service.MeetingService#selectByLeaderState(java.lang.String, int)  
	* @Function: MeetingServiceImpl.java
	* @Description: TODO
	*
	* @param: @param leader
	* @param: @param mstate
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午1:11:56 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Meeting> selectByLeaderState(String leader, int mstate) {
		// TODO Auto-generated method stub
		return meetingDao.selectByLeaderState(leader, mstate);
	}

	/** 
	* @see com.qq.service.MeetingService#save(com.qq.entity.Meeting)  
	* @Function: MeetingServiceImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午1:11:56 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void save(Meeting entity) {
		// TODO Auto-generated method stub
		meetingDao.save(entity);
	}

	/** 
	* @see com.qq.service.MeetingService#update(com.qq.entity.Meeting)  
	* @Function: MeetingServiceImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午1:11:56 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void update(Meeting entity) {
		// TODO Auto-generated method stub
		meetingDao.update(entity);
	}

	/** 
	* @see com.qq.service.MeetingService#findObjectById(java.lang.Object)  
	* @Function: MeetingServiceImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午1:11:56 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public Meeting findObjectById(Object id) {
		// TODO Auto-generated method stub
		return meetingDao.findObjectById(id);
	}

	/** 
	* @see com.qq.service.MeetingService#deleteByIds(java.lang.String)  
	* @Function: MeetingServiceImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午1:11:56 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void deleteByIds(String id) {
		// TODO Auto-generated method stub
		meetingDao.deleteByIds(id);
	}
}
