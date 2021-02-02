package com.sam.automobiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@ComponentScan("com.sam.automobiles")
@EnableScheduling
@EnableWebMvc
@EnableAutoConfiguration(exclude={RedisAutoConfiguration.class})
@EnableJpaRepositories(basePackages="com.sam.automobiles.dao")
@PropertySource({"classpath:application.properties"})
public class BootWebappApplication {//extends WebMvcConfigurerAdapter {

	
	public static void main(String[] args) {
		SpringApplication.run(BootWebappApplication.class, args);
	}

	
}