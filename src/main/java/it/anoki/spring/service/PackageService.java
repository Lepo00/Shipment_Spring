package it.anoki.spring.service;

import java.util.Optional;

import it.anoki.spring.model.Package;

public interface PackageService {

	public Optional<Package> one(Long id) throws Exception;

	public Package save(Package p) throws Exception;
}