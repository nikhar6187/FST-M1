package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		driver.get("https://www.training-support.net/selenium/simple-form");

		Thread.sleep(2000);
		
		System.out.println("The title is : "+driver.getTitle());
			
		driver.findElement(By.id("firstName")).sendKeys("Nikhar");
		
		driver.findElement(By.id("lastName")).sendKeys("Vijayvargiya");
		
		driver.findElement(By.id("email")).sendKeys("Nikhar@Vijayvargiya.com");
	
		driver.findElement(By.id("number")).sendKeys("7829543284");
		
		driver.findElement(By.cssSelector(".ui.green.button")).click();		
		
		Thread.sleep(7000);
	
		System.out.println("The new page title is : "+driver.getTitle());
		
		driver.close();
	}

}
