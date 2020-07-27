/**   
 * @Title: TestGoals.java
 * @Package: com.qq.test 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午1:42:19 
 */
package com.qq.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qq.common.BanUUID;
import com.qq.entity.Employee;
import com.qq.entity.Goals;
import com.qq.service.EmployeeService;
import com.qq.service.GoalsService;

/**   
* @ClassName: TestGoals
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午1:42:19 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestEmployee {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void selectName() {
		List<Employee> lists=employeeService.selectName("zs");
		System.out.println(lists.size());
		for(int i=0;i<lists.size();i++) {
			System.out.println(lists.get(i).getId());
		}
	}
	
	@Test
	public void selectAll() {
		List<Employee> lists=employeeService.selectAll();
		System.out.println(lists.size());
		for(int i=0;i<lists.size();i++) {
			System.out.println(lists.get(i).getId());
		}
	}
	
	@Test
	public void save() {
		Employee employee=new Employee();
		employee.setId("AA300019");
		employee.setUphone("123");
		employee.setUgender(1);
		employee.setDepartment("3");
		employee.setUemail("444563322@qq.com");
		employee.setUcard("894580258024");
		employee.setUname("牛久久");
		employeeService.save(employee);
	}
	
}
