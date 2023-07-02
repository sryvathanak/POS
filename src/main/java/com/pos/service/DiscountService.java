package com.pos.service;

import java.util.List;

import com.pos.model.DiscountType;

public interface DiscountService {
	public DiscountType saveDiscount(DiscountType type);
	public List<DiscountType> getAllDiscounts();
	public DiscountType getByDiscountId(Long id);
	public DiscountType updateDiscount(DiscountType type);
	public void deleteDiscountById(DiscountType type);
	public List<DiscountType> listAll(String keyword);
}
