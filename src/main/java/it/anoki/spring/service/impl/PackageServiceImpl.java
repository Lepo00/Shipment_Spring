package it.anoki.spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.anoki.spring.model.Package;
import it.anoki.spring.repository.PackageRepository;
import it.anoki.spring.service.PackageService;

@Service
public class PackageServiceImpl implements PackageService {
	
	@Autowired
	PackageRepository packageRepository;

	@Override
	public Optional<Package> one(Long id) throws Exception {
		return packageRepository.findById(id);
	}

	@Override
	public Package save(Package p) throws Exception {
		return packageRepository.save(p);
	}

	
}
