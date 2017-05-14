package com.tssa.km.web.controller;

import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.tssa.km.core.util.Utility;
import com.tssa.km.domain.Question;
import com.tssa.km.domain.service.QuestionService;
import com.tssa.km.web.command.QuestionCommand;

public class TestQuestionFormController extends AbstractTestFormController {
	private QuestionService questionService;
	private short displayJavaQuestions;
	private short displayCppQuestions;
	private short displayDesignQuestions;
	private final ThreadLocal<Vector<Question> > qList =  new ThreadLocal<Vector<Question> >() {
	    @Override protected Vector<Question> initialValue() {
	        return new Vector<Question>();
	    }
	};
	int max=0;
	public short getDisplayDesignQuestions() {
		return displayDesignQuestions;
	}
	public void setDisplayDesignQuestions(short displayDesignQuestions) {
		this.displayDesignQuestions = displayDesignQuestions;
	}
	public short getDisplayJavaQuestions() {
		return displayJavaQuestions;
	}
	public void setDisplayJavaQuestions(short displayJavaQuestions) {
		this.displayJavaQuestions = displayJavaQuestions;
	}
	public short getDisplayCppQuestions() {
		return displayCppQuestions;
	}
	public void setDisplayCppQuestions(short displayCppQuestions) {
		this.displayCppQuestions = displayCppQuestions;
	}
	public QuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	protected ModelAndView onSubmit(Object command) throws ServletException {
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
		if(currentIndex == max){
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
		String testType=(String)request.getSession().getAttribute("testType");
		if(max==0){
			System.out.println("Initializing number of the question to display....");
			if(testType.equals("java")){
				max=displayJavaQuestions;
			}else if(testType.equals("cpp")){
				max=displayCppQuestions;
			}else if(testType.equals("design")){
				max=displayDesignQuestions;
			}else{
				max=30;
			}
		}
		qList.set((Vector<Question>) request.getSession().getAttribute("qList"));
     	QuestionCommand questionCommand=new QuestionCommand();
		if(qList==null){  //Web server is restarted, so retrieve all question again
			System.out.println("qList is empty....may be session is closed/restarted");
		//	retrieveQuestionsFrmCookie(request);
		//	request.getSession().setAttribute("qList", qList);
		}
		int currentIndex=(Integer)request.getSession().getAttribute("currentIndex");
		System.out.println("Current question index is "+currentIndex);
		Question currentQuestion=qList.get().get(currentIndex);
		String qText = Utility.preserveFormating(currentQuestion.getqText());
		currentQuestion.setqText(qText);
		questionCommand.setCurrentQuestion(currentQuestion);
		questionCommand.setPageTitle("QUESTION# "+(currentIndex+1)+" OF "+max);
		questionCommand.setQuestionTitle("QUESTION# "+(currentIndex+1));
		request.getSession().setAttribute("qList", qList.get()); //Update session object each time it is changed
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
		if(strQArray.length == max){
			System.out.println("Found all questions in Cookie");
			for(int qIndex=0; qIndex<max; qIndex++){
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
}
