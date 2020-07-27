/**   
 * @Title: SigninTest.java
 * @Package: com.qq.test 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午11:03:38 
 */
package com.qq.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qq.common.BanUUID;
import com.qq.common.JudgeEmpty;
import com.qq.entity.Signin;
import com.qq.service.SigninService;

/**   
* @ClassName: SigninTest
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午11:03:38 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SigninTest {

	@Autowired
	private SigninService signinService;
	
	@Test
	public void save() {
		Signin s=new Signin();
		s.setId(BanUUID.getUUID());
		s.setEmployeeid("A000003");
		s.setOnState(1);
		s.setOnduty("2020-03-16 07:12");
		s.setOffState(1);
		s.setOffduty("2020-03-16 18:12");
		s.setStime("2020-03-16");
		signinService.save(s);
	}
	
	@Test
	public void select() {
		Signin s=signinService.selectByEidTime("A000003", "2020-03-17");
		if(JudgeEmpty.isEmpty(s)) {
			System.out.println("空");
		}else
		System.out.println(s.getOffduty());
	}
	
	@Test
	public void select2() {
		List<Signin> lists=signinService.selectTime("A000003", "2020-03");
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i).getOffduty());
		}
	}
	
	//selectThree
	@Test
	public void select3() {
		List<Signin> lists=signinService.selectThree("A000003");
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i).getOffduty());
		}
	}
	
}
