package com.gmmr.springcore.scopes.service;

import java.util.concurrent.TimeUnit;

/**
 * Created by Giovanni on 18/08/2017.
 */
public class TestServiceImpl implements TestService {

    public TestServiceImpl(Integer delay) {
        doWork(delay);
    }

    @Override
    public void doWork(int waitingSeconds) {
        try {
            TimeUnit.SECONDS.sleep(waitingSeconds);
        } catch (InterruptedException e) {
            // don't care
        }
    }
}
