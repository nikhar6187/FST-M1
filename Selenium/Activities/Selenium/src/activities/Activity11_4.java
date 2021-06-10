package activities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get("https://www.training-support.net/selenium/tab-opener");

		System.out.println("Page title is: " + driver.getTitle());

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentWindow);

		driver.findElement(By.id("launcher")).click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("All window handles: " + allWindowHandles);
		Iterator<String> i1=allWindowHandles.iterator();
		String newTab = null;
		while(i1.hasNext())
		{
			newTab = i1.next();
			
			if(!parentWindow.equalsIgnoreCase(newTab))
			{
				driver.switchTo().window(newTab);
				Thread.sleep(3000);
				
			}
		}

		System.out.println("The title of new tab is :" +driver.getTitle());

		String newTabMsg = driver.findElement(By.xpath("//div[@class='sub header']")).getText(); 
		
		System.out.println("Message on new tab is : "+newTabMsg);
		
		// CLick on the Open Another One! button.
		driver.findElement(By.id("actionButton")).click();

		// Wait until another tab opens.
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));

		allWindowHandles = driver.getWindowHandles();
		System.out.println("All window handles: " + allWindowHandles);
		Iterator<String> i2 = allWindowHandles.iterator();
		String newTabWindow=null;
		while(i2.hasNext())
		{
			newTabWindow = i2.next();
			
			if(!(parentWindow.equalsIgnoreCase(newTabWindow)&&(newTab.equalsIgnoreCase(newTabWindow))))
			{
				driver.switchTo().window(newTabWindow);
			}
		}

		System.out.println("New tab handle: " + driver.getWindowHandle());

		wait.until(ExpectedConditions.titleIs("Newtab2"));

		System.out.println("New Tab Title is: " + driver.getTitle());

		String newTabText = driver.findElement(By.xpath("//div[@class='sub header']")).getText();        
		System.out.println("Message on new tab is : "+newTabText);

		driver.quit();	
		
	}

}
