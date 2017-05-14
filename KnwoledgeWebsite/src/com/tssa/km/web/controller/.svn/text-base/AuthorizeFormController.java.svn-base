package com.tssa.km.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.tssa.km.core.mail.JavaMailManager;
import com.tssa.km.core.mail.SimpleMailManager;
import com.tssa.km.web.command.AuthorizeCommand;
import com.tssa.km.web.command.RegistrationCommand;

public class AuthorizeFormController extends AbstractTestFormController {
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws ServletException {
		AuthorizeCommand authorizeCommand=(AuthorizeCommand) command;
		ModelAndView modelAndView = new ModelAndView("redirect:certificateView.html");
		String docLink=(String)request.getSession().getAttribute("docLink");
		modelAndView.addObject("docLink", docLink);
		String petName=authorizeCommand.getPetName();
		String dob=authorizeCommand.getDob();
		if(!(petName.equals("Tommy") && dob.equals("04/01/1974"))){
			errors.reject("Invalid Values");
		}
		else{
			request.getSession().setAttribute("authorized", "Yes");
		}
		return modelAndView;
	}
	protected Map referenceData(HttpServletRequest request, Object command,	Errors errors) throws Exception {
		 Map data=new HashMap();
		 return data;
	}
}
