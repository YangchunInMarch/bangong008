/**   
 * @Title: UploadfileTest.java
 * @Package: com.qq.test 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午10:02:27 
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
import com.qq.entity.Uploadfile;
import com.qq.service.UploadfileService;

/**   
* @ClassName: UploadfileTest
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午10:02:27 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UploadfileTest {

	@Autowired
	private UploadfileService  uploadfileService;
	
	@Test
	public void save() {
		Uploadfile uf=new Uploadfile();
		uf.setId(BanUUID.getUUID());;
		uf.setDepartmentid("1");
		uf.setTitle("jar包");
		uf.setUploadfile("n-2.2.4.jar");
		uf.setUploadperson("A000001");
		uf.setUploadtime(new Date());
		uploadfileService.save(uf);
	}
	@Test
	public void selectFileByDepart() {
		List<Uploadfile> lists=uploadfileService.selectFileByDepart("1");
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i).getUploadfile());
		}
	}
	
	@Test
	public void selectFileByFileName() {
		List<Uploadfile> lists=uploadfileService.selectFileByFileName("on","1");
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i).getUploadfile());
		}
	}
	
	@Test
	public void delete() {
		uploadfileService.deleteByIds("11");
	}
}
