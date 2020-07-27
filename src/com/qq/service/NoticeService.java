/**   
 * @Noticeitle: NoticeService.java
 * @Package: com.qq.service 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午8:50:25 
 */
package com.qq.service;

import java.util.List;

import com.qq.entity.Notice;

/**   
* @ClassName: NoticeService
* @Description: NoticeODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午8:50:25 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
public interface NoticeService {

	  void save(Notice entity);	
	  void update(Notice entity);
	  Notice findObjectById(Object id);
	  void deleteByIds(Object id);
	  List<Notice> selectAll();
	  List<Notice> selectByTitle(String ntitle);
	  Notice       selectOne();
}
