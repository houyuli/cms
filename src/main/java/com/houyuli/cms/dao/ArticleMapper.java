package com.houyuli.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.houyuli.cms.domain.Article;

/**
 * 文章的mapper
 * 
 * @ClassName: ArticleMapper
 * @Description: TODO
 * @author: King
 * @date: 2020年5月31日 下午2:51:22
 */
public interface ArticleMapper {
	/**
	 * 文章的模糊查询
	 * 
	 * @Title: selectArticles
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selectArticles(Article article);

	/**
	 * 查询单个文章
	 * 
	 * @Title: selectArticle
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article selectArticle(@Param("id") Integer id);

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
