package com.easybuy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.CheckCodeDao;
import com.easybuy.dao.CheckCodeDaoImpl;
import com.easybuy.entity.CheckCode;

public class CheckCodeServiceImpl implements CheckCodeService {
	private CheckCodeDao ccd;

	public CheckCodeServiceImpl() {
		this.ccd = new CheckCodeDaoImpl();
	}

	/*
	 * 查询所有的验证码集合
	 */
	@Override
	public List<CheckCode> queryCheckCode() {
		List<CheckCode> checkCodeList = new ArrayList<CheckCode>();
		try {
			checkCodeList = ccd.queryCheckCode();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkCodeList;
	}

}
