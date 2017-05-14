package com.tssa.km.core.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FormObjectValidator implements Validator{
	public Class getSupportedClass() {
		return supportedClass;
	}
	public void setSupportedClass(Class supportedClass) {
		this.supportedClass = supportedClass;
	}

	public StringValueValidator[] getValidators() {
		return validators;
	}

	public void setValidators(StringValueValidator[] validators) {
		this.validators = validators;
	}
		@Override
	public boolean supports(Class clazz) {
		return this.supportedClass.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		for(int i=0; i<validators.length; i++){
			validators[i].validate(target, errors);
		}
	}
	private Class supportedClass;
	private StringValueValidator[] validators = new StringValueValidator[0];
}
