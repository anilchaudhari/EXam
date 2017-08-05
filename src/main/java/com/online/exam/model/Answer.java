package com.online.exam.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Answer")
public class Answer {
	@Id 
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "ans_id")
	private Long ansId;
	@Column(name="answer")
	private String answer;
	@Column(name="descrption")
	private String descrption;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="questions_id")
	private Questions questions;
	
	public Long getAnsId() {
		return ansId;
	}
	public void setAnsId(Long ansId) {
		this.ansId = ansId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	
}
