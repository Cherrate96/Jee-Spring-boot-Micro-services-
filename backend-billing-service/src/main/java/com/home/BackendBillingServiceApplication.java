package com.home;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import com.home.domain.Bill;
import com.home.domain.Customer;
import com.home.domain.Product;
import com.home.domain.ProductItem;
import com.home.repository.BillRepository;
import com.home.repository.CustomerService;
import com.home.repository.InventoryService;
import com.home.repository.ProductItemRepository;
import com.netflix.discovery.converters.Auto;

@SpringBootApplication
@EnableFeignClients
public class BackendBillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBillingServiceApplication.class, args);
	}
	  
	@Bean
	CommandLineRunner start(BillRepository billRepository,
			ProductItemRepository productItemRepository,
			CustomerService customerService,
			InventoryService inventoryService
			
			
			)
	{
		return args->{
			Customer c1=customerService.findCustomerById(1L);
			System.out.println("************");
			System.out.println("id="+c1.getId());
			System.out.println("Name:"+c1.getName());
			System.out.println("Email :"+c1.getEmail());
			System.out.println("************");

			Bill bill1=billRepository.save(new Bill(null, new Date(), c1.getId(), null,null));
			
			PagedModel<Product> products=inventoryService.findAllProducts();
			products.getContent().forEach(p->{
				productItemRepository.save(new ProductItem(null, p.getId(), null,p.getPrice(), 30,bill1));
				
			});
			
		

		};
	}

}
