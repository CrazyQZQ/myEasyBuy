package com.easybuy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.easybuy.utils.JdbcUtil;

/**
 * 操作数据库的基类 <一句话功能简述>
 * 
 * @author 秦强
 * @version [V1.00, 2018年9月7日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class BaseDao {

	/*
	 * 查询
	 */
	public ResultSet excuteSelect(String sql, Object[] params)
			throws SQLException {
		ResultSet rs = null;
		Connection conn = JdbcUtil.getConnection();

		PreparedStatement pasm = conn.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pasm.setObject(i + 1, params[i]);
			}
		}
		rs = pasm.executeQuery();
		// if (conn.getAutoCommit()) {
		// JdbcUtil.closeResource(conn, pasm, null);
		// }
		return rs;
	}

	/*
	 * 更新
	 */
	public int excuteUpdate(String sql, Object[] params) throws SQLException {
		int updateRows = 0;
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pasm = conn.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			pasm.setObject(i + 1, params[i]);
		}
		updateRows = pasm.executeUpdate();
		// if (conn.getAutoCommit()) {
		// JdbcUtil.closeResource(conn, pasm, null);
		// }
		return updateRows;
	}

}
