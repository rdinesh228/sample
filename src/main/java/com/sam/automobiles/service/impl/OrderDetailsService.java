package com.sam.automobiles.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.automobiles.dao.IOrderDetailsDao;
import com.sam.automobiles.dto.OrderDetailsDTO;
import com.sam.automobiles.dto.ProductTypeDTO;
import com.sam.automobiles.dto.UserDTO;
import com.sam.automobiles.entity.OrderDetails;
import com.sam.automobiles.requestutil.UserOrderRequest;
import com.sam.automobiles.service.IOrderDetailsService;

@Service
public class OrderDetailsService implements IOrderDetailsService{

	@Autowired
	private IOrderDetailsDao orderDetailsDao;
	
	@Override
	@Transactional
	public List<OrderDetailsDTO> getUserOrders(String userId) {
		List<OrderDetails> orders = orderDetailsDao.findByUserId(Long.parseLong(userId));
		List<OrderDetailsDTO> ordersRes = transformToDTO(orders);
		return ordersRes;
	}

	@Override
	@Transactional
	public List<OrderDetailsDTO> getUserOrdersWithPrice(UserOrderRequest userOrderRequest) {
		List<OrderDetails> orders = orderDetailsDao.getUserWithPrice(Long.parseLong(userOrderRequest.getUserId()), userOrderRequest.getPrice());
		List<OrderDetailsDTO> ordersRes = transformToDTO(orders);
		return ordersRes;
	}
	
	@Override
	@Transactional
	public List<OrderDetailsDTO> getUserOrdersWithProduct(UserOrderRequest userOrderRequest) {
		List<OrderDetailsDTO> ordersRes = getUserOrders(userOrderRequest.getUserId());
		ordersRes = ordersRes.stream().filter(p->(userOrderRequest.getProduct().equals(p.getProductType().getName()))).collect(Collectors.toList());
		return ordersRes;
	}
	
	private List<OrderDetailsDTO> transformToDTO(List<OrderDetails> orderDetailsEntity){
		List<OrderDetailsDTO> ordersRes = new ArrayList<>();
		for(OrderDetails order : orderDetailsEntity) {
			OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
			orderDetailsDTO.setId(order.getId());
			orderDetailsDTO.setPrice(order.getPrice());
			orderDetailsDTO.setProductId(order.getProductId());
			ProductTypeDTO productType = new ProductTypeDTO();
			productType.setId(order.getProductType().getId());
			productType.setName(order.getProductType().getName());
			orderDetailsDTO.setProductType(productType);
			UserDTO user = new UserDTO();
			user.setEmail(order.getUser().getEmail());
			user.setFirstName(order.getUser().getFirstName());
			user.setId(order.getUser().getId());
			user.setLastName(order.getUser().getLastName());
			orderDetailsDTO.setUser(user);
			ordersRes.add(orderDetailsDTO);
		}
		return ordersRes;
	}


}