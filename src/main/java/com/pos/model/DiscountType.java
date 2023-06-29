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
@Table(name = "discount")
public class DiscountType {
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
	  @Column(name = "discount")
	  private Double discount;
	  @Column(name = "description")
	  private String description;
}
