/**   
 * @Title: Notice.java
 * @Package: com.qq.entity 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午8:44:14 
 */
package com.qq.entity;

import java.util.Date;

/**   
* @ClassName: Notice
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午8:44:14 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
public class Notice {
	private String id;
	private String ntitle;
	private String ncontent;
	private String npeople;
	private String npeopleid;
	private Date ntime;
	
	public Notice() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNpeople() {
		return npeople;
	}
	public void setNpeople(String npeople) {
		this.npeople = npeople;
	}
	public String getNpeopleid() {
		return npeopleid;
	}
	public void setNpeopleid(String npeopleid) {
		this.npeopleid = npeopleid;
	}
	public Date getNtime() {
		return ntime;
	}
	public void setNtime(Date ntime) {
		this.ntime = ntime;
	}
	public Notice(String id, String ntitle, String ncontent, String npeople, String npeopleid, Date ntime) {
		super();
		this.id = id;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.npeople = npeople;
		this.npeopleid = npeopleid;
		this.ntime = ntime;
	}
	
}
