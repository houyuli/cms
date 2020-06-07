package com.houyuli.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.houyuli.cms.domain.User;
import com.houyuli.cms.vo.UserVo;

public interface UserMapper {
	/**
	 * ��ѯUser
	 * 
	 * @Title: selectUsers
	 * @Description: TODO
	 * @param userVo
	 * @return
	 * @return: List<User>
	 */
	List<User> selectUsers(UserVo userVo);

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
	 * �����û�
	 * 
	 * @Title: insertUser
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: int
	 */
	int insertUser(User user);

	/**
	 * ��ѯ�Ƿ������username����
	 * @Title: selectUserByName 
	 * @Description: TODO
	 * @param username
	 * @return
	 * @return: User
	 */
	User selectUserByName(@Param("username")String username);
}
