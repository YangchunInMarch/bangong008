/**   
 * @Title: ICommonDao.java
 * @Package: com.qq.dao 
 * @author: 刘紫薇
 * @date: 2020年3月18日 下午6:42:26 
 */
package com.qq.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

/**   
* @ClassName: ICommonDao
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月18日 下午6:42:26 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public interface ICommonDao<T> {
	  void save(T entity);	
	  void update(T entity);
	  T findObjectById(Object id);
	  void deleteByIds(Object id);


}
