/**   
 * @Title: EmailsServiceImpl.java
 * @Package: com.qq.service.impl 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午4:18:04 
 */
package com.qq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qq.dao.EmailsDao;
import com.qq.entity.Emails;
import com.qq.service.EmailsService;

/**   
* @ClassName: EmailsServiceImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午4:18:04 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Transactional
@Service("emailsService")
public class EmailsServiceImpl implements EmailsService {

	@Autowired
	private EmailsDao emailsDao;
	
	/** 
	* @see com.qq.service.EmailsService#selectEmailByFromState(java.lang.String, int)  
	* @Function: EmailsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param esend
	* @param: @param estate
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午4:18:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Emails> selectEmailByFromState(String esend, int estate) {
		// TODO Auto-generated method stub
		return emailsDao.selectEmailByFromState(esend, estate);
	}

	/** 
	* @see com.qq.service.EmailsService#selectEmailByFrom(java.lang.String)  
	* @Function: EmailsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param esend
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午4:18:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Emails> selectEmailByFrom(String esend,String efrom) {
		// TODO Auto-generated method stub
		return emailsDao.selectEmailByFrom(esend,efrom);
	}

	/** 
	* @see com.qq.service.EmailsService#save(com.qq.entity.Emails)  
	* @Function: EmailsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午4:18:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void save(Emails entity) {
		emailsDao.save(entity);
		
	}

	/** 
	* @see com.qq.service.EmailsService#deleteByIds(java.lang.String)  
	* @Function: EmailsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午4:18:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		emailsDao.deleteByIds(id);
	}

	/** 
	* @see com.qq.service.EmailsService#selectEmail(java.lang.String)  
	* @Function: EmailsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param efrom
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午5:27:38 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Emails> selectEmail(String efrom) {
		// TODO Auto-generated method stub
		return emailsDao.selectEmail(efrom);
	}

	/** 
	* @see com.qq.service.EmailsService#findObjectById(java.lang.Object)  
	* @Function: EmailsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午6:15:08 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public Emails findObjectById(Object id) {
		// TODO Auto-generated method stub
		return emailsDao.findObjectById(id);
	}

	/** 
	* @see com.qq.service.EmailsService#update(com.qq.entity.Emails)  
	* @Function: EmailsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午6:37:09 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void update(Emails entity) {
		// TODO Auto-generated method stub
		emailsDao.update(entity);
	}

}
