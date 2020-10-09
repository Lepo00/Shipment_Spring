package it.anoki.spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.anoki.spring.model.Customer;
import it.anoki.spring.repository.CustomerRepository;
import it.anoki.spring.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Optional<Customer> one(Long id) throws Exception {
		return customerRepository.findById(id);
	}

	@Override
	public Customer save(Customer c) throws Exception {
		return customerRepository.save(c);
	}

	@Override
	public void delete(Long id) throws Exception {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer update(Long id, String address, String email) throws Exception {
		if(this.one(id).isPresent()){
			Customer c= this.one(id).get();
			if(address != null)
				c.setAddress(address);
			if(email != null)
				c.setEmail(email);
			return customerRepository.save(c);
		}
		else
			return null;
	}

	
}
