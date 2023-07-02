package com.pos.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="code")
	private String code;
	@Column(name="fullname_en")
	private String fullname_en;
	@Column(name="fullname_kh")
	private String fullname_kh;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "staffs_roles",
        joinColumns = @JoinColumn(name = "staff_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
	private List<Role> roles;
	@Column(name="work_in")
	private String work_in;
	@Column(name="work_out")
	private String work_out;
	@Column(name="phone_number")
	private String phone_number;
	@Column(name="address")
	private String address;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name = "status")
	private int status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFullname_en() {
		return fullname_en;
	}
	public void setFullname_en(String fullname_en) {
		this.fullname_en = fullname_en;
	}
	public String getFullname_kh() {
		return fullname_kh;
	}
	public void setFullname_kh(String fullname_kh) {
		this.fullname_kh = fullname_kh;
	}
	
	
	
	public String getWork_in() {
		return work_in;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setWork_in(String work_in) {
		this.work_in = work_in;
	}
	public String getWork_out() {
		return work_out;
	}
	public void setWork_out(String work_out) {
		this.work_out = work_out;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
