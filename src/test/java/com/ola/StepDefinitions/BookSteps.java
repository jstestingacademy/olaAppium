package com.ola.StepDefinitions;

import com.ola.Base.LibararyClass;
import com.ola.Base.Utitlityclass;
import com.ola.Page.AccountDetailsPage;
import com.ola.Page.BookPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BookSteps {
	BookPage book ;
	Utitlityclass util;
	
	
	public BookSteps() {
		util=new Utitlityclass(LibararyClass.driver.get());
		book=new BookPage();
	}
	
	@Given("Launch  App")
	public void launch_app() {
	   System.out.println("app launched");
	}

	@Given("Click The ChangeLocation button")
	public void click_the_change_location_button() {
	    book.ClickLocation();
	}

	@When("Click the pickup location text box")
	public void click_the_pickup_location_text_box() {
	   book.Clickpickuplocation();
	}

	@When("Select the Source location")
	public void select_the_source_location() {
	    book.ClickHome();
	}

	@When("Click The Continue button")
	public void click_the_continue_button() {
	    book.ClickContinue();
	}

	@When("Select the Desiniation location")
	public void select_the_desiniation_location() {
	    book.ClickDeistination();
	}

	@When("Click The Book Any button")
	public void click_the_book_any_button() {
	    book.ClickBookAny();
	}

	@When("Take the screenshots")
	public void take_the_screenshots() {
	    util.takeScreenshotWithTimestamp("BookAny");
	}



}
