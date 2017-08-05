package com.online.exam.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.exam.dao.AnswerDao;
import com.online.exam.model.Answer;
import com.online.exam.model.Questions;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private AnswerDao answerDao;

	public Long saveAnswer(Answer answer) {
		
		return answerDao.saveAnswer(answer);
	}

	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}

	public void deleteByQuestions(Questions questions) {
		// TODO Auto-generated method stub
		
	}

}
