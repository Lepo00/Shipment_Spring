package it.anoki.spring.service.impl;

import java.util.Date;
import java.util.Optional;

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
	public boolean addPallet(Long idPallet, Long idShipment) {
		Optional<Shipment> shipment = shipmentRepository.findById(idShipment);
		Optional<Pallet> pallet= palletRepository.findById(idPallet);
		if(pallet.isPresent() && shipment.isPresent() && shipment.get().isOpen() && pallet.get().getMaxPackages()>0 && pallet.get().getPackages().size()<=pallet.get().getMaxPackages()) {
			shipment.get().getPallets().add(pallet.get());
			shipmentRepository.save(shipment.get());
			return true;
		}
		return false;
	}

	@Override
	public Shipment close(Long id) {
		Shipment shipment = null;
		if(shipmentRepository.findById(id).isPresent()) {
			shipment = shipmentRepository.findById(id).get();
			shipment.closeStatus();
			shipmentRepository.save(shipment);
		}
		return shipment;
	}

	@Override
	public Optional<Shipment> one(Long id) {
		return shipmentRepository.findById(id);
	}

	
}
