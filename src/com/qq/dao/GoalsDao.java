/**   
 * @Title: GoalsDao.java
 * @Package: com.qq.dao 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午1:26:26 
 */
package com.qq.dao;

import java.util.List;

import com.qq.entity.Employee;
import com.qq.entity.Goals;

/**   
* @ClassName: GoalsDao
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午1:26:26 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
public interface GoalsDao extends ICommonDao<Goals>{
	 List<Goals> selectUid(String uid);
}
