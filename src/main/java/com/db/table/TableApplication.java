package com.db.table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TableApplication extends ServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TableApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TableApplication.class, args);
	}

}
