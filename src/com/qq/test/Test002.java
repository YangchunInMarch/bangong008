/**   
 * @Title: Test002.java
 * @Package: com.qq.test 
 * @author: 阳春三月   
 * @date: 2020年3月18日 上午10:47:44 
 */
package com.qq.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.hibernate.Transaction;

import com.qq.entity.Department;
import com.qq.entity.Emails;
import com.qq.entity.Employee;
import com.qq.entity.Meeting;
import com.qq.entity.Meetingroom;
import com.qq.entity.Uploadfile;

/**   
* @ClassName: Test002
* @Description: TODO
*
* @version: v1.0.0
* @author: 阳春三月
* @date: 2020年3月18日 上午10:47:44 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public class Test002 {

	@Test
	public void test001() {
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Transaction  tran=  session.beginTransaction();
		try {
		Employee em=new Employee();
		em.setId("A000004");
		em.setUname("zs");
		em.setUcard("123131213231");
		em.setDepartment("1");
		em.setUpass("123");
		session.save(em);

			tran.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
}
	
	@Test
	public void test002() {
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Transaction  tran=  session.beginTransaction();
		Uploadfile   uploadFile=new Uploadfile();
		uploadFile.setId("16");
		uploadFile.setTitle("dfsdsd");
		uploadFile.setDepartmentid("2");
		uploadFile.setUploadtime(new Date());
		session.save(uploadFile);
		tran.commit();
}

	@Test
	public void test003() {
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Transaction  tran=  session.beginTransaction();
		Department   de=new Department();
		de.setId(1);
		de.setDname("技术部");
		de.setDnumber(12);
		session.save(de);
		tran.commit();
}
	
	@Test
	public void test004() {
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Transaction  tran=  session.beginTransaction();
		
		Emails   em=new Emails();
	    em.setId("23123");
	    em.setEsend("zs");
	    em.setEfrom("ls");
	    em.setEtitle("os");
	    em.setEtime(new Date());
		session.save(em);
		tran.commit();
}
	
	@Test
	public void test005() {
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Transaction  tran=  session.beginTransaction();
		
		Meeting   em=new Meeting();
	    em.setId("1213");
	    em.setMcontent("sds");
		session.save(em);
		tran.commit();
}
	@Test
	public void test006() {
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Transaction  tran=  session.beginTransaction();
		
		Meetingroom   em=new Meetingroom();
	    em.setId(2);
	    em.setRoomname("三楼东");
	    em.setRoomstate(1);
		session.save(em);
		tran.commit();
}
	
}