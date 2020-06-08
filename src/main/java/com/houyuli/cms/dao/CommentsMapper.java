package com.houyuli.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.houyuli.cms.domain.Article;
import com.houyuli.cms.domain.Comments;

public interface CommentsMapper {

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
	 * ��������id��ѯ����
	 * 
	 * @Title: selectCommentsByArticleId
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: List<Comments>
	 */
	List<Comments> selectCommentsByArticleId(@Param("id") Integer id);

	/**
	 * �޸������е���������
	 * 
	 * @Title: updateArticleComments
	 * @Description: TODO
	 * @return
	 * @return: int
	 */
	int updateArticleComments(@Param("articleId") Integer articleId);

	/**
	 * ��ѯ�������а�
	 * 
	 * @Title: selectComments
	 * @Description: TODO
	 * @return
	 * @return: List<Comments>
	 */
	List<Article> selectCommentsByOrder();
}
