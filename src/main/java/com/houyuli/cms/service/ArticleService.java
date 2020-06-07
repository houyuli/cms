package com.houyuli.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.houyuli.cms.domain.Article;

public interface ArticleService {
	/**
	 * 文章的模糊查询
	 * 
	 * @Title: selectArticles
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: List<Article>
	 */
	PageInfo<Article> selectArticles(Article article, Integer pageNum, Integer pageSize);

	/**
	 * 查询单个文章
	 * 
	 * @Title: selectArticle
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article selectArticle(Integer id);

	/**
	 * 文章发布
	 * 
	 * @Title: insertArticle
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: int
	 */
	int insertArticle(Article article);

	/**
	 * 文章修改
	 * 
	 * @Title: updateArticle
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: int
	 */
	int updateArticle(Article article);
}
