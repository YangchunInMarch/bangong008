/**   
 * @Title: UploadfileDao.java
 * @Package: com.qq.dao 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午9:48:29 
 */
package com.qq.dao;

import java.util.List;

import com.qq.entity.Uploadfile;

/**   
* @ClassName: UploadfileDao
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午9:48:29 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
public interface UploadfileDao extends ICommonDao<Uploadfile>{

	List<Uploadfile> selectFileByDepart(String depart);
	List<Uploadfile> selectFileByFileName(String fileName,String depart);
	void save(Uploadfile entity);	
}
