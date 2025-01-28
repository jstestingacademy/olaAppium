package com.ola.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	 private static ExtentReports extent;

	    public static ExtentReports createInstance() {
	        String reportFilePath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportFilePath);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle("TestNG Extent Report");
	        htmlReporter.config().setReportName("Automation Test Report");

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("OS", System.getProperty("os.name"));
	        extent.setSystemInfo("Browser", "Chrome");

	        return extent;
	    }
}
