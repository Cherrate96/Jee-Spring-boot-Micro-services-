package com.home;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.home.domain.Customer;
import com.home.repository.CustomerRepository;

@SpringBootApplication
public class BackendCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCustomerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,RepositoryRestConfiguration repositoryConfiguration)
	{
		return args->{
			//afficher l'id 
			repositoryConfiguration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null, "adam", "adam@gmail.com"));
			customerRepository.save(new Customer(null, "ch", "ch@gmail.com"));
			customerRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			});
			
		

		};
	}

}
