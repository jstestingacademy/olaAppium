package com.ola.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class BrowserStackIntegration {

	public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public static final String USERNAME = "jstestingacademy_TkFPGn"; // Replace with your BrowserStack username
    public static final String AUTOMATE_KEY = System.getenv("AUTOMATE_KEY"); // Replace with your BrowserStack Access Key
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public void initializeDriver() throws IOException {
        Properties prop = new Properties();

        // Load configuration properties
        try (FileInputStream file = new FileInputStream("src/test/resources/Properties/Config.Properties")) {
            prop.load(file);
        }

        if (AUTOMATE_KEY == null || AUTOMATE_KEY.isEmpty()) {
            System.err.println("Please set AUTOMATE_KEY as an environment variable.");
            System.exit(1);
        }

        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            // BrowserStack credentials
            caps.setCapability("browserstack.user", USERNAME);
            caps.setCapability("browserstack.key", AUTOMATE_KEY);

            // Platform-specific capabilities
            caps.setCapability("platformName", prop.getProperty("platformName"));
            caps.setCapability("platformVersion", prop.getProperty("platformVersion"));
            caps.setCapability("deviceName", prop.getProperty("deviceName"));

            // App-specific capabilities
            caps.setCapability("app", prop.getProperty("app"));
            caps.setCapability("appPackage", prop.getProperty("appPackage"));
            caps.setCapability("appActivity", prop.getProperty("appActivity"));
            caps.setCapability("automationName", prop.getProperty("automationName"));

            // BrowserStack options
            caps.setCapability("project", prop.getProperty("projectName", "Ola Automation"));
            caps.setCapability("build", prop.getProperty("buildName", "1.0"));
            caps.setCapability("name", prop.getProperty("testName", "App Test"));

            // Initialize AndroidDriver with BrowserStack URL
            URL remoteUrl = new URL(URL);
            AndroidDriver ldriver = new AndroidDriver(remoteUrl, caps);
            driver.set(ldriver);

            System.out.println("Driver initialized successfully on BrowserStack.");

        } catch (Exception e) {
            System.err.println("Error during driver initialization: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
