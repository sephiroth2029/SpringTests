package com.gmmr.springcore.scopes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {"com.gmmr.springcore"})
@EnableWebMvc
public class ScopesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScopesApplication.class, args);
    }
}
