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

public class zoomAndPinch {
	AndroidDriver driver;

	@Test
	public void setup() throws MalformedURLException, InterruptedException {
		// AndroidDriver driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "OnePlus 6");
		capability.setCapability("platformName", "Android");
		capability.setCapability("noReset", "true");
		capability.setCapability("appPackage", "com.oneplus.gallery");
		capability.setCapability("appActivity", "com.oneplus.gallery.OPGalleryActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		Thread.sleep(12000);
		List<WebElement> titles = driver.findElements(By.id("com.oneplus.gallery:id/media_set_title"));
		for(WebElement title : titles) {
			if(title.getText().equals("All photos and videos")) {
				title.click();
				break;
			}
		}
		Thread.sleep(2000);
		List<WebElement> thumbnail = driver.findElements(By.id("com.oneplus.gallery:id/item_thumbnail"));
		thumbnail.get(4).click();
		Thread.sleep(5000);
		WebElement image = driver.findElement(By.id("com.oneplus.gallery:id/filmstrip_item_scale_image_view"));
		driver.zoom(image);
		driver.zoom(500,1100);
		Thread.sleep(5000);
		driver.pinch(image);
		driver.pinch(500,1100);
		Thread.sleep(5000);
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}