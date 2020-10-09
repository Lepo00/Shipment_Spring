package it.anoki.spring.service;

import java.util.Date;

import it.anoki.spring.model.Pallet;
import it.anoki.spring.model.Shipment;

public interface ShipmentService {

	public Shipment save(String description, Date shipmentDate, Long idCustomer);
	
	public Pallet addPallet(Pallet p, Long id);

	public Shipment close(Long id);
	
}
