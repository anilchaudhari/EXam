package com.online.exam.dao;

import java.util.List;

import com.online.exam.form.QuestionCriteria;
import com.online.exam.model.QCategory;
import com.online.exam.model.Questions;

public interface QuestionsDao {
	
	Long saveQuestions(Questions questions);
	Questions findById(Long qId);
	void deleteQuestionsByCategory(QCategory  category);
	void deleteById(Long id);
	Questions findByCategory(Long cId);
	List<Questions> findAllQuestion();
	List<Questions> findRandomQuestion(QuestionCriteria questionCriteria);
}
