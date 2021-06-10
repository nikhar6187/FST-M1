package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNGActivity3 {

	WebDriver driver;
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		//Open the browser
		driver.get("https://www.training-support.net/selenium/login-form");
	}

	@Test
	public void loginTest() {

		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

	
		username.sendKeys("admin");
		password.sendKeys("password");

		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		
		String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals("Welcome Back, admin", loginMessage);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}


}
