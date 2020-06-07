package com.houyuli.cms.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.houyuli.cms.domain.Article;
import com.houyuli.cms.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ArticleServiceImplTest {

	@Resource
	private ArticleService articleService;

	@Test
	public void testGetArticles() {
		PageInfo<Article> selectArticles = articleService.selectArticles(new Article(), 1, 10);
		System.out.println(selectArticles);
	}

}
