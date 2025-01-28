package com.ola.StepDefinitions;

import com.ola.Base.LibararyClass;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends LibararyClass{
	@Before
    
	 public void setUp() throws Exception {
		intailiazedriver();
	    }
 

   @After
   public void tearDown() {
	   quitdriver();
   }
}
