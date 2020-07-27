/**   
 * @Title: GoalsDaoImpl.java
 * @Package: com.qq.dao.impl 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午1:27:04 
 */
package com.qq.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.qq.dao.GoalsDao;
import com.qq.entity.Goals;

/**   
* @ClassName: GoalsDaoImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午1:27:04 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Component("goalsDao")
public class GoalsDaoImpl implements GoalsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/** 
	* @see com.qq.dao.ICommonDao#save(java.lang.Object)  
	* @Function: GoalsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午1:27:07 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void save(Goals entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}

	/** 
	* @see com.qq.dao.ICommonDao#update(java.lang.Object)  
	* @Function: GoalsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午1:27:07 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void update(Goals entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	/** 
	* @see com.qq.dao.ICommonDao#findObjectById(java.lang.Object)  
	* @Function: GoalsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午1:27:07 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public Goals findObjectById(Object id) {
		// TODO Auto-generated method stub
		
		Query query=sessionFactory.getCurrentSession().createQuery("from Goals goals where goals.id=?");
		query.setString(0,(String)id);
		Goals g=(Goals) query.uniqueResult();
		return g;
	}

	/** 
	* @see com.qq.dao.ICommonDao#deleteByIds(java.lang.Object)  
	* @Function: GoalsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午1:27:07 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void deleteByIds(Object id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete  Goals goals where goals.id='"+id+"'").executeUpdate();	   	
	}

	/** 
	* @see com.qq.dao.GoalsDao#selectDepart(java.lang.String)  
	* @Function: GoalsDaoImpl.java
	* @Description: TODO
	*
	* @param: @param uid
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午1:33:19 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Goals> selectUid(String uid) {
	 
		Query query = sessionFactory.getCurrentSession().createQuery("from Goals goals where goals.uid=? order by time desc limit 20 ");
		query.setString(0, uid);
		List list = query.list();
		return list;
	}

}
