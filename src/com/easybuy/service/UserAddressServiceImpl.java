package com.easybuy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.UserAddressDao;
import com.easybuy.dao.UserAddressDaoImpl;
import com.easybuy.entity.Page;
import com.easybuy.entity.UserAddress;

public class UserAddressServiceImpl implements UserAddressService {
	private UserAddressDao uad;

	public UserAddressServiceImpl() {
		this.uad = new UserAddressDaoImpl();
	}

	/*
	 * 分页查询
	 */
	@Override
	public Page<UserAddress> queryUserAddressList(Integer id,
			Integer currentPageNo, Integer pageSize) {
		Page<UserAddress> page = null;
		List<UserAddress> userAddressList = new ArrayList<UserAddress>();
		try {
			userAddressList = uad.queryUserAdress(id, currentPageNo, pageSize);
			int totalCount = uad.queryUserAdress(id, null, null).size();
			page = new Page<UserAddress>(currentPageNo, pageSize, totalCount,
					userAddressList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	/*
	 * 查询用户地址
	 */
	@Override
	public List<UserAddress> queryUserAdressByUserId(Integer id) {
		List<UserAddress> userAddressList = new ArrayList<UserAddress>();
		try {
			userAddressList = uad.queryUserAdress(id, null, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userAddressList;
	}

	/*
	 * 创建新地址
	 */
	@Override
	public int createNewAddress(UserAddress userAddress) {
		int result = 0;
		try {
			result = uad.createNewAddress(userAddress);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 根据id查询地址
	 */
	@Override
	public UserAddress queryAddressById(int id) {
		UserAddress userAddress = null;
		try {
			userAddress = uad.queryAddressById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userAddress;
	}

}
