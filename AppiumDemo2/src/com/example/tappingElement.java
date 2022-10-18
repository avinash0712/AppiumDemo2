package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class tappingElement {
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
		Thread.sleep(2000);
		// driver.scrollToExact("Buttons & Gestures");
		// driver.swipe(500,1800,500,800);
		driver.swipe(500, 1800, 500, 800, 2000);
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.id("android:id/title"));
		for (WebElement element : elements) {
			System.out.println("The element present on the screen are :" + element.getText());
			if (element.getText().equals("Buttons & Gestures")) {
				element.click();
				break;
			}
		}
		Thread.sleep(2000);
		WebElement button = driver.findElement(By.id("android:id/switch_widget"));
		driver.tap(1, button, 2);
		Thread.sleep(6000);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}