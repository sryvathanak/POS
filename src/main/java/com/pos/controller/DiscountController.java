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
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.model.DiscountType;
import com.pos.service.DiscountServiceImp;

@Controller
@RequestMapping("")
public class DiscountController {

	@Autowired
	private DiscountServiceImp discountServiceImp;
	
	@GetMapping("/discounts")
	  public String searchdiscounts(Model model,@Param("keyword") String keyword) {
		List<DiscountType> listDiscountTypes = discountServiceImp.listAll(keyword);
			model.addAttribute("discounts", listDiscountTypes);
			model.addAttribute("keyword", keyword);
		
	    return "discounts";
	  }
	
	
	@GetMapping("/discounts/new")
	public String createDiscount(Model model) {
		
		
		DiscountType discountType = new DiscountType();
		model.addAttribute("discount", discountType);
		return "saveDiscount";
		
	}
	@PostMapping("/discounts")
	public String saveDiscount(@ModelAttribute("discount") DiscountType discountType) 
	{
		discountServiceImp.saveDiscount(discountType);
		return "redirect:/discounts";
	}
	
	@GetMapping("/discounts/edit/{id}")
	public String editDiscountForm(@PathVariable Long id, Model model) {
		model.addAttribute("discount", discountServiceImp.getByDiscountId(id));
		return "updateDiscount";
	}

	
	@PostMapping("/discounts/{id}")
	public String updateDiscount(@PathVariable Long id,
			@ModelAttribute("category") DiscountType discountType,
			Model model) {
		DiscountType type = discountServiceImp.getByDiscountId(id);
		type.setId(id);
		type.setCode(discountType.getCode());
		type.setTitle(discountType.getTitle());
		type.setTitle_kh(discountType.getTitle_kh());
		
		discountServiceImp.updateDiscount(discountType);
		return "redirect:/discounts";
	}
	
	@GetMapping("/discounts/{id}")
	public String deleteDiscount(@PathVariable Long id,@ModelAttribute("discount") DiscountType discountType,
			Model model) {
		DiscountType type = discountServiceImp.getByDiscountId(id);
		type.setStatus(1);
		discountServiceImp.deleteDiscountById(type);
		return "redirect:/discounts";
	}
}
