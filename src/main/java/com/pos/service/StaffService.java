package com.pos.service;

import java.util.List;

import com.pos.model.Staff;

public interface StaffService {
	public Staff saveStaff(Staff staff);
	public List<Staff> getAllStaffs();
	public Staff getStaffById(Long id);
	public Staff updateStaff(Staff staff);
	public void deleteStaffById(Staff staff);
	public List<Staff> listAll(String keyword);
}
