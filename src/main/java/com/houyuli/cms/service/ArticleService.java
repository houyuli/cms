package com.houyuli.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.houyuli.cms.domain.Article;

public interface ArticleService {
	/**
	 * ���µ�ģ����ѯ
	 * 
	 * @Title: selectArticles
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: List<Article>
	 */
	PageInfo<Article> selectArticles(Article article, Integer pageNum, Integer pageSize);

	/**
	 * ��ѯ��������
	 * 
	 * @Title: selectArticle
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article selectArticle(Integer id);

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
