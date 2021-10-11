package com.simplilearn.sportyshoes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.entity.Category;
import com.simplilearn.sportyshoes.entity.Product;
import com.simplilearn.sportyshoes.exception.SSException;
import com.simplilearn.sportyshoes.service.ShoesService;


@Controller
public class CategoryController {

	private Logger logger = null;
	
	
	@Autowired
	private ShoesService<Category> service;
	
	
	public CategoryController () {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}
	
	@GetMapping("/admin/categories")
	 public ModelAndView getCategories() {
		logger.debug("inside get all categories");
		List<Category> categories =  service.getAll();
		return new ModelAndView("categories/list-categories", "categories", categories);
	}
	

	@GetMapping("/admin/categories/add")
	public ModelAndView showNewFormAction() {
		return new ModelAndView("categories/add-category", "category", new Category());
	}
	
	@PostMapping("/admin/categories/add") 
	public ModelAndView addCategory(@ModelAttribute("category")Category category) throws SSException {
		logger.debug("inside add category");
			service.add(category);
		return new ModelAndView("redirect:/admin/categories");
	}
	
	@GetMapping("/admin/categories/edit/{categoryId}")
	public ModelAndView showEditFormAction(@PathVariable("categoryId")Integer categoryId) throws SSException {
		Category category = service.getById(categoryId);
		return new ModelAndView("categories/add-category", "category", category);
	}
	
	@PostMapping("/admin/categories/edit/{categoryId}") 
	public ModelAndView editCategory(@ModelAttribute("category")Category category) throws SSException {
		logger.debug("inside edit category");
		System.out.println("cateogry: " + category);
		service.update(category);
		return new ModelAndView("redirect:/admin/categories");
	}

	@GetMapping("/admin/categories/delete/{categoryId}")
	public ModelAndView deleteCategory(@PathVariable("categoryId")Integer categoryId) throws SSException {
		logger.debug("inside delete category");
		service.delete(categoryId);
		return new ModelAndView("redirect:/admin/categories");
	}

}
