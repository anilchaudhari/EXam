package com.online.exam.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.online.exam.form.NewQuestion;
import com.online.exam.form.QuestionCriteria;
import com.online.exam.model.Answer;
import com.online.exam.model.Questions;
import com.online.exam.service.AnswerService;
import com.online.exam.service.CategoryService;
import com.online.exam.service.QuestionsService;

@Controller
public class QuestionController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private AnswerService answerService;
	
	//New Question
	@RequestMapping(value="newQuestion",method=RequestMethod.GET)
	public String requestNewQuestion(Model model){
		model.addAttribute("question", new NewQuestion());
		model.addAttribute("categories", categoryService.getAllCategory());
		return "new_question";
	}
	
	//Questions List
	@RequestMapping(value="questions",method=RequestMethod.GET)
	public String questionList(Model model){
		model.addAttribute("questionList", questionsService.findAllQuestion());
		
		return "questions";
	}
	
	@RequestMapping(value="saveQuestion",method=RequestMethod.POST)
	public String saveQuestion(@ModelAttribute("question") NewQuestion newQuestion, BindingResult result){
		Questions questions = new Questions();
		questions.setqCategory(categoryService.findById(newQuestion.getCategoryId()));
		questions.setOp1(newQuestion.getOp1());
		questions.setOp2(newQuestion.getOp2());
		questions.setOp3(newQuestion.getOp3());
		questions.setOp4(newQuestion.getOp4());
		questions.setQ_name(newQuestion.getQ_name());
		questions.setPostedby(newQuestion.getPostedby());
		Long questionId = questionsService.saveQuestions(questions);
		Answer answer = new Answer();
		answer.setAnswer(newQuestion.getAnswer());
		answer.setDescrption(newQuestion.getDesc());
		answer.setQuestions(questionsService.findById(questionId));
		answerService.saveAnswer(answer);
		return "questions";
	}

	//New Question
	@RequestMapping(value="questioncriteri",method=RequestMethod.GET)
	public String requestForTest(Model model){
		model.addAttribute("questionCriteria", new QuestionCriteria());
		model.addAttribute("categories", categoryService.getAllCategory());
		return "questioncriteri";
	}
	
	//New Question
	@RequestMapping(value="takeexam",method=RequestMethod.POST)
	public String takeExam(@ModelAttribute("questionCriteria") QuestionCriteria questionCriteria, BindingResult result, Model model){
		List<Questions> questionList = questionsService.findRandomQuestion(questionCriteria);
		model.addAttribute("questionsList", questionList);
		model.addAttribute("counter", questionList.size());
		return "take_exam";
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public QuestionsService getQuestionsService() {
		return questionsService;
	}

	public void setQuestionsService(QuestionsService questionsService) {
		this.questionsService = questionsService;
	}

	public AnswerService getAnswerService() {
		return answerService;
	}

	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}
}
