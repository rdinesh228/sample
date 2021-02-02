package com.sam.automobiles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private Integer noOfAxels;
	
	@Column
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNoOfAxels() {
		return noOfAxels;
	}

	public void setNoOfAxels(Integer noOfAxels) {
		this.noOfAxels = noOfAxels;
	}

}