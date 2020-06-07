package com.houyuli.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.houyuli.cms.domain.Article;
import com.houyuli.cms.domain.User;
import com.houyuli.cms.service.ArticleService;
import com.houyuli.cms.service.UserService;
import com.houyuli.cms.vo.UserVo;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Resource
	private ArticleService articleService;
	@Resource
	private UserService userService;

	/**
	 * 进入管理员首页
	 * 
	 * @Title: index
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = { "", "/", "index" })
	public String index() {
		return "admin/index";
	}

	/**
	 * 查询所有文章
	 * 
	 * @Title: articles
	 * @Description: TODO
	 * @param model
	 * @param article
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(Model model, Article article, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "5") Integer pageSize) {
		PageInfo<Article> info = articleService.selectArticles(article, pageNum, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("article", article);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++" + article);
		return "admin/articles";
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
	 * 修改文章信息
	 * 
	 * @Title: updateArticle
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@RequestMapping("updateArticle")
	@ResponseBody
	public boolean updateArticle(Article article) {
		return articleService.updateArticle(article) > 0;
	}

	/**
	 * 查询用户列表
	 * 
	 * @Title: users
	 * @Description: TODO
	 * @param model
	 * @param userVo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("users")
	public String users(Model model, UserVo userVo, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		PageInfo<User> info = userService.selectUsers(userVo, pageNum, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("userVO", userVo);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+userVo);
		return "admin/users";
	}
	/**
	 * 	管理用户(修改用户)
	 * @Title: updateUser 
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: boolean
	 */
	@RequestMapping("updateUser")
	@ResponseBody
	public boolean updateUser(User user) {
		return userService.updateUser(user) > 0;
	}
}
