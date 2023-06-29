package com.pos.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "transaction")
public class Transaction {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id")
	  private Long id;
	  @Column(name="code")
	  private String code;
	  @Column(name="transaction_date")
	  private LocalDateTime transaction_date;
	  @Column(name = "status")
	  private int status;
	  @OneToMany(mappedBy = "transaction")
	  private List<TransactionItem>transactionItems;
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
	public LocalDateTime getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(LocalDateTime transaction_date) {
		this.transaction_date = transaction_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	  
	  
}
