package org.erp.sales.store.controller;

import org.erp.sales.dto.MessageDto;
import org.erp.sales.store.SellingItem;
import org.erp.sales.store.service.StoreService;
import org.erp.sales.util.InstanceInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/v1")
public class StoreController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StoreService storeService;
	
	@Autowired
	private InstanceInformationService instanceInformationService;

	@PostMapping("/sell")
	public MessageDto sellItem(@RequestBody SellingItem sellingItem) {
		logger.info("Selling Product With Id : {} to Customer With Phone : {}",sellingItem.getProductId(), sellingItem.getCustomerPhoneNumber());
		String message = storeService.sellItem(sellingItem);
		MessageDto messageDto = new MessageDto();
		messageDto.setMessage(message);
		messageDto.setEnvLog(instanceInformationService.retrieveInstanceInfo());
		return messageDto;
	}
}
