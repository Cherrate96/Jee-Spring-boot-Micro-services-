package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.home.domail.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{

}
