package it.anoki.spring.service;

import it.anoki.spring.model.BankTransaction;

public interface BankTransactionService {

	public BankTransaction one(Long id) throws Exception;

}