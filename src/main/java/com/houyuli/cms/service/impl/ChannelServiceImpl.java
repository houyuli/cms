package com.houyuli.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.houyuli.cms.dao.ChannelMapper;
import com.houyuli.cms.domain.Category;
import com.houyuli.cms.domain.Channel;
import com.houyuli.cms.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService{

	@Resource
	private ChannelMapper channelMapper;
	@Override
	public List<Channel> selectChannels() {
		return channelMapper.selectChannels();
	}
	@Override
	public List<Category> selectCategorys(Integer channelId) {
		return channelMapper.selectCategorys(channelId);
	}

	
}
