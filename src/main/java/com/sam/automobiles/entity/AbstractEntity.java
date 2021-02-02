package com.sam.automobiles.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Persistable<ID>  {
	
	/** System generated Serial Version UID. */
	private static final long serialVersionUID = -5554308939380869754L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(columnDefinition="BIGINT UNSIGNED", nullable = false, updatable = false, name= "id")
	protected ID id;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.data.domain.Persistable#getId()
	 */
	public ID getId() {

		return id;
	}

	@Override
	public boolean isNew() {
		return null == getId();
	}

}