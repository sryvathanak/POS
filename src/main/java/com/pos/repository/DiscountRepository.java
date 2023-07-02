package com.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pos.model.Category;
import com.pos.model.DiscountType;

import jakarta.transaction.Transactional;

public interface DiscountRepository extends JpaRepository<DiscountType, Long> {
	@Transactional
	@Modifying
	@Query("SELECT d FROM DiscountType d WHERE  d.status=0 and CONCAT(d.code, ' ', d.title, ' ', d.title_kh) LIKE %?1%")
	public List<DiscountType> search(String keyword);
	
	@Transactional
	@Modifying
	@Query("SELECT d FROM DiscountType d WHERE d.status=0")
	public List<DiscountType> getAllDiscount();
	
}
