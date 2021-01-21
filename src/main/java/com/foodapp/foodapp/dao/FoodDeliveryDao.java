package com.foodapp.foodapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapp.entity.Customer;
import com.foodapp.foodapp.entity.Restaurant;
import com.foodapp.foodapp.entity.UserCredential;
import com.foodapp.foodapp.repository.CustomerRepo;
import com.foodapp.foodapp.repository.RestaurantRepo;
import com.foodapp.foodapp.repository.UserLoginRepo;

@Repository
public class FoodDeliveryDao {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	UserLoginRepo loginRepo;
	
	@Autowired
	RestaurantRepo restaurantRepo;

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

	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> restuarants = null;
		try {
			restuarants = restaurantRepo.findAllRestaurant();
		}catch (Exception e) {
			System.out.println("error"+e.getLocalizedMessage());
		}
		
		return restuarants;
	}

}
