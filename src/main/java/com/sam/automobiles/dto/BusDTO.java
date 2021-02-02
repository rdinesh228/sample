package com.sam.automobiles.dto;

import java.io.Serializable;

public class BusDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Integer noOfAxels;
	
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}