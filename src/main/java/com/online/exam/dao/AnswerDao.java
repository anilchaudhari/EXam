package com.online.exam.dao;

import com.online.exam.model.Answer;
import com.online.exam.model.Questions;

public interface AnswerDao {
	
	Long saveAnswer(Answer answer);
	void deleteByQuestions(Questions questions);
}
