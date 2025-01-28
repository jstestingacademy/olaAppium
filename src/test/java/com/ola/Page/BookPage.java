package com.ola.Page;

import org.openqa.selenium.By;

import com.ola.Base.LibararyClass;
import com.ola.Base.Utitlityclass;

import io.appium.java_client.AppiumDriver;

public class BookPage {


	private AppiumDriver driver;
	Utitlityclass util;
	
	
    private By Location=By.xpath("//android.widget.TextView[@resource-id=\"com.olacabs.customer:id/change_location_btn\"]");
	
	private By pickuplocation=By.xpath("//android.widget.EditText[@resource-id=\"com.olacabs.customer:id/et_pickup\"]");
	private By Home=By.xpath("//android.widget.TextView[@resource-id=\"com.olacabs.customer:id/tv_address\" and @text=\"Punithavathy Colony Main Road, Gowrivakkam, Sembakkam, Punithavathy Colony, Tamil Nadu 600073, India\"]");
	private By Continue=By.xpath("//android.widget.TextView[@resource-id=\"com.olacabs.customer:id/bfseContinueCta\"]");
	private By Deistination=By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.olacabs.customer:id/frequent_list\"]/android.view.ViewGroup[2]");
	private By BookAny=By.xpath("(//android.widget.TextView[@resource-id=\"com.olacabs.customer:id/btn_book\"])[4]");

	
	public BookPage() {
		this.driver=LibararyClass.driver.get();
		this.util= new Utitlityclass(driver);
	}
	
	public void ClickLocation() {
		util.waitForClickability(Location, 30);
		util.clickElement(Location);
	}
	
	public void Clickpickuplocation() {
		util.waitForClickability(pickuplocation, 30);
		util.clickElement(pickuplocation);
	}
	
	public void ClickHome() {
		util.waitForClickability(Home, 30);
		util.clickElement(Home);
	}
	
	public void ClickContinue() {
		util.waitForClickability(Continue, 30);
		util.clickElement(Continue);
	}
	
	public void ClickDeistination() {
		util.waitForClickability(Deistination, 30);
		util.clickElement(Deistination);
	}
	
	public void ClickBookAny() {
		util.waitForClickability(BookAny, 30);
		util.clickElement(BookAny);
	}
	
	
}
