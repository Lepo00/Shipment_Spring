package it.anoki.spring.service;

import java.util.Optional;

import it.anoki.spring.model.Pallet;
import it.anoki.spring.model.Package;

public interface PalletService {

	public Optional<Pallet> one(Long id) throws Exception;

	public Pallet save(Pallet t) throws Exception;

	public boolean addPackage(Long idPackage, Long id);
}