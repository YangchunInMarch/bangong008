/**   
 * @Title: SigninServiceImpl.java
 * @Package: com.qq.service.impl 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午11:01:51 
 */
package com.qq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qq.dao.SigninDao;
import com.qq.entity.Signin;
import com.qq.service.SigninService;

/**   
* @ClassName: SigninServiceImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午11:01:51 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
@Transactional
@Service("signinService")
public class SigninServiceImpl implements SigninService {

	@Autowired
	private SigninDao signinDao;

 
	@Override
	public void save(Signin entity) {
		// TODO Auto-generated method stub
		signinDao.save(entity);
	}

	 
	@Override
	public void update(Signin entity) {
		// TODO Auto-generated method stub
		signinDao.update(entity);
	}

 
	@Override
	public Signin selectByEidTime(String employeeid, String stime) {
		// TODO Auto-generated method stub
		return signinDao.selectByEidTime(employeeid, stime);
	}

 
	@Override
	public List<Signin> selectThree(String employeeid) {
		// TODO Auto-generated method stub
		return signinDao.selectThree(employeeid);
	}

	 
	@Override
	public List<Signin> selectTime(String employeeid, String stime) {
		 
		return signinDao.selectTime(employeeid, stime);
	}

	 
	@Override
	public Signin findObjectById(String id) {
		// TODO Auto-generated method stub
		return signinDao.findObjectById(id);
	}
	
}
