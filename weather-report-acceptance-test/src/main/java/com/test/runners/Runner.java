package com.test.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", plugin = { "pretty", "html:target/cucumber-reports",
		"json:target/cucumber-reports/Cucumber.json" }, monochrome = true, glue = { "com.test.steps" }, tags = {"~@HOURLY_FORECAST"})

public class Runner {
}
