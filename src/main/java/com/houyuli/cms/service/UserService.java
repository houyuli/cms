package com.houyuli.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.houyuli.cms.domain.User;
import com.houyuli.cms.vo.UserVo;

public interface UserService {

	/**
	 * ��ѯUser
	 * 
	 * @Title: selectUsers
	 * @Description: TODO
	 * @param userVo
	 * @return
	 * @return: List<User>
	 */
	PageInfo<User> selectUsers(UserVo userVo, Integer pageNum, Integer pageSize);

	/**
	 * �޸�User
	 * 
	 * @Title: updateUser
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: int
	 */
	int updateUser(User user);

	/**
	 * ע���˺�
	 * 
	 * @Title: insertUser
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: int
	 */
	int insertUser(User user);

	/**
	 * ��ѯ�Ƿ�������username
	 * 
	 * @Title: selectUserByName
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: User
	 */
	User selectUserByName(String userName);

	/**
	 * ��¼
	 * 
	 * @Title: login
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: User
	 */
	User login(User user);
}
