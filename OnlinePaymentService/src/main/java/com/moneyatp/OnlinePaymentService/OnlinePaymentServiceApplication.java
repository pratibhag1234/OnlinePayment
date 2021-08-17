package com.moneyatp.OnlinePaymentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OnlinePaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinePaymentServiceApplication.class, args);
	}

}
