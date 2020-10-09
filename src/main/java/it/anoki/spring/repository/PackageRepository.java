package it.anoki.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.anoki.spring.model.Package;

@Repository("packageRepository")
public interface PackageRepository extends JpaRepository<Package, Long> {

}