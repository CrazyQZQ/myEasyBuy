package com.easybuy.service;

import java.util.List;

import com.easybuy.entity.Page;
import com.easybuy.entity.UserAddress;

public interface UserAddressService {
	/*
	 * 分页查询
	 */
	Page<UserAddress> queryUserAddressList(Integer id, Integer currentPageNo,
			Integer pageSize);

	/*
	 * 查询用户地址
	 */
	List<UserAddress> queryUserAdressByUserId(Integer id);

	/*
	 * 创建新地址
	 */
	int createNewAddress(UserAddress userAddress);

	/*
	 * 根据id查询地址
	 */
	UserAddress queryAddressById(int id);
}
