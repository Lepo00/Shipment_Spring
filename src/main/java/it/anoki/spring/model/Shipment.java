package it.anoki.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Entity
@Table(name="shipment")
//shipment
//(desc, shipment_date, id_customer, status(OPEN, CLOSED))
public class Shipment extends AuditModel{
	@Column(name = "description")
	private String description;
	
	@Column(name = "shipment_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date shipmentDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	private enum Status {OPEN,CLOSED}
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	Status status;
	
	@ManyToMany
	@JoinTable(name="shipment_details")
	private List<Pallet> pallets;
	
	public List<Pallet> getPallets() {
		return pallets;
	}
	public void setPallets(List<Pallet> pallets) {
		this.pallets = pallets;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDesc(String description) {
		this.description = description;
	}
	public Date getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Status getStatus() {
		return status;
	}
	public void openStatus() {
		this.status=Status.OPEN;
	}
	public void closeStatus() {
		this.status=Status.CLOSED;
	}
	public boolean isOpen() {
		if(this.status==Status.OPEN)
			return true;
		return false;
	}
	
}
