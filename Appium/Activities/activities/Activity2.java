package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pexel4Emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);

		wait = new WebDriverWait(driver,30);

	
		driver.get("https://www.training-support.net/");	
	}

	@Test
	public void printTitles() {

		String expectedHomePageTitle = "Training Support";
		String expectedAboutUsTitle = "About Us";
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Training Support']")));

	
		String actualHomePageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
		
		System.out.println("The Home page title is : "+actualHomePageTitle);

		
		driver.findElementByXPath("//android.view.View[@text='About Us']").click();

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='About Us']")));

		
		String actualAboutUsPageTitle = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
		System.out.println("The New page title is : "+actualAboutUsPageTitle);
		
	
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle, "Home Page title is not same");
		Assert.assertEquals(actualAboutUsPageTitle, expectedAboutUsTitle, "About Us Page title is not same");


	}

	@AfterClass
	public void afterClass() {
		// Close the browser.
		driver.quit();
	}
}
