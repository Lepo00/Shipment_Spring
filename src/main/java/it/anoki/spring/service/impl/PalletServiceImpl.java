package it.anoki.spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.anoki.spring.model.Pallet;
import it.anoki.spring.model.Package;
import it.anoki.spring.repository.PackageRepository;
import it.anoki.spring.repository.PalletRepository;
import it.anoki.spring.service.PalletService;

@Service
public class PalletServiceImpl implements PalletService {

	@Autowired
	PalletRepository palletRepository;
	@Autowired
	PackageRepository packageRepository;

	@Override
	public Optional<Pallet> one(Long id) throws Exception {
		return palletRepository.findById(id);
	}

	@Override
	public Pallet save(Pallet t) throws Exception {
		return palletRepository.save(t);
	}

	@Override
	public boolean addPackage(Package p, Long id) {
		if(!palletRepository.findById(id).isPresent())
			return false;
		Pallet pallet= palletRepository.findById(id).get();
		if(pallet.getPackages().size()>=pallet.getMaxPackages())
			return false;
		palletRepository.findById(id).get().getPackages().add(p);
		packageRepository.save(p);
		return true;
	}
	
	

}
