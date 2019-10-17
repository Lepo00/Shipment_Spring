package it.anoki.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "bank_transaction")
public class BankTransaction extends AuditModel {

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "transaction_type")
	@Enumerated(EnumType.STRING)
	private TransactionTypeEnum transactionType;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	public enum StatusEnum {
		Completed, Pending, Declined;
	}

	public enum TransactionTypeEnum {
		CHARGE, REFUND;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public TransactionTypeEnum getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionTypeEnum transactionType) {
		this.transactionType = transactionType;
	}

}
