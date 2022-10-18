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

public class dragAndDrop {
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
		WebElement drag1 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"WA Business\"]"));
		WebElement drag2 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Parallel WhatsApp\"]"));
		WebElement drop = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"WhatsApp\"]"));
		Thread.sleep(2000);
		TouchAction action = new TouchAction((MobileDriver)driver);
		action.longPress(drag1).moveTo(drop).release().perform();
		Thread.sleep(3000);
		action.longPress(drag2).moveTo(drop).release().perform();
		Thread.sleep(2000);
		//action.longPress(drag1).moveTo(500,2000).release().perform();
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}