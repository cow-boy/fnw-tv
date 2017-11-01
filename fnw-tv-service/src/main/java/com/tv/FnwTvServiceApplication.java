package com.tv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tv.dao")
public class FnwTvServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FnwTvServiceApplication.class, args);
	}
}
