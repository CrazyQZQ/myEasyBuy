package com.easybuy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <一句话功能简述>
 * 
 * @author 秦强
 * @version [V1.00, 2018年9月27日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class UserAddress implements Serializable {

	private Integer id;

	private String address;

	private Integer userId;

	private Date createTime;// 创建时间

	private String remark;

	private Integer isDefault;

	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddress(String address, Integer userId, Date createTime,
			String remark, Integer isDefault) {
		super();
		this.address = address;
		this.userId = userId;
		this.createTime = createTime;
		this.remark = remark;
		this.isDefault = isDefault;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
