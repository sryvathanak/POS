package com.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.model.Role;
import com.pos.repository.RoleRepository;
@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id).get();
	}

	@Override
	public Role updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void deleteRoleById(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

	@Override
	public List<Role> listAll(String keyword) {
		// TODO Auto-generated method stub
		if (keyword  != null) {
			return roleRepository.search(keyword);
		}
		else
			return roleRepository.getAllRole();
	}

}
