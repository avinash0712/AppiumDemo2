package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class findingElement {
	AndroidDriver driver;

	@Test
	public void setup() throws MalformedURLException, InterruptedException {
		// AndroidDriver driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "OnePlus 6");
		capability.setCapability("platformName", "Android");
		capability.setCapability("noReset", "true");
		capability.setCapability("appPackage", "com.instagram.android");
		capability.setCapability("appActivity", "com.instagram.mainactivity.MainActivity");
		//WebDriver driver = new WebDriver();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		WebElement like = driver.findElement(By.id("com.instagram.android:id/row_feed_button_like"));
		Thread.sleep(2000);
		like.click();
		System.out.println(like.getAttribute("checkable"));
		System.out.println(like.getAttribute("enabled"));
		System.out.println(like.getAttribute("checked"));
		System.out.println(like.getAttribute("scrollable"));
		System.out.println("selected value is " + like.getAttribute("selected"));
		//driver.scrollTo("_dekhbhai_");

		if (like.getAttribute("selected").equals("true")) {
			System.out.println("post is clicked");
		} else
			System.out.println("post is not clicked");
		Thread.sleep(5000);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
