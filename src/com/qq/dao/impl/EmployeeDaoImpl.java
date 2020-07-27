/**   
 * @Title: EmployeeDaoImpl.java
 * @Package: com.qq.dao.impl 
 * @author: 刘紫薇
 * @date: 2020年3月18日 下午6:46:02 
 */
package com.qq.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.qq.dao.EmployeeDao;
import com.qq.entity.Employee;

/**   
* @ClassName: EmployeeDaoImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月18日 下午6:46:02 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** 
	* @see com.qq.dao.ICommonDao#save(java.lang.Object)  
	* @Function: EmployeeDaoImpl.java
	* @Description: 实现增加员工
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月18日 下午6:46:05 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月18日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void save(Employee entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	/** 
	* @see com.qq.dao.ICommonDao#update(java.lang.Object)  
	* @Function: EmployeeDaoImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月18日 下午6:46:05 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月18日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void update(Employee entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	/** 
	* @see com.qq.dao.ICommonDao#findObjectById(java.lang.Object)  
	* @Function: EmployeeDaoImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月18日 下午6:46:05 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月18日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public Employee findObjectById(Object id) {
		 
		Query query=sessionFactory.getCurrentSession().createQuery("from Employee em where em.id=?");
		query.setString(0,(String)id);
		Employee em=(Employee) query.uniqueResult();
		 
		return em;
	}

	/** 
	* @see com.qq.dao.ICommonDao#deleteByIds(java.lang.Object)  
	* @Function: EmployeeDaoImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月18日 下午6:46:05 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月18日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void deleteByIds(Object id) {
		sessionFactory.getCurrentSession().createQuery("delete Employee em where em.id='"+id+"'").executeUpdate();	   	

		
	}

	
	@Override
	public List<Employee> selectDepart(String department){
		Query query = sessionFactory.getCurrentSession().createQuery("from Employee em where em.department=?");
		query.setString(0, department);
		List list = query.list();
		return list;
	}

	/** 
	* @see com.qq.dao.EmployeeDao#selectAll()  
	* @Function: EmployeeDaoImpl.java
	* @Description: TODO
	*
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午2:56:49 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Employee> selectAll() {
		 
		Query query = sessionFactory.getCurrentSession().createQuery("from Employee");
		List list = query.list();
		return list;
	}

	/** 
	* @see com.qq.dao.EmployeeDao#selectName(java.lang.String)  
	* @Function: EmployeeDaoImpl.java
	* @Description: TODO
	*
	* @param: @param name
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午2:59:19 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Employee> selectName(String name) {
	 
		Query query = sessionFactory.getCurrentSession().createQuery("from Employee em where em.uname like ?");
		query.setString(0, "%"+name+"%");
		List list = query.list();
		return list;
	}

	
}
