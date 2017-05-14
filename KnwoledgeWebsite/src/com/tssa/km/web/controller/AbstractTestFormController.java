package com.tssa.km.web.controller;

import javax.servlet.ServletException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class AbstractTestFormController extends SimpleFormController{
	protected ModelAndView onSubmit(Object command) throws ServletException {
			  ModelAndView modelAndView = new ModelAndView(getSuccessView());
			  return modelAndView;  
	}

}
