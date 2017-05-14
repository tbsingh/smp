package com.tssa.km.domain.hibernate;

import java.sql.Timestamp;

import com.tssa.km.core.entity.AbstractEntity;
import com.tssa.km.domain.Question;

public class QuestionAnswer extends AbstractEntity {
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public QuestionExt getQuestion() {
		return question;
	}
	public void setQuestion(QuestionExt question) {
		this.question = question;
	}
	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}
	public Timestamp getCreatedTs() {
		return createdTs;
	}
	public void setOption(QuestionOption option) {
		this.option = option;
	}
	public QuestionOption getOption() {
		return option;
	}
	private static final long serialVersionUID = 1L;
	private QuestionOption option;
	private String text;
	private QuestionExt question;
	private Timestamp createdTs;
}

