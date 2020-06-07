package com.houyuli.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.houyuli.cms.dao.UserMapper;
import com.houyuli.cms.domain.User;
import com.houyuli.cms.service.UserService;
import com.houyuli.cms.util.CMSException;
import com.houyuli.cms.util.Md5Util;
import com.houyuli.cms.vo.UserVo;
import com.houyuli.common.utils.StringUtil;
@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;

	@Override
	public PageInfo<User> selectUsers(UserVo userVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> list = userMapper.selectUsers(userVo);
		PageInfo<User> info = new PageInfo<User>(list);
		return info;
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public int insertUser(User user) {
		if(!StringUtil.hasText(user.getUsername())) {
			throw new CMSException("�û�������λ��");
		}
		if(!(user.getUsername().length() >= 5 && user.getUsername().length() <= 10)) {
			throw new CMSException("�û������Ʋ�������5�����10");
		}
		if(!StringUtil.hasText(user.getPassword())) {
			throw new CMSException("���벻��Ϊ��");
		}
		if(!(user.getPassword().length() >= 6 && user.getPassword().length() <= 10)) {
			throw new CMSException("����ĳ��Ȳ�������6λ������ĳ��Ȳ��ܳ���10λ");
		}
		if(!user.getPassword().equals(user.getRepassword())){
			throw new CMSException("�����������벻��ͬ");
		}
		User u = userMapper.selectUserByName(user.getUsername());
		if( null != u) {
			throw new CMSException("�û�����ע��");
		}
		user.setPassword(Md5Util.md5Encode(user.getPassword()));
		return userMapper.insertUser(user);
	}

	@Override
	public User selectUserByName(String userName) {
		return userMapper.selectUserByName(userName);
	}

	@Override
	public User login(User user) {
		if(!StringUtil.hasText(user.getUsername()))
			throw new CMSException("�û�������Ϊ��");
		User u = selectUserByName(user.getUsername());
		System.out.println("++++++++++++++LOgin++++++++++++++++++++"+u);
		if(null == u) {
			throw new CMSException("�û���������");
		}
		if(!StringUtil.hasText(user.getPassword())) {
			throw new CMSException("���벻��Ϊ��");
		}
		 if(!Md5Util.md5Encode(user.getPassword()).equals(u.getPassword())) {
			 throw new CMSException("���벻��ȷ");
		 } 
		if(u.getLocked() == 1) {
			throw new CMSException("�˻�������,����ϵ����Ա");
		}
		return u;
	}

	
}
