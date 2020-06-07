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
			throw new CMSException("用户名不能位空");
		}
		if(!(user.getUsername().length() >= 5 && user.getUsername().length() <= 10)) {
			throw new CMSException("用户名名称不能少于5或大于10");
		}
		if(!StringUtil.hasText(user.getPassword())) {
			throw new CMSException("密码不能为空");
		}
		if(!(user.getPassword().length() >= 6 && user.getPassword().length() <= 10)) {
			throw new CMSException("密码的长度不能少于6位且密码的长度不能超过10位");
		}
		if(!user.getPassword().equals(user.getRepassword())){
			throw new CMSException("两次密码输入不相同");
		}
		User u = userMapper.selectUserByName(user.getUsername());
		if( null != u) {
			throw new CMSException("用户名已注册");
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
			throw new CMSException("用户名不能为空");
		User u = selectUserByName(user.getUsername());
		System.out.println("++++++++++++++LOgin++++++++++++++++++++"+u);
		if(null == u) {
			throw new CMSException("用户名不存在");
		}
		if(!StringUtil.hasText(user.getPassword())) {
			throw new CMSException("密码不能为空");
		}
		 if(!Md5Util.md5Encode(user.getPassword()).equals(u.getPassword())) {
			 throw new CMSException("密码不正确");
		 } 
		if(u.getLocked() == 1) {
			throw new CMSException("账户被禁用,请联系管理员");
		}
		return u;
	}

	
}
