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
	 * תע��ҳ��
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
	 * ��ѯ�Ƿ���ڴ��û�
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
		// ��װһ��������Ϣ����
		CMSResult<User> cmsResult = new CMSResult<User>();
		try {
			userService.insertUser(user);
			cmsResult.setMsg("ע��ɹ�");
			cmsResult.setCode(200);
		} catch (CMSException e) {
			cmsResult.setCode(500);// ���������ʾ
			cmsResult.setMsg("ע��ʧ��," + e.getMessage());
		} catch (Exception e) {
			cmsResult.setCode(500);// ���������ʾ
			cmsResult.setMsg("ע��ʧ��,ϵͳ��������ϵ����Ա");
		}
		return cmsResult;
	}

	/**
	 * ȥ��¼
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
				session.setAttribute("user", u);// ��ͨ�û�
			} else {
				session.setAttribute("admin", u);// ����Ա
			}
		} catch (CMSException e) {
			e.printStackTrace();
			result.setCode(500);// ��¼ʧ��
			result.setMsg("��¼ʧ��," + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("��¼ʧ��,����ϵ����Ա");
		}
		return result;
	}

	/**
	 * ע����¼
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
