package com.sam.automobiles.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.automobiles.entity.AbstractEntity;

public interface AbstractRepository<T extends AbstractEntity<ID>,ID extends Serializable> extends JpaRepository<T, ID> {

}