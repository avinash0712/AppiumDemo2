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

public class radioButton {
	AndroidDriver driver;

	@Test
	public void setup() throws MalformedURLException, InterruptedException {
		// AndroidDriver driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "OnePlus 6");
		capability.setCapability("platformName", "Android");
		capability.setCapability("noReset", "true");
		capability.setCapability("appPackage", "cris.icms.ntes");
		capability.setCapability("appActivity", "cris.icms.ntes.NtesActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		Thread.sleep(5000);
		WebElement liveStation = driver.findElement(By.id("cris.icms.ntes:id/live"));
		liveStation.click();
		Thread.sleep(3000);
		WebElement fHr = driver.findElement(By.id("cris.icms.ntes:id/fhr"));
		fHr.click();
		Thread.sleep(3000);
		WebElement eHr = driver.findElement(By.id("cris.icms.ntes:id/ehr"));
		eHr.click();
		Thread.sleep(3000);
		WebElement tHr = driver.findElement(By.id("cris.icms.ntes:id/thr"));
		tHr.click();
		Thread.sleep(3000);
		
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}