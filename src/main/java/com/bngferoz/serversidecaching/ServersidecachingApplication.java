package com.bngferoz.serversidecaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ServersidecachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServersidecachingApplication.class, args);
	}

}
