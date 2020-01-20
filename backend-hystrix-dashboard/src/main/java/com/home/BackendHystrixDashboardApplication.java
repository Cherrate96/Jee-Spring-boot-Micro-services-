package com.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class BackendHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendHystrixDashboardApplication.class, args);
	}

}
