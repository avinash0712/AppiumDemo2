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

public class toggleButton {
	AndroidDriver driver;

	@Test
	public void setup() throws MalformedURLException, InterruptedException {
		// AndroidDriver driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "OnePlus 6");
		capability.setCapability("platformName", "Android");
		capability.setCapability("noReset", "true");
		capability.setCapability("appPackage", "com.android.settings");
		capability.setCapability("appActivity", "com.android.settings.Settings");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		Thread.sleep(5000);
		driver.swipe(500, 2000, 500, 1500, 3000);
		List<WebElement> titles = driver.findElements(By.id("android:id/title"));
		for(WebElement title : titles) {
			if(title.getText().equals("Display")) {
				title.click();
				break;
			}
		}
		Thread.sleep(3000);
		WebElement toggle = driver.findElement(By.id("android:id/switch_widget"));
		toggle.click();
		Thread.sleep(3000);
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}