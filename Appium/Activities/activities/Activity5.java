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
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity5 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "<device name>");
		caps.setCapability("platformName", "Android");
		caps.setCapability("noReset", true);
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", ".ui.ConversationListActivity");

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void smsTest() {
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Start new conversation")));
	
		driver.findElement(MobileBy.AccessibilityId("Start new conversation")).click();

	
		String contactTextBox = "com.google.android.apps.messaging:id/recipient_text_view";

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id(contactTextBox)));
		
		
		driver.findElement(MobileBy.id(contactTextBox)).sendKeys("9014842678");
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")));

	
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Hello from Appium");

		
		driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();

	
		String message = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(message)));

	
		String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(message)).getText();
		Assert.assertEquals(sentMessageText, "Hi Appium");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}