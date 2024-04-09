package com.example.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.Customer;
import com.example.bank.repository.CustomerRepository;

@RestController
public class LoginController 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer)
	{
		ResponseEntity<String> response = null;
		
		try
		{
			Customer save = customerRepository.save(customer);
			
			if(save!=null)
			{
				response = ResponseEntity.status(HttpStatus.CREATED)
				.body("User successfully registered");
			}
		}
		catch (Exception ex)
		{
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Exception Occured : " +ex.getMessage());
		}
		
		return response;
	}

}
