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
import com.pos.model.Staff;
import com.pos.repository.StaffRepository;
import com.pos.service.StaffServiceImp;

@Controller
@RequestMapping("")
public class StaffController {

	@Autowired
	private StaffServiceImp staffServiceImp;
	@Autowired 
	private StaffRepository staffRepository;
	@GetMapping("/staffs")
	  public String searchstaffs(Model model,@Param("keyword") String keyword) {
		List<Staff> listStaffs= staffServiceImp.listAll(keyword);
			model.addAttribute("staffs", listStaffs);
			model.addAttribute("keyword", keyword);
		
	    return "staffs";
	  }
	
	
	@GetMapping("/staffs/new")
	public String createStaff(Model model) {
		
		
		Staff staff = new Staff();
		model.addAttribute("staff", staff);
		return "saveStaff";
		
	}
	@PostMapping("/staffs")
	public String saveStaff(@ModelAttribute("staff") Staff staff) 
	{
		staffServiceImp.saveStaff(staff);
		return "redirect:/staffs";
	}
	
	@GetMapping("/staffs/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("staff", staffServiceImp.getStaffById(id));
		return "updateStaff";
	}

	
	@PostMapping("/staffs/{id}")
	public String updateStaff(@PathVariable Long id,
			@ModelAttribute("staff") Staff staff,
			Model model) {
		Staff s = staffServiceImp.getStaffById(id);
		s.setId(id);
		s.setCode(staff.getCode());
		s.setFullname_en(staff.getFullname_en());
		s.setFullname_kh(staff.getFullname_kh());
		s.setPhone_number(staff.getPhone_number());
		s.setAddress(staff.getAddress());
		s.setUsername(staff.getUsername());
		s.setPassword(staff.getPassword());
		s.setWork_in(staff.getWork_in());
		s.setWork_out(staff.getWork_out());
		s.setRoles(staff.getRoles());
		
		staffServiceImp.updateStaff(staff);
		return "redirect:/staffs";
	}
	
	@GetMapping("/staffs/{id}")
	public String deleteStaff(@PathVariable Long id,@ModelAttribute("staff") Staff staff,
			Model model) {
		Staff s = staffServiceImp.getStaffById(id);
//		catego.setId(id);
//		catego.setCode(category.getCode());
//		catego.setTitle(category.getTitle());
//		catego.setTitle_kh(category.getTitle_kh());
		s.setStatus(1);
		staffServiceImp.deleteStaffById(s);
		return "redirect:/staffs";
	}
	
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	@PostMapping("/")
	public String userLogin(@ModelAttribute(name="user")Staff staff,Model model) {
		
		
		staff=staffRepository.findByUsernameAndPassword(staff.getUsername(),staff.getPassword());
		if(staff == null) {
            model.addAttribute("msg", "Invalid Username and Password");
            return "login";
        }else {
            return "index";
        }
	}
}
