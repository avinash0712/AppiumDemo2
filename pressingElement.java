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

public class pressingElement {
	AndroidDriver driver;

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
		Thread.sleep(2000);
		List<WebElement> names = driver.findElements(By.id("com.whatsapp:id/conversations_row_contact_name"));
		//System.out.println("avi");
		for (WebElement name : names) {
			if(name.getText().equals("❣️❣️❣️❣️❣️❣️"));
			//System.out.println("avi");
			name.click();
			break;
		}
		Thread.sleep(5000);
		
		WebElement message = driver.findElement(By.id("com.whatsapp:id/titleSnippetUrlLayout"));
		TouchAction action = new TouchAction((MobileDriver)driver);
		action.longPress(message).perform();
		//action.press(message).waitAction(2000).release().perform();
		
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}