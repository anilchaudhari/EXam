package com.online.exam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.exam.dao.QuestionsDao;
import com.online.exam.form.QuestionCriteria;
import com.online.exam.model.QCategory;
import com.online.exam.model.Questions;
@Service
@Transactional
public class QuestionsServiceImpl implements QuestionsService {

	@Autowired
	private QuestionsDao questionsDao;
	public Long saveQuestions(Questions questions) {
		
		return questionsDao.saveQuestions(questions);
	}

	public Questions findById(Long qId) {
		
		return questionsDao.findById(qId);
	}

	public void deleteQuestionsByCategory(QCategory category) {
		questionsDao.deleteQuestionsByCategory(category);
		
	}
	public void deleteById(Long id) {
		questionsDao.deleteById(id);
		
	}
	public Questions findByCategory(Long cId) {
		
		return questionsDao.findByCategory(cId);
	}
	public List<Questions> findRandomQuestion(QuestionCriteria questionCriteria) {
		// TODO Auto-generated method stub
		return questionsDao.findRandomQuestion(questionCriteria);
	}
	public List<Questions> findAllQuestion() {
		// TODO Auto-generated method stub
		return questionsDao.findAllQuestion();
	}
	public QuestionsDao getQuestionsDao() {
		return questionsDao;
	}
	public void setQuestionsDao(QuestionsDao questionsDao) {
		this.questionsDao = questionsDao;
	}

	


}
