/**   
 * @Title: SigninDaoImpl.java
 * @Package: com.qq.dao.impl 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午10:52:13 
 */
package com.qq.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qq.dao.SigninDao;
import com.qq.entity.Signin;

/**   
* @ClassName: SigninDaoImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午10:52:13 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Component("signinDao")
public class SigninDaoImpl implements SigninDao {

	@Autowired
	private SessionFactory  sessionFactory;
 
	@Override
	public void save(Signin entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}

	 
	@Override
	public void update(Signin entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	 
	@Override
	public Signin findObjectById(Object id) {
		 Query query=sessionFactory.getCurrentSession().createQuery("from Signin s where s.id='"+id+"'");
		return (Signin) query.uniqueResult();
	}

	 
	@Override
	public void deleteByIds(Object id) {
		sessionFactory.getCurrentSession().createQuery("delete Signin s where s.id='"+id+"'").executeUpdate();
	}

	 
	@Override
	public Signin selectByEidTime(String employeeid, String stime) {
		 Query query=sessionFactory.getCurrentSession().createQuery("from Signin s where s.employeeid=? and s.stime=?");
		 query.setString(0, employeeid);
		 query.setString(1, stime);
		 
		 return (Signin) query.uniqueResult();
	}

	 
	@Override
	public List<Signin> selectThree(String employeeid) {
		 Query query=sessionFactory.getCurrentSession().createQuery("from Signin s where s.employeeid=?  ORDER BY s.stime desc limit 30");
		 query.setString(0, employeeid);
		return query.list();
	}
 
	
	@Override
	public List<Signin> selectTime(String employeeid, String stime) {
		 Query query=sessionFactory.getCurrentSession().createQuery("from Signin s where s.employeeid=? and s.stime like ?");
		 query.setString(0, employeeid);
		 query.setString(1, "%"+stime+"%");
		 List list=query.list();
		return list;
	}
	
	
}
