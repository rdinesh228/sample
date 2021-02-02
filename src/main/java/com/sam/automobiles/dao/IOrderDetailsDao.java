package com.sam.automobiles.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sam.automobiles.entity.OrderDetails;

public interface IOrderDetailsDao extends AbstractRepository<OrderDetails, Long>{

	List<OrderDetails> findByUserId(final Long userId);
	
	@Query(value = "select * from order_details where user_id=? and price >= ?", nativeQuery = true)
	List<OrderDetails> getUserWithPrice(final Long userId, final BigDecimal price);
	
}