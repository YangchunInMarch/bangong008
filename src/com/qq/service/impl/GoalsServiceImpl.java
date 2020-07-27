/**   
 * @Title: GoalsServiceImpl.java
 * @Package: com.qq.service.impl 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午1:36:54 
 */
package com.qq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qq.dao.GoalsDao;
import com.qq.entity.Goals;
import com.qq.service.GoalsService;

/**   
* @ClassName: GoalsServiceImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午1:36:54 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Transactional
@Service("goalsService")
public class GoalsServiceImpl implements GoalsService{

	@Autowired
	private GoalsDao goalsDao;
	
	/** 
	* @see com.qq.dao.ICommonDao#save(java.lang.Object)  
	* @Function: GoalsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午1:37:30 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void save(Goals entity) {
		// TODO Auto-generated method stub
		goalsDao.save(entity);	
	}

	/** 
	* @see com.qq.dao.ICommonDao#update(java.lang.Object)  
	* @Function: GoalsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param entity
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午1:37:30 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void update(Goals entity) {
		// TODO Auto-generated method stub
		goalsDao.update(entity);
	}
	/** 
	* @see com.qq.dao.ICommonDao#deleteByIds(java.lang.Object)  
	* @Function: GoalsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午1:37:30 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public void deleteByIds(Object id) {
		// TODO Auto-generated method stub
		goalsDao.deleteByIds(id);
	}

	/** 
	* @see com.qq.service.GoalsService#findObjectById(java.lang.String)  
	* @Function: GoalsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param id
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午1:39:21 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public Goals findObjectById(String id) {
		// TODO Auto-generated method stub
		return goalsDao.findObjectById(id);
	}

	/** 
	* @see com.qq.service.GoalsService#selectDepart(java.lang.String)  
	* @Function: GoalsServiceImpl.java
	* @Description: TODO
	*
	* @param: @param uid
	* @param: @return
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2020年3月19日 下午1:39:21 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2020年3月19日     Administrator           v1.0.0               修改原因
	*/
	@Override
	public List<Goals> selectUid(String uid) {
		// TODO Auto-generated method stub
		return goalsDao.selectUid(uid);
	}


}
