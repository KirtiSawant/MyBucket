package com.mybucket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.mybucket.controller","com.mybucket.service"})
@EnableJdbcRepositories(basePackages="com.mybucket.repository")
public class MyBucketApplication {

	public static void main(String[] args){
		SpringApplication.run(MyBucketApplication.class,args);
	}

}
