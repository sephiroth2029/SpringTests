package com.gmmr.springcore.scopes.controller;

import com.gmmr.springcore.scopes.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Giovanni on 18/08/2017.
 */
@RestController
public class TestController {

    private ApplicationContext appContext;

    @Autowired
    public TestController(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @PostMapping("/worker/start")
    public void startWork(@RequestParam(name = "time") Integer time) {
        TestService testService = appContext.getBean(TestService.class);
        testService.doWork(time);
    }

}
