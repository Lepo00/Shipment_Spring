package it.anoki.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.anoki.spring.model.BankTransaction;
import it.anoki.spring.service.BankTransactionService;

@RestController
class BankTransactionController {

	@Autowired
	private BankTransactionService bankTransactionService;

	@GetMapping("/transaction/{id}")
	ResponseEntity<BankTransaction> one(@PathVariable Long id) throws Exception {
		Optional<BankTransaction> t = bankTransactionService.one(id);
		if (t.isPresent()) {
			return ResponseEntity.ok(t.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/transaction")
	ResponseEntity<?> newBankTransaction(@RequestBody BankTransaction t) throws Exception {
		try {
			BankTransaction save = bankTransactionService.save(t);
			return ResponseEntity.ok(save);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Guest NOT Saved!");
		}
	}

}
