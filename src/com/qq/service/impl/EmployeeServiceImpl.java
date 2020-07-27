/**   
 * @Title: EmployeeDaoImpl.java
 * @Package: com.qq.service.impl 
 * @author: 刘紫薇
 * @date: 2020年3月18日 下午7:57:40 
 */
package com.qq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qq.dao.EmployeeDao;
import com.qq.entity.Employee;
import com.qq.service.EmployeeService;

/**   
* @ClassName: EmployeeDaoImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月18日 下午7:57:40 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
@Transactional
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	/** 
	* @see com.qq.service.EmployeeService#save(com.qq.entity.Employee)  
	* @Function: EmployeeServiceImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月18日 下午7:59:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月18日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void save(Employee entity) {
		// TODO Auto-generated method stub
		employeeDao.save(entity);
	}

	/** 
	* @see com.qq.service.EmployeeService#update(com.qq.entity.Employee)  
	* @Function: EmployeeServiceImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月18日 下午7:59:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月18日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void update(Employee entity) {
		// TODO Auto-generated method stub
		employeeDao.update(entity);
	}

	/** 
	* @see com.qq.service.EmployeeService#findObjectById(java.lang.String)  
	* @Function: EmployeeServiceImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月18日 下午7:59:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月18日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public Employee findObjectById(String id) {
		// TODO Auto-generated method stub
		return employeeDao.findObjectById(id);
	}

	/** 
	* @see com.qq.service.EmployeeService#deleteByIds(java.lang.Object)  
	* @Function: EmployeeServiceImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月18日 下午7:59:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月18日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void deleteByIds(Object id) {
		// TODO Auto-generated method stub
		employeeDao.deleteByIds(id);
	}

	/** 
	* @see com.qq.service.EmployeeService#selectAll()  
	* @Function: EmployeeServiceImpl.java
	* @Description: TODO
	*
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午2:57:47 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Employee> selectAll() {
		// TODO Auto-generated method stub
		return employeeDao.selectAll();
	}

	/** 
	* @see com.qq.service.EmployeeService#selectName(java.lang.String)  
	* @Function: EmployeeServiceImpl.java
	* @Description: TODO
	*
	* @param: @param name
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午3:00:42 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Employee> selectName(String name) {
		// TODO Auto-generated method stub
		return employeeDao.selectName(name);
	}

	/** 
	* @see com.qq.service.EmployeeService#selectEmployeeByDepart(java.lang.String)  
	* @Function: EmployeeServiceImpl.java
	* @Description: TODO
	*
	* @param: @param depart
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月20日 上午10:17:21 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月20日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Employee> selectEmployeeByDepart(String depart) {
		// TODO Auto-generated method stub
		return employeeDao.selectDepart(depart);
	}


}
