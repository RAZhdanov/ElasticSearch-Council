package com.job.elastic.springelasticdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.job.elastic.springelasticdemo.controller.SearchController;
import com.job.elastic.springelasticdemo.controller.UploadController;
import com.job.elastic.springelasticdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan("com.job.elastic")
public class SpringElasticDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringElasticDemoApplication.class, args);
	}
}
