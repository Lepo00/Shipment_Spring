package it.anoki.spring.service;

import java.util.Optional;

import it.anoki.spring.model.Pallet;

public interface PalletService {

	public Optional<Pallet> one(Long id) throws Exception;

	public Pallet save(Pallet t) throws Exception;

}