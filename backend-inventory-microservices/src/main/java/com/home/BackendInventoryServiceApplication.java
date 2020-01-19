package com.home;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.home.domail.Product;
import com.home.repository.ProductRepository;

@SpringBootApplication
public class BackendInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendInventoryServiceApplication.class, args);
	}
@Bean
CommandLineRunner start(ProductRepository productRepository,
						RepositoryRestConfiguration repositoryRestConfiguration
		)
{
	return args->{
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		productRepository.save(new Product(null,"Mouse",55.3));
		productRepository.save(new Product(null,"Pc",85.3));
		productRepository.save(new Product(null,"Imprimante",77.13));

		productRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});

	};
}
}
