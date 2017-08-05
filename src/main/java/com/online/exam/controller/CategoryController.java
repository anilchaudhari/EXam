package com.online.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.online.exam.form.NewCategory;
import com.online.exam.model.QCategory;
import com.online.exam.service.CategoryService;
import com.online.exam.service.QuestionsService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private QuestionsService questionsService;

	//List of Category
	@RequestMapping(value="categories",method=RequestMethod.GET)
	public String categoryList(Model model){
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}
	
	//Delete Category
	@RequestMapping(value="deletecategory/{id}",method=RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long id, Model model){
		/*QCategory qCategory = categoryService.findById(id);
		Questions questions = questionsService.findByCategory(qCategory.getCid());
		System.out.println("idididii:"+qCategory.getCid());
		System.out.println("question name is:"+questions.getQ_name());;
		questionsService.deleteQuestionsByCategory(qCategory);
		categoryService.deleteCategory(qCategory);
		questionsService.deleteById(questions.getQ_id());*/
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}

	//New Category
	@RequestMapping(value="category",method=RequestMethod.GET)
	public String requestNewCategory(Model model){
		model.addAttribute("category", new NewCategory());
		return "new_category";
	}
	
	@RequestMapping(value="savecategory",method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") NewCategory newCategory, BindingResult result, Model model){
		
		QCategory category = new QCategory();
		category.setCname(newCategory.getCategoryName());
		categoryService.saveCategory(category);
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
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

}
