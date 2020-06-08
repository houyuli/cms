package com.houyuli.cms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.houyuli.cms.domain.Article;
import com.houyuli.cms.domain.Category;
import com.houyuli.cms.domain.Channel;
import com.houyuli.cms.domain.Comments;
import com.houyuli.cms.domain.Slide;
import com.houyuli.cms.domain.User;
import com.houyuli.cms.service.ArticleService;
import com.houyuli.cms.service.ChannelService;
import com.houyuli.cms.service.CommentsService;
import com.houyuli.cms.service.SlideService;
import com.houyuli.common.utils.DateUtil;

@Controller
public class IndexController {

	@Resource
	private ChannelService channelService;
	@Resource
	private ArticleService articleService;
	@Resource
	private SlideService slideService;
	@Resource
	private CommentsService commentsService;

	@RequestMapping(value = { "", "/", "index" })
	public String index(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "6") Integer pageSize, Article article) {
		// 查询所有栏目
		List<Channel> channels = channelService.selectChannels();
		model.addAttribute("channels", channels);
		// 如果栏目id不是null那么根据栏目查询
		if (article.getChannelId() != null) {
			// 栏目下分类
			List<Category> categorys = channelService.selectCategorys(article.getCategoryId());
			model.addAttribute("categorys", categorys);
			// 栏目下文章
			PageInfo<Article> info = articleService.selectArticles(article, pageNum, pageSize);
			model.addAttribute("info", info);
		}
		// 如果点击热点或者没点击栏目 就显示热点文章
		if (article.getChannelId() == null) {
			// 查询热点文章
			article.setHot(1);
			PageInfo<Article> info = articleService.selectArticles(article, 0, 5);
			model.addAttribute("info", info);
			// 查询广告
			List<Slide> slides = slideService.selectSlides();
			model.addAttribute("slides", slides);
		}
		// 显示热文 一天内的前4条
		// 获取昨天日期
		Date startDate = DateUtil.SubDate(new Date(), -1);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++" + startDate.toString());
		article.setCreated(startDate);
		// 设置热点文章
		article.setHot(1);
		PageInfo<Article> hotArticle = articleService.selectArticles(article, 1, 4);
		model.addAttribute("hot24Articles", hotArticle);
		return "index/index";
	}

	/**
	 * 查询文章详情
	 * 
	 * @Title: detail
	 * @Description: TODO
	 * @param model
	 * @param id
	 * @return
	 * @return: String
	 */
	@RequestMapping("detail")
	public String detail(Model model, Integer id,@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "5") Integer pageSize) {
		Article article = articleService.selectArticle(id);
		model.addAttribute("article", article);
		PageInfo<Comments> info = commentsService.selectCommentsByArticleId(id, pageNum, pageSize);
		model.addAttribute("info", info);
		PageInfo<Article> info2 = commentsService.selectCommentsByOrder(1, 10);
		model.addAttribute("info2", info2);
		return "index/article";
	}
	
	@RequestMapping("addComments")
	@ResponseBody
	public boolean addComments(Comments comments,HttpSession session) {
		User user = (User) session.getAttribute("user");
		comments.setUserId(user.getId());
		comments.setCreated(new Date());
		commentsService.updateArticleComments(comments.getArticleId());
		return commentsService.insertComments(comments) > 0;
	}

}
