package com.easybuy.entity;

import java.io.Serializable;

/**
 * 
 * <一句话功能简述>
 * 
 * @author 秦强
 * @version [V1.00, 2018年9月27日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class User implements Serializable {
	// idint(20)主键
	// loginNamevarchar(255)登录名
	// userNamevarchar(255)用户名
	// passwordvarchar(255)密码
	// sexint(2)性别(1:男 0：女)
	// identityCodevarchar(60)身份证号
	// emailvarchar(80)邮箱
	// mobilevarchar(11)手机
	// typeint(2)类型（1：后台 0:前台）
	private int id;
	private String loginName;
	private String userName;
	private String password;
	private int sex;
	private String identityCode;
	private String email;
	private String mobile;
	private int type;
	private int isDelete;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String loginName, String password, String email, String mobile,
			int type, int isDelete) {
		super();
		this.loginName = loginName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
		this.isDelete = isDelete;
	}

	public User(String loginName, String userName, String password, int sex,
			String identityCode, String email, String mobile, int type,
			int isDelete) {
		super();
		this.loginName = loginName;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
		this.isDelete = isDelete;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
