/**   
 * @Title: UploadfileService.java
 * @Package: com.qq.service 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午9:57:03 
 */
package com.qq.service;

import java.util.List;

import com.qq.entity.Uploadfile;

/**   
* @ClassName: UploadfileService
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午9:57:03 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
public interface UploadfileService {

	  void save(Uploadfile entity);	
	  void deleteByIds(String id);
	  List<Uploadfile> selectFileByDepart(String depart);
    	List<Uploadfile> selectFileByFileName(String fileName,String depart);
	
}
