package com;

import com.backend.dao.Database;
import com.service.MoviesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleMoviesDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleMoviesDbApplication.class, args);
	}
}
