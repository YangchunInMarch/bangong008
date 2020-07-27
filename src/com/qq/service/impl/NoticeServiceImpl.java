/**   
 * @Title: NoticeServiceImpl.java
 * @Package: com.qq.service.impl 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午8:50:59 
 */
package com.qq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qq.dao.NoticeDao;
import com.qq.entity.Notice;
import com.qq.service.NoticeService;

/**   
* @ClassName: NoticeServiceImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午8:50:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Transactional
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

   @Autowired
   private  NoticeDao noticeDao;
   
	@Override
	public void save(Notice entity) {
		// TODO Auto-generated method stub
		noticeDao.save(entity);
	}
 
	@Override
	public void update(Notice entity) {
		// TODO Auto-generated method stub
		noticeDao.update(entity);
	}

 
	@Override
	public Notice findObjectById(Object id) {
		// TODO Auto-generated method stub
		return noticeDao.findObjectById(id);
	}

 
	@Override
	public void deleteByIds(Object id) {
		// TODO Auto-generated method stub
		noticeDao.deleteByIds(id);
	}

	 
	@Override
	public List<Notice> selectAll() {
		// TODO Auto-generated method stub
		return noticeDao.selectAll();
	}

	 
	@Override
	public List<Notice> selectByTitle(String ntitle) {
		// TODO Auto-generated method stub
		return noticeDao.selectByTitle(ntitle);
	}

	 
	@Override
	public Notice selectOne() {
		// TODO Auto-generated method stub
		return noticeDao.selectOne();
	}

}
