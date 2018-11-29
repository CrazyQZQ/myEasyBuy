package com.easybuy.service;

import java.util.List;

import com.easybuy.entity.CheckCode;

public interface CheckCodeService {
	/*
	 * 查询所有的验证码集合
	 */
	List<CheckCode> queryCheckCode();
}
