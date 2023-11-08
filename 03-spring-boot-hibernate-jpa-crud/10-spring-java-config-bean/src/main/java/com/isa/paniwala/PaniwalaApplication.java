package com.isa.paniwala;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(
//        scanBasePackages = {"com.isa.paniwala",
//                           "com.isa,paniwala2"}
//        )
@SpringBootApplication
public class PaniwalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaniwalaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRUnner(String[] arg) {
	    return runner -> {
	        System.out.println("Hello World!");
	    };
	} 
}
