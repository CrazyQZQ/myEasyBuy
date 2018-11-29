package com.easybuy.utils;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

public class SecurityUtils {

	/**
	 * md5加密
	 *
	 * @param value
	 *            要加密的数据
	 * @return md5加密后的数据
	 */
	public static String md5Hex(String value) {
		return DigestUtils.md5Hex(value);

	}

	/**
	 * 3次md5操作
	 * 
	 * @param value
	 * @return
	 */
	public static String md5Hex3(String value) {
		for (int i = 0; i < 3; i++) {
			value = DigestUtils.md5Hex(value);
		}
		return value;
	}

}
