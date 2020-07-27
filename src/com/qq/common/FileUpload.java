/**   
 * @Title: FileUpload.java
 * @Package: com.qq.common 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午7:34:12 
 */
package com.qq.common;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**   
* @ClassName: FileUpload
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午7:34:12 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
public class FileUpload {

	public static boolean saveFile(HttpServletRequest request,
			MultipartFile file, String relativeFilePath) {
		// 判断文件是否为空
		if (file == null || relativeFilePath == null
				|| relativeFilePath.isEmpty()) {
			return false;
		}
		if (!file.isEmpty()) {
			try {
				String absoluteFilePath = request.getSession()
						.getServletContext().getRealPath("/")
						+ relativeFilePath;
				System.out.println("----文件上传的路径："+absoluteFilePath);
				File saveDir = new File(absoluteFilePath);
				if (!saveDir.getParentFile().exists())
					saveDir.getParentFile().mkdirs();
				// 转存文件
				file.transferTo(saveDir);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	
}
