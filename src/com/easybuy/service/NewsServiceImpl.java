package com.easybuy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.dao.NewsDao;
import com.easybuy.dao.NewsDaoImpl;
import com.easybuy.entity.News;
import com.easybuy.entity.Page;

public class NewsServiceImpl implements NewsService {
	private NewsDao nd;

	public NewsServiceImpl() {
		this.nd = new NewsDaoImpl();
	}

	/*
	 * 分页查询
	 */
	@Override
	public Page<News> queryNewsPage(Integer currentPageNo, Integer pageSize) {
		Page<News> page = null;
		List<News> newsList = new ArrayList<News>();
		try {
			newsList = nd.queryNews(currentPageNo, pageSize);
			int totalCount = nd.queryNews(null, null).size();
			page = new Page<News>(currentPageNo, pageSize, totalCount, newsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	/*
	 * 删除新闻
	 */
	@Override
	public int daleteNews(int id) {
		int result = 0;
		try {
			result = nd.daleteNews(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
