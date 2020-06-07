package com.houyuli.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.houyuli.cms.dao.ArticleMapper;
import com.houyuli.cms.domain.Article;
import com.houyuli.cms.service.ArticleService;
import com.houyuli.common.utils.DateUtil;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper articleMapper;

	@Override
	public PageInfo<Article> selectArticles(Article article, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Article> list = articleMapper.selectArticles(article);
		//遍历LIST集合,然后 调用时间工具类的人性化时然后setdisplayTime
		for (Article article2 : list) {
			Date date = article2.getCreated();
			String displayTime = DateUtil.getDisplayTime(date);
			article2.setDisplayDate(displayTime);
		}
		PageInfo<Article> info = new PageInfo<Article>(list);
		return info;
	}

	@Override
	public Article selectArticle(Integer id) {
		return articleMapper.selectArticle(id);
	}

	@Override
	public int insertArticle(Article article) {
		return articleMapper.insertArticle(article);
	}

	@Override
	public int updateArticle(Article article) {
		return articleMapper.updateArticle(article);
	}

}
