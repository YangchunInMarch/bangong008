/**   
 * @Title: NoticeTest.java
 * @Package: com.qq.test 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午8:52:37 
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
import com.qq.entity.Notice;
import com.qq.service.NoticeService;

/**   
* @ClassName: NoticeTest
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午8:52:37 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class NoticeTest {

	@Autowired
	private NoticeService  noticeService;
	
	@Test
	public void save() {
		Notice notice=new Notice();
		notice.setId(BanUUID.getUUID());
		notice.setNcontent("男");
		notice.setNtitle("男");
		notice.setNpeople("曹操");
		notice.setNpeopleid("AA1010");
		notice.setNtime(new Date());
		noticeService.save(notice);
	}
	
	@Test 
	public void all() {
		List<Notice> lists=noticeService.selectAll();
		for (int i = 0; i <lists.size(); i++) {
			System.out.println(lists.get(i).getNtitle());
		}
	}
	
	@Test
	public void delete() {
		noticeService.deleteByIds("31186da3c219446984408524ce470fb0");
	}
}
