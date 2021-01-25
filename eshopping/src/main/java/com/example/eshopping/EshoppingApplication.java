package com.example.eshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.example.eshopping.util.FileStorageProperties;



@SpringBootApplication
@ComponentScan({"com.example.*"})
@EntityScan({"com.example.*"})
@EnableAutoConfiguration
@EnableConfigurationProperties({
    FileStorageProperties.class
})
//@EnableMongoRepositories({"com.example.*"})
public class EshoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshoppingApplication.class, args);
	}

}
