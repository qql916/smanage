package com.xnxy.stu.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.xnxy.stu.user.mapper")
public class StuUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuUserServiceApplication.class, args);
	}

}

