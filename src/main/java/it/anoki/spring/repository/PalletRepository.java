package it.anoki.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.anoki.spring.model.Pallet;

@Repository("palletRepository")
public interface PalletRepository extends JpaRepository<Pallet, Long> {

}