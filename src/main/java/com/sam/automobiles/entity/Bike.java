package com.sam.automobiles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bike")
public class Bike extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String sideCar;
	
	@Column
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSideCar() {
		return sideCar;
	}

	public void setSideCar(String sideCar) {
		this.sideCar = sideCar;
	}
	
}