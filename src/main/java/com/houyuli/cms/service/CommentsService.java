package com.houyuli.cms.service;

import com.github.pagehelper.PageInfo;
import com.houyuli.cms.domain.Article;
import com.houyuli.cms.domain.Comments;

public interface CommentsService {
	/**
	 * �������
	 * 
	 * @Title: insertComments
	 * @Description: TODO
	 * @param comments
	 * @return
	 * @return: int
	 */
	int insertComments(Comments comments);

	/**
	 * ������id��ѯ����
	 * 
	 * @Title: selectCommentsByArticleId
	 * @Description: TODO
	 * @param id
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @return: PageInfo<Comments>
	 */
	PageInfo<Comments> selectCommentsByArticleId(Integer id, Integer pageNum, Integer pageSize);

	/**
	 * �޸����±��е���������
	 * 
	 * @Title: updateArticleComments
	 * @Description: TODO
	 * @param articleId
	 * @return
	 * @return: int
	 */
	int updateArticleComments(Integer articleId);

	/**
	 * ��ѯ�������а�
	 * 
	 * @Title: selectCommentsByOrder
	 * @Description: TODO
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> selectCommentsByOrder(Integer pageNum,Integer pageSize);
}
