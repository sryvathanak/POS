package com.pos.service;

import java.util.List;

import com.pos.model.Category;
import com.pos.model.Role;

public interface RoleService {

	public Role saveRole(Role role);
	public List<Role> getAllRoles();
	public Role getRoleById(Long id);
	public Role updateRole(Role role);
	public void deleteRoleById(Role role);
	public List<Role> listAll(String keyword);
}
