package org.erp.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableEurekaClient
@EnableFeignClients("org.erp.sales.customer.client")
@SpringBootApplication
public class SalesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApiApplication.class, args);
	}

}
