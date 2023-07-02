package com.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pos.model.Staff;

import jakarta.transaction.Transactional;

public interface StaffRepository extends JpaRepository<Staff, Long>{
	@Transactional
	@Modifying
	@Query("SELECT s FROM Staff s WHERE  s.status=0 and CONCAT(s.code, ' ', s.fullname_en, ' ', s.fullname_kh) LIKE %?1%")
	public List<Staff> search(String keyword);
	
	@Transactional
	@Modifying
	@Query("SELECT s FROM Staff s WHERE s.status=0")
	public List<Staff> getAllStaff();
	public Staff findByUsernameAndPassword (String username,String password);
}
