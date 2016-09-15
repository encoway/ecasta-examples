package com.encoway.ecasta_example;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-results" }, features = { "com/encoway/cucumberseleniumexample" })
public class RunTest {

}
