/**   
 * @Title: UploadfileDaoImpl.java
 * @Package: com.qq.dao.impl 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午9:50:21 
 */
package com.qq.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qq.dao.UploadfileDao;
import com.qq.entity.Uploadfile;

/**   
* @ClassName: UploadfileDaoImpl
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午9:50:21 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
@Component("uploadfileDao")
public class UploadfileDaoImpl implements UploadfileDao {

	@Autowired
	private SessionFactory sessionFactory;
 
	@Override
	public void save(Uploadfile entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	 
		@Override
		public void deleteByIds(Object id) {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().createQuery("delete Uploadfile uf where uf.id='"+id+"'").executeUpdate();
		}

		 
		@Override
		public List<Uploadfile> selectFileByDepart(String depart) {
			Query query=sessionFactory.getCurrentSession().createQuery("from Uploadfile uf where uf.departmentid='"+depart+"' ORDER BY uploadtime desc  ");
			List lists=query.list();
			return lists;
		}

		 
		@Override
		public List<Uploadfile> selectFileByFileName(String fileName,String depart) {
			Query query=sessionFactory.getCurrentSession().createQuery("from Uploadfile uf where uf.departmentid='"+depart+"' and uf.uploadfile like ? ORDER BY uploadtime desc  ");
			query.setString(0, "%"+fileName+"%");
			 List lists=query.list();
			return lists;
		}


		
	@Override
	public void update(Uploadfile entity) {
		
	}

	 
	@Override
	public Uploadfile findObjectById(Object id) {
		 
		return null;
	}


}
