/**   
 * @Title: Uploadfile.java
 * @Package: com.qq.entity 
 * @author: 阳春三月   
 * @date: 2020年3月18日 上午10:42:36 
 */
package com.qq.entity;

import java.util.Date;


/**   
* @ClassName: Uploadfile
* @Description: TODO
*
* @version: v1.0.0
* @author: 阳春三月
* @date: 2020年3月18日 上午10:42:36 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public class Uploadfile {

	private String id;
    private String title;
    private String uploadperson;
    private String departmentid;
    private String uploadfile;
    private Date uploadtime;

    public Uploadfile() {
    }

    
    /** full constructor */
    public Uploadfile(String id, String title, String uploadperson, String uploadfile,String departmentid, Date uploadtime) {
        this.id = id;
        this.title = title;
        this.uploadperson = uploadperson;
        this.departmentid = departmentid;
        this.uploadtime = uploadtime;
        this.uploadfile=uploadfile;
    }


	public String getUploadfile() {
		return uploadfile;
	}


	public void setUploadfile(String uploadfile) {
		this.uploadfile = uploadfile;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getUploadperson() {
		return uploadperson;
	}


	public void setUploadperson(String uploadperson) {
		this.uploadperson = uploadperson;
	}


	public String getDepartmentid() {
		return departmentid;
	}


	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}


	public Date getUploadtime() {
		return uploadtime;
	}


	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}


   

}
