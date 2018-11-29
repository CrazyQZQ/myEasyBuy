package com.easybuy.entity;

import java.io.Serializable;

public class CheckCode implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private String value;

	public CheckCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckCode(String name, int id, String value) {
		super();
		this.name = name;
		this.id = id;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
