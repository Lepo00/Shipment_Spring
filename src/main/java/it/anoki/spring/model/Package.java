package it.anoki.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "package")
public class Package extends AuditModel {
	@Column(name="description")
	private String description;
	
	@Column(name="weight")
	private double weight;

	public String getDescription() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
