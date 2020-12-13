package com.foodapp.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.foodapp.dao.FoodDeliveryDao;
import com.foodapp.foodapp.dto.CustomerDTO;
import com.foodapp.foodapp.entity.Cart;
import com.foodapp.foodapp.entity.Customer;

@Service
public class FoodDeliveryService {

	@Autowired
	FoodDeliveryDao foodDeliveryDao;
	
	public String register(CustomerDTO customerdto) {
		Customer customer = new Customer();
		customer.setFirstName(customerdto.getFirstName());
		customer.setLastName(customerdto.getLastName());
		customer.setEmail(customerdto.getEmail());
		customer.setMobileNumber(customerdto.getMobileNumber());
		customer.setAddress(customerdto.getAddress());
		
		Cart cart = new Cart();
		
		customer.setCart(cart);
		
		return foodDeliveryDao.customerRegistration(customer);
	}
	
}
