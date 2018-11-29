package com.easybuy.entity;

import java.util.List;

public class Page<T> {
	private int currPageNo = 1;// 当前页码
	private int pageSize = 4; // 页面大小，即每页显示记录数
	private int totalCount; // 记录总数
	private int totalPageCount; // 总页数
	private List<T> objList; // 每页集合

	public Page(int currPageNo, int pageSize, int totalCount, List<T> objList) {
		super();
		this.currPageNo = currPageNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.objList = objList;
	}

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

	}

	public int getTotalPageCount() {
		totalPageCount = (this.totalCount % pageSize == 0) ? (this.totalCount / pageSize)
				: (this.totalCount / pageSize + 1);
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public List<T> getObjList() {
		return objList;
	}

	public void setObjList(List<T> objList) {
		this.objList = objList;
	}

}
