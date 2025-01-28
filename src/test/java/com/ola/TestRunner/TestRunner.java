package com.ola.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {"src/test/resources/Features"},      // Path to feature files
	    glue = {"com.ola.StepDefinitions", "Hooks"},              // Package for step definitions and hooks
	    		plugin = {
	    		        "pretty",
	    		        "html:target/cucumber-html-report",
	    		        "json:target/cucumber.json",
	    		        "rerun:target/rerun.txt",
	    		        "com.ola.TestRunner.CucumberExtentReportPlugin"// Add extent reports logic to the after plugin lifecycle
	    		    },
	    		
	    		 monochrome = false
	    
	   
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	    // Empty class - the annotations drive the configuration
}