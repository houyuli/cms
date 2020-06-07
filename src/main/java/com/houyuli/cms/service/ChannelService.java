package com.houyuli.cms.service;

import java.util.List;

import com.houyuli.cms.domain.Category;
import com.houyuli.cms.domain.Channel;

public interface ChannelService {

	/**
	 * 	������Ŀ����
	 * @Title: selectChannels 
	 * @Description: TODO
	 * @return
	 * @return: List<Channel>
	 */
	public List<Channel> selectChannels();
	
	/**
	 * 	������������
	 * @Title: selectCategorys 
	 * @Description: TODO
	 * @return
	 * @return: List<Category>
	 */
	public List<Category> selectCategorys(Integer channelId);
}
