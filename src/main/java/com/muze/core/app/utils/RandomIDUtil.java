package com.muze.core.app.utils;

import java.util.Random;

public class RandomIDUtil {

	private static char[] chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R'
		,'S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m'
		,'n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
	
	public static  String getRandomID(int i){
		
		Random  random = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int j = 0; j < i; j++) {
			char c = chars[random.nextInt(61)];
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}
}
