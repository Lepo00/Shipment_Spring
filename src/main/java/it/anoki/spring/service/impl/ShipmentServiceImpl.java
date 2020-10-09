package it.anoki.spring.service.impl;

import java.util.Date;

import javax.net.ssl.SSLEngineResult.Status;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.anoki.spring.model.Pallet;
import it.anoki.spring.model.Shipment;
import it.anoki.spring.repository.CustomerRepository;
import it.anoki.spring.repository.PalletRepository;
import it.anoki.spring.repository.ShipmentRepository;
import it.anoki.spring.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService{

	@Autowired
	ShipmentRepository shipmentRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	PalletRepository palletRepository;

	@Override
	@Transactional
	public Shipment save(String description, Date shipmentDate, Long idCustomer) {
		Shipment s= new Shipment();
		s.setDesc(description);
		s.setShipmentDate(shipmentDate);
		s.openStatus();
		s.setCustomer(customerRepository.findById(idCustomer).get());
		return shipmentRepository.save(s);
	}

	@Override
	public Pallet addPallet(Pallet p, Long id) {
		if(shipmentRepository.findById(id).isPresent() && p!=null) {
			shipmentRepository.findById(id).get().getPallet().add(p);
		}
		return palletRepository.save(p);
	}

	
}
