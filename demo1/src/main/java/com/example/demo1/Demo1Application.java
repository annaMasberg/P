package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Demo1Application implements WebMvcConfigurer{

  /*@Autowired
	private JdbcTemplate jbdcTemplate;
	*/
	
	public void addViewController(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
