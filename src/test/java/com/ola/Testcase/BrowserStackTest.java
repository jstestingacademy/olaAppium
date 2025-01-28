package com.ola.Testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ola.Base.BrowserStackIntegration;

public class BrowserStackTest {

	private BrowserStackIntegration browserstack= new BrowserStackIntegration();
@BeforeClass
@Parameters({"deviceName","platformVersion"})
public void setup(String deviceName,String platformVersion) throws IOException {
	System.setProperty("deviceName", deviceName);
	System.setProperty("platformVersion", platformVersion);
	browserstack.initializeDriver();
	
}
@Test
public void test() {
	System.out.println(" Running test on device: " + browserstack.getDriver().getCapabilities().getCapability("deviceName"));
}

public void teardown() {
	browserstack.quitDriver();
}
}
