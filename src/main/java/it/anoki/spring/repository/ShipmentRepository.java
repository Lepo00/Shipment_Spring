package it.anoki.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.anoki.spring.model.Shipment;

@Repository("shipmentRepository")
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

}