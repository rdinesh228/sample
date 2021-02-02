package com.sam.automobiles.service;

import java.util.List;

import com.sam.automobiles.dto.OrderDetailsDTO;
import com.sam.automobiles.requestutil.UserOrderRequest;

public interface IOrderDetailsService {
	
	public List<OrderDetailsDTO> getUserOrders(final String userId);
	
	public List<OrderDetailsDTO> getUserOrdersWithPrice(final UserOrderRequest userOrderRequest);
	
	public List<OrderDetailsDTO> getUserOrdersWithProduct(final UserOrderRequest userOrderRequest);

}