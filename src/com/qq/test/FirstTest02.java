/**   
 * @Title: FirstTest.java
 * @Package: com.qq.test 
 * @author: 阳春三月   
 * @date: 2020年3月18日 上午12:38:26 
 */
package com.qq.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.qq.entity.Employee;

/**   
* @ClassName: FirstTest
* @Description: TODO
*
* @version: v1.0.0
* @author: 阳春三月
* @date: 2020年3月18日 上午12:38:26 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public class FirstTest02 {

	/**   
	* @Function: main
	* @Description: TODO
	* @param: @param args  
	* @return：void
	* @throws： 
	*
	* @version: v1.0.0
	* @author: 阳春三月
	* @date: 2020年3月18日 上午12:38:27          
	*/
	public static void main(String[] args) {
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Transaction  tran =session.beginTransaction();
		
        System.out.println(tran);
        try {
    		Employee em=new Employee();
    		em.setId("A000002");
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

}
