package com.tssa.km.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.tssa.km.core.mail.JavaMailManager;
import com.tssa.km.core.mail.SimpleMailManager;
import com.tssa.km.web.command.RegistrationCommand;

public class TestRegistrationFormController extends AbstractTestFormController {
	private JavaMailManager googleAppMailSender;
	protected ModelAndView onSubmit(Object command) throws ServletException {
		
		RegistrationCommand registrationCommand=(RegistrationCommand) command;
		ModelAndView modelAndView = new ModelAndView(getSuccessView());
		try{
		modelAndView.addObject("command", new RegistrationCommand());
		//JavaMailManager mailSender=(JavaMailManager)getApplicationContext().getBean("googleAppMailSender");
		googleAppMailSender.sendMail("New Registration observed\n"+"First Name: "+registrationCommand.getFirstName()+"\n Second Name: "+registrationCommand.getSecondName()+"\nEmail Address: "+registrationCommand.getEmailAddress());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;  
	}
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		String testType = (String)request.getParameter("test");
		request.getSession().setAttribute("testType", testType);
		return new RegistrationCommand();
	}
	public void setGoogleAppMailSender(JavaMailManager googleAppMailSender) {
		this.googleAppMailSender = googleAppMailSender;
	}
	public JavaMailManager getGoogleAppMailSender() {
		return googleAppMailSender;
	}
}
