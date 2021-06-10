package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		WebElement confirmation = driver.findElement(By.id("confirm"));
		
		confirmation.click();
		
		Thread.sleep(3000);
		
		Alert alertAccept = driver.switchTo().alert();
		
		String text = alertAccept.getText();
	
		System.out.println("The text on alert pop-up is : "+text);
		
		alertAccept.accept();
		
		// Click on Confirmation Alert button.
		confirmation.click();

		Thread.sleep(3000);

		Alert alertDismiss = driver.switchTo().alert();

		text = alertDismiss.getText();

		System.out.println("The text on alert pop-up is : "+text);

		alertDismiss.dismiss();

		Thread.sleep(3000);
		
		driver.close();

	}

}
