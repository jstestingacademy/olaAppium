package com.ola.StepDefinitions;

import com.ola.Base.LibararyClass;
import com.ola.Base.Utitlityclass;
import com.ola.Page.HomePage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
	HomePage home ;
	Utitlityclass util;
	public HomeSteps() {
		util=new Utitlityclass(LibararyClass.driver.get());
		home=new HomePage();
	}
	
	@Given("Launch the APP")
	public void launch_the_app() {
		
		System.out.println("App Launched");
	}

	@Given("Click phonenumber")
	public void click_phonenumber() {
	   home.Clickphonenumber();
	}

	@When("Enter Number")
	public void enter_number() {
	   home.Enternumber();
	}

	@When("Click Verify")
	public void click_verify() {
		home.clicknext();
	    home.clickverifyt();
	}

	@When("Click Allow")
	public void click_allow() {
		
	    home.clickallow();
	}

	@Then("Click device Location")
	public void click_device_location() {
	   home.clickdevicelocation();
	}

	@Then("Click Mangecalls")
	public void click_mangecalls() {
	    home.clickmangecalls();
	}

	@Then("Click Notifications")
	public void click_notifications() {
	    home.clicknotifications();
	}

	

	@Then("Take screenshots")
	public void take_screenshots() {
	    util.takeScreenshotWithTimestamp("HomePage");
	}
}
