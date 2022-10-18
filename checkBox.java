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

public class checkBox {
	AndroidDriver driver;

	@Test
	public void setup() throws MalformedURLException, InterruptedException {
		// AndroidDriver driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "OnePlus 6");
		capability.setCapability("platformName", "Android");
		capability.setCapability("noReset", "true");
		capability.setCapability("appPackage", "com.oneplus.filemanager");
		capability.setCapability("appActivity", "com.oneplus.filemanager.HomePageActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		Thread.sleep(7000);
		List<WebElement> titles = driver.findElements(By.id("com.oneplus.filemanager:id/title"));
		for(WebElement title : titles) {
			if(title.getText().equals("Audio")) {
				title.click();
				break;
			}
		}
		Thread.sleep(5000);
		List<WebElement> icons = driver.findElements(By.id("com.oneplus.filemanager:id/file_icon"));
		WebElement icon = icons.get(0);
		TouchAction ta = new TouchAction((MobileDriver)driver);
		ta.longPress(icon).release().perform();
		Thread.sleep(3000);
		
		
		List<WebElement> checkBoxes = driver.findElements(By.id("com.oneplus.filemanager:id/file_select_box"));
		for(WebElement checkBox : checkBoxes) {
			//System.out.println(checkBox.getAttribute("checked"));
			if(checkBox.getAttribute("checked").equals("false")) {
				checkBox.click();
				Thread.sleep(2000);
			}
		}
		
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}