package com.easybuy.service;

import com.easybuy.entity.News;
import com.easybuy.entity.Page;

public interface NewsService {
	/*
	 * 分页查询
	 */
	Page<News> queryNewsPage(Integer currentPageNo, Integer pageSize);

	/*
	 * 删除新闻
	 */
	int daleteNews(int id);
}
