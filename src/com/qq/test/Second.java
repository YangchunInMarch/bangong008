/**   
 * @Title: Second.java
 * @Package: com.qq.test 
 * @author: 阳春三月   
 * @date: 2020年3月18日 上午10:55:18 
 */
package com.qq.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.qq.entity.Employee;

/**   
* @ClassName: Second
* @Description: TODO
*
* @version: v1.0.0
* @author: 阳春三月
* @date: 2020年3月18日 上午10:55:18 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public class Second {

	public static void main(String[] args) {
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Transaction  tran=  session.beginTransaction();
		
        System.out.println(tran);
        Employee em=new Employee();
		em.setId("A000001");
		em.setUname("zs");
		em.setUcard("123131213231");
		em.setDepartment("1");
		em.setUpass("123");
		session.save(em);
		tran.commit();
	}
	
}
