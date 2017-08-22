package com.gmmr.springcore.scopes.configuration;

import com.gmmr.springcore.scopes.service.TestService;
import com.gmmr.springcore.scopes.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

/**
 * Created by Giovanni on 18/08/2017.
 */
@Configuration
public class ScopeConfiguration {

    private Integer delay;

    public ScopeConfiguration(@Value("${scopes.beanBuildTime}") Integer delay) {
        this.delay = delay;
    }

    @Bean
    @Profile("singleton")
    public TestService singletonTestService() {
        return new TestServiceImpl(delay);
    }

    @Bean
    @Profile("prototype")
    @Scope("prototype")
    public TestService prototypeTestService() {
        return new TestServiceImpl(delay);
    }

}
