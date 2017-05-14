package com.tssa.km.core.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class AbstractMethodInterceptor implements MethodInterceptor {
	  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
	    Object args[]  = methodInvocation.getArguments();
	    final Logger logger = Logger.getLogger(methodInvocation.getThis().getClass());
	    logger.info(methodInvocation.getMethod().getName()+"<="+args);
	    Object result = methodInvocation.proceed();
	    logger.info(methodInvocation.getMethod().getName()+"=>"+result);
	    return result;
	  }
	}