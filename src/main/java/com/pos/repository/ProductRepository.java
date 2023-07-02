package com.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pos.model.Category;
import com.pos.model.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Transactional
	@Modifying
	@Query("SELECT p FROM Product p WHERE  p.status=0 and CONCAT(p.code, ' ', p.title, ' ', p.title_kh) LIKE %?1%")
	public List<Product> search(String keyword);
	
	@Transactional
	@Modifying
	@Query("SELECT p FROM Product p WHERE p.status=0")
	public List<Product> getAllProdct();
}
