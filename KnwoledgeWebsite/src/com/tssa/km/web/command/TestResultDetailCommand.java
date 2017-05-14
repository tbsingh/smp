package com.tssa.km.web.command;

import java.util.ArrayList;

import com.tssa.km.domain.Question;

public class TestResultDetailCommand {
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	private ArrayList<Question> questions=null;
	private String category;
	private String pageTitle;
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

}
