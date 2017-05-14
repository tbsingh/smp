package com.tssa.km.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RegisterationInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,	HttpServletResponse response, Object handler, Exception exception)throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelView) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String pathInfo=request.getPathInfo();
        String firstName=null;
		String secondName=null;
		String emailAddress=null;
		if(pathInfo.contains("testRegistrationView")){
			firstName=request.getParameter("firstName");
			secondName=request.getParameter("secondName");
			emailAddress=request.getParameter("emailAddress");
			request.getSession().setAttribute("firstName", firstName);
			request.getSession().setAttribute("secondName", secondName);
			request.getSession().setAttribute("emailAddress", emailAddress);
		} 
		else if (!pathInfo.contains("knowledgeView")){
			firstName=(String)request.getSession().getAttribute("firstName");
			secondName=(String)request.getSession().getAttribute("secondName");
			emailAddress=(String)request.getSession().getAttribute("emailAddress");
			if(firstName == null || secondName==null || emailAddress==null){
				response.sendRedirect(request.getContextPath() + "/knowledge/testRegistrationView.html");
			}
		}
		return true;
	}
}
