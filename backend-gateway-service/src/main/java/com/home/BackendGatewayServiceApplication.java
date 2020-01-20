package com.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.commons.httpclient.OkHttpClientFactory.DisableValidationTrustManager;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableHystrix

public class BackendGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendGatewayServiceApplication.class, args);
	}
	@Bean
	RouteLocator staticRoutes(RouteLocatorBuilder builder)
	{
		return builder.routes()
				.route(r->r.
						path("/publicCountries/**")
						.filters(f->f.addRequestHeader("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
									.addRequestHeader("x-rapidapi-key", "484631da85msh651a2e6217c32b6p1d756ejsn37ae9e0e3c1a")
									.rewritePath("/publicCountries/(?<segment>.*)", "/${segment}")
									.hystrix(h->h.setName("countries").setFallbackUri("forward:/defaultCountries"))
								)
						
						.uri("https://restcountries-v1.p.rapidapi.com").id("r1"))
				
				.route(r->r.
						path("/muslim/**")
						.filters(f->f.addRequestHeader("x-rapidapi-host", "muslimsalat.p.rapidapi.com")
									.addRequestHeader("x-rapidapi-key", "484631da85msh651a2e6217c32b6p1d756ejsn37ae9e0e3c1a")
									.rewritePath("/muslim/(?<segment>.*)", "/${segment}")
									.hystrix(h->h.setName("muslimsalat").setFallbackUri("forward:/defaultSalat"))

								)
						
						.uri("https://muslimsalat.p.rapidapi.com").id("r2"))		
				.build();
	}
	
	
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,DiscoveryLocatorProperties dlp)
	{
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}

}
