package com.easybuy.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {

	public static Connection conn;
	public static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	/*
	 * 获取连接
	 */
	public static Connection getConnection() throws SQLException {
		conn = tl.get();
		if (null == conn) {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			conn = cpds.getConnection();
			tl.set(conn);
		}
		return conn;
	}

	/*
	 * 判断输入是否为数字
	 */
	public static boolean isInteger(String num) {
		Pattern patten = Pattern.compile("^\\d*$");
		return patten.matcher(num).matches();
	}

	// 释放资源
	public static void closeResource(Connection conn, PreparedStatement pstm,
			ResultSet rs) {
		if (null != conn) {
			try {
				conn.close();
				conn = null;
				tl.set(null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != pstm) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
