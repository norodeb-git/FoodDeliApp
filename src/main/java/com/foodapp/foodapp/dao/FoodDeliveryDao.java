package com.foodapp.foodapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapp.entity.Customer;
import com.foodapp.foodapp.entity.UserCredential;
import com.foodapp.foodapp.repository.CustomerRepo;
import com.foodapp.foodapp.repository.UserLoginRepo;

@Repository
public class FoodDeliveryDao {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	UserLoginRepo loginRepo;

	public Customer customerRegistration(Customer customer) {
		Customer customerResponse = null;
		try {
			if(customer != null)
				customerResponse = customerRepo.save(customer);
		} catch (Exception e) {
			System.out.println("Exception in FoodDeliveryDao->customerRegistration");
		}
		return customerResponse;
	}

	public UserCredential login(String userName) {
		UserCredential validUserName = null;
		try {
			if (userName != null)
				validUserName = loginRepo.findUserByUserName(userName);
		} catch (Exception e) {
			System.out.println("Exception in FoodDeliveryDao->login");
			System.out.println("Error "+e.getMessage());
		}
		return validUserName;
	}

}
