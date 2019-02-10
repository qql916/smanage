package com.xnxy.stu.utils;

import java.nio.file.attribute.AclEntry.Builder;

public class CodeRandom {
	/**
	 * 生成随机验证码
	 * @param number生成验证码的位数
	 * @return
	 */
	public static String codeRandom(Integer number) {
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0;i<number;i++) {
			double random = Math.random()*10;
			int num = (int) random;
			stringBuilder.append(num);
		}
		
		return stringBuilder.toString();
	}

}
