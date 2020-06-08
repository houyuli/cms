package com.houyuli.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.houyuli.cms.dao.CommentsMapper;
import com.houyuli.cms.domain.Article;
import com.houyuli.cms.domain.Comments;
import com.houyuli.cms.service.CommentsService;
import com.houyuli.common.utils.DateUtil;
@Service
public class CommentsServiceImpl implements CommentsService{
	
	@Resource
	private CommentsMapper commentsMapper;

	@Override
	public int insertComments(Comments comments) {
		return commentsMapper.insertComments(comments);
	}

	@Override
	public PageInfo<Comments> selectCommentsByArticleId(Integer id, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Comments> list = commentsMapper.selectCommentsByArticleId(id);
		for (Comments comments : list) {
			String displayTime = DateUtil.getDisplayTime(comments.getCreated());
			comments.setDisplayTime(displayTime);
		}
		return new PageInfo<Comments>(list);
	}

	@Override
	public int updateArticleComments(Integer articleId) {
		return	commentsMapper.updateArticleComments(articleId);
	}

	@Override
	public PageInfo<Article> selectCommentsByOrder(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Article> list = commentsMapper.selectCommentsByOrder();
		return new PageInfo<Article>(list);
	}
	
}
