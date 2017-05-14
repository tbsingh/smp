package com.tssa.km.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.tssa.km.core.util.Utility;
import com.tssa.km.domain.Question;
import com.tssa.km.domain.hibernate.QuestionCategory;
import com.tssa.km.domain.service.QuestionService;
import com.tssa.km.web.command.QuestionCommand;
import com.tssa.km.web.command.TestResultDetailCommand;

public class TestResultDetailFormController extends AbstractTestFormController{
	private QuestionService questionService;
	private Vector<Question> qList = new Vector<Question>();
	public QuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	protected ModelAndView onSubmit(Object command) throws ServletException {
		ModelAndView modelAndView = new ModelAndView(getSuccessView());
		return modelAndView;  
	}
	@Override
	protected ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)throws Exception {
		return super.processFormSubmission(request, response, command, errors);
	}
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		TestResultDetailCommand testResultDetailCommand= new TestResultDetailCommand();
		String category = request.getParameter("category");
		testResultDetailCommand.setPageTitle(category);
		testResultDetailCommand.setCategory(category);
		Map<String,Vector<Question>> questByCategory = (Map<String,Vector<Question>>) request.getSession().getAttribute("qListByCategory");
		String catShortName = getCategoryShortName(category, request);
		Vector<Question>qVector=questByCategory.get(catShortName);
		ArrayList<Question> qList = new ArrayList<Question>();
		for(int i=0; i<qVector.size(); i++){
			Question question = qVector.get(i);
			String qText = question.getqText();
			qText=Utility.preserveFormating(qText);
			//qText=qText.replaceAll("@","<br/>");
			question.setqText(qText);
			qList.add(question);
		}
		testResultDetailCommand.setQuestions(qList);
		return testResultDetailCommand;
	}
	private String getCategoryShortName(String category,	HttpServletRequest request) {
		//String configPath=(String) request.getSession().getServletContext().getRealPath("/conf/");
		String catShortName=null;
		//Properties catProp=new Properties();
		try {
			//catProp.load(new FileInputStream(new File(configPath+"/category.properties")));
			List<QuestionCategory> categories = questionService.getQuestionCategories();
			for(QuestionCategory cat : categories){
				if(cat.getDescription().equals(category)){
					catShortName=cat.getName();
				}
			}
//			Enumeration<Object> itr = catProp.keys();
//			while(itr.hasMoreElements()){
//				String key = (String)itr.nextElement();
//				String element=catProp.getProperty(key);
//				if(element.equals(category)){
//					catShortName=(String)key;
//					return catShortName;
//				}
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return catShortName;
	}
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,	Errors errors) throws Exception {
		return super.referenceData(request, command, errors);
	}
}
