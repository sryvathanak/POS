package com.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pos.model.Category;

import jakarta.transaction.Transactional;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Transactional
	@Modifying
	@Query("SELECT c FROM Category c WHERE  c.status=0 and CONCAT(c.code, ' ', c.title, ' ', c.title_kh) LIKE %?1%")
	public List<Category> search(String keyword);
	
	@Transactional
	@Modifying
	@Query("SELECT c FROM Category c WHERE c.status=0")
	public List<Category> getAllCategory();
	
	
}
