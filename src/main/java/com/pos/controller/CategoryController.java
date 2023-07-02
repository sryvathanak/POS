package com.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.pos.model.Category;
import com.pos.service.CategoryServiceImp;

@Controller
@RequestMapping("")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImp categoryServiceImp;
	
	@GetMapping("/categorys")
	  public String searchcategorys(Model model,@Param("keyword") String keyword) {
		List<Category> listCategory = categoryServiceImp.listAll(keyword);
			model.addAttribute("categorys", listCategory);
			model.addAttribute("keyword", keyword);
		
	    return "categorys";
	  }
	
	
	@GetMapping("/categorys/new")
	public String createCategory(Model model) {
		
		
		Category category = new Category();
		model.addAttribute("category", category);
		return "saveCategory";
		
	}
	@PostMapping("/categorys")
	public String saveCategory(@ModelAttribute("category") Category category) 
	{
		categoryServiceImp.saveCategory(category);
		return "redirect:/categorys";
	}
	
	@GetMapping("/categorys/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("category", categoryServiceImp.getCategoryById(id));
		return "updateCategory";
	}

	
	@PostMapping("/categorys/{id}")
	public String updateCategory(@PathVariable Long id,
			@ModelAttribute("category") Category category,
			Model model) {
		Category catego = categoryServiceImp.getCategoryById(id);
		catego.setId(id);
		catego.setCode(category.getCode());
		catego.setTitle(category.getTitle());
		catego.setTitle_kh(category.getTitle_kh());
		
		categoryServiceImp.updateCategory(category);
		return "redirect:/categorys";
	}
	
	@GetMapping("/categorys/{id}")
	public String deleteCategory(@PathVariable Long id,@ModelAttribute("category") Category category,
			Model model) {
		Category catego = categoryServiceImp.getCategoryById(id);
//		catego.setId(id);
//		catego.setCode(category.getCode());
//		catego.setTitle(category.getTitle());
//		catego.setTitle_kh(category.getTitle_kh());
		catego.setStatus(1);
		categoryServiceImp.deleteCategoryById(catego);
		return "redirect:/categorys";
	}
}
