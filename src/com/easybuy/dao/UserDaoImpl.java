package com.easybuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.entity.User;
import com.easybuy.utils.JdbcUtil;
import com.easybuy.utils.SecurityUtils;

public class UserDaoImpl extends BaseDao implements UserDao {
	/*
	 * 注册
	 */
	@Override
	public int insert(User user) throws SQLException {
		Connection conn = JdbcUtil.getConnection();
		String password = SecurityUtils.md5Hex(user.getPassword());
		String sql = " insert into easybuy_user (loginName,username,password,sex,identityCode,email,mobile,type,isDelete) "
				+ "values(?,?,?,?,?,?,?,?,?) ";
		Object[] params = { user.getLoginName(), user.getUserName(), password,
				user.getSex(), user.getIdentityCode(), user.getEmail(),
				user.getMobile(), user.getType(), user.getIsDelete() };
		int result = excuteUpdate(sql, params);
		return result;
	}

	/*
	 * 查询所有用户信息
	 */
	@Override
	public List<User> queryUserList() throws SQLException {
		String sql = "select * from easybuy_user where isDelete=0";
		ResultSet rs = excuteSelect(sql, null);
		List<User> userList = new ArrayList<>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setLoginName(rs.getString("loginName"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getInt("sex"));
			user.setIdentityCode(rs.getString("identityCode"));
			user.setEmail(rs.getString("email"));
			user.setMobile(rs.getString("mobile"));
			user.setType(rs.getInt("type"));
			userList.add(user);
		}
		return userList;
	}

	/*
	 * 根据loginname查询用户
	 */
	@Override
	public User queryUser(String loginName) throws SQLException {
		String sql = "select * from easybuy_user where loginName=?";
		Object[] params = { loginName };
		ResultSet rs = excuteSelect(sql, params);
		User user = new User();
		if (rs.next()) {
			user.setId(rs.getInt("id"));
			user.setLoginName(rs.getString("loginName"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getInt("sex"));
			user.setIdentityCode(rs.getString("identityCode"));
			user.setEmail(rs.getString("email"));
			user.setMobile(rs.getString("mobile"));
			user.setType(rs.getInt("type"));
		}
		return user;
	}

	/*
	 * 分页查询查询用户信息
	 */
	@Override
	public List<User> queryUserList(Integer currentPageNo, Integer pageSize)
			throws SQLException {
		StringBuffer sql = new StringBuffer("select * from easybuy_user");
		sql.append(" where isDelete=0");
		List<Object> params = new ArrayList<Object>();
		if (currentPageNo != null) {
			params.add((currentPageNo - 1) * pageSize);
			params.add(pageSize);
			sql.append(" limit ?,?");
		}
		ResultSet rs = excuteSelect(sql.toString(), params.toArray());
		List<User> userList = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setLoginName(rs.getString("loginName"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getInt("sex"));
			user.setIdentityCode(rs.getString("identityCode"));
			user.setEmail(rs.getString("email"));
			user.setMobile(rs.getString("mobile"));
			user.setType(rs.getInt("type"));
			userList.add(user);
		}
		return userList;
	}

	/*
	 * 删除用户(数据库中仍存在)
	 */
	@Override
	public int deleteUserById(int id) throws SQLException {
		int result = 0;
		String sql = "update easybuy_user set isDelete=1 where id=?";
		Object[] params = { id };
		result = excuteUpdate(sql, params);
		return result;
	}
}
