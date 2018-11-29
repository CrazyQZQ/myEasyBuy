package com.easybuy.dao;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.entity.User;

public interface UserDao {
	/*
	 * 注册
	 */
	int insert(User user) throws SQLException;

	/*
	 * 查询所有用户信息
	 */
	List<User> queryUserList() throws SQLException;

	/*
	 * 根据loginname查询用户
	 */
	User queryUser(String loginName) throws SQLException;

	/*
	 * 分页查询查询用户信息
	 */
	List<User> queryUserList(Integer currentPageNo, Integer pageSize)
			throws SQLException;

	/*
	 * 删除用户(数据库中仍存在)
	 */
	int deleteUserById(int id) throws SQLException;
}
