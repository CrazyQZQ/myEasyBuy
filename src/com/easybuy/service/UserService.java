package com.easybuy.service;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.entity.Page;
import com.easybuy.entity.Product;
import com.easybuy.entity.User;

public interface UserService {
	/*
	 * 注册
	 */
	boolean regist(User user);

	/*
	 * 登录
	 */
	boolean login(String username, String password);

	/*
	 * 查询所有用户信息
	 */
	List<User> queryUserList();

	/*
	 * 根据loginname查询用户
	 */
	User queryUser(String loginName) throws SQLException;

	/*
	 * 分页查询
	 */
	Page<User> queryUserList(Integer currentPageNo, Integer pageSize);

	/*
	 * 删除用户(数据库中仍存在)
	 */
	int deleteUserById(int id);
}
