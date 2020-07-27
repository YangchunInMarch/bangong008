package com.qq.common;

import java.util.StringTokenizer;

/**   
* @ClassName: JudgeEmpty
* @Description: TODO
*
* @version: v1.0.0
* @author: 刘紫薇
* @date: 2020年3月19日 上午9:49:26 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年3月19日     Administrator           v1.0.0               修改原因
*/
public class JudgeEmpty {

	public static boolean  isEmpty(Object obj) { //如果是空的话，就返回true
		if(obj==null||obj.equals(null)||obj=="") {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean  stringIsEmpty(String obj) { //如果是空的话，就返回true
		if(obj==null||obj.length()<=0||obj=="") {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean notEquals(String target1,String target2) {
		if(!target1.equals(target2)) return true; //不相等的话，就返回true
		else return false;
	}
	
	public static boolean isEquals(String target1,String target2) {
		if(target1.equals(target2)) return true; //相等的话，就返回true
		else return false;
	}
	
	public static boolean isExist(String uid,String nicePeople) {
		StringTokenizer token = new StringTokenizer(nicePeople, ",");
	 
		  boolean target=true;
			while(token.hasMoreElements()&&target) {
			//	System.out.println("while:");
				String a=token.nextToken();
				if(uid.equals(a)) {
					//该人已经点赞
				//	System.out.println("d___a:"+a);
					target=false;
					return true;
				} 
				
			}
			return false;  //该人没有点赞
		}
	
	public static boolean isExist02(String uid,String nicePeople) {
	 String[] strs=nicePeople.split(",");
	 for(String s:strs) {
		 if(uid.equals(s)) {
			 return true;
		 }
		// System.out.println("-"+s);
	 }
		  
			return false;  //该人没有点赞
		}
	
	
}
