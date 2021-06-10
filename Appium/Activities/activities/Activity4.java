package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Activity4 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {

		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pexel4Emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.dialer");
		caps.setCapability("appActivity", ".extensions.GoogleDialtactsActivity");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);

		wait = new WebDriverWait(driver,30);

	}

	@Test
	public void addContact() throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Contacts']")));
		driver.findElementByXPath("//android.widget.TextView[@text='Create new contact']").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.android.contacts:id/photo")));
		driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");
		driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Varma");
		driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("999148292");
		driver.findElementById("com.android.contacts:id/editor_menu_save_button").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("com.android.contacts:id/photo")));
		String contactName = driver.findElementById("com.android.contacts:id/title_gradient").getText();		
		System.out.println("Contact Name : "+contactName);
		Assert.assertEquals(contactName, "Aaditya Varma");
	}
}
