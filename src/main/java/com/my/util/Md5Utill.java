package com.my.util;

import org.springframework.util.DigestUtils;

/**
 * @Author: whmyit@163.com
 * @Description: 混淆MD5 不可逆
 * @Date: Created in 11:27  2018/1/12
 */
public class Md5Utill {
	
	private static final String slat ="1239)()_(*+@#($*$)(*";
	
	public static String getMd5(long seckillId){
		String base =seckillId+"/"+slat;;
		//spring 工具类
		String md5=DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

}
