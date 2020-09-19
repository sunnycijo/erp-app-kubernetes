package org.erp.sales.store.service;

import java.util.Optional;

import org.erp.sales.customer.client.CustomerClient;
import org.erp.sales.dto.CustomerDto;
import org.erp.sales.store.SellingItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	private Logger logger = LoggerFactory.getLogger(StoreService.class);
	@Autowired
	private CustomerClient customerClient;
	public String sellItem(SellingItem sellingItem) {
		CustomerDto customerDto = customerClient.getCustomerIdFromPhone(sellingItem.getCustomerPhoneNumber());
		if(Optional.ofNullable(customerDto).isPresent() && Optional.ofNullable(customerDto.getName()).isPresent()) {
			logger.info("Sold product with id {} to Customer named {}",sellingItem.getProductId(), customerDto.getName());
			return "Sold product with id ".concat(sellingItem.getProductId()).concat("to Customer named ").concat(customerDto.getName());
		} else {
			logger.info("Unable to sell product with id {} to Customer with phone {} as CUSTOMER DOES NOT EXIST IN SYSTEM",sellingItem.getProductId(), sellingItem.getCustomerPhoneNumber());
			return "Unable to sell product with id ".concat(sellingItem.getProductId()).concat(", Error : CUSTOMER DOES NOT EXIST IN SYSTEM");
		}
	}
}
