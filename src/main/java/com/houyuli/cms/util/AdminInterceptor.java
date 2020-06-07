package com.houyuli.cms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * admin����Ա����������
 * 
 * @ClassName: AdminInterceptor
 * @Description: TODO
 * @author: King
 * @date: 2020��6��8�� ����12:08:40
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1.����Ѿ���¼��session�ж�Ӧ��ֵ��������
		// false�����request����session�����򷵻ء����û���򷵻�null
		// true:���request����session�����򷵻ء����û���򴴽�һ���µ�session �����ٷ���
		HttpSession session = request.getSession(false);
		if (null != session && null != session.getAttribute("admin")) {
			return true;// ������
		}
		// ���û�е�¼�������ת������¼ҳ��
		request.setAttribute("msg", "���¼������...");
		request.getRequestDispatcher("/WEB-INF/view/passport/login.jsp").forward(request, response);

		return false;
	}
}
