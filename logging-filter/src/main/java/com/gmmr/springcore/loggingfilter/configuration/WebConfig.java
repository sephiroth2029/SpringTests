package com.gmmr.springcore.loggingfilter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Giovanni on 08/08/2017.
 *
 * The profiled configuration. If the active profile is "regular" there won't be logging; if
 * it's "logged" the request/response will be logged.
 */
@Configuration
public class WebConfig {

    public static final String PROFILE_REGULAR = "regular";

    public static final String PROFILE_LOGGED = "logged";

    @Bean
    @Profile(PROFILE_REGULAR)
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate;
    }

    @Bean
    @Profile(PROFILE_LOGGED)
    public RestTemplate loggedRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

        restTemplate.setInterceptors(Arrays.asList(new MyLogInterceptor()));

        return restTemplate;
    }

}
