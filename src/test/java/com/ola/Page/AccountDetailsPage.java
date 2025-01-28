package com.ola.Page;

import org.openqa.selenium.By;

import com.ola.Base.LibararyClass;
import com.ola.Base.Utitlityclass;

import io.appium.java_client.AppiumDriver;

public class AccountDetailsPage {

	private AppiumDriver driver;
	Utitlityclass util;
	
	
    private By Navigation=By.xpath("//android.widget.ImageView[@content-desc=\"Navigation\"]");
	
	private By Myprofile=By.xpath("//android.widget.ImageView[@resource-id=\"com.olacabs.customer:id/arrow_item\"]");
	private By Edit=By.xpath("//android.view.ViewGroup[@resource-id=\"com.olacabs.customer:id/search_bar_parent\"]/android.widget.FrameLayout");
	private By Bar=By.xpath("//android.view.ViewGroup[@resource-id=\"com.olacabs.customer:id/search_bar_parent\"]/android.widget.FrameLayout");

public AccountDetailsPage() {
	this.driver=LibararyClass.driver.get();
	this.util= new Utitlityclass(driver);
}

public void ClickNavigation() {
	util.waitForClickability(Navigation, 30);
	util.clickElement(Navigation);
}

public void ClickMyprofile() {
	util.waitForClickability(Myprofile, 30);
	util.clickElement(Myprofile);
}

public void ClickMyEdit() {
	util.waitForClickability(Edit, 30);
	util.clickElement(Edit);
}

public void ClickMyBar() {
	util.waitForClickability(Bar, 30);
	util.clickElement(Bar);
}

}
