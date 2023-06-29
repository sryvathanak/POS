package com.pos.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Stock")
public class Stock {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id")
	  private Long id;
	  @Column(name="code")
	  private String code;
	  @Column(name = "status")
	  private int status;
	  @Column(name = "quantity")
	  private Double quantity;
	  @Column(name = "reason")
	  private String reason;
	  @Column(name = "in_stock_date")
	  private LocalDateTime stock_in_date;
	  @OneToOne(cascade =CascadeType.ALL)
	  private Product product;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LocalDateTime getStock_in_date() {
		return stock_in_date;
	}
	public void setStock_in_date(LocalDateTime stock_in_date) {
		this.stock_in_date = stock_in_date;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Stock(Long id, String code, int status, Double quantity, String reason, LocalDateTime stock_in_date,
			Product product) {
		super();
		this.id = id;
		this.code = code;
		this.status = status;
		this.quantity = quantity;
		this.reason = reason;
		this.stock_in_date = stock_in_date;
		this.product = product;
	}
	  
	  
}
