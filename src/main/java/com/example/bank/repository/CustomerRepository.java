package com.example.bank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bank.model.Customer;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Long>
{
	public List<Customer> findByEmail(String email);

}
