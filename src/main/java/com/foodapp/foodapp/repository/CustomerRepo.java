package com.foodapp.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapp.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
