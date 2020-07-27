/**   
 * @Title: Meetingroom.java
 * @Package: com.qq.entity 
 * @author: 阳春三月   
 * @date: 2020年3月18日 上午11:32:14 
 */
package com.qq.entity;

/**   
* @ClassName: Meetingroom
* @Description: TODO
*
* @version: v1.0.0
* @author: 阳春三月
* @date: 2020年3月18日 上午11:32:14 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public class Meetingroom {

	private Integer id;
	private String roomname;
	private Integer roomstate;

	// Constructors

	/** default constructor */
	public Meetingroom() {
	}

	/** full constructor */
	public Meetingroom(Integer id, String roomname, Integer roomstate) {
		this.id = id;
		this.roomname = roomname;
		this.roomstate = roomstate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomname() {
		return this.roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Integer getRoomstate() {
		return this.roomstate;
	}

	public void setRoomstate(Integer roomstate) {
		this.roomstate = roomstate;
	}

	
}
