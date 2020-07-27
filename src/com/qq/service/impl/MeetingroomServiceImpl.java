/**   
 * @Title: MeetingroomServiceImpl.java
 * @Package: com.qq.service.impl 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午2:07:05 
 */
package com.qq.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qq.dao.MeetingroomDao;
import com.qq.entity.Meetingroom;
import com.qq.service.MeetingroomService;

/**   
* @ClassName: MeetingroomServiceImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午2:07:05 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Transactional
@Service("meetingroomService")
public class MeetingroomServiceImpl implements MeetingroomService {

	@Autowired
	private MeetingroomDao meetingroomDao;

	
	@Override
	public List<Meetingroom> selectState(int state) {
		// TODO Auto-generated method stub
		return meetingroomDao.selectState(state);
	}

	
	@Override
	public void save(Meetingroom entity) {
		// TODO Auto-generated method stub
		meetingroomDao.save(entity);
	}

	
	@Override
	public void update(Meetingroom entity) {
		// TODO Auto-generated method stub
		meetingroomDao.update(entity);
	}

	
	@Override
	public Meetingroom findObjectById(Object id) {
		// TODO Auto-generated method stub
		return meetingroomDao.findObjectById(id);
	}


	@Override
	public void deleteByIds(Object id) {
		// TODO Auto-generated method stub
		meetingroomDao.deleteByIds(id);
	}

 
	@Override
	public Meetingroom findObjectByName(String roomname) {
		// TODO Auto-generated method stub
		return meetingroomDao.findObjectByName(roomname);
	}
	
}
