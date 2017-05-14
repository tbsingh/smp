package com.tssa.km.core.validator;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.validation.Errors;

public class EmailValidator extends StringValueValidator {
	public EmailValidator(){
		
	}
	@Override
	public void validate(Object target, Errors errors) {
		super.validate(target, errors);
		BeanWrapper targetObject = new BeanWrapperImpl(target);
		String propertyValue=(String)targetObject.getPropertyValue(propertyName);
		String []emailParts = propertyValue.trim().split("@");
		if(emailParts.length != 2){
			 errors.rejectValue(propertyName, "registration.email.address.error");
		}
	}
}
