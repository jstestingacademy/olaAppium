package com.ola.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LibararyClass {
	 public static ThreadLocal<AppiumDriver> driver =new ThreadLocal<>();
	    
	    public void intailiazedriver() throws IOException {
	    	Properties prop = new Properties();
	    	FileInputStream file = new FileInputStream("src/test/resources/Properties/Config.Properties");
	    	prop.load(file);
	    	
	    	DesiredCapabilities caps =new DesiredCapabilities();
	    	caps.setCapability("plaformName", prop.getProperty("plaformName"));
	    	caps.setCapability("PlatformVersion", prop.getProperty("PlatformVersion"));
	    	caps.setCapability("deviceName", prop.getProperty("deviceName"));
	    	caps.setCapability("app", prop.getProperty("app"));
	    	caps.setCapability("appPackage", prop.getProperty("appPackage"));
	    	caps.setCapability("appActivity", prop.getProperty("appActivity"));
	    	caps.setCapability("automationName", prop.getProperty("automationName"));
	    	URL remoteurl = new URL(prop.getProperty("serverURL"));
	    	AndroidDriver ldriver =new AndroidDriver(remoteurl,caps);
	    	driver.set(ldriver);
	    	
	    }
	    
	    public AppiumDriver getdriver() {
	    	return driver.get();
	    }
	    
	    public void quitdriver() {
	    	driver.get().quit();
	    	driver.remove();
	    }
}
