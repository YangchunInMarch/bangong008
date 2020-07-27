/**   
 * @Title: Meeting.java
 * @Package: com.qq.entity 
 * @author: 阳春三月   
 * @date: 2020年3月18日 上午11:31:39 
 */
package com.qq.entity;

import java.util.Date;

/**   
* @ClassName: Meeting
* @Description: TODO
*
* @version: v1.0.0
* @author: 阳春三月
* @date: 2020年3月18日 上午11:31:39 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public class Meeting {

	private String id;
	private String mtitle;
	private String mcontent;
	private String mleader; 
	private String mperson;
	private String meetingtime;   
	private String mroomname;  
	private Date mtime;
	private int  mstate;

	// Constructors

	/** default constructor */
	public Meeting() {
	}

	/** full constructor */
	public Meeting(String id, String mtitle, String mcontent, String mleader, 
			String mperson, Date mtime,String meetingtime,int  mstate,String mroomname) {
		this.id = id;
		this.mtitle = mtitle;
		this.meetingtime= meetingtime;
		this.mcontent = mcontent;
		this.mleader = mleader;
		this.mperson = mperson;
		this.mtime = mtime;
		this.mstate=mstate;
		this.mroomname=mroomname;
	}

	// Property accessors

	public String getMroomname() {
		return mroomname;
	}

	public void setMroomname(String mroomname) {
		this.mroomname = mroomname;
	}

	public String getMeetingtime() {
		return meetingtime;
	}

	public int getMstate() {
		return mstate;
	}

	public void setMstate(int mstate) {
		this.mstate = mstate;
	}

	public void setMeetingtime(String meetingtime) {
		this.meetingtime = meetingtime;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMtitle() {
		return this.mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getMcontent() {
		return this.mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getMleader() {
		return this.mleader;
	}

	public void setMleader(String mleader) {
		this.mleader = mleader;
	}

	public String getMperson() {
		return this.mperson;
	}

	public void setMperson(String mperson) {
		this.mperson = mperson;
	}

	public Date getMtime() {
		return this.mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	
}
