package com.tssa.km.domain.hibernate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.tssa.km.core.entity.AbstractEntity;
import com.tssa.km.domain.Question;

public class QuestionExt extends AbstractEntity {
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Set<QuestionAnswer> getQuestionAnswer() {
		return questionAnswers;
	}
	public void setQuestionAnswer(Set<QuestionAnswer> questionAnswers) {
		this.questionAnswers = questionAnswers;
	}
	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}
	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
	}
	public QuestionType getQuestionType() {
		return questionType;
	}
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	public List<QuestionOption> getQuestionOptions() {
		return questionOptions;
	}
	public void setQuestionOptions(List<QuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}
	
	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}
	public Timestamp getCreatedTs() {
		return createdTs;
	}

	public void setQNo(int qNo) {
		this.qNo = qNo;
	}
	public int getQNo() {
		return qNo;
	}

	private static final long serialVersionUID = 1L;
	private int qNo;
	private String text;
	private Set<QuestionAnswer> questionAnswers;
	private List<QuestionOption> questionOptions=new ArrayList<QuestionOption>();
	private QuestionCategory questionCategory;
	private QuestionType questionType;
	private Timestamp createdTs;
}

