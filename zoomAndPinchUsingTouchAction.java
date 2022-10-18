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
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class zoomAndPinchUsingTouchAction {
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
		
		//WebElement image = driver.findElement(By.id("com.oneplus.gallery:id/filmstrip_item_download_icon"));
		WebElement image = driver.findElement(By.id("com.oneplus.gallery:id/filmstrip_item_scale_image_view"));
		//int x = driver.manage().window().getPosition().getX() + driver.manage().window().getSize().getWidth()/2;
		int x = driver.manage().window().getSize().getWidth()/2;
		//int y = driver.manage().window().getPosition().getY() + driver.manage().window().getSize().getHeight()/2;
		int y = driver.manage().window().getSize().getHeight()/2;
		//int x = image.getLocation().getX() + image.getSize().getWidth()/2;
		//int y = image.getLocation().getY() + image.getSize().getHeight()/2;
		TouchAction finger1 = new TouchAction((MobileDriver)driver);
		finger1.press(x, y-20).moveTo(x, y-500);
		TouchAction finger2 = new TouchAction ((MobileDriver)driver);
		finger2.press(x, y+20).moveTo(x, y+500);
		MultiTouchAction action = new MultiTouchAction((MobileDriver)driver);
		action.add(finger1).add(finger2).perform();
		Thread.sleep(5000);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}