package com.yourname.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.yourname.tests",
        plugin = {"pretty", "json:target/cucumber.json"},
        monochrome = true
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
