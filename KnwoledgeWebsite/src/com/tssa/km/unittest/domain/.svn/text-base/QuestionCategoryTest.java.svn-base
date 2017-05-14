package com.tssa.km.unittest.domain;


import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tssa.km.domain.hibernate.QuestionCategory;
import com.tssa.km.domain.hibernate.QuestionExt;
import com.tssa.km.domain.repo.HibernateQuestionRepository;
import com.tssa.km.domain.repo.QuestionRepository;
import com.tssa.km.domain.service.QuestionService;

public class QuestionCategoryTest {
	private ApplicationContext ctx;
	QuestionService service;

	@Before
	public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext(new String[]{"com/tssa/km/unittest/domain/service-test.xml", "applicationContext.xml"});
		service=(QuestionService) ctx.getBean("questionServiceImpl");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}
	@Test
	public void validateQuestionCategories(){
		List<QuestionExt> qList = service.getQuestionList();
		System.out.println("qList "+qList.size());
		List<QuestionCategory>qCategories = service.getQuestionCategories();
		System.out.println("qCategories "+qCategories.size());
	}
}
