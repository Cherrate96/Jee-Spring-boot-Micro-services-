package com.home.domain;

import lombok.Data;

@Data
public class Product {
	private Long id;
	private String name;
	private double price;
	public Product(Long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
