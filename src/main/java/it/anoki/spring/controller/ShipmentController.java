package it.anoki.spring.controller;

import java.util.Date;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.anoki.spring.model.Shipment;
import it.anoki.spring.service.ShipmentService;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {
	
	@Autowired
	ShipmentService shipmentService;
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Shipment> one(@PathVariable Long id) throws Exception {
		Optional<Shipment> s = shipmentService.one(id);
		if (s.isPresent()) {
			return ResponseEntity.ok(s.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> newShipment(
			@RequestParam String description,
			@RequestParam @DateTimeFormat(pattern="dd/MM/yyyy") Date shipmentDate,
			@RequestParam Long idCustomer
			) throws Exception {
		try {
			Shipment save = shipmentService.save(description, shipmentDate, idCustomer);
			return ResponseEntity.ok(save);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Shipment Not Saved!");
		}
	}
	
	@PostMapping("/{id}/pallet")
	public ResponseEntity<?> addPallet(
			@PathVariable Long id,
			@RequestParam Long idPallet
			) throws Exception {
		try {
			boolean save = shipmentService.addPallet(idPallet,id);
			return(save ? ResponseEntity.ok("Added") : ResponseEntity.badRequest().body("Pallet Not Added!"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Pallet Not Added!");
		}
	}
	
	@PutMapping("/{id}/close")
	public ResponseEntity<?> addPallet(@PathVariable Long id)throws Exception{
		try {
			Shipment close = shipmentService.close(id);
			return ResponseEntity.ok(close);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Can't close order!");
		}
	}
	
}
