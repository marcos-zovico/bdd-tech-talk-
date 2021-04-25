package com.msouza.cucumber.hooks;

import io.cucumber.java.BeforeStep;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @BeforeStep
    public void beforeStep() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(1000);
    }
}
