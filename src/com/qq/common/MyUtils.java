/**   
 * @Title: MyUtils.java
 * @Package: com.qq.common 
 * @author: 刘紫薇
 * @date: 2020年3月21日 上午7:46:11 
 */
package com.qq.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**   
* @ClassName: MyUtils
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月21日 上午7:46:11 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月21日     Administrator           v1.0.0               修改原因
*/
public class MyUtils {

	public static String getDay() {  //获取当前日期，并格式化
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date());
	}
	
	public static String getMonth() {  //获取当前月份，并格式化
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
		return format.format(new Date());
	}
	
	public static String getTime() {  //获取当前时刻，并格式化
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date d= new Date();
		return format.format(d);
	}
	
	public static boolean getMorning() {
		//判断上午是否在规定时间内打卡
		SimpleDateFormat format=new SimpleDateFormat("hhmm");
		//现在时刻
		String now=format.format(new Date());
		
		try {
			Date d1=format.parse("0830");
			Date d2=format.parse("0900");
			Date d_now=format.parse(now);
		    long result1 = d_now.getTime()-d1.getTime();
		    long result2 = d2.getTime()-d_now.getTime();
		    if(result1>0&&result2>0) return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean getAfternoon() {
		//判断上午是否在规定时间内打卡
		SimpleDateFormat format=new SimpleDateFormat("hhmm");
		//现在时刻
		String now=format.format(new Date());
		
		try {
			Date d1=format.parse("1800");
			Date d2=format.parse("2300");
			Date d_now=format.parse(now);
		    long result1 = d_now.getTime()-d1.getTime();
		    long result2 = d2.getTime()-d_now.getTime();
		    if(result1>0&&result2>0) return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
