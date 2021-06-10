package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println("The title is : "+title);
		
	
		WebElement uname = driver.findElement(By.xpath("//input[starts-with(@class,'username')]"));
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@class,'password')]"));
		
		
		WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		
		uname.sendKeys("admin");

		password.sendKeys("password");
	
		login.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='action-confirmation']")));
	
		System.out.println("The message is : "+driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText());
		
		Thread.sleep(3000);
		
		driver.close();
			
		}

}
