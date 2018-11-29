package com.easybuy.dao;

import java.sql.SQLException;
import java.util.List;

import com.easybuy.entity.News;

public interface NewsDao {
	/*
	 * 分页查询
	 */
	List<News> queryNews(Integer currentPageNo, Integer pageSize)
			throws SQLException;

	/*
	 * 删除新闻
	 */
	int daleteNews(int id) throws SQLException;
}
