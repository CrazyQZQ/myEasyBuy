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
public class Product_category implements Serializable {
	// idint(10)主键
	// namevarchar(20)名称
	// parentIdint(10)父级目录id
	// typeint(11)级别(1:一级 2：二级 3：三级)
	// iconClassvarchar(255)图标
	private int id;
	private String name;
	private int parentId;
	private int type;
	private String iconClass;

	private String parentName;

	public Product_category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product_category(String name, int parentId, int type,
			String iconClass) {
		super();
		this.name = name;
		this.parentId = parentId;
		this.type = type;
		this.iconClass = iconClass;
	}

	public Product_category(int id, String name, int parentId, int type,
			String iconClass) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
		this.iconClass = iconClass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}
