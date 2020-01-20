package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.home.domain.Bill;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long>{

}
