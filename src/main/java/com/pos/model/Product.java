package com.pos.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Product")
public class Product {
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
	  @Column(name = "price")
	  private Double price;
	  @Column(name = "quantity")
	  private Double quantity;
	  @Column(name = "description")
	  private String description;
	  @Column(name = "product_image")
	  private String product_image;
	  
	  public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
	    private Category category;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product(Long id, String code, String title, String title_kh, int status, Double price, Double quantity,
			String description, Category category) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.title_kh = title_kh;
		this.status = status;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.category = category;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	  
	  
}
