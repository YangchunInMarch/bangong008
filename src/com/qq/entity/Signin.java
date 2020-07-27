/**   
 * @Title: Signin.java
 * @Package: com.qq.entity 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午10:43:42 
 */
package com.qq.entity;

import java.util.Date;

/**   
* @ClassName: Signin
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午10:43:42 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
public class Signin {

	private String id;
	private String employeeid;
	private String onduty;
	private Integer onState;
	private String  offduty;
	private Integer offState;
	private String  stime;

	// Constructors

	/** default constructor */
	public Signin() {
	}

	/** full constructor */
	public Signin(String id, String employeeid, String onduty,
			Integer onState, String offduty, Integer offState, String stime) {
		this.id = id;
		this.employeeid = employeeid;
		this.onduty = onduty;
		this.onState = onState;
		this.offduty = offduty;
		this.offState = offState;
		this.stime = stime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getOnduty() {
		return this.onduty;
	}

	public void setOnduty(String onduty) {
		this.onduty = onduty;
	}

	public Integer getOnState() {
		return this.onState;
	}

	public void setOnState(Integer onState) {
		this.onState = onState;
	}

	public String getOffduty() {
		return this.offduty;
	}

	public void setOffduty(String offduty) {
		this.offduty = offduty;
	}

	public Integer getOffState() {
		return this.offState;
	}

	public void setOffState(Integer offState) {
		this.offState = offState;
	}

	public String getStime() {
		return this.stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}
}
