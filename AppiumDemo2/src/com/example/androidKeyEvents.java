package com.example;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
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
import io.appium.java_client.android.AndroidKeyCode;

public class androidKeyEvents {
	AndroidDriver driver;

	@Test
	public void setup() throws InterruptedException, IOException {
		// AndroidDriver driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "OnePlus 6");
		capability.setCapability("platformName", "Android");
		capability.setCapability("noReset", "true");
		capability.setCapability("appPackage", "com.whatsapp");
		capability.setCapability("appActivity", "com.whatsapp.HomeActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		Thread.sleep(5000);
		List<WebElement> row = driver.findElements(By.id("com.whatsapp:id/contact_row_container"));
		row.get(0).click();
		WebElement entry = driver.findElement(By.id("com.whatsapp:id/entry"));
		entry.click();
		entry.sendKeys("Hello");
		driver.sendKeyEvent(AndroidKeyCode.ENTER);
		driver.sendKeyEvent(36);
		driver.sendKeyEvent(AndroidKeyCode.ENTER);
		driver.sendKeyEvent(AndroidKeyCode.SETTINGS);
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}