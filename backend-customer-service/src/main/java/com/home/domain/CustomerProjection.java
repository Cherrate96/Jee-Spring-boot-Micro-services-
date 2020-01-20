package com.home.domain;

import org.springframework.data.rest.core.config.Projection;
//personnaliser les données
@Projection(name = "p1",types = Customer.class)
public interface CustomerProjection {
	public Long getId();
	public String getName();

}
