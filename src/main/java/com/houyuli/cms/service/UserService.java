package com.houyuli.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.houyuli.cms.domain.User;
import com.houyuli.cms.vo.UserVo;

public interface UserService {

	/**
	 * 查询User
	 * 
	 * @Title: selectUsers
	 * @Description: TODO
	 * @param userVo
	 * @return
	 * @return: List<User>
	 */
	PageInfo<User> selectUsers(UserVo userVo, Integer pageNum, Integer pageSize);

	/**
	 * 修改User
	 * 
	 * @Title: updateUser
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: int
	 */
	int updateUser(User user);

	/**
	 * 注册账号
	 * 
	 * @Title: insertUser
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: int
	 */
	int insertUser(User user);

	/**
	 * 查询是否存在这个username
	 * 
	 * @Title: selectUserByName
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: User
	 */
	User selectUserByName(String userName);

	/**
	 * 登录
	 * 
	 * @Title: login
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: User
	 */
	User login(User user);
}
