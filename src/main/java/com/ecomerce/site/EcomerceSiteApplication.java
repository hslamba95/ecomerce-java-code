package com.ecomerce.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ecomerce.site.*"})
public class EcomerceSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomerceSiteApplication.class, args);
	}

}
