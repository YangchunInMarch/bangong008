/**   
 * @Title: EmployeeDao.java
 * @Package: com.qq.service 
 * @author: 刘紫薇
 * @date: 2020年3月18日 下午7:57:27 
 */
package com.qq.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.qq.entity.Employee;

/**   
* @ClassName: EmployeeDao
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月18日 下午7:57:27 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public interface EmployeeService {
	  void save(Employee entity);	
	  void update(Employee entity);
	  Employee findObjectById(String id);
	  void deleteByIds(Object id);
	  
	  List<Employee> selectAll();
	  List<Employee> selectName(String name);
	  List<Employee> selectEmployeeByDepart(String depart);
	  
	  
}
