/**   
 * @Title: TestEmail.java
 * @Package: com.qq.test 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午4:20:18 
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
import com.qq.entity.Emails;
import com.qq.service.EmailsService;

/**   
* @ClassName: TestEmail
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午4:20:18 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestEmail {

	@Autowired
	private EmailsService emailsService;
	
	@Test
	public void add() {
		Emails em=new Emails();
		em.setId(BanUUID.getUUID());
		em.setEtitle("说说");
		em.setEcontent("德国啦啦");
		em.setEsend("A000001");
		em.setEfrom("A000004");
		em.setEfromName("zs3");
		em.setEtime(new Date());
		emailsService.save(em);
	}
	
	@Test
	public void select() {
		List<Emails> lists=emailsService.selectEmailByFromState("A000001", 0);
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i).getEtitle());
		}
	}
	
	@Test
	public void select2() {
		List<Emails> lists=emailsService.selectEmailByFrom("A000001","A000002");
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i).getEtitle());
		}
	}
	@Test
	public void delete() {
		emailsService.deleteById("23123");
	}
}
