package com.pos.service;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pos.model.Category;
import com.pos.repository.CategoryRepository;

@Service
public  class CategoryServiceImp implements CategoryService {
     
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategorys() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category updateCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategoryById(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.save(category);
	}

	@Override
	public List<Category> listAll(String keyword) {
		 
		if (keyword  != null) {
			return categoryRepository.search(keyword);
		}
		else
			return categoryRepository.getAllCategory();
		   // return (List<Category>) categoryRepository.findAll(Sort.by("code").ascending());
	}

	

	

	
	
	
}
