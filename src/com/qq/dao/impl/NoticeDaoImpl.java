/**   
 * @Title: NoticeDaoImpl.java
 * @Package: com.qq.dao.impl 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午8:46:49 
 */
package com.qq.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qq.dao.NoticeDao;
import com.qq.entity.Notice;

/**   
* @ClassName: NoticeDaoImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午8:46:49 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Component("noticeDao")
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Notice entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Notice entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}
	@Override
	public Notice findObjectById(Object id) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Notice n where n.id=?");
		query.setString(0, (String)id);
		return (Notice) query.uniqueResult();
	}
	@Override
	public void deleteByIds(Object id) {
		sessionFactory.getCurrentSession().createQuery("delete Notice n where n.id='"+id+"'").executeUpdate();
	}

	 
	@Override
	public List<Notice> selectAll() {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("from Notice");
		List<Notice> lists=query.list();
		return lists;
	}

	@Override
	public List<Notice> selectByTitle(String ntitle) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Notice n where n.ntitle like ?");
		query.setString(0, "%"+ntitle+"%");
		 List<Notice>  lists=query.list();
		return lists;
	}
 
	@Override
	public Notice selectOne() {
		 Query query=sessionFactory.getCurrentSession().createQuery("from Notice n order by  n.ntime desc limit 1");
		 List list=query.list();
		return  (Notice) list.get(0);
	}
	
	
}
