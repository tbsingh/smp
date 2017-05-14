package com.tssa.km.core.validator;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.validation.Errors;

public class StringValueValidator {
	public boolean getRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public int getMinLength() {
		return minLength;
	}
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public void validate(Object target, Errors errors){
		 BeanWrapper targetObject = new BeanWrapperImpl(target);
		 String propertyValue=(String)targetObject.getPropertyValue(propertyName);
	     int length = (propertyValue == null) ? 0 : propertyValue.trim().length();
	     if(length == 0 && required == true){
	    	 errors.rejectValue(propertyName, "string.required");
	     }
	     else if(minLength > length) {
	            errors.rejectValue(propertyName, "string.required","minLenght should be greater than "+minLength+" for "+propertyName);
	     }else if (maxLength < length) {
	            errors.rejectValue(propertyName, "string.required", "maxLenght should be less than "+maxLength+" for "+propertyName);
	     }
	}
	protected String propertyName="";
	protected boolean required=true;
	protected int maxLength=2147483647;;
	protected int minLength=0;;
	
}
