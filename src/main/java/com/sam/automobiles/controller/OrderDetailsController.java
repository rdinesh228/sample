package com.sam.automobiles.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sam.automobiles.dto.OrderDetailsDTO;
import com.sam.automobiles.requestutil.UserOrderRequest;
import com.sam.automobiles.responseutil.Response;
import com.sam.automobiles.service.IOrderDetailsService;

@RestController
@RequestMapping(value = "/orderdetails")
public class OrderDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);
	
	@Autowired
	private IOrderDetailsService orderDetailsService;

	@RequestMapping(value = "/userorders", method = RequestMethod.POST)
	public Response<List<OrderDetailsDTO>> userOrders(@RequestParam String userId) {
		logger.debug("Inside test1");
		Response<List<OrderDetailsDTO>> res = null;
		try {
			List<OrderDetailsDTO> orders = orderDetailsService.getUserOrders(userId);
			res = Response.success(orders);
		}
		catch(Exception e) {
			logger.debug("Error userOders:", e);
			res = Response.failure("ERR01", "Technical Error");
		}
		return res;
	}
	
	@RequestMapping(value = "/userOrdersWithPrice", method = RequestMethod.POST)
	public Response<List<OrderDetailsDTO>> userOrdersWithPrice(@RequestBody UserOrderRequest userOrderRequest) {
		logger.debug("Inside test1");
		Response<List<OrderDetailsDTO>> res = null;
		try {
			List<OrderDetailsDTO> orders = orderDetailsService.getUserOrdersWithPrice(userOrderRequest);
			res = Response.success(orders);
		}
		catch(Exception e) {
			logger.debug("Error userOrdersWithPrice:", e);
			res = Response.failure("ERR02", "Technical Error");
		}
		return res;
	}
	
	@RequestMapping(value = "/userOrdersWithProduct", method = RequestMethod.POST)
	public Response<List<OrderDetailsDTO>> userOrdersWithProduct(@RequestBody UserOrderRequest userOrderRequest) {
		logger.debug("Inside test1");
		Response<List<OrderDetailsDTO>> res = null;
		try {
			List<OrderDetailsDTO> orders = orderDetailsService.getUserOrdersWithProduct(userOrderRequest);
			res = Response.success(orders);
		}
		catch(Exception e) {
			logger.debug("Error userOrdersWithPrice:", e);
			res = Response.failure("ERR02", "Technical Error");
		}
		return res;
	}
	
	
}