package com.sam.automobiles.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tg.hotel.interceptor.HotelAPIInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(handler());
//		super.addInterceptors(registry);
//	}

	@Bean
	public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}


	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(messageConverter());
		addDefaultHttpMessageConverters(converters);
	}

	@Bean
	public MappingJackson2HttpMessageConverter messageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
		supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
		supportedMediaTypes.add(MediaType.TEXT_PLAIN);
		converter.setSupportedMediaTypes(supportedMediaTypes);
		converter.setObjectMapper(objectMapper());
		return converter;
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper;
	}

	@Bean
	public MethodInvokingFactoryBean methodInvokingFactoryBean() {
		MethodInvokingFactoryBean factoryBean = new MethodInvokingFactoryBean();
		factoryBean.setTargetObject(objectMapper());
		factoryBean.setTargetMethod("configure");
		factoryBean.setArguments(new Object[] { DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false });
		return factoryBean;
	}

	 @Bean
	public ContentNegotiationManagerFactoryBean contentNegotiationManager() {
		ContentNegotiationManagerFactoryBean factoryBean = new ContentNegotiationManagerFactoryBean();
		factoryBean.setFavorPathExtension(true);
		factoryBean.setFavorParameter(true);
		factoryBean.setParameterName("format");
		factoryBean.setIgnoreAcceptHeader(true);
		factoryBean.setDefaultContentType(MediaType.APPLICATION_JSON);
		Properties mediaTypes = new Properties();
		mediaTypes.put("json", MediaType.APPLICATION_JSON_VALUE);
		mediaTypes.put("xml", MediaType.APPLICATION_XML_VALUE);
		factoryBean.setMediaTypes(mediaTypes);
		return factoryBean;
	} 

	/*@Bean
	public EhCacheManagerFactoryBean ehCManagerFactoryBean() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}*/

	/*@Bean
	public EhCacheCacheManager ehCacheCacheManager() {
		EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager(ehCManagerFactoryBean().getObject());
		return ehCacheCacheManager;

	}

	@Bean
	public CacheManager cacheManager() {
		return ehCacheCacheManager().getCacheManager();
	}*/

}