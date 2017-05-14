package com.tssa.km.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.tssa.km.domain.Question;
import com.tssa.km.domain.hibernate.QuestionCategory;
import com.tssa.km.domain.service.QuestionService;
import com.tssa.km.web.command.TestResultCommand;

public class TestResultFormController extends AbstractTestFormController{
	private QuestionService questionService;
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
	@SuppressWarnings("unchecked")
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		TestResultCommand testResultCommand = new TestResultCommand();
		Vector<Question>qList=(Vector<Question>) request.getSession().getAttribute("qList");
		//printQList(qList);
		testResultCommand.setPageTitle("Your Test Result");
		Map<String, Integer> result=processResultByCategory(qList,request);
		testResultCommand.setResult(result);
		int score=processScore(result).intValue();
		testResultCommand.setScore(score);
		return testResultCommand;
	}
	private Float processScore(Map<String, Integer> result) {
		float sum=0;
		for(String cat: result.keySet()){
			sum+=result.get(cat);
		}
		float finalResult=sum/result.size();
		return finalResult;
	}
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,	Errors errors) throws Exception {
		return super.referenceData(request, command, errors);
	}
	private Map<String, Integer> processResultByCategory(Vector<Question> questionsAnswered, HttpServletRequest request) throws FileNotFoundException, IOException {
		Map<String, Integer>result = new HashMap<String, Integer>();
		Map<String,Vector<Question>> questionsByCategory = new HashMap<String, Vector<Question>>();
		Iterator<Question> itr = questionsAnswered.iterator();
		while(itr.hasNext()){
			Question q = (Question) itr.next();
			String category = q.getqCategory();
			if(!questionsByCategory.containsKey(category)){
				Vector<Question> qList = new Vector<Question>();
				qList.add(q);
				questionsByCategory.put(category, qList);
			}else{
				questionsByCategory.get(category).add(q);
			}
		}
		for(String cat : questionsByCategory.keySet()){
			Vector<Question> qList = questionsByCategory.get(cat);
			Iterator<Question> iterator = qList.iterator();
			int correct=0;
			while(iterator.hasNext()){
				Question q = iterator.next();
				//System.out.println("CA="+q.getqAnswer()+", and UA="+q.getUserAnswer()+" for question# "+q.getqNo());
				if(q.getqAnswer().equals(q.getUserAnswer())){
					//System.out.println("Found Correct Answer: ");
					//System.out.println("Category: "+cat+" Answer: "+q.getqAnswer());
					correct++;
				}
			}
			int catResult = (int) (correct/(float)qList.size()*100);
			//System.out.println("Result for category: "+cat+" is "+catResult);
			result.put(cat, catResult);
		}
		Map<String, Integer>resultByCategory = new HashMap<String, Integer>();
		for(String cat : result.keySet()){
			String category = getCategoryDesc(cat, request);
			resultByCategory.put(category, result.get(cat));
		}
		request.getSession().setAttribute("qListByCategory", questionsByCategory);
		return resultByCategory;
		
	}
	private String getCategoryDesc(String cat, HttpServletRequest request) {
		//String configPath=(String) request.getSession().getServletContext().getRealPath("/conf/");
		String catDesc=null;
		//Properties catProp=new Properties();
		try {
			//catProp.load(new FileInputStream(new File(configPath+"/category.properties")));
			//catDesc=catProp.getProperty(cat);
			List<QuestionCategory> categories = questionService.getQuestionCategories();
			for(QuestionCategory category : categories){
				if(category.getName().equals(cat)){
					catDesc=category.getDescription();
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return catDesc;
	}

}
