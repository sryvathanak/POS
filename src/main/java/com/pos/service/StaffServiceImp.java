package com.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.model.Staff;
import com.pos.repository.StaffRepository;
@Service
public class StaffServiceImp implements StaffService{

	@Autowired
	private StaffRepository staffRepository;
	@Override
	public Staff saveStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffRepository.save(staff);
	}

	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return staffRepository.findAll();
	}

	@Override
	public Staff getStaffById(Long id) {
		// TODO Auto-generated method stub
		return staffRepository.findById(id).get();
	}

	@Override
	public Staff updateStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffRepository.save(staff);
	}

	@Override
	public void deleteStaffById(Staff staff) {
		// TODO Auto-generated method stub
		staffRepository.save(staff);
	}

	@Override
	public List<Staff> listAll(String keyword) {
		// TODO Auto-generated method stub
		if (keyword  != null) {
			return staffRepository.search(keyword);
		}
		else
			return staffRepository.getAllStaff();
	}

}
