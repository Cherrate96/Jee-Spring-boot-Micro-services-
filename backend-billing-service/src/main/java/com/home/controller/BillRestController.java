package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.home.domain.Bill;
import com.home.repository.BillRepository;
import com.home.repository.CustomerService;
import com.home.repository.InventoryService;
import com.home.repository.ProductItemRepository;
@RestController
public class BillRestController {
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private ProductItemRepository productItemRepository;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/fullBill/{id}")
	public Bill getBill(@PathVariable(name = "id") Long id)
	{
		Bill bill=billRepository.findById(id).get();
		bill.setCustomer(customerService.findCustomerById(bill.getCustomerID()));
		bill.getProductItems().forEach(pi->{
			pi.setProduct(inventoryService.findProductById(pi.getProductID()));
			
		});
		return bill;
		
	}
	

}
