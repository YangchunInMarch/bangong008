/**   
 * @Title: MeetingTest.java
 * @Package: com.qq.test 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午1:12:52 
 */
package com.qq.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qq.common.BanUUID;
import com.qq.entity.Meeting;
import com.qq.service.MeetingService;

/**   
* @ClassName: MeetingTest
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午1:12:52 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MeetingTest {

	@Autowired
	private MeetingService meetingService; 
	@Test
	public void save() {
		Meeting mm=new Meeting();
		mm.setId(BanUUID.getUUID());
		mm.setMcontent("黑盒");
		mm.setMeetingtime("12-18");
		mm.setMleader("A000003");
		mm.setMstate(0);
		meetingService.save(mm);
	}
	
	@Test
	public void update() {
		Meeting mm=new Meeting();
		mm.setId("92eb5a397f4b4335af30d8a6f72a3652");
		mm.setMstate(1);
		meetingService.update(mm);
	}
	
	@Test
	public void select() {
		Meeting mm=meetingService.findObjectById("93c23b90430e48bf8395fba778433040");
		System.out.println(mm.getMleader());
	}
	
	@Test
	public void select2() {
		List<Meeting> lists=meetingService.selectByLeaderState("A000003", 0);
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i).getMleader());
		}
	}
	
}
