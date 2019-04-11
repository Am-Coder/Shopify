package com.example.herok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

@SpringBootApplication
public class HeroKApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroKApplication.class, args);
	}

}
