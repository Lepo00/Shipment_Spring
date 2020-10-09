package it.anoki.spring.service;

import java.util.Optional;

import it.anoki.spring.model.Customer;
public interface CustomerService {

	public Optional<Customer> one(Long id) throws Exception;

	public Customer save(Customer c) throws Exception;
	
	public void delete(Long id) throws Exception;
	
	public Customer update(Long id, String address, String email) throws Exception;

}