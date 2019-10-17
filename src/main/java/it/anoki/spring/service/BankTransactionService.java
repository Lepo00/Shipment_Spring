package it.anoki.spring.service;

import java.util.Optional;

import it.anoki.spring.model.BankTransaction;

public interface BankTransactionService {

	public Optional<BankTransaction> one(Long id) throws Exception;

	public BankTransaction save(BankTransaction t) throws Exception;

}