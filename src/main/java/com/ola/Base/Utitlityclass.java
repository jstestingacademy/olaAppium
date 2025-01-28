package com.ola.Base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class Utitlityclass {

	 
	 private AppiumDriver driver;
	 
	 private int defaultTimeout = 30;
	 
	 public Utitlityclass(AppiumDriver driver) {
	        this.driver = driver;
	    }

	
	public boolean waitForInvisibility(By locator, int timeout) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
       return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
   }
	
	
	public  WebElement waitforvisblity(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	  public WebElement waitForClickability(By locator, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }
	  
	  public void takeScreenshot1(String filePath) {
	        try {
	            // Capture screenshot
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	            // Create directories if they don't exist
	            File destinationFile = new File(filePath);
	            destinationFile.getParentFile().mkdirs();

	            // Copy the screenshot to the destination
	            Files.copy(screenshot.toPath(), destinationFile.toPath());

	            System.out.println("Screenshot saved at: " + filePath);
	        } catch (IOException e) {
	            System.err.println("Failed to save screenshot: " + e.getMessage());
	        }
	    }
	    
	    public void takeScreenshotWithTimestamp(String fileName) {
	        String timestamp = String.valueOf(System.currentTimeMillis());
	        String defaultDirectory = "screenshots/";
	        String fullPath = defaultDirectory + fileName + "_" + timestamp + ".png";
	        takeScreenshot1(fullPath);
	    }
	    
	    public void clickElement(By locator) {
	    	waitForClickability(locator, 10).click();
	    }
	    
	    public void enterTextByXPath(By locator, String text) {
	        try {
	            WebElement element = driver.findElement(locator);

	            // Clear the field if any text exists
	            element.clear();

	            // Send the new text
	            element.sendKeys(text);

	            System.out.println("Text entered successfully using XPath: " + text);
	        } catch (NoSuchElementException e) {
	            System.err.println("Element not found: " + e.getMessage());
	        } catch (Exception e) {
	            System.err.println("An error occurred while entering text: " + e.getMessage());
	        }
	    }
	    
	    public void getlocation() {
	    	Point source = driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]")).getLocation();
	    	Point target = driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]")).getLocation();

	    	dragAndDrop(source.getX(), source.getY(), target.getX(), target.getY());
	    }
	    
	    
	    public void dragAndDrop(int startX, int startY, int endX, int endY) {
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence dragAndDrop = new Sequence(finger, 0);

	        // Press at the source
	        dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),
	                                                       PointerInput.Origin.viewport(), startX, startY));
	        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

	        // Drag to the destination
	        dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(1000),
	                                                       PointerInput.Origin.viewport(), endX, endY));
	        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        // Perform the action
	        driver.perform(Arrays.asList(dragAndDrop));
	    }
	    //Scroll down
	    public void scrollDown() {
	        // Get the screen size
	    	PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipe = new Sequence(finger, 1);
	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
	                                                 PointerInput.Origin.viewport(), 540, 680));
	        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
	                                                 PointerInput.Origin.viewport(), 540, 480));
	        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        driver.perform(Arrays.asList(swipe));
}
	    public void selectDropdownOption(String optionText) {
	        try {
	            // Expand dropdown
	            WebElement dropdown = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));
	            dropdown.click();
	            System.out.println("[INFO] Dropdown expanded.");

	            // Wait for the option to load
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	            String optionXpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='" + optionText + "']";
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(optionXpath)));

	            // Select the option
	            WebElement option = driver.findElement(By.xpath(optionXpath));
	            option.click();
	            System.out.println("[INFO] Option selected: " + optionText);
	        } catch (NoSuchElementException e) {
	            System.err.println("[ERROR] Option not found: " + optionText);
	            throw e;
	        } catch (Exception e) {
	            System.err.println("[ERROR] Failed to select dropdown option: " + e.getMessage());
	            throw e;
	        }
	    } 
	    
	    public void zoom(By locator) {
	       
	    	 WebElement element = driver.findElement(locator);

	         // Get the center of the element
	         int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
	         int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
	         int zoomDistance = element.getSize().getHeight() / 4;

	         // Define two pointer inputs (Finger1 and Finger2)
	         PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	         PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

	         // Define gestures for finger1
	         Sequence finger1Sequence = new Sequence(finger1, 0);
	         finger1Sequence.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY - 10));
	         finger1Sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	         finger1Sequence.addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerX, centerY - zoomDistance));
	         finger1Sequence.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	         // Define gestures for finger2
	         Sequence finger2Sequence = new Sequence(finger2, 0);
	         finger2Sequence.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY + 10));
	         finger2Sequence.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	         finger2Sequence.addAction(finger2.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerX, centerY + zoomDistance));
	         finger2Sequence.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	         // Perform both gestures
	         try {
	             driver.perform(Arrays.asList(finger1Sequence, finger2Sequence));
	             System.out.println("✅ Zoom gesture performed successfully.");
	         } catch (Exception e) {
	             System.err.println("❌ Error performing zoom gesture: " + e.getMessage());
	             throw e;
	         }
	     }
	    
	    public void swipeHorizontally() {
	        int screenHeight = driver.manage().window().getSize().height;
	        int screenWidth = driver.manage().window().getSize().width;

	        int startX = (int) (screenWidth * 0.8); // Start from 80% of screen width
	        int endX = (int) (screenWidth * 0.2);   // Swipe to 20% of screen width
	        int y = screenHeight / 2;              // Middle of the screen

	        performSwipe(startX, y, endX, y);
	    }

	    public void swipeVertically() {
	        int screenHeight = driver.manage().window().getSize().height;
	        int screenWidth = driver.manage().window().getSize().width;

	        int startY = (int) (screenHeight * 0.8); // Start from 80% of screen height
	        int endY = (int) (screenHeight * 0.2);   // Swipe to 20% of screen height
	        int x = screenWidth / 2;                // Middle of the screen

	        performSwipe(x, startY, x, endY);
	    }

	    private void performSwipe(int startX, int startY, int endX, int endY) {
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipe = new Sequence(finger, 0);

	        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
	        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
	        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        try {
	            driver.perform(Collections.singletonList(swipe));
	            System.out.println("✅ Swipe gesture performed successfully.");
	        } catch (Exception e) {
	            System.err.println("❌ Error performing swipe gesture: " + e.getMessage());
	            throw e;
	        }
	    }
}
