package io.project.exchangeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchangeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeProjectApplication.class, args);
    }

}
