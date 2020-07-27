/**   
 * @Title: TestAdd.java
 * @Package: com.qq.test 
 * @author: 刘紫薇
 * @date: 2020年3月18日 下午7:10:25 
 */
package com.qq.test;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.qq.dao.EmployeeDao;
import com.qq.entity.Employee;
import com.qq.service.EmployeeService;

/**   
* @ClassName: TestAdd
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月18日 下午7:10:25 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public class TestAdd {
	
	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	EmployeeService employeeService= (EmployeeService) ctx.getBean("employeeService");
		
	@Test
	public void test001() {
		
		 System.out.println("ctx:"+ctx); 
		 
		   Employee em=new Employee();
			em.setId("A11009");
			em.setUname("zs");
			em.setUcard("123131213231");
			em.setDepartment("1");
			em.setUpass("123");
			employeeService.save(em);
		   
	}

	
	
	@Test
	public void test002() {
		 ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		   Employee em=new Employee();
			em.setId("A11006");
			em.setUname("zs");
			em.setUcard("123131213231");
			em.setDepartment("1");
			em.setUpass("123");
			employeeService.save(em);
		   
	}
}
