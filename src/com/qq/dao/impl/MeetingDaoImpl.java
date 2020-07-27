/**   
 * @Title: MeetingDaoImpl.java
 * @Package: com.qq.dao.impl 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午1:01:38 
 */
package com.qq.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qq.dao.MeetingDao;
import com.qq.entity.Meeting;

/**   
* @ClassName: MeetingDaoImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午1:01:38 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Component("meetingDao")
public class MeetingDaoImpl implements MeetingDao{

	@Autowired
	private SessionFactory  sessionFactory;
	
	@Override
	public void save(Meeting entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);	
	}

	
	@Override
	public void update(Meeting entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public Meeting findObjectById(Object id) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Meeting m where m.id='"+id+"'");
		Meeting mm=(Meeting) query.uniqueResult();

		return mm;
	}

	
	@Override
	public void deleteByIds(Object id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete Meeting m where m.id='"+id+"'").executeUpdate();	
	}

	
	@Override
	public List<Meeting> selectByLeaderState(String leader, int mstate) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Meeting m where m.mleader=? and m.mstate=?  order by mtime desc ");
		query.setString(0, leader);
		query.setInteger(1, mstate);
		List lists=query.list();
		return lists;
	}

}
