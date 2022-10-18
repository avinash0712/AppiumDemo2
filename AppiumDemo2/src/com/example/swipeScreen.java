package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class swipeScreen {
	AndroidDriver driver;

	@Test
	public void setup() throws MalformedURLException, InterruptedException {
		// AndroidDriver driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "OnePlus 6");
		capability.setCapability("platformName", "Android");
		capability.setCapability("noReset", "true");
		capability.setCapability("appPackage", "com.whatsapp");
		capability.setCapability("appActivity", "com.whatsapp.HomeActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		Thread.sleep(2000);
		int screenWidth = driver.manage().window().getSize().getWidth();
		int screenHeight = driver.manage().window().getSize().getHeight();
		
		int startX = screenWidth*9/10;
		int endX = screenWidth/10;
		int startY = screenHeight/2;
		int endY = screenHeight/2;
		Thread.sleep(2000);
		//Swipe Left
		driver.swipe(startX, startY, endX, endY, 4000);
		Thread.sleep(4000);
		
		//Checking stories of whatsapp
		List<WebElement> stories = driver.findElements(By.id("com.whatsapp:id/contact_name"));
		for(WebElement story : stories ) {
			story.click();
			Thread.sleep(2000);
			driver.navigate().back();
		}
		
		
		//swipe right
		startX = screenWidth/10;
		endX = screenWidth*9/10;
		startY = screenHeight/2;
		endY = screenHeight/2;
		Thread.sleep(2000);
		driver.swipe(startX, startY, endX, endY, 4000);
		Thread.sleep(4000);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}