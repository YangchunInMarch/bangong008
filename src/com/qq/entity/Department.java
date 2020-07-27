/**   
 * @Title: Department.java
 * @Package: com.qq.entity 
 * @author: 阳春三月   
 * @date: 2020年3月18日 上午11:30:21 
 */
package com.qq.entity;

/**   
* @ClassName: Department
* @Description: TODO
*
* @version: v1.0.0
* @author: 阳春三月
* @date: 2020年3月18日 上午11:30:21 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public class Department {

	private Integer id;
	private String dname;
	private Integer dnumber;

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** full constructor */
	public Department(Integer id, String dname, Integer dnumber) {
		this.id = id;
		this.dname = dname;
		this.dnumber = dnumber;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getDnumber() {
		return this.dnumber;
	}

	public void setDnumber(Integer dnumber) {
		this.dnumber = dnumber;
	}

	
}
