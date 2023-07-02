package com.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pos.model.Category;
import com.pos.model.Role;

import jakarta.transaction.Transactional;

public interface RoleRepository extends JpaRepository<Role, Long>{

	@Transactional
	@Modifying
	@Query("SELECT r FROM Role r WHERE  r.status=0 and CONCAT(r.code, ' ', r.title, ' ', r.title_kh) LIKE %?1%")
	public List<Role> search(String keyword);
	
	@Transactional
	@Modifying
	@Query("SELECT r FROM Role r WHERE r.status=0")
	public List<Role> getAllRole();
	
}
