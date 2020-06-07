package com.houyuli.cms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.houyuli.cms.domain.User;
import com.houyuli.cms.service.UserService;
import com.houyuli.cms.util.CMSException;
import com.houyuli.cms.util.CMSResult;

@RequestMapping("passport")
@Controller
public class PassportController {

	@Resource
	private UserService userService;

	/**
	 * 转注册页面
	 * 
	 * @Title: reg
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@GetMapping("reg")
	public String reg() {
		return "passport/reg";
	}

	/**
	 * 查询是否存在此用户
	 * 
	 * @Title: reg
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: boolean
	 */
	@PostMapping("reg")
	@ResponseBody
	public CMSResult<User> reg(User user) {
		// 封装一个返回消息对象
		CMSResult<User> cmsResult = new CMSResult<User>();
		try {
			userService.insertUser(user);
			cmsResult.setMsg("注册成功");
			cmsResult.setCode(200);
		} catch (CMSException e) {
			cmsResult.setCode(500);// 错误代码提示
			cmsResult.setMsg("注册失败," + e.getMessage());
		} catch (Exception e) {
			cmsResult.setCode(500);// 错误代码提示
			cmsResult.setMsg("注册失败,系统错误清联系管理员");
		}
		return cmsResult;
	}

	/**
	 * 去登录
	 * 
	 * @Title: login
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@GetMapping("login")
	public String login(Model model, String username) {
		model.addAttribute("username", username);
		return "passport/login";
	}

	@PostMapping("login")
	@ResponseBody
	public CMSResult<User> login(User user, HttpSession session) {
		CMSResult<User> result = new CMSResult<User>();
		try {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + user);
			User u = userService.login(user);
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++" + u);
			result.setCode(200);
			if (u.getRole() == 0) {
				session.setAttribute("user", u);// 普通用户
			} else {
				session.setAttribute("admin", u);// 管理员
			}
		} catch (CMSException e) {
			e.printStackTrace();
			result.setCode(500);// 登录失败
			result.setMsg("登录失败," + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("登录失败,请联系管理员");
		}
		return result;
	}

	/**
	 * 注销登录
	 * 
	 * @Title: logout
	 * @Description: TODO
	 * @param session
	 * @return
	 * @return: String
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
