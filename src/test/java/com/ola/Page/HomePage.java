package com.ola.Page;

import org.openqa.selenium.By;

import com.ola.Base.LibararyClass;
import com.ola.Base.Utitlityclass;


import io.appium.java_client.AppiumDriver;

public class HomePage {

	private AppiumDriver driver;
	Utitlityclass util;
	
	
	private By phonenumber=By.xpath("//android.widget.TextView[@resource-id=\"com.olacabs.customer:id/continue_with_phone_number\"]");
	
	private By number=By.xpath("//android.widget.EditText[@resource-id=\"com.olacabs.customer:id/mobile_number\"]");
	private By next=By.xpath("//android.widget.Button[@resource-id=\"com.olacabs.customer:id/blackButton\"]");
	private By verify=By.xpath("//android.widget.Button[@resource-id=\"com.olacabs.customer:id/blackButton\"]");
	private By allow=By.xpath("//android.widget.Button[@resource-id=\"com.olacabs.customer:id/allow_permission\"]");
	private By devicelocation=By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_one_time_button\"]");
	private By mangecalls=By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");
	private By notifications=By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");
	private By changelocation=By.xpath("//android.widget.TextView[@text='Change Location']");
public HomePage() {
	this.driver=LibararyClass.driver.get();
	this.util= new Utitlityclass(driver);
}

public void Clickphonenumber() {
	util.waitForClickability(phonenumber, 100);
	util.clickElement(phonenumber);
}


public void Enternumber() {
	util.waitforvisblity(number, 100);
	util.enterTextByXPath(number,"8220957223" );
}

public void clicknext() {
	util.waitForClickability(next, 100);
	util.clickElement(next);
}

public void clickverifyt() {
	util.waitForClickability(verify, 100);
	util.clickElement(verify);
}

public void clickallow() {
	util.waitForClickability(allow, 100);
	util.clickElement(allow);
}

public void clickdevicelocation() {
	util.waitForClickability(devicelocation, 100);
	util.clickElement(devicelocation);
}

public void clickmangecalls() {
	util.waitForClickability(mangecalls, 100);
	util.clickElement(mangecalls);
}

public void clicknotifications() {
	util.waitForClickability(notifications, 100);
	util.clickElement(notifications);
}

public void clickchangelocation() {
	util.waitforvisblity(changelocation, 150);
	util.clickElement(changelocation);
}
}
