package com.easybuy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.entity.UserAddress;

public class UserAddressDaoImpl extends BaseDao implements UserAddressDao {
	/*
	 * 查询用户地址
	 */
	@Override
	public List<UserAddress> queryUserAdress(Integer id, Integer currentPageNo,
			Integer pageSize) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"select * from easybuy_user_address");
		List<Object> params = new ArrayList<Object>();
		if (id != null) {
			sql.append(" where userId=?");
			params.add(id);
		}
		if (currentPageNo != null) {
			params.add((currentPageNo - 1) * pageSize);
			params.add(pageSize);
			sql.append(" limit ?,?");
		}
		ResultSet rs = excuteSelect(sql.toString(), params.toArray());
		List<UserAddress> userAddressList = new ArrayList<UserAddress>();
		while (rs.next()) {
			UserAddress userAddress = new UserAddress();
			userAddress.setId(rs.getInt("id"));
			userAddress.setUserId(rs.getInt("userId"));
			userAddress.setAddress(rs.getString("address"));
			userAddress.setCreateTime(rs.getDate("createTime"));
			userAddress.setIsDefault(rs.getInt("isDefault"));
			userAddress.setRemark(rs.getString("remark"));
			userAddressList.add(userAddress);
		}
		return userAddressList;
	}

	/*
	 * 创建新地址
	 */
	@Override
	public int createNewAddress(UserAddress userAddress) throws SQLException {
		int result = 0;
		String sql = "insert into easybuy_user_address (userId,address,createTime,isDefault,remark) values(?,?,?,?,?)";
		Object[] params = { userAddress.getUserId(), userAddress.getAddress(),
				userAddress.getCreateTime(), userAddress.getIsDefault(),
				userAddress.getRemark() };
		result = excuteUpdate(sql, params);
		return result;
	}

	/*
	 * 根据id查询地址
	 */
	@Override
	public UserAddress queryAddressById(int id) throws SQLException {
		String sql = "select * from easybuy_user_address where id=?";
		Object[] params = { id };
		ResultSet rs = excuteSelect(sql, params);
		UserAddress userAddress = new UserAddress();
		while (rs.next()) {
			userAddress.setId(rs.getInt("id"));
			userAddress.setUserId(rs.getInt("userId"));
			userAddress.setAddress(rs.getString("address"));
			userAddress.setCreateTime(rs.getDate("createTime"));
			userAddress.setIsDefault(rs.getInt("isDefault"));
			userAddress.setRemark(rs.getString("remark"));
		}
		return userAddress;
	}

}
