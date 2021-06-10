package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		driver.get("https://www.training-support.net/selenium/input-events");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		WebElement cube = driver.findElement(By.id("wrapD3Cube"));
		
		Actions builder = new Actions(driver);
		
		builder.click().build().perform();
		
		Thread.sleep(3000);
		String singleClickValue = driver.findElement(By.xpath("//div[@id='D3Cube']//div[@class='active']/h1")).getText();
		System.out.println("The value on front is : "+singleClickValue);
		
		builder.doubleClick(cube).build().perform();
		
		Thread.sleep(4000);
		String doubleClickValue = driver.findElement(By.xpath("//div[@id='D3Cube']//div[@class='active']/h1")).getText();
		System.out.println("The value on front is : "+doubleClickValue);
		
		builder.contextClick().build().perform();

		Thread.sleep(2000);
	
		String rightClickValue = driver.findElement(By.xpath("//div[@id='D3Cube']//div[@class='active']/h1")).getText();
		System.out.println("The value on front is : "+rightClickValue);

		
		driver.close();
		
	}

}
