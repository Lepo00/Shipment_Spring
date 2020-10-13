package it.anoki.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.anoki.spring.model.Package;
import it.anoki.spring.service.PackageService;

@RestController
@RequestMapping("/package")
class PackageController {

	@Autowired
	private PackageService packageService;

	@GetMapping("/detail/{id}")
	public ResponseEntity<Package> one(@PathVariable Long id) throws Exception {
		Optional<Package> p = packageService.one(id);
		if (p.isPresent()) {
			return ResponseEntity.ok(p.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> newPackage(@RequestBody Package p) throws Exception {
		try {
			Package save = packageService.save(p);
			if(save!=null)
				return ResponseEntity.ok(save);
			else
				return ResponseEntity.badRequest().body("Package Not Saved!");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Package Not Saved!");
		}
	}
}
