package it.anoki.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "pallet")
public class Pallet extends AuditModel {

	@Column(name = "description")
	private String description;
	
	@Column(name="max_packages")
	private int maxPackages;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pallet_id")
	private List<Package> packages;
	
	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public int getMaxPackages() {
		return maxPackages;
	}

	public void setMaxPackages(int maxPackages) {
		this.maxPackages = maxPackages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
