package com.home.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class ProductItem {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private Long productID;
	@Transient
	private Product product;
	private double price;
	private double quantity;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Bill bill;
	public ProductItem(Long id, Long productID,  Product product,double price, double quantity, Bill bill) {
		super();
		this.id = id;
		this.productID = productID;
		this.product=product;
		this.price = price;
		this.quantity = quantity;
		this.bill = bill;
	}

	
}
