package com.tssa.km.web.controller;

import java.util.Map;
import java.util.Vector;

import com.tssa.km.domain.Question;
import com.tssa.km.web.command.QuestionCommand;


public class CompJavaTestQuestionFormController extends AbstractTestQuestionFormController {
	private Map<String, Integer>displayTotalQuestions;
	@Override
	public void initializeQList(String filePath) {
		for(String testType: displayTotalQuestions.keySet()){
			Vector<Question> testQList=getQuestionService().getQuestionList(testType,Long.valueOf(displayTotalQuestions.get(testType)),filePath);
			getQList().get().addAll(testQList);
		}
		setDisplayMaxQuestions(getQList().get().size());
	}
	public void setDisplayTotalQuestions(Map<String, Integer> displayTotalQuestions) {
		this.displayTotalQuestions = displayTotalQuestions;
	}
	public Map<String, Integer> getDisplayTotalQuestions() {
		return displayTotalQuestions;
	}
}
