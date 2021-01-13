package com.foodapp.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.foodapp.foodapp.dao.FoodDeliveryDao;
import com.foodapp.foodapp.dto.CustomerDTO;
import com.foodapp.foodapp.dto.LoginDTO;
import com.foodapp.foodapp.entity.Cart;
import com.foodapp.foodapp.entity.Customer;
import com.foodapp.foodapp.entity.UserCredential;
import com.foodapp.foodapp.utility.Response;
import com.foodapp.foodapp.utility.StatusResponse;

@Service
public class FoodDeliveryService {

	@Autowired
	FoodDeliveryDao foodDeliveryDao;

	public Response register(CustomerDTO customerdto) {
		Response response = new Response();
		Customer customer = new Customer();
		Customer customerResponse = null;
		Cart cart = new Cart();
		UserCredential userCredential = new UserCredential();
		customer.setFirstName(customerdto.getFirstName());
		customer.setLastName(customerdto.getLastName());
		customer.setEmail(customerdto.getEmail());
		customer.setMobileNumber(customerdto.getMobileNumber());
		customer.setAddress(customerdto.getAddress());
		customer.setCart(cart);

		userCredential.setUserName(customerdto.getUserName());
		userCredential.setPassword(customerdto.getPassword());

		customer.setUserCredential(userCredential);

		customerResponse = foodDeliveryDao.customerRegistration(customer);
		
		if (customerResponse != null) {
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Customer Registered successfully");
			response.setStatusResponse(StatusResponse.SUCCESS);
		} else {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Invalid");
			response.setStatusResponse(StatusResponse.Failure);
		}
		return response;
	}

	public Response loginUser(LoginDTO loginUser) {
		Response response = new Response();
		UserCredential user = null;
		UserCredential userCredential = new UserCredential();
		userCredential.setUserName(loginUser.getUserName());
		userCredential.setPassword(loginUser.getPassword());

		user = foodDeliveryDao.login(userCredential.getUserName());
		if (user != null && (user.getPassword().equals(userCredential.getPassword()))) {
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Login validated successfully");
			response.setStatusResponse(StatusResponse.SUCCESS);
		} else {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Invalid Credentials");
			response.setStatusResponse(StatusResponse.Failure);
		}
		return response;
	}

}
