package it.anoki.spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.anoki.spring.model.BankTransaction;
import it.anoki.spring.repository.BankTransactionRepository;
import it.anoki.spring.service.BankTransactionService;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

	@Autowired
	BankTransactionRepository transactionRepository;
	
	@Override
	public Optional<BankTransaction> one(Long id) throws Exception {
		return transactionRepository.findById(id);
	}

	@Override
	public BankTransaction save(BankTransaction t) throws Exception {
		return transactionRepository.save(t);
	}

}
