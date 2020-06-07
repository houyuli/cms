package com.houyuli.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.houyuli.cms.domain.Article;

/**
 * ���µ�mapper
 * 
 * @ClassName: ArticleMapper
 * @Description: TODO
 * @author: King
 * @date: 2020��5��31�� ����2:51:22
 */
public interface ArticleMapper {
	/**
	 * ���µ�ģ����ѯ
	 * 
	 * @Title: selectArticles
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selectArticles(Article article);

	/**
	 * ��ѯ��������
	 * 
	 * @Title: selectArticle
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article selectArticle(@Param("id") Integer id);

	/**
	 * ���·���
	 * 
	 * @Title: insertArticle
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: int
	 */
	int insertArticle(Article article);

	/**
	 * �����޸�
	 * 
	 * @Title: updateArticle
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: int
	 */
	int updateArticle(Article article);
}
