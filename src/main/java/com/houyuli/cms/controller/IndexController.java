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
		// ��ѯ������Ŀ
		List<Channel> channels = channelService.selectChannels();
		model.addAttribute("channels", channels);
		// �����Ŀid����null��ô������Ŀ��ѯ
		if (article.getChannelId() != null) {
			// ��Ŀ�·���
			List<Category> categorys = channelService.selectCategorys(article.getCategoryId());
			model.addAttribute("categorys", categorys);
			// ��Ŀ������
			PageInfo<Article> info = articleService.selectArticles(article, pageNum, pageSize);
			model.addAttribute("info", info);
		}
		// �������ȵ����û�����Ŀ ����ʾ�ȵ�����
		if (article.getChannelId() == null) {
			// ��ѯ�ȵ�����
			article.setHot(1);
			PageInfo<Article> info = articleService.selectArticles(article, 0, 5);
			model.addAttribute("info", info);
			// ��ѯ���
			List<Slide> slides = slideService.selectSlides();
			model.addAttribute("slides", slides);
		}
		// ��ʾ���� һ���ڵ�ǰ4��
		// ��ȡ��������
		Date startDate = DateUtil.SubDate(new Date(), -1);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++" + startDate.toString());
		article.setCreated(startDate);
		// �����ȵ�����
		article.setHot(1);
		PageInfo<Article> hotArticle = articleService.selectArticles(article, 1, 4);
		model.addAttribute("hot24Articles", hotArticle);
		return "index/index";
	}

	/**
	 * ��ѯ��������
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
