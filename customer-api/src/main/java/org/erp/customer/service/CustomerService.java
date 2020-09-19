package org.erp.customer.service;

import java.util.Optional;

import org.erp.customer.dto.CustomerDto;
import org.erp.customer.entity.Customer;
import org.erp.customer.repository.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	private Logger logger = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	private CustomerRepo customerRepo;
	
	public CustomerDto getCustomerByPhone(String phone) {
		CustomerDto customerDto = new CustomerDto();
		try {
			Customer customer = customerRepo.findByPhoneNumber(phone);
			if(!Optional.ofNullable(customer).isPresent())
				throw new Exception("No user with phone number ".concat(phone));
			logger.info("Found customer with Phone Number : {}, Customer Detail : {}", phone, customer.getFirstName().concat(" ").concat(customer.getLastName()));
			customerDto.setUserId(customer.getId());
			customerDto.setName(customer.getFirstName().concat(" ").concat(customer.getLastName()));
			customerDto.setPhone(customer.getPhoneNumber());
		} catch (Exception e) {
			logger.error("Error retreiving customer from phone Error : {}",e.getMessage());
		}
		return customerDto;
	}
}
