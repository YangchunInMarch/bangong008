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
import com.qq.entity.Goals;
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
public class TestGoals {

	@Autowired
	private GoalsService goalsService;
	
	@Test
	public void add() {
		Goals goals=new Goals();
		goals.setId(BanUUID.getUUID());
		goals.setUid("A000001");
		goals.setTitle("制作PPT");
		goals.setContent("1.巴拉巴拉2.巴拉巴拉");
		goals.setTime(new Date());
		goalsService.save(goals);
	}
	
	@Test
	public void select() {
		Goals goals=goalsService.findObjectById("38a7142daf9f4c789379a5c234c58793");
		System.out.println(goals.getTitle());
	}
	
	@Test
	public void selectAll() {
		List<Goals> lists=goalsService.selectUid("A000001");
		System.out.println(lists.size());
		for(int i=0;i<lists.size();i++) {
			System.out.println(lists.get(i).getTime());
		}
	}
}
