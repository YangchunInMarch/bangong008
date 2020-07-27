/**   
 * @Title: UploadfileServiceImpl.java
 * @Package: com.qq.service.impl 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午10:00:58 
 */
package com.qq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qq.dao.UploadfileDao;
import com.qq.entity.Uploadfile;
import com.qq.service.UploadfileService;

/**   
* @ClassName: UploadfileServiceImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午10:00:58 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Transactional
@Service("uploadfileService")
public class UploadfileServiceImpl implements UploadfileService {

	@Autowired
	private UploadfileDao uploadfileDao ;
	
	/** 
	* @see com.qq.service.UploadfileService#save(com.qq.entity.Uploadfile)  
	* @Function: UploadfileServiceImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午10:01:23 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void save(Uploadfile entity) {
		uploadfileDao.save(entity);
		
	}

	/** 
	* @see com.qq.service.UploadfileService#deleteByIds(java.lang.String)  
	* @Function: UploadfileServiceImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午10:01:23 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void deleteByIds(String id) {
		uploadfileDao.deleteByIds(id);
		
	}

	/** 
	* @see com.qq.service.UploadfileService#selectFileByDepart(java.lang.String)  
	* @Function: UploadfileServiceImpl.java
	* @Description: TODO
	*
	* @param: @param depart
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午10:01:23 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Uploadfile> selectFileByDepart(String depart) {
		// TODO Auto-generated method stub
		return uploadfileDao.selectFileByDepart(depart);
	}

	/** 
	* @see com.qq.service.UploadfileService#selectFileByFileName(java.lang.String)  
	* @Function: UploadfileServiceImpl.java
	* @Description: TODO
	*
	* @param: @param fileName
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午10:01:23 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Uploadfile> selectFileByFileName(String fileName,String depart) {
		// TODO Auto-generated method stub
		return uploadfileDao.selectFileByFileName(fileName,depart);
	}

}
