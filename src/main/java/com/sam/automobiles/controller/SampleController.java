package com.sam.automobiles.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sam.automobiles.responseutil.Response;
import com.sam.automobiles.util.ResourceConfig;


@RestController
@RequestMapping(value = "/sample")
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public Response<String> test1() {
		logger.debug("Inside test1 ----> " + ResourceConfig.SAMPLE_URL);
		return Response.success("Success");
	}
	
}