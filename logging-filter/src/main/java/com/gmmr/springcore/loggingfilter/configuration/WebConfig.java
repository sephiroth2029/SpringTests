package com.gmmr.springcore.loggingfilter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Giovanni on 08/08/2017.
 */
@Configuration
public class WebConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate;
    }

}
