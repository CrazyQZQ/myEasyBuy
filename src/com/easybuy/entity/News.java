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
public class News implements Serializable {
	private Integer id;// ID
	private String title;// 标题
	private String content;// 内容
	private Date createTime;// 创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
