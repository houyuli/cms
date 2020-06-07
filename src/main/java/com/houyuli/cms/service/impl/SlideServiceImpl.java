package com.houyuli.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.houyuli.cms.dao.SlideMapper;
import com.houyuli.cms.domain.Slide;
import com.houyuli.cms.service.SlideService;
@Service
public class SlideServiceImpl implements SlideService{

	@Resource
	private SlideMapper slideMapper;
	
	@Override
	public List<Slide> selectSlides() {
		return slideMapper.selectSlides();
	}

	
}
