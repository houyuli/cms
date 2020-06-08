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
	 * 进入个人中心主页
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
	 * 文章列表
	 * 
	 * @Title: index
	 * @Description: TODO
	 * @param model
	 * @param pageNum  第几页
	 * @param pageSize 分几条显示
	 * @param article  模糊查询条件
	 * @return
	 * @return: String 返回location
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
	 * 查询单个文章详情
	 * 
	 * @Title: selectArticle
	 * @Description: TODO
	 * @param model
	 * @param id    根据id查询
	 * @return
	 * @return: Article ajax返回数据
	 */
	@RequestMapping("selectArticleById")
	@ResponseBody
	public Article selectArticle(Model model, Integer id) {
		// System.out.println("+++++++++++++++++++++++++++++++"+id);
		return articleService.selectArticle(id);
	}

	/**
	 * 去发布文章页面
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
	 * 二级联动使用 返回所有栏目类型
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
	 * 二级联动 根据栏目id查询分类
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
	 * 文章的添加
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
		// 文件上传
		if (null != file && !file.isEmpty()) {
			// 文件上传的路径
			String path = "e:/pic/";
			// 防止文件重名,使用工具类中的uuid给文件重命名
			// 获取名字
			String originalFileName = file.getOriginalFilename();
			// 截取原始文件后缀。并调用工具类产生新的文件名
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
		// 文章默认值
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		article.setCreated(new Date());
		System.out.println("++++++++++++++++" + article);
		return articleService.insertArticle(article) > 0;
	}
}
