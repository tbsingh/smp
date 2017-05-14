package com.tssa.km.web.controller;

import java.util.Map;
import java.util.Vector;

import com.tssa.km.domain.Question;
import com.tssa.km.web.command.QuestionCommand;


public class CppTestQuestionFormController extends AbstractTestQuestionFormController {
	private static final String TEST_TYPE="cpp";
	private Integer displayTotalQuestions;
	@Override
	public void initializeQList(String filePath) {
		Vector<Question> testQList=getQuestionService().getQuestionList(TEST_TYPE,Long.valueOf(displayTotalQuestions),filePath);
		setDisplayMaxQuestions(displayTotalQuestions);
		getQList().get().addAll(testQList);
	}
	public void setDisplayTotalQuestions(Integer displayTotalQuestions) {
		this.displayTotalQuestions = displayTotalQuestions;
	}
	public Integer getDisplayTotalQuestions() {
		return displayTotalQuestions;
	}
}
