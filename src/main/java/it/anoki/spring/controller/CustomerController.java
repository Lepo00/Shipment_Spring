package it.anoki.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.anoki.spring.model.Customer;
import it.anoki.spring.service.CustomerService;
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Customer> one(@PathVariable Long id) throws Exception {
		System.out.println("CALL DETAIL");
		Optional<Customer> c = customerService.one(id);
		System.out.println("prova:"+c.toString());
		if (c.isPresent()) {
			return ResponseEntity.ok(c.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> newCustomer(@RequestBody Customer c) throws Exception {
		try {
			Customer save = customerService.save(c);
			return ResponseEntity.ok(save);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Customer Not Saved!");
		}
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable Long id,
			@RequestParam (required = false) String email,
			@RequestParam (required = false) String address) {
		try {
			Customer save = customerService.update(id, address, email);
			return ResponseEntity.ok(save);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Customer Not Updated!");
		}
	}
	
	@DeleteMapping(path="delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
		try {
			customerService.delete(id);
			return ResponseEntity.ok().body("deleted");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
