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

public class pressElement {
	AndroidDriver driver;

	@Test
	public void setup() throws MalformedURLException, InterruptedException {
		// AndroidDriver driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "OnePlus 6");
		capability.setCapability("platformName", "Android");
		capability.setCapability("noReset", "true");
		capability.setCapability("appPackage", "net.oneplus.launcher");
		capability.setCapability("appActivity", "net.oneplus.launcher.Launcher");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		Thread.sleep(5000);
		List<WebElement> icons = driver.findElements(By.className("android.widget.TextView"));
		for(WebElement icon : icons) {
			if(icon.getText().equals("Duo")) {
				TouchAction action = new TouchAction ((MobileDriver)driver);
				//action.longPress(icon).perform();
				action.press(icon).waitAction(3000).release().perform();
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement> appinfo = driver.findElements(By.id("net.oneplus.launcher:id/shortcut_text"));
		for(WebElement info : appinfo) {
			if(info.getText().equals("App info")) {
				info.click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}