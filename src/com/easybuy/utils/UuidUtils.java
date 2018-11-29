package com.easybuy.utils;

import java.util.UUID;

public class UuidUtils {
	public static String randomUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "").toUpperCase();
	}

	public static String toAllUpperCase(String uuid) {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < uuid.length(); i++) {
			char c = uuid.charAt(i);
			if (Character.isLowerCase(c)) {
				buffer.append(Character.toUpperCase(c));
			} else {
				buffer.append(c);
			}
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(randomUUID());
	}
}
