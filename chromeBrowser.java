package com.example;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class chromeBrowser {
	AndroidDriver driver;
	@Test
	public void setup() throws InterruptedException, IOException {
		// AndroidDriver driver;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "OnePlus 6");
		capability.setCapability("platformName", "Android");
		capability.setCapability("noReset", "true");
		capability.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avina\\OneDrive\\Documents\\Automation\\chromedriver_win32\\chromedriver.exe");
		
		//capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("androidPackage", "com.android.chrome");
		//capability.setCapability(ChromeOptions.CAPABILITY, options);
		
		//capability.setCapability("appPackage", "com.whatsapp");
		//capability.setCapability("appActivity", "com.whatsapp.HomeActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		Thread.sleep(5000);
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}