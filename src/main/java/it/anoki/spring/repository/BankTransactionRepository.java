package it.anoki.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.anoki.spring.model.BankTransaction;

@Repository("transactionRepository")
public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> {

}