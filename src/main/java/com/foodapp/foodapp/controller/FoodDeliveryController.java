package com.foodapp.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapp.dto.CustomerDTO;
import com.foodapp.foodapp.dto.LoginDTO;
import com.foodapp.foodapp.service.FoodDeliveryService;
import com.foodapp.foodapp.utility.Response;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/fooddelivery")
public class FoodDeliveryController {

	@Autowired
	FoodDeliveryService foodDeliveryService;
	
	@RequestMapping(value = "/register")
	public ResponseEntity<Response> register(@RequestBody CustomerDTO customer){
		Response response = foodDeliveryService.register(customer);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login")
	public ResponseEntity<Response> login(@RequestBody LoginDTO loginUser){
		Response response = foodDeliveryService.loginUser(loginUser);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
}
