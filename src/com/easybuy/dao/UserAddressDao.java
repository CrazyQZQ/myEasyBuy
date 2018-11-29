package com.easybuy.dao;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.entity.UserAddress;

public interface UserAddressDao {
	/*
	 * 查询用户地址
	 */
	List<UserAddress> queryUserAdress(Integer id, Integer currentPageNo,
			Integer pageSize) throws SQLException;

	/*
	 * 创建新地址
	 */
	int createNewAddress(UserAddress userAddress) throws SQLException;

	/*
	 * 根据id查询地址
	 */
	UserAddress queryAddressById(int id) throws SQLException;
}
