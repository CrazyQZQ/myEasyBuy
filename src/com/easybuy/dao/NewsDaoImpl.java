package com.easybuy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easybuy.entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	/*
	 * 分页查询
	 */
	@Override
	public List<News> queryNews(Integer currentPageNo, Integer pageSize)
			throws SQLException {
		StringBuffer sql = new StringBuffer("select * from easybuy_news");
		List<Object> params = new ArrayList<Object>();
		if (currentPageNo != null) {
			params.add((currentPageNo - 1) * pageSize);
			params.add(pageSize);
			sql.append(" limit ?,?");
		}
		ResultSet rs = excuteSelect(sql.toString(), params.toArray());
		List<News> newsList = new ArrayList<News>();
		while (rs.next()) {
			News news = new News();
			news.setId(rs.getInt("id"));
			news.setTitle(rs.getString("title"));
			news.setContent(rs.getString("content"));
			news.setCreateTime(rs.getDate("createTime"));
			newsList.add(news);
		}
		return newsList;
	}

	/*
	 * 删除新闻
	 */
	@Override
	public int daleteNews(int id) throws SQLException {
		int result = 0;
		String sql = "delete from easybuy_news where id=?";
		Object[] params = { id };
		result = excuteUpdate(sql, params);
		return result;
	}

}
