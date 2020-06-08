package com.houyuli.cms.service;

import com.github.pagehelper.PageInfo;
import com.houyuli.cms.domain.Article;
import com.houyuli.cms.domain.Comments;

public interface CommentsService {
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
	 * 以文章id查询评论
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
	 * 修改文章表中的评论条数
	 * 
	 * @Title: updateArticleComments
	 * @Description: TODO
	 * @param articleId
	 * @return
	 * @return: int
	 */
	int updateArticleComments(Integer articleId);

	/**
	 * 查询评论排行榜
	 * 
	 * @Title: selectCommentsByOrder
	 * @Description: TODO
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> selectCommentsByOrder(Integer pageNum,Integer pageSize);
}
