package com.easybuy.utils;

import java.util.regex.Pattern;

public class NumUtil {
	/*
	 * 获得限定范围随机数
	 */
	public static int getRandomNum(int start, int end) {
		return (int) (start + Math.random() * (end + 1));
	}

	/*
	 * 获得限定范围随机数(与输入数字不同)
	 */
	public static int getRandomNum(int start, int end, int num) {
		int result = 0;
		while (true) {
			int random = getRandomNum(start, end);
			if (random != num) {
				result = random;
				break;
			}
		}
		return result;
	}

	/*
	 * 判断输入是否为数字
	 */
	public static boolean isInteger(String num) {
		Pattern patten = Pattern.compile("^\\d*$");
		return patten.matcher(num).matches();
	}
}
