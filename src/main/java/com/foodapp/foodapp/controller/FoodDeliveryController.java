package com.foodapp.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapp.dto.CustomerDTO;
import com.foodapp.foodapp.service.FoodDeliveryService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/fooddelivery")
public class FoodDeliveryController {

	@Autowired
	FoodDeliveryService foodDeliveryService;
	
	@RequestMapping(value = "/register")
	public ResponseEntity<String> register(@RequestBody CustomerDTO customer){
		String msg = foodDeliveryService.register(customer);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}
