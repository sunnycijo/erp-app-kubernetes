package org.erp.sales.customer.client;

import org.erp.sales.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-api", url = "${CUSTOMER_API_URI:http://localhost}:8081")
public interface CustomerClient {
	@GetMapping("/customer-api/info/v1/idfromphone/{phone}")
	public CustomerDto getCustomerIdFromPhone(@PathVariable(name = "phone") String phone);
}
