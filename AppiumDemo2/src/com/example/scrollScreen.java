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

public class scrollScreen {
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

		boolean flag = true;
		// Scrollto command doesn't work always
		// driver.scrollTo("Privacy").click();
		// List<WebElement> tabs = driver.findElements(By.id("android:id/title"));
		while (flag) {
			List<WebElement> tabs = driver.findElements(By.id("android:id/title"));
			for (WebElement tab : tabs) {
				System.out.println(tab.getText());
				if (tab.getText().equals("System")) {
					tab.click();
					Thread.sleep(2000);
					System.out.println("System is clicked");
					flag = false;
					Thread.sleep(2000);
					System.out.println("value of flag is : " + flag);
					break;
				}
			}
			if (flag == true) {
				System.out.println("value of flag is : " + flag);
				int count = tabs.size();
				WebElement lastElement = tabs.get(count - 2);
				int intialX = lastElement.getLocation().getX() + lastElement.getSize().getWidth() / 2;
				int intialY = lastElement.getLocation().getY() + lastElement.getSize().getHeight() / 2;
				driver.swipe(intialX, intialY, intialX, intialY - 900, 3000);
				System.out.println("Swiping screen");
			}
		}
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}