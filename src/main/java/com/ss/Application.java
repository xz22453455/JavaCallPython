package com.ss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.ss.dao")
public class Application {
	@RequestMapping("/")
	@ResponseBody
	String greeting() {
		return "hello";
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
