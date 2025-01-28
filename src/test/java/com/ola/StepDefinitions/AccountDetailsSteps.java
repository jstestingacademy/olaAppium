package com.ola.StepDefinitions;

import com.ola.Base.LibararyClass;
import com.ola.Base.Utitlityclass;
import com.ola.Page.AccountDetailsPage;
import com.ola.Page.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AccountDetailsSteps {
	AccountDetailsPage details ;
	Utitlityclass util;
	
	
	public AccountDetailsSteps() {
		util=new Utitlityclass(LibararyClass.driver.get());
		details=new AccountDetailsPage();
	}
	
	
	@Given("Click The Nvaigation link")
	public void click_the_nvaigation_link() {
	    details.ClickNavigation();
	}

	@When("Click the My Profile arrow")
	public void click_the_my_profile_arrow() {
	    details.ClickMyprofile();
	}

	@When("Click the EDit page")
	public void click_the_e_dit_page() {
	  details.ClickMyEdit();
	}

	@When("Naviagte to Accountdeatils page")
	public void naviagte_to_accountdeatils_page() {
	    details.ClickMyBar();
	}

	@When("Take SCREENSHOT")
	public void take_screenshot() {
	    util.takeScreenshotWithTimestamp("AccoundetailsPage");
	}


}
