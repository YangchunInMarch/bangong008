/**   
 * @Title: GoalsService.java
 * @Package: com.qq.service 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午1:36:44 
 */
package com.qq.service;

import java.util.List;

import com.qq.dao.ICommonDao;
import com.qq.entity.Employee;
import com.qq.entity.Goals;

/**   
* @ClassName: GoalsService
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午1:36:44 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
public interface GoalsService{

	  void save(Goals entity);	
	  void update(Goals entity);
	  Goals findObjectById(String id);
	  void deleteByIds(Object id);
	  List<Goals> selectUid(String uid);
	  
}
