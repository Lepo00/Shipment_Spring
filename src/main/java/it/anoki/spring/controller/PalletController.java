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

import it.anoki.spring.model.Pallet;
import it.anoki.spring.service.PalletService;

@RestController
class PalletController {

	@Autowired
	private PalletService palletService;

	@GetMapping("/pallet/{id}")
	ResponseEntity<Pallet> one(@PathVariable Long id) throws Exception {
		Optional<Pallet> t = palletService.one(id);
		if (t.isPresent()) {
			return ResponseEntity.ok(t.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/pallet")
	ResponseEntity<?> newPallet(@RequestBody Pallet t) throws Exception {
		try {
			Pallet save = palletService.save(t);
			return ResponseEntity.ok(save);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Pallet Not Saved!");
		}
	}

}
