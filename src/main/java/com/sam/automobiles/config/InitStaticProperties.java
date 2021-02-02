package com.sam.automobiles.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sam.automobiles.util.ResourceConfig;



@Configuration
@PropertySource(value="classpath:application.properties")
public class InitStaticProperties {
	
	@Value("${sample.url}") 
	private void setOYOBaseURL(String sampleURL){
		ResourceConfig.SAMPLE_URL = sampleURL;
	}
	
	@Value("${sample.base.url}") 
	private void setCIARBaseURL(String sampleBaseURL){
		ResourceConfig.SAMPLE_URL = sampleBaseURL;
	}
	
	
}