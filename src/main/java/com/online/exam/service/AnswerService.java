package com.online.exam.service;

import com.online.exam.model.Answer;
import com.online.exam.model.Questions;

public interface AnswerService {
	Long saveAnswer(Answer answer);
	void deleteByQuestions(Questions questions);
}
