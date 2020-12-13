package com.foodapp.foodapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapp.entity.Customer;
import com.foodapp.foodapp.repository.CustomerRepo;

@Repository
public class FoodDeliveryDao {

	@Autowired
	CustomerRepo customerRepo;
	
	public String customerRegistration(Customer customer) {
		try {
			customerRepo.save(customer);
		}
		catch(Exception e) {
			System.out.println("Exception in FoodDeliveryDao->customerRegistration");
		}
		return "Customer Saved";
	}
	
}
