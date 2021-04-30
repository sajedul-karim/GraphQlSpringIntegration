package com.skarim.graphqlspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import javax.servlet.Filter;

@SpringBootApplication
public class GraphqlSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlSpringApplication.class, args);
	}

	@Bean
	public Filter OpenFilter() {
		return new OpenEntityManagerInViewFilter();
	}

}
