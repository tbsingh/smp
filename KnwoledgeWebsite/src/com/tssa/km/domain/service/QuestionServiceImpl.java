package com.tssa.km.domain.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.tssa.km.domain.Question;
import com.tssa.km.domain.hibernate.QuestionAnswer;
import com.tssa.km.domain.hibernate.QuestionCategory;
import com.tssa.km.domain.hibernate.QuestionExt;
import com.tssa.km.domain.hibernate.QuestionOption;
import com.tssa.km.domain.repo.QuestionRepository;
import com.tssa.km.core.util.XmlHandler;

public class QuestionServiceImpl implements QuestionService {
	private final ThreadLocal<Map<Integer, Question> > qList =  new ThreadLocal<Map<Integer, Question> >() {
        @Override protected Map<Integer, Question> initialValue() {
            return new HashMap<Integer, Question>();
    }
};
private QuestionRepository questionRepository;
private final ThreadLocal<Vector<Question> > generatedQList =  new ThreadLocal<Vector<Question> >() {
    @Override protected Vector<Question> initialValue() {
        return new Vector<Question>();
    }
};
	public ThreadLocal<Vector<Question>> getGeneratedQList() {
	return generatedQList;
}
	public ThreadLocal<Map<Integer, Question>> getQList() {
		return qList;
	}
	private Map<String, Long> totalQuestions;
	
	
	public QuestionServiceImpl(){
	}
	@Override
	public Vector<Question> getQuestionList(HttpServletRequest request, int max) {
		if(qList.get().isEmpty()){
			populateQList(request);
		}
	
		String testType=(String)request.getSession().getAttribute("testType");
		int total=Integer.parseInt(String.valueOf(totalQuestions.get(testType)));
		
		Set<Integer>generatedN = new LinkedHashSet<Integer>();
		do{
			Random rand = new Random(); 
			int pickedNumber = rand.nextInt(total) + 1; 
			if(generatedN.contains(pickedNumber)){
				continue;
			}
			else{
				//System.out.println("Generated Question# "+pickedNumber);
				Question question = qList.get().get(pickedNumber);
				//System.out.println("Adding question# "+question.getqNo());
				generatedQList.get().add(question);
				generatedN.add(pickedNumber);
				//System.out.println("generatedN: "+generatedN);
			}
		}while(generatedQList.get().size()<max);
		return generatedQList.get();
	}
	private void populateQList(HttpServletRequest request) {
		String dataPath=(String) request.getSession().getServletContext().getRealPath("/data/");
		String fileName;
		String testType=(String)request.getSession().getAttribute("testType");
		fileName="/"+testType+"-questions.xml";
		XmlHandler handler = new XmlHandler(dataPath+fileName);
		 Element root= handler.getDocument().getDocumentElement();
		 NodeList questions = root.getChildNodes();
		 Question questionObj=null;
		 for(int i=0; i<questions.getLength(); i++){
			 Node questionNode = questions.item(i);
			 if(questionNode.getNodeType()==Node.ELEMENT_NODE){
				 Element questionElem = (Element)questionNode;
				 questionObj = new Question();
				 questionObj.setqNo(Integer.parseInt(questionElem.getAttribute("no")));
				 questionObj.setqText(questionElem.getElementsByTagName("body").item(0).getTextContent());
				 questionObj.setqCategory(questionElem.getElementsByTagName("category").item(0).getTextContent());
				 Element answerElem = (Element)questionElem.getElementsByTagName("answer").item(0);
				 questionObj.setqAnswer(answerElem.getAttribute("name"));
				 questionObj.setqAnswerText(answerElem.getTextContent());
				 Element optionsElem = (Element)questionElem.getElementsByTagName("options").item(0);
				 Map<String, String> optionsMap = new LinkedHashMap<String, String>();
				 NodeList options = optionsElem.getChildNodes();
				 for(int j=0; j<options.getLength(); j++){
					 Node optionNode = options.item(j); 
					 if(optionNode.getNodeType()==Node.ELEMENT_NODE){
						 Element optionElem = (Element)optionNode;
						 optionsMap.put(optionElem.getNodeName(), optionElem.getTextContent());
					 }
				 }
				 questionObj.setqOptions(optionsMap);
				 qList.get().put(questionObj.getqNo(), questionObj);
			 }
		 }
		
	}
	@Override
	public void printQList(){
		for( int qNo : qList.get().keySet()){
			Question q = qList.get().get(qNo);
			System.out.println("Question# "+q.getqNo());
			System.out.println(q.getqText());
			for(String option : q.getqOptions().keySet()){
				System.out.println(option+".   "+q.getqOptions().get(option));
			}
			
			System.out.println("Answer "+q.getqAnswer());
			System.out.println(q.getqAnswerText());
			System.out.println("Category:"+q.getqCategory());
		}
		
	}
	public void printQList(Vector<Question> qList){
		Iterator<Question> itr = qList.iterator();
		int count =0;
		while(itr.hasNext()){
			count++;
			Question q = itr.next();
			System.out.println("Question# "+q.getqNo());
			System.out.println(q.getqText());
			for(String option : q.getqOptions().keySet()){
				System.out.println(option+".   "+q.getqOptions().get(option));
			}
			
			System.out.println("Answer "+q.getqAnswer());
			System.out.println(q.getqAnswerText());
			System.out.println("Category:"+q.getqCategory());
		}
		System.out.println("Total Questions Count: "+count);
		
	}
	@Override
	public Question getQuestion(int QNo) {
		return qList.get().get(QNo);
	}
	public void setTotalQuestions(Map<String, Long> totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public Map<String, Long> getTotalQuestions() {
		return totalQuestions;
	}
	@Override
	public Vector<Question> getQuestionList(String testType, Long max, String filePath) {
		Map<Integer, Question>  testAllQList=getTestAllQList(testType);
		Vector<Question>  selectedTestQList= new Vector<Question>();
		int total=Integer.parseInt(String.valueOf(totalQuestions.get(testType)));
		Set<Integer>generatedN = new LinkedHashSet<Integer>();
		do{
			Random rand = new Random(); 
			int pickedNumber = rand.nextInt(total) + 1; 
			if(generatedN.contains(pickedNumber)){
				continue;
			}
			else{
				//System.out.println("Generated Question# "+pickedNumber);
				Question question = testAllQList.get(pickedNumber);
				//System.out.println("Adding question# "+question.getqNo());
				selectedTestQList.add(question);
				generatedN.add(pickedNumber);
				//System.out.println("generatedN: "+generatedN);
			}
		}while(selectedTestQList.size()<max);
		return selectedTestQList;
	}
	private Map<Integer, Question> getTestAllQList(String testType) {
		List<QuestionExt> list=questionRepository.getQuestionList();
		Map<Integer, Question>  testAllQList=new HashMap<Integer, Question>  ();
		for(QuestionExt question : list){
			if(question.getQuestionType().getName().equals(testType)){
				Question nextQuestion = new Question();
				Set<QuestionAnswer> questionAnswers = question.getQuestionAnswer();
				List<QuestionOption> questionOptions = question.getQuestionOptions();
				QuestionCategory questionCategory = question.getQuestionCategory();
				int qNo = question.getQNo();
				nextQuestion.setqCategory(questionCategory.getName());
				nextQuestion.setqNo(qNo);
				nextQuestion.setqText(question.getText());
				Map<String, String> options = new TreeMap<String, String>();
				for(QuestionOption option : questionOptions){
					options.put(option.getName(), option.getText());
				}
				nextQuestion.setqOptions(options);
				String actualAnswer = "";
				String answerText="";
				for(QuestionAnswer answer : questionAnswers){
					actualAnswer=actualAnswer+answer.getOption().getName();
					answerText=answer.getText();
				}
				nextQuestion.setqAnswer(actualAnswer);
				nextQuestion.setqAnswerText(answerText);
				testAllQList.put(qNo, nextQuestion);
			}
		}
		return testAllQList;
	}
	public Map<Integer, Question> getTestAllQList(String testType, String filePath) {
		Map<Integer, Question>  testAllQList=new HashMap<Integer, Question>  ();
		//String dataPath=(String) request.getSession().getServletContext().getRealPath("/data/");
		String fileName="/"+testType+"-questions.xml";
		//String testType=(String)request.getSession().getAttribute("testType");
		fileName="/"+testType+"-questions.xml";
		XmlHandler handler = new XmlHandler(filePath+fileName);
		 Element root= handler.getDocument().getDocumentElement();
		 NodeList questions = root.getChildNodes();
		 Question questionObj=null;
		 for(int i=0; i<questions.getLength(); i++){
			 Node questionNode = questions.item(i);
			 if(questionNode.getNodeType()==Node.ELEMENT_NODE){
				 Element questionElem = (Element)questionNode;
				 questionObj = new Question();
				 questionObj.setqNo(Integer.parseInt(questionElem.getAttribute("no")));
				 questionObj.setqText(questionElem.getElementsByTagName("body").item(0).getTextContent());
				 questionObj.setqCategory(questionElem.getElementsByTagName("category").item(0).getTextContent());
				 Element answerElem = (Element)questionElem.getElementsByTagName("answer").item(0);
				 questionObj.setqAnswer(answerElem.getAttribute("name"));
				 questionObj.setqAnswerText(answerElem.getTextContent());
				 Element optionsElem = (Element)questionElem.getElementsByTagName("options").item(0);
				 Map<String, String> optionsMap = new LinkedHashMap<String, String>();
				 NodeList options = optionsElem.getChildNodes();
				 for(int j=0; j<options.getLength(); j++){
					 Node optionNode = options.item(j); 
					 if(optionNode.getNodeType()==Node.ELEMENT_NODE){
						 Element optionElem = (Element)optionNode;
						 optionsMap.put(optionElem.getNodeName(), optionElem.getTextContent());
					 }
				 }
				 questionObj.setqOptions(optionsMap);
				 testAllQList.put(questionObj.getqNo(), questionObj);
			 }
		 }
		
		return testAllQList;
	}
	public void setQuestionRepository(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	public QuestionRepository getQuestionRepository() {
		return questionRepository;
	}
	@Override
	public List<QuestionCategory> getQuestionCategories() {
		return questionRepository.getQuestionCategories();
	}
	@Override
	public List<QuestionExt> getQuestionList() {
		return questionRepository.getQuestionList();
	}

}
