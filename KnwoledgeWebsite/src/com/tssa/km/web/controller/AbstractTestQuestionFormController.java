package com.tssa.km.web.controller;

import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.tssa.km.core.util.Utility;
import com.tssa.km.domain.Question;
import com.tssa.km.domain.service.QuestionService;
import com.tssa.km.web.command.QuestionCommand;

public abstract class AbstractTestQuestionFormController extends SimpleFormController {
	private QuestionService questionService;
	private int displayMaxQuestions;
	private final ThreadLocal<Vector<Question> > qList =  new ThreadLocal<Vector<Question> >() {
	    @Override protected Vector<Question> initialValue() {
	        return new Vector<Question>();
	    }
	};
	public abstract void initializeQList(String filePath);
	public ThreadLocal<Vector<Question>> getQList() {
		return qList;
	}
	public QuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	protected ModelAndView onSubmit(Object command) throws ServletException {
	//	applyCommand(command);
		StringBuffer userAnser= new StringBuffer();
		QuestionCommand questionCommand = (QuestionCommand)command;
		if(questionCommand.isA()) {
			userAnser.append("a");
		}
		if(questionCommand.isB()){
			userAnser.append("b");
		}
		if(questionCommand.isC()){
			userAnser.append("c");
		}
		if(questionCommand.isD()){
			userAnser.append("d");
		}
		if(questionCommand.isE()){
			userAnser.append("e");
		}
		int currentIndex=questionCommand.getCurrentIndex();
		//System.out.println("User answer for question# "+currentIndex+" is "+userAnser);
		
		questionCommand.getCurrentQuestion().setUserAnswer(userAnser.toString());
		if(currentIndex == displayMaxQuestions){
			ModelAndView mv= new ModelAndView(new RedirectView("/knowledge/testResultView.html", true));
			//printQList(qList.toArray());
			mv.addObject("qList", qList.get().toArray());
			return mv;
		}
		ModelAndView modelAndView = new ModelAndView(getSuccessView());
		return modelAndView;  
	}
	private void printQList(Object[] array) {
		for(int i=0; i<array.length;i++){
			Question q= (Question) array[i];
			System.out.println("CA="+q.getqAnswer()+", and UA="+q.getUserAnswer()+" for question# "+q.getqNo());
		}
		
	}
	@Override
	protected ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)throws Exception {
		return super.processFormSubmission(request, response, command, errors);
	}
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
//		if(questionService==null){
//			System.out.println("TestQuestionFormController:Question Service object does not exist, creating one....");
//			questionService=(QuestionService)getApplicationContext().getBean("questionService");
//		}
		if(request.getParameter("test") != null){
			qList.get().clear();
			initializeQList((String) request.getSession().getServletContext().getRealPath("/data/"));
			request.getSession().setAttribute("qList",qList.get());
			request.getSession().setAttribute("currentIndex",0);
		}
		qList.set((Vector<Question>) request.getSession().getAttribute("qList"));
		displayMaxQuestions=qList.get().size();
		QuestionCommand questionCommand=new QuestionCommand();
		int currentIndex=(Integer)request.getSession().getAttribute("currentIndex");
		System.out.println("Current question index is "+currentIndex);
		System.out.println("Number of Question in qList: "+qList.get().size());
		Question currentQuestion=qList.get().get(currentIndex);
		String qText = Utility.preserveFormating(currentQuestion.getqText());
		currentQuestion.setqText(qText);
		questionCommand.setCurrentQuestion(currentQuestion);
		questionCommand.setPageTitle("QUESTION# "+(currentIndex+1)+" OF "+displayMaxQuestions);
		questionCommand.setQuestionTitle("QUESTION# "+(currentIndex+1));
		//request.getSession().setAttribute("qList", qList.get()); //Update session object each time it is changed
		if(isFormSubmission(request)){
			System.out.println("Increasing question index by 1...");
			currentIndex++;
			request.getSession().setAttribute("currentIndex", currentIndex);
		}
		System.out.println("Next question index is "+currentIndex);
		questionCommand.setCurrentIndex(currentIndex);
		return questionCommand;
	}
	private void retrieveQuestionsFrmCookie(HttpServletRequest request) {
		Cookie[] cookieQList = request.getCookies();
		String strQList=null;
		for(int i=0; i<cookieQList.length;i++){
			if(cookieQList[i].getName().equals("qList")){
				strQList=cookieQList[i].getValue();
				break;
			}
		}
		String[] strQArray=strQList.split(",");
		if(strQArray.length == displayMaxQuestions){
			System.out.println("Found all questions in Cookie");
			for(int qIndex=0; qIndex<displayMaxQuestions; qIndex++){
				String qPair=strQArray[qIndex];
				String[] qNumners=qPair.split("=");
				if(qNumners.length == 2){
					Question question=questionService.getQuestion(Integer.parseInt(qNumners[1]));
					qList.get().add(Integer.parseInt(qNumners[0]),question );
				}else{
					System.out.println("Could not find both q numbers in Cookie");
				}
			}
		}
	//	questionService.printQList(qList);
	}
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,	Errors errors) throws Exception {
		return super.referenceData(request, command, errors);
	}
	public void setDisplayMaxQuestions(int displayQuestions) {
		this.displayMaxQuestions = displayQuestions;
	}
	public int getDisplayMaxQuestions() {
		return displayMaxQuestions;
	}
}
