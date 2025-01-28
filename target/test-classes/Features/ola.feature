

Feature: To Validate the Ola App


  
  Background: To Naviagte to Home Page
    Given Launch the APP
    And Click phonenumber
    When Enter Number
    And Click Verify
    And Click Allow
    Then Click device Location
    And Click Mangecalls
    And Click Notifications
  
    And Take screenshots
    
     
   Scenario: To Naviagte to AccountsDeatils Page
    Given Launch the APP
    And Click The Nvaigation link
    When Click the My Profile arrow
    And Click the EDit page
    And Naviagte to Accountdeatils page
    And Take SCREENSHOT

   
   Scenario: To Naivgiate to Book Any page
    Given Launch  App
    And Click The ChangeLocation button
    When Click the pickup location text box
    And Select the Source location
    And Click The Continue button
    And Select the Desiniation location
    And Click The Book Any button
    And Take the screenshots
    
   
   