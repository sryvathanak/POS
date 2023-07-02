package com.pos.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Role")
public class Role {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id")
	  private Long id;
	  @Column(name="code")
	  private String code;
	  @Column(name="title")
	  private String title;
	  @Column(name="title_kh")
	  private String title_kh;
	  @Column(name = "status")
	  private int status;
	  
	  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle_kh() {
		return title_kh;
	}
	public void setTitle_kh(String title_kh) {
		this.title_kh = title_kh;
	}
	public Role(Long id, String title, String title_kh) {
		super();
		this.id = id;
		this.title = title;
		this.title_kh = title_kh;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  
	 
}
