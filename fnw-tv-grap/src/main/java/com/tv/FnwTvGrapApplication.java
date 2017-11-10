package com.tv;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tv.dao")
public class FnwTvGrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(FnwTvGrapApplication.class, args);
	}
}
