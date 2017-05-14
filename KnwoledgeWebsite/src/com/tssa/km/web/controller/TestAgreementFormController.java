package com.tssa.km.web.controller;

import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.tssa.km.core.util.Utility;
import com.tssa.km.domain.Question;
import com.tssa.km.domain.service.QuestionService;
import com.tssa.km.web.command.AgreementCommand;
import com.tssa.km.web.command.RegistrationCommand;

public class TestAgreementFormController extends AbstractTestFormController {
	private QuestionService questionService;
	private short displayJavaQuestions;
	private short displayCppQuestions;
	private short displayDesignQuestions;
	int maxQ2Display=0;
	private Vector<Question> qList = new Vector<Question>();
	protected ModelAndView onSubmit(Object command) throws ServletException {
		  
		ModelAndView modelAndView = new ModelAndView(getSuccessView());
		modelAndView.addObject("command", command);
	    return modelAndView;  
	}

	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		AgreementCommand command = new AgreementCommand();
		return command;
	}
	public short getDisplayJavaQuestions() {
		return displayJavaQuestions;
	}
	public void setDisplayJavaQuestions(short displayJavaQuestions) {
		this.displayJavaQuestions = displayJavaQuestions;
	}
	public short getDisplayCppQuestions() {
		return displayCppQuestions;
	}
	public void setDisplayCppQuestions(short displayCppQuestions) {
		this.displayCppQuestions = displayCppQuestions;
	}
	public short getDisplayDesignQuestions() {
		return displayDesignQuestions;
	}
	public void setDisplayDesignQuestions(short displayDesignQuestions) {
		this.displayDesignQuestions = displayDesignQuestions;
	}
}
