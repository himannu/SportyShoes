package com.simplilearn.sportyshoes.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.entity.Category;
import com.simplilearn.sportyshoes.entity.Product;
import com.simplilearn.sportyshoes.exception.SSException;
import com.simplilearn.sportyshoes.model.ShoeSizes;
import com.simplilearn.sportyshoes.service.ProductServiceImpl;
import com.simplilearn.sportyshoes.service.ShoesService;


@Controller
public class ProductController {

	private Logger logger = null;
	
	
	@Autowired
	private ShoesService<Product> service;
	
	@Autowired
	private ShoesService<Category> categoryService;
	
	public ProductController () {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}
	
	@GetMapping("/admin/products")
	 public ModelAndView getProducts() {
		logger.debug("inside get all products");
		
		List<Product> products =  service.getAll();
		return new ModelAndView("products/list-products", "products", products);
	}
	
	@GetMapping("/user/products")
	 public ModelAndView getUserProducts(HttpSession session) {
		logger.debug("inside user products");

		ModelAndView mv = new ModelAndView("user-home");
		Object obj = session.getAttribute("cartItems");
		if (obj == null) {
			session.setAttribute("cartItems", 0);
		}
		mv.addObject("products", service.getAll());
		mv.addObject("categoriesMap", getCategoriesMap());
		return mv;
	}
	
	@GetMapping("/user/products/{productId}")
	 public ModelAndView viewProduct(@PathVariable("productId") Integer productId) throws SSException {
		logger.debug("inside view product");

		ModelAndView mv = new ModelAndView("products/view-product");
		mv.addObject("product", service.getById(productId));
		return mv;
	}
	
	@GetMapping("/user/products/searchByCategory/{categoryId}")
	 public ModelAndView searchByCategory(@PathVariable("categoryId") Integer categoryId) throws SSException {
		List<Product> products = ((ProductServiceImpl)service).getByCategory(categoryId);
		ModelAndView mv = new ModelAndView("user-home");
		mv.addObject("products", products);
		mv.addObject("categoriesMap", getCategoriesMap());
		return mv;
	}

	
	@GetMapping("admin/products/add")
	public ModelAndView showNewFormAction() {
		ModelAndView mv = new ModelAndView("products/add-product");
		Product product = new Product();
		Category category = new Category();
		product.setCategory(category);
		mv.addObject("product", product);
		mv.addObject("categoriesMap", getCategoriesMap());
		return mv;
	}
	
	private Map<Integer, String> getCategoriesMap() {
		List<Category> categories = categoryService.getAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		categories.stream().forEach(cat-> categoryMap.put(cat.getId(), cat.getName()));
		return categoryMap;
	}
	
	@PostMapping("admin/products/add") 
	public ModelAndView addProduct(@ModelAttribute("product") Product product ) {
		
		try {
			service.add(product);
		} catch (SSException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/products");
	}
	
	@GetMapping("admin/products/edit/{productId}")
	public ModelAndView showEditFormAction(@PathVariable("productId")Integer productId) throws SSException {
		logger.debug("inside show edit product");

		ModelAndView mv = new ModelAndView("products/add-product");
		Product product = service.getById(productId);
		mv.addObject("product", product);
		List<Category> categories = categoryService.getAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		categories.stream().forEach(cat-> categoryMap.put(cat.getId(), cat.getName()));
		mv.addObject("categoriesMap", categoryMap);
		return mv;
	}

	
	@PostMapping("admin/products/edit/{productId}") 
	public ModelAndView editProduct(@ModelAttribute("product")Product product) throws SSException {
		logger.debug("inside edit product");
		System.out.println("product: " + product);
		service.update(product);
		return new ModelAndView("redirect:/admin/products");
	}

	@GetMapping("admin/products/delete/{productId}")
	public ModelAndView deleteProduct(@PathVariable("productId")Integer productId) throws SSException {
		logger.debug("inside delete product");
		service.delete(productId);
		return new ModelAndView("redirect:/admin/products");
	}
	
}
