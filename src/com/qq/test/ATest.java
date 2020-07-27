/**   
 * @Title: ATest.java
 * @Package: com.qq.test 
 * @author: 李玉娇
 * @date: 2020年5月15日 下午10:58:48 
 */
package com.qq.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**   
* @ClassName: ATest
* @Description: TODO
*
* @version: v1.0.0
* @author: 李玉娇
* @date: 2020年5月15日 下午10:58:48 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年5月15日     Administrator           v1.0.0               修改原因
*/
public class ATest {

	/**   
	* @Function: main
	* @Description: TODO
	* @param: @param args  
	* @return：void
	* @throws： 
	*
	* @version: v1.0.0
	* @author: 李玉娇
	* @date: 2020年5月15日 下午10:58:48          
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date d= new Date();
		String time_now=format.format(d);
		System.out.println(time_now);
		System.out.println(time_now.length());
	}

}
