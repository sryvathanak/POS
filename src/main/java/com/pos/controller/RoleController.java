package com.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.model.Category;
import com.pos.model.Role;
import com.pos.service.RoleServiceImp;

@Controller
@RequestMapping("")
public class RoleController {

	@Autowired
	private RoleServiceImp roleServiceImp;
	@GetMapping("/roles")
	  public String searchcategorys(Model model,@Param("keyword") String keyword) {
		List<Role> listRole = roleServiceImp.listAll(keyword);
			model.addAttribute("roles", listRole);
			model.addAttribute("keyword", keyword);
		
	    return "roles";
	  }
	
	
	@GetMapping("/roles/new")
	public String createRole(Model model) {
		
		
		Role role = new Role();
		model.addAttribute("role", role);
		return "saveRole";
		
	}
	@PostMapping("/roles")
	public String saveRole(@ModelAttribute("role") Role role) 
	{
		roleServiceImp.saveRole(role);
		return "redirect:/roles";
	}
	
	@GetMapping("/roles/edit/{id}")
	public String editRoleForm(@PathVariable Long id, Model model) {
		model.addAttribute("role", roleServiceImp.getRoleById(id));
		return "updateRole";
	}

	
	@PostMapping("/roles/{id}")
	public String updateRole(@PathVariable Long id,
			@ModelAttribute("role") Role role,
			Model model) {
		Role r = roleServiceImp.getRoleById(id);
		r.setId(id);
		r.setCode(role.getCode());
		r.setTitle(role.getTitle());
		r.setTitle_kh(role.getTitle_kh());
		
		roleServiceImp.updateRole(role);
		return "redirect:/roles";
	}
	
	@GetMapping("/roles/{id}")
	public String deleteRole(@PathVariable Long id,@ModelAttribute("role") Role role,
			Model model) {
		Role r = roleServiceImp.getRoleById(id);

		r.setStatus(1);
		roleServiceImp.deleteRoleById(r);
		return "redirect:/roles";
	}
}
