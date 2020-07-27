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

import com.qq.entity.Meetingroom;
import com.qq.service.MeetingroomService;

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
public class MeetingRoomTest {

	@Autowired
	private MeetingroomService meetingroomService; 
	@Test
	public void save() {
		 Meetingroom mm=new Meetingroom();
		 mm.setId(12);
		 mm.setRoomname("六楼东");
		 mm.setRoomstate(0);
		 
		 meetingroomService.save(mm);
	}
	
	@Test
	public void select() {
		Meetingroom mm= meetingroomService.findObjectById(2);
		mm.setRoomstate(1);
		meetingroomService.update(mm);
		System.out.println(mm.getRoomname());
	}
	
	@Test
	public void select2() {
		List<Meetingroom> lists= meetingroomService.selectState(0);
           for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i).getRoomname());
		}
	}

	@Test
	public void select3() {
		Meetingroom mm= meetingroomService.findObjectByName("二楼东")	;
		System.out.println(mm.getId());
	}
	 
	
}
