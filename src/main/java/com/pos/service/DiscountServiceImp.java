package com.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.model.DiscountType;
import com.pos.repository.DiscountRepository;

@Service
public class DiscountServiceImp implements DiscountService{

	@Autowired
	private DiscountRepository discountRepository;
	@Override
	public DiscountType saveDiscount(DiscountType type) {
		// TODO Auto-generated method stub
		return discountRepository.save(type);
	}

	@Override
	public List<DiscountType> getAllDiscounts() {
		// TODO Auto-generated method stub
		return discountRepository.findAll();
	}

	@Override
	public DiscountType getByDiscountId(Long id) {
		// TODO Auto-generated method stub
		return discountRepository.findById(id).get();
	}

	@Override
	public DiscountType updateDiscount(DiscountType type) {
		// TODO Auto-generated method stub
		return discountRepository.save(type);
	}

	@Override
	public void deleteDiscountById(DiscountType type) {
		// TODO Auto-generated method stub
		discountRepository.save(type);
	}

	@Override
	public List<DiscountType> listAll(String keyword) {
		// TODO Auto-generated method stub
		if (keyword  != null) {
			return discountRepository.search(keyword);
		}
		else
			return discountRepository.getAllDiscount();
	}

}
