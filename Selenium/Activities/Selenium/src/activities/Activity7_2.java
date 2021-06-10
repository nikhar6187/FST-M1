package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		WebElement uname = driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
		WebElement password = driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
		WebElement cpassword = driver.findElement(By.xpath("//label[contains(text(),'Confirm')]/following-sibling::input"));
		WebElement email = driver.findElement(By.xpath("//input[starts-with(@class,'email')]"));
		
		uname.sendKeys("admin");
		password.sendKeys("password");
		cpassword.sendKeys("password");
		email.sendKeys("email@abc.com");

		WebElement signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
		signUp.click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='action-confirmation']"))));
		
		String text = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
	
		System.out.println("The message is : "+text);
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
