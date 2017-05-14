package com.tssa.km.domain.service;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.tssa.km.domain.Question;
import com.tssa.km.domain.hibernate.QuestionCategory;
import com.tssa.km.domain.hibernate.QuestionExt;


public interface QuestionService {
	public Vector<Question> getQuestionList(HttpServletRequest request, int max);
	public void printQList();
	public void printQList(Vector<Question> qList);
	public ThreadLocal<Map<Integer, Question>> getQList();
	public ThreadLocal<Vector<Question>> getGeneratedQList();
	public Question getQuestion(int qNo);
	public Vector<Question> getQuestionList(String testType, Long max, String filePath);
	public List<QuestionCategory> getQuestionCategories();
	public List<QuestionExt> getQuestionList();
}
