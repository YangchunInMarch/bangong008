package com.qq.common;

import java.util.UUID;

// 2月12-----3月15
public class BanUUID {
  
  public BanUUID() {}
  public static String getUUID() {
	  UUID u=UUID.randomUUID();
	  String uuid=u.toString();
	  String temp=uuid.substring(0, 8)+uuid.substring(9,13)+uuid.substring(14,18)+uuid.substring(19,23)+uuid.substring(24);
	  return temp;
  }
  
  public static String getUUID2() {
	  //做字符串的截取
	  //1.将字符串以-分割，利用数组，对数组进行赋值，去掉-以前的内容，循环
	  UUID u = UUID.randomUUID();
		String uuid = u.toString();
		char[] aaa=uuid.toCharArray();
		StringBuffer arr = new StringBuffer();
		for(int i=0;i<uuid.length();i++) {
			String a1=String.valueOf(aaa[i]);
			if(!a1.equals("-")) 
				arr.append(a1);
		}
	  return arr.toString();
	  
  }
}
