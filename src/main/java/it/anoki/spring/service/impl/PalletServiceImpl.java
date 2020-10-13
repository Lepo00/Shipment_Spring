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
	public Pallet save(Pallet p) throws Exception {
		if(p.getMaxPackages()<=0 || p.getPackages().size()>p.getMaxPackages())
			return null;
		return palletRepository.save(p);
	}

	@Override
	public boolean addPackage(Long idPackage, Long idPallet) {
		Optional<Pallet> pallet = palletRepository.findById(idPallet);
		Optional<Package> pack = packageRepository.findById(idPackage);
		
		if(!pallet.isPresent() || !pack.isPresent() || pallet.get().getPackages().size()>=pallet.get().getMaxPackages())
			return false;
		
		pallet.get().getPackages().add(pack.get());
		palletRepository.save(pallet.get());
		return true;
	}
	
	

}
