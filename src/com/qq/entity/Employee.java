/**   
 * @Title: Employee.java
 * @Package: com.qq.entity 
 * @author: 阳春三月   
 * @date: 2020年3月18日 上午10:46:51 
 */
package com.qq.entity;

/**   
* @ClassName: Employee
* @Description: TODO
*
* @version: v1.0.0
* @author: 阳春三月
* @date: 2020年3月18日 上午10:46:51 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public class Employee {


    private String id;
    private String uname;
    private int    ugender;
    private String upass;
    private String uphone;
    private String uemail;
    private String ucard;
    private String img;
    private String department;
    
    public Employee() {
    }

    
    /** full constructor */
    public Employee(String id, String uname, int    ugender,String upass, String uphone, String uemail,String img, String ucard, String department) {
        this.id = id;
        this.uname = uname;
        this.ugender=ugender;
        this.upass = upass;
        this.uphone = uphone;
        this.uemail = uemail;
        this.ucard = ucard;
        this.department = department;
        this.img=img;
    }


	public int getUgender() {
		return ugender;
	}


	public void setUgender(int ugender) {
		this.ugender = ugender;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUpass() {
		return upass;
	}


	public void setUpass(String upass) {
		this.upass = upass;
	}


	public String getUphone() {
		return uphone;
	}


	public void setUphone(String uphone) {
		this.uphone = uphone;
	}


	public String getUemail() {
		return uemail;
	}


	public void setUemail(String uemail) {
		this.uemail = uemail;
	}


	public String getUcard() {
		return ucard;
	}


	public void setUcard(String ucard) {
		this.ucard = ucard;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}

    
}
