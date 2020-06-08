package com.houyuli.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.houyuli.cms.domain.Article;
import com.houyuli.cms.domain.Comments;

public interface CommentsMapper {

	/**
	 * 添加评论
	 * 
	 * @Title: insertComments
	 * @Description: TODO
	 * @param comments
	 * @return
	 * @return: int
	 */
	int insertComments(Comments comments);

	/**
	 * 根据文章id查询评论
	 * 
	 * @Title: selectCommentsByArticleId
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: List<Comments>
	 */
	List<Comments> selectCommentsByArticleId(@Param("id") Integer id);

	/**
	 * 修改文章中的评论条数
	 * 
	 * @Title: updateArticleComments
	 * @Description: TODO
	 * @return
	 * @return: int
	 */
	int updateArticleComments(@Param("articleId") Integer articleId);

	/**
	 * 查询评论排行榜
	 * 
	 * @Title: selectComments
	 * @Description: TODO
	 * @return
	 * @return: List<Comments>
	 */
	List<Article> selectCommentsByOrder();
}
