/**   
 * @Title: CommonTest.java
 * @Package: com.qq.test 
 * @author: 刘紫薇
 * @date: 2020年3月20日 下午5:13:06 
 */
package com.qq.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.qq.common.MyUtils;

/**   
* @ClassName: CommonTest
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月20日 下午5:13:06 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月20日     Administrator           v1.0.0               修改原因
*/
public class CommonTest {

	@Test
	public void test01() {
		String strs="a,b,c,d,e";
		String[] string=strs.split(",");
		String ping="";
		for(String str:string) {
			System.out.println(str);
		ping+=str+"-";
		}
		System.out.println(ping);
	}
	
	@Test
	public void test02() {
		System.out.println(MyUtils.getDay());
		System.out.println(MyUtils.getMonth());
	}
	
	@Test
	public void test03() {
		String now=MyUtils.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("hhmm");
		
		try {
			  Date d1 = sdf.parse("0900");
			  Date d2  = sdf.parse("0800");
			  long result = d1.getTime()-d2.getTime();
			  System.out.println(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		  
	}
}
