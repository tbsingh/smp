package com.tssa.km.core.interceptor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

public class ContentAgreementFilter extends OncePerRequestFilter {
	private static final String AGREEMENT_PAGE = "/knowledge/testAgreementView.html";
	private static final String COOKIE_REDIRECT_URL = "targetURL";

	@Override
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		if (request.getPathInfo()!=null && (request.getPathInfo().contains("TestView") || request.getPathInfo().contains("accepted"))) {
			if(request.getParameter("accepted") != null){
				request.getSession().setAttribute("Accepted", "Yes");
			}
			if(request.getSession().getAttribute("Accepted")==null){
				doAgreement(request,response, chain);
			}
		}
		if(request.getParameter("accepted") != null){
			final Cookie redirectCookie = WebUtils.getCookie(request, COOKIE_REDIRECT_URL);
			if (redirectCookie != null && !redirectCookie.getValue().equals("")) {
				final String redirectUrl = URLDecoder.decode(redirectCookie.getValue(), "UTF-8");
	            final String contextPath = request.getContextPath();
	            if (request.getPathInfo()!=null && (request.getPathInfo().contains("TestView") || request.getPathInfo().contains("accepted"))) {
	            	final Cookie deleteCookie = new Cookie(COOKIE_REDIRECT_URL, "");
	    			deleteCookie.setPath(contextPath);
	                deleteCookie.setMaxAge(0);
	                response.addCookie(deleteCookie);
	            	response.sendRedirect(contextPath+redirectUrl);
	            	return;
	            } 
			}
		}
		chain.doFilter(request, response);
		
				
//		if(request.getPathInfo() != null && request.getPathInfo().contains("TestView")){
//			if(request.getSession().getAttribute("Accepted")==null){
//				doAgreement(request,response, chain);
//			}
//		}else if(request.getParameter("Accepted") != null){
//			request.getSession().setAttribute("Accepted", "Yes");
//		}
//		final Cookie redirectCookie = WebUtils.getCookie(request, COOKIE_REDIRECT_URL);
//		if (redirectCookie != null && !redirectCookie.getValue().equals("")) {
//			final String redirectUrl = URLDecoder.decode(redirectCookie.getValue(), "UTF-8");
//            final String contextPath = request.getContextPath();
//            if (request.getPathInfo().contains("TestView") || request.getPathInfo().contains("testQuestionView")) {
//            	final Cookie deleteCookie = new Cookie(COOKIE_REDIRECT_URL, "");
//    			deleteCookie.setPath(contextPath);
//                deleteCookie.setMaxAge(0);
//                response.addCookie(deleteCookie);
//            	response.sendRedirect(contextPath+redirectUrl);
//            } else if(request.getSession().getAttribute("Accepted")==null){
//                response.sendRedirect(request.getContextPath() + AGREEMENT_PAGE);
				 
//            }
//		}
//		 chain.doFilter(request, response);
	}
	@SuppressWarnings("deprecation")
	private void doAgreement(HttpServletRequest request,HttpServletResponse response, FilterChain chain) {
		String encodedUrl;
		try {
				encodedUrl = URLEncoder.encode("/knowledge"+request.getPathInfo().toString());
			    final Cookie redirectCookie = new Cookie(COOKIE_REDIRECT_URL, encodedUrl);
		        redirectCookie.setPath(request.getContextPath());
		        response.addCookie(redirectCookie);
		        response.sendRedirect(request.getContextPath() + AGREEMENT_PAGE);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
