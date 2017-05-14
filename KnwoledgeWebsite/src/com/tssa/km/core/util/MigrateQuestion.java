package com.tssa.km.core.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tssa.km.domain.Question;
import com.tssa.km.domain.service.QuestionServiceImpl;

public class MigrateQuestion {
	final static String[] testType = new String[]{"cpp","java", "design", "db","os"};
	final static String FS="','";
	final Map<String, Integer> qTypeMap= new HashMap<String, Integer>();
	final Map<String, Integer> qCategoryMap= new HashMap<String, Integer>();
	int nextQuestionOptionId=0;
	int nextQuestionId=0;
	public MigrateQuestion(){
		initTestType();
		initCategory();
		
	}
	private void initCategory() {
		qCategoryMap.put("CS",1);
		qCategoryMap.put("DPT",2);
		qCategoryMap.put("DBMS",3);
		qCategoryMap.put("DGN",4);
		qCategoryMap.put("OS",5);
		qCategoryMap.put("DPP",6);
		qCategoryMap.put("IP",7);
		qCategoryMap.put("IO",8);
		qCategoryMap.put("FSP",9);
		qCategoryMap.put("PKG",10);
		qCategoryMap.put("OOTCF",11);
		qCategoryMap.put("N",12);
		qCategoryMap.put("DS",13);
		qCategoryMap.put("GT",14);
		qCategoryMap.put("APT",15);
		qCategoryMap.put("MT",16);
		qCategoryMap.put("TLT",17);
		qCategoryMap.put("DTOPCS",18);
		qCategoryMap.put("AI",19);
		qCategoryMap.put("RTTI",20);
		qCategoryMap.put("FCT",21);
		qCategoryMap.put("JC",22);
		qCategoryMap.put("EDH",23);
		qCategoryMap.put("IDP",24);
		qCategoryMap.put("JAVA",25);
		qCategoryMap.put("STL",26);
		qCategoryMap.put("OOP",27);
		qCategoryMap.put("EH",28);
	}
	private void initTestType() {
		qTypeMap.put("cpp",1);
		qTypeMap.put("java",2);
		qTypeMap.put("design",3);
		qTypeMap.put("db",4);
		qTypeMap.put("os",5);
	}
	public static void main(String[] args) {
		try {
			new MigrateQuestion().migrate();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	void migrate() throws FileNotFoundException{
		PrintWriter  sqlFileWriter = new PrintWriter (new File("E:\\workspaces\\KnowledgeWebsite\\WebContent\\data\\questions.sql"));
		//sqlFileWriter.write("INSERT INTO kmp_questions_ (id, description, created_ts)VALUES\n");
		for(int i=0;i<testType.length;i++){
			String test = testType[i];
			Map<Integer, Question>  testAllQList = new QuestionServiceImpl().getTestAllQList(test, "E:\\workspaces\\KnowledgeWebsite\\WebContent\\data\\");
			for(Integer qid : testAllQList.keySet()){
				migrateQuestion(testAllQList.get(qid), sqlFileWriter,test);
			}
		}
		sqlFileWriter.close();
	}
	private void migrateQuestion(Question question, PrintWriter sqlFileWriter, String test) {
		sqlFileWriter.write("\n\n-- #########################################################################################\n");
		sqlFileWriter.write("INSERT INTO kmp_questions_question (id, qNo, text, category_id, type_id, created_ts)VALUES\n");
		String editedQText=question.getqText().replace("'", "''");
		nextQuestionId++;
		String qSql="('"+nextQuestionId+FS+question.getqNo()+FS+editedQText+FS+qCategoryMap.get(question.getqCategory())+FS+qTypeMap.get(test)+"',now());\n";
		sqlFileWriter.write(qSql);
		for(String optionKey : question.getqOptions().keySet()){
			List<Integer> answers=new ArrayList<Integer>();
			nextQuestionOptionId++;
			sqlFileWriter.write("INSERT INTO kmp_questions_option (id, name, text, question_id, created_ts)VALUES\n");
			String editedOptionText=question.getqOptions().get(optionKey).replace("'", "''");
			String optionSql="('"+nextQuestionOptionId+FS+optionKey+FS+editedOptionText+FS+nextQuestionId+"',now());\n";
			sqlFileWriter.write(optionSql);
			if(isOptionInAnswers(question.getqAnswer(), optionKey)){
				answers.add(nextQuestionOptionId);
			}
			for(Integer answer : answers){
				sqlFileWriter.write("INSERT INTO kmp_questions_answer (selected_option_id, text, question_id, created_ts)VALUES\n");
				String editedAnswerText=question.getqAnswerText().replace("'", "''");
				String answerSql="('"+answer+FS+editedAnswerText+FS+nextQuestionId+"',now());\n";
				sqlFileWriter.write(answerSql);
			}
		}
	}
	private boolean isOptionInAnswers(String getqAnswers, String optionKey) {
		for(int i=0; i<getqAnswers.length();i++){
			char answer = getqAnswers.charAt(i);
			if(optionKey.equals(answer+"")){
				return true;
			}
		}
		return false;
	}
}
