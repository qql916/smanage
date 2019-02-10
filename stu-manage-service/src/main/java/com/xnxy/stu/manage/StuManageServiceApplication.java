package com.xnxy.stu.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.xnxy.stu.manage.mapper")
public class StuManageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuManageServiceApplication.class, args);
	}

}

