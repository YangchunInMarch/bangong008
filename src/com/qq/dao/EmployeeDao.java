/**   
 * @Title: EmployeeDao.java
 * @Package: com.qq.dao 
 * @author: 刘紫薇
 * @date: 2020年3月18日 下午6:08:58 
 */
package com.qq.dao;

import java.util.List;
import com.qq.entity.Employee;

/**   
* @ClassName: EmployeeDao
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月18日 下午6:08:58 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public interface EmployeeDao extends ICommonDao<Employee> {
	
	 List<Employee> selectDepart(String department);
	 List<Employee> selectName(String name);
	 List<Employee> selectAll();
}
