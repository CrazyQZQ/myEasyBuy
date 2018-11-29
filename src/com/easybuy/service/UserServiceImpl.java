package com.easybuy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.UserDao;
import com.easybuy.dao.UserDaoImpl;
import com.easybuy.entity.Page;
import com.easybuy.entity.Product;
import com.easybuy.entity.User;
import com.easybuy.utils.SecurityUtils;

public class UserServiceImpl implements UserService {
	private UserDao ud;

	public UserServiceImpl() {
		this.ud = new UserDaoImpl();
	}

	/*
	 * 注册
	 */
	@Override
	public boolean regist(User user) {
		int result = 0;
		boolean flag = false;
		try {
			List<User> userList = ud.queryUserList();
			for (User userTemp : userList) {
				if (userTemp.getLoginName().equals(user.getLoginName())
						&& user.getPassword().equals(userTemp.getPassword())) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				result = ud.insert(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result == 0 ? false : true;
	}

	/*
	 * 登录
	 */
	@Override
	public boolean login(String username, String password) {
		boolean flag = false;
		String pwd = SecurityUtils.md5Hex(password);
		try {
			List<User> userList = ud.queryUserList();
			for (User user : userList) {
				if (user.getLoginName().equals(username)
						&& pwd.equals(user.getPassword())) {
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * 查询所有用户信息
	 */
	@Override
	public List<User> queryUserList() {
		List<User> userList = new ArrayList<User>();
		try {
			userList = ud.queryUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	/*
	 * 根据loginname查询用户
	 */
	@Override
	public User queryUser(String loginName) {
		User user = new User();
		try {
			user = ud.queryUser(loginName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/*
	 * 分页查询
	 */
	@Override
	public Page<User> queryUserList(Integer currentPageNo, Integer pageSize) {
		Page<User> page = null;
		List<User> userList = new ArrayList<User>();
		try {
			userList = ud.queryUserList(currentPageNo, pageSize);
			int totalCount = ud.queryUserList(null, null).size();
			page = new Page<User>(currentPageNo, pageSize, totalCount, userList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	/*
	 * 删除用户(数据库中仍存在)
	 */
	@Override
	public int deleteUserById(int id) {
		int result = 0;
		try {
			result = ud.deleteUserById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
