package com.houyuli.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.houyuli.cms.domain.Article;
import com.houyuli.cms.domain.Category;
import com.houyuli.cms.domain.Channel;
import com.houyuli.cms.domain.User;
import com.houyuli.cms.service.ArticleService;
import com.houyuli.cms.service.ChannelService;
import com.houyuli.common.utils.RandomUtil;

@Controller
@RequestMapping("my")
public class MyController {

	@Resource
	private ArticleService articleService;
	@Resource
	private ChannelService channelService;

	/**
	 * �������������ҳ
	 * 
	 * @Title: index
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = { "", "index", "/" })
	public String index() {
		return "my/index";
	}

	/**
	 * �����б�
	 * 
	 * @Title: index
	 * @Description: TODO
	 * @param model
	 * @param pageNum  �ڼ�ҳ
	 * @param pageSize �ּ�����ʾ
	 * @param article  ģ����ѯ����
	 * @return
	 * @return: String ����location
	 */
	@RequestMapping("articles")
	public String index(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize, Article article) {
		PageInfo<Article> pageInfo = articleService.selectArticles(article, pageNum, pageSize);
		model.addAttribute("info", pageInfo);
		model.addAttribute("article", article);
		model.addAttribute("list", pageInfo.getList());
		return "my/articles";
	}

	/**
	 * ��ѯ������������
	 * 
	 * @Title: selectArticle
	 * @Description: TODO
	 * @param model
	 * @param id    ����id��ѯ
	 * @return
	 * @return: Article ajax��������
	 */
	@RequestMapping("selectArticleById")
	@ResponseBody
	public Article selectArticle(Model model, Integer id) {
		// System.out.println("+++++++++++++++++++++++++++++++"+id);
		return articleService.selectArticle(id);
	}

	/**
	 * ȥ��������ҳ��
	 * 
	 * @Title: publish
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@RequestMapping("toPublish")
	public String toPublish() {
		return "my/publish";
	}

	/**
	 * ��������ʹ�� ����������Ŀ����
	 * 
	 * @Title: channels
	 * @Description: TODO
	 * @return
	 * @return: List<Channel>
	 */
	@RequestMapping("channels")
	@ResponseBody
	public List<Channel> channels() {
		return channelService.selectChannels();
	}

	/**
	 * �������� ������Ŀid��ѯ����
	 * 
	 * @Title: categorys
	 * @Description: TODO
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	@RequestMapping("categorys")
	@ResponseBody
	public List<Category> categorys(Integer channelId) {
		return channelService.selectCategorys(channelId);
	}

	/**
	 * ���µ����
	 * 
	 * @Title: publish
	 * @Description: TODO
	 * @param article
	 * @param file
	 * @return
	 * @return: boolean
	 */
	@RequestMapping("publish")
	@ResponseBody
	public boolean publish(Article article, MultipartFile file,HttpSession session) {
		// �ļ��ϴ�
		if (null != file && !file.isEmpty()) {
			// �ļ��ϴ���·��
			String path = "e:/pic/";
			// ��ֹ�ļ�����,ʹ�ù������е�uuid���ļ�������
			// ��ȡ����
			String originalFileName = file.getOriginalFilename();
			// ��ȡԭʼ�ļ���׺�������ù���������µ��ļ���
			String fileName = RandomUtil.uuid() + originalFileName.substring(originalFileName.lastIndexOf("."));
			File f = new File(path, fileName);
			try {
				file.transferTo(f);
				article.setPicture(fileName);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ����Ĭ��ֵ
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		article.setCreated(new Date());
		System.out.println("++++++++++++++++" + article);
		return articleService.insertArticle(article) > 0;
	}
}
