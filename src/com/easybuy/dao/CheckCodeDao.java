package com.easybuy.dao;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.entity.CheckCode;

public interface CheckCodeDao {
	/*
	 * 查询所有的验证码集合
	 */
	List<CheckCode> queryCheckCode() throws SQLException;
}
