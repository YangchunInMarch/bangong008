/**   
 * @Title: NoticeDao.java
 * @Package: com.qq.dao 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午8:45:40 
 */
package com.qq.dao;

import java.util.List;

import com.qq.entity.Notice;

/**   
* @ClassName: NoticeDao
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午8:45:40 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
public interface NoticeDao extends ICommonDao<Notice>{
  
	List<Notice> selectAll();
	List<Notice> selectByTitle(String ntitle);
	//查询最近的一条公告
	Notice       selectOne();
}
