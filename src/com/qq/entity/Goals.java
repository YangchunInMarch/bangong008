/**   
 * @Title: Goals.java
 * @Package: com.qq.entity 
 * @author: 刘紫薇
 * @date: 2020年3月19日 下午1:24:59 
 */
package com.qq.entity;

import java.util.Date;

/**   
* @ClassName: Goals
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 下午1:24:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
public class Goals {

	private String id;
	private String uid;
	private String title;
	private String content;
	private Date time;

	// Constructors

	/** default constructor */
	public Goals() {
	}

	/** full constructor */
	public Goals(String uid, String title, String content, Date time) {
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.time = time;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	
}
