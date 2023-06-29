package com.pos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class Customer {
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
	  @Column(name="phone_number")
	  private String phone_number;
	  @Column(name="address")
	  private String address;
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
	public Customer(Long id, String code, String fullname_en, String fullname_kh, String phone_number, String address) {
		super();
		this.id = id;
		this.code = code;
		this.fullname_en = fullname_en;
		this.fullname_kh = fullname_kh;
		this.phone_number = phone_number;
		this.address = address;
	}
	  
	  
}
