package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.home.domain.ProductItem;

import lombok.NoArgsConstructor;


@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long>{

}
