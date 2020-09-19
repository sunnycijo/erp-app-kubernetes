package org.erp.customer.info.controller;

import javax.websocket.server.PathParam;

import org.erp.customer.dto.CustomerDto;
import org.erp.customer.service.CustomerService;
import org.erp.customer.util.InstanceInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info/v1")
public class CustomerInfoController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private InstanceInformationService instanceInformationService;
	
	@GetMapping("/idfromphone/{phone}")
	public CustomerDto getCustomerIdFromPhoneNumber(@PathVariable(name = "phone") String phone) {
		logger.info("Getting Customer Details From Phone Number : {}", phone);
		CustomerDto customerDto = customerService.getCustomerByPhone(phone);
		customerDto.setEnvLog(instanceInformationService.retrieveInstanceInfo());
		return customerDto;
	}
}
