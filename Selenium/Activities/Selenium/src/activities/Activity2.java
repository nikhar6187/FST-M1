package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		driver.get("https://www.training-support.net");

		Thread.sleep(4000);
	
		System.out.println("The title is : "+driver.getTitle());

		WebElement withId = driver.findElement(By.id("about-link"));
		System.out.println("The Id  : "+withId.getText());

		WebElement withClassName = driver.findElement(By.className("green"));
		System.out.println("The class name  : "+withClassName.getText());

		WebElement withLinkText = driver.findElement(By.linkText("About Us"));
		System.out.println("The Link Text  : "+withLinkText.getText());
		
		WebElement withCss = driver.findElement(By.cssSelector("a#about-link"));
		System.out.println("The CSS Selector  : "+withCss.getText());
			
		driver.close();
		
		
	}

}
