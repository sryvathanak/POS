package com.pos.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "transaction_item")
public class TransactionItem {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id")
	  private Long id;
	  @Column(name="code")
	  private String code;
	  @Column(name = "status")
	  private int status;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Product product;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Staff staff;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Customer customer;
	  @OneToOne(cascade = CascadeType.ALL)
	  private DiscountType discountType;
	  @Column(name = "quantity")
	  private Double quantity;
	  @ManyToOne
	  @JoinColumn(name = "transaction_id")
	  private Transaction transaction;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public DiscountType getDiscountType() {
		return discountType;
	}
	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public TransactionItem(Long id, String code, int status, Product product, Staff staff, Customer customer,
			DiscountType discountType, Double quantity, Transaction transaction) {
		super();
		this.id = id;
		this.code = code;
		this.status = status;
		this.product = product;
		this.staff = staff;
		this.customer = customer;
		this.discountType = discountType;
		this.quantity = quantity;
		this.transaction = transaction;
	}
	  
	  
	  
}
