package com.easybuy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.entity.CheckCode;

public class CheckCodeDaoImpl extends BaseDao implements CheckCodeDao {
	/*
	 * 查询所有的验证码集合
	 */
	@Override
	public List<CheckCode> queryCheckCode() throws SQLException {
		String sql = "select * from easybuy_checkcode";
		ResultSet rs = excuteSelect(sql, null);
		List<CheckCode> checkCodeList = new ArrayList<CheckCode>();
		while (rs.next()) {
			CheckCode checkCode = new CheckCode(rs.getString("name"),
					rs.getInt("id"), rs.getString("value"));
			checkCodeList.add(checkCode);
		}
		return checkCodeList;
	}

}
