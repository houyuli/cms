package com.houyuli.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.houyuli.cms.domain.User;
import com.houyuli.cms.vo.UserVo;

public interface UserMapper {
	/**
	 * 查询User
	 * 
	 * @Title: selectUsers
	 * @Description: TODO
	 * @param userVo
	 * @return
	 * @return: List<User>
	 */
	List<User> selectUsers(UserVo userVo);

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
	 * 增加用户
	 * 
	 * @Title: insertUser
	 * @Description: TODO
	 * @param user
	 * @return
	 * @return: int
	 */
	int insertUser(User user);

	/**
	 * 查询是否有这个username存在
	 * @Title: selectUserByName 
	 * @Description: TODO
	 * @param username
	 * @return
	 * @return: User
	 */
	User selectUserByName(@Param("username")String username);
}
