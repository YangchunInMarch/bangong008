/**   
 * @Title: FirstTest.java
 * @Package: com.qq.test 
 * @author: 阳春三月   
 * @date: 2020年3月18日 上午12:38:26 
 */
package com.qq.test;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
public class FirstTest {

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
		Transaction  tran=(Transaction) session.beginTransaction();
		
        System.out.println(tran);
	}

}
