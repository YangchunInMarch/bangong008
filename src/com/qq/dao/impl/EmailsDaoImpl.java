/**   
 * @Title: EmailsDaoImpl.java
 * @Package: com.qq.dao.impl 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午4:08:42 
 */
package com.qq.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.qq.dao.EmailsDao;
import com.qq.entity.Emails;

/**   
* @ClassName: EmailsDaoImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午4:08:42 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Component("emailsDao")
public class EmailsDaoImpl implements EmailsDao {

	@Autowired
	private SessionFactory sessionFactory;
	/** 
	* @see com.qq.dao.ICommonDao#save(java.lang.Object)  
	* @Function: EmailsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午4:08:45 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void save(Emails entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	/** 
	* @see com.qq.dao.ICommonDao#update(java.lang.Object)  
	* @Function: EmailsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午4:08:45 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void update(Emails entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	/** 
	* @see com.qq.dao.ICommonDao#findObjectById(java.lang.Object)  
	* @Function: EmailsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午4:08:45 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public Emails findObjectById(Object id) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Emails em where em=?");
		query.setString(0, (String)id);
		
		return (Emails)query.uniqueResult();
	}

	/** 
	* @see com.qq.dao.ICommonDao#deleteByIds(java.lang.Object)  
	* @Function: EmailsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午4:08:45 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void deleteByIds(Object id) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().createQuery("delete Emails  emails where emails.id='"+(String)id+"'").executeUpdate();
		
	}

	/** 
	* @see com.qq.dao.EmailsDao#selectEmailByFromState(java.lang.String, int)  
	* @Function: EmailsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param esend
	* @param: @param estate
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午4:08:45 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Emails> selectEmailByFromState(String esend, int estate) {
		 
		Query query = sessionFactory.getCurrentSession().createQuery("from Emails em where em.esend =? and  em.estate=?");
		query.setString(0, esend);
		query.setInteger(1, estate);
		List list = query.list();
		return list;
	}

	/** 
	* @see com.qq.dao.EmailsDao#selectEmailByFrom(java.lang.String)  
	* @Function: EmailsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param esend
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午4:08:45 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Emails> selectEmailByFrom(String esend,String efromName) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Emails em where em.esend =? and em.efromName like ?");
		query.setString(0, esend);
		query.setString(1, "%"+efromName+"%");
		List list = query.list();
		return list;
	}

	/** 
	* @see com.qq.dao.EmailsDao#selectEmail(java.lang.String)  
	* @Function: EmailsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param efrom
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午5:26:34 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Emails> selectEmail(String efrom) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Emails em where em.efrom =?");
		query.setString(0, efrom);
		List list = query.list();
		return list;
	}

}
