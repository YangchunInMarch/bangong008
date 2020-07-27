/**   
 * @Title: MeetingroomDaoImpl.java
 * @Package: com.qq.dao.impl 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午1:59:59 
 */
package com.qq.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qq.dao.MeetingroomDao;
import com.qq.entity.Meetingroom;

/**   
* @ClassName: MeetingroomDaoImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午1:59:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Component("meetingroomDao")
public class MeetingroomDaoImpl implements MeetingroomDao {

	@Autowired
	private SessionFactory sessionFactory;
	/** 
	* @see com.qq.dao.ICommonDao#save(java.lang.Object)  
	* @Function: MeetingroomDaoImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午2:00:13 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void save(Meetingroom entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	/** 
	* @see com.qq.dao.ICommonDao#update(java.lang.Object)  
	* @Function: MeetingroomDaoImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午2:00:13 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void update(Meetingroom entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	/** 
	* @see com.qq.dao.ICommonDao#findObjectById(java.lang.Object)  
	* @Function: MeetingroomDaoImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午2:00:13 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public Meetingroom findObjectById(Object id) {
		// TODO Auto-generated method stub
		Query	query=sessionFactory.getCurrentSession().createQuery("from Meetingroom mm where mm.id="+id+"");
		
		return (Meetingroom) query.uniqueResult();
	}

	/** 
	* @see com.qq.dao.ICommonDao#deleteByIds(java.lang.Object)  
	* @Function: MeetingroomDaoImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午2:00:13 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void deleteByIds(Object id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete Meetingroom mm where mm.id='"+id+"'").executeUpdate();
	}

	/** 
	* @see com.qq.dao.MeetingroomDao#selectState(int)  
	* @Function: MeetingroomDaoImpl.java
	* @Description: TODO
	*
	* @param: @param state
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午2:00:13 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Meetingroom> selectState(int state) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Meetingroom mm where mm.roomstate=?");
		query.setInteger(0, state);
		List<Meetingroom> list=query.list();
		return list;
	}

	/** 
	* @see com.qq.dao.MeetingroomDao#findObjectByName(java.lang.String)  
	* @Function: MeetingroomDaoImpl.java
	* @Description: TODO
	*
	* @param: @param roomname
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 下午6:30:20 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public Meetingroom findObjectByName(String roomname) {
         Query query=sessionFactory.getCurrentSession().createQuery("from Meetingroom mm where mm.roomname=?");
         query.setString(0, roomname);
		return (Meetingroom) query.uniqueResult();
	}

}
