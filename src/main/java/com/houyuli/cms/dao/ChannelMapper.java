package com.houyuli.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.houyuli.cms.domain.Category;
import com.houyuli.cms.domain.Channel;

public interface ChannelMapper {

	/**
	 * 	回显栏目分类
	 * @Title: selectChannels 
	 * @Description: TODO
	 * @return
	 * @return: List<Channel>
	 */
	public List<Channel> selectChannels();
	
	/**
	 * 	二级联动回显
	 * @Title: selectCategorys 
	 * @Description: TODO
	 * @return
	 * @return: List<Category>
	 */
	public List<Category> selectCategorys(@Param("channelId")Integer channelId);
}
