package com.moneyatp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CustomerInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerInfoServiceApplication.class, args);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {

		return NoOpPasswordEncoder.getInstance();
	}


}
