package org.ncu.ecommerce_app.service;

import org.ncu.ecommerce_app.dao.CustomerDao;
import org.ncu.ecommerce_app.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	public String insertCustomerRecord(Customer customer) {
		customerDao.saveCustomer(customer);
		return "customer saved!";
	}
	
	// create methods for find customer by id, update customer & delete customer
}
