package com.home.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity


public class Bill {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Date billingDate;
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private Long customerID;
@Transient
private Customer customer;
@OneToMany(mappedBy = "bill")
private Collection<ProductItem> productItems;
public Bill(Long id, Date billingDate, Long customerID, Customer customer,Collection<ProductItem> productItems) {
	super();
	this.id = id;
	this.billingDate = billingDate;
	this.customerID = customerID;
	this.customer=customer;
	this.productItems = productItems;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Date getBillingDate() {
	return billingDate;
}
public void setBillingDate(Date billingDate) {
	this.billingDate = billingDate;
}
public Long getCustomerID() {
	return customerID;
}
public void setCustomerID(Long customerID) {
	this.customerID = customerID;
}
public Collection<ProductItem> getProductItems() {
	return productItems;
}
public void setProductItems(Collection<ProductItem> productItems) {
	this.productItems = productItems;
}

public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Bill() {
	super();
	// TODO Auto-generated constructor stub
}

}
