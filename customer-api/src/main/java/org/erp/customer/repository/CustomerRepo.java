package org.erp.customer.repository;

import org.erp.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{
	public Customer findByPhoneNumber(String phoneNumber);
}
