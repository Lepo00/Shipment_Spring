package it.anoki.spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.anoki.spring.model.Pallet;
import it.anoki.spring.repository.PalletRepository;
import it.anoki.spring.service.PalletService;

@Service
public class PalletServiceImpl implements PalletService {

	@Autowired
	PalletRepository palletRepository;

	@Override
	public Optional<Pallet> one(Long id) throws Exception {
		return palletRepository.findById(id);
	}

	@Override
	public Pallet save(Pallet t) throws Exception {
		return palletRepository.save(t);
	}

	@Override
	public Pallet addPackage(Package p, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
