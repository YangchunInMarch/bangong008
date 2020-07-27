/**   
 * @Title: TestAdd.java
 * @Package: com.qq.test 
 * @author: 刘紫薇
 * @date: 2020年3月18日 下午7:10:25 
 */
package com.qq.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qq.common.MD5Util;
import com.qq.dao.EmployeeDao;
import com.qq.entity.Employee;
import com.qq.entity.Meetingroom;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestAdd02 {
	
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void test003() {
		    Employee em=employeeService.findObjectById("A000001");
			 System.out.println(em.getUname());
		   
	}
	
	@Test
	public void testAdd() {
		          Employee em=new Employee();
					em.setId("AA0010");
					em.setUname("孙仲谋");
					em.setUcard("123131213231");
					em.setDepartment("4");
					em.setUphone("102");
					employeeService.save(em);
	}

	@Test
	public void testMd5() {
		System.out.println(MD5Util.MD5("123"));
	}
	
	
	@Test
	public void test002() {
		 ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		   Employee em=new Employee();
			em.setId("A001006");
			em.setUname("zs");
			em.setUcard("123131213231");
			em.setDepartment("1");
			em.setUpass("123");
		//	employeeService.save(em);
		   
	}
	
	
}
