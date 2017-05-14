package com.tssa.km.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int getqNo() {
		return qNo;
	}
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	public String getqText() {
		return qText;
	}
	public void setqText(String qText) {
		this.qText = qText;
	}
	public Map<String, String> getqOptions() {
		return qOptions;
	}
	public void setqOptions(Map<String, String> qOptions) {
		this.qOptions = qOptions;
	}
	public String getqAnswer() {
		return qAnswer;
	}
	public void setqAnswer(String qAnswer) {
		this.qAnswer = qAnswer;
	}
	public String getqAnswerText() {
		return qAnswerText;
	}
	public void setqAnswerText(String qAnswerText) {
		this.qAnswerText = qAnswerText;
	}
	public String getqCategory() {
		return qCategory;
	}
	public void setqCategory(String qQategory) {
		this.qCategory = qQategory;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	private int qNo;
	private String qText;
	private Map<String, String> qOptions=new HashMap<String, String>();
	private String qAnswer;
	private String qAnswerText;
	private String qCategory;
	private String userAnswer;
	
}
