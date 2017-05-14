package com.tssa.km.web.controller;

import javax.servlet.ServletException;

import org.springframework.web.servlet.ModelAndView;

import com.tssa.km.web.command.AgreementCommand;

public class KnowledgeController extends AbstractTestFormController {
	protected ModelAndView onSubmit(Object command) throws ServletException {
		  
		ModelAndView modelAndView = new ModelAndView(getSuccessView());
		modelAndView.addObject("command", new AgreementCommand());
		  return modelAndView;  
	}
}
