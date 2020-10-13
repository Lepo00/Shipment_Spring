package it.anoki.spring.service;

import java.util.Date;
import java.util.Optional;

import it.anoki.spring.model.Shipment;

public interface ShipmentService {

	public Shipment save(String description, Date shipmentDate, Long idCustomer);
	
	public boolean addPallet(Long idPallet, Long id);

	public Shipment close(Long id);

	public Optional<Shipment> one(Long id);
	
}
