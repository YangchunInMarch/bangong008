/**   
 * @Title: Emails.java
 * @Package: com.qq.entity 
 * @author: 阳春三月   
 * @date: 2020年3月18日 上午11:30:58 
 */
package com.qq.entity;

import java.util.Date;

/**   
* @ClassName: Emails
* @Description: TODO
*
* @version: v1.0.0
* @author: 阳春三月
* @date: 2020年3月18日 上午11:30:58 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月18日     Administrator           v1.0.0               修改原因
*/
public class Emails {

	

	private String id;
	private String efrom; //发送者的工号
	private String efromName; //发送者 的 姓名
	private String esend; //接受者的公号
	private String esendName; //接受者的姓名
	private String etitle;
	private String econtent;
	private String efile;
	private Date etime;
	private int  estate;

	// Constructors

	/** default constructor */
	public Emails() {
	}

	/** full constructor */
	public Emails(String id, String efrom, String esend, String etitle,
			String econtent, String efile, Date etime,int  estate,String efromName,String esendName) {
		this.id = id;
		this.efrom = efrom;
		this.esend = esend;
		this.etitle = etitle;
		this.econtent = econtent;
		this.efile = efile;
		this.etime = etime;
		this.estate=estate;
		this.efromName=efromName;
		this.esendName=esendName;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public String getEsendName() {
		return esendName;
	}

	public void setEsendName(String esendName) {
		this.esendName = esendName;
	}

	public String getEfromName() {
		return efromName;
	}

	public void setEfromName(String efromName) {
		this.efromName = efromName;
	}

	public int getEstate() {
		return estate;
	}

	public void setEstate(int estate) {
		this.estate = estate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEfrom() {
		return this.efrom;
	}

	public void setEfrom(String efrom) {
		this.efrom = efrom;
	}

	public String getEsend() {
		return this.esend;
	}

	public void setEsend(String esend) {
		this.esend = esend;
	}

	public String getEtitle() {
		return this.etitle;
	}

	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}

	public String getEcontent() {
		return this.econtent;
	}

	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}

	public String getEfile() {
		return this.efile;
	}

	public void setEfile(String efile) {
		this.efile = efile;
	}

	public Date getEtime() {
		return this.etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}
	
}
