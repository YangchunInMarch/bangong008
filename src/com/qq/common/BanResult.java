/**   
 * @Title: BanResult.java
 * @Package: com.qq.common 
 * @author: 刘紫薇
 * @date: 2020年3月19日 上午8:29:37 
 */
package com.qq.common;

/**   
* @ClassName: BanResult
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 上午8:29:37 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
public class BanResult {

	private boolean success;
	private String msg;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
