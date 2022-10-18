package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class orientation {
	AndroidDriver driver;
	ScreenOrientation orientation;

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
		Thread.sleep(5000);
		orientation = ScreenOrientation.LANDSCAPE;
		driver.execute(DriverCommand.SET_SCREEN_ORIENTATION,
				ImmutableMap.of("orientation",orientation.value().toUpperCase()));
		Thread.sleep(5000);
		orientation = ScreenOrientation.PORTRAIT;
		driver.execute(DriverCommand.SET_SCREEN_ORIENTATION,
				ImmutableMap.of("orientation",orientation.value().toUpperCase()));
		Thread.sleep(5000);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}