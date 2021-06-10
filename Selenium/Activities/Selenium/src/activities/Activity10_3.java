package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_3 {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		driver.get("https://training-support.net/selenium/drag-drop");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		Actions action = new Actions(driver);

		WebElement ball = driver.findElement(By.id("draggable"));

		WebElement dropZone1 = driver.findElement(By.id("droppable"));

		WebElement dropZone2 = driver.findElement(By.id("dropzone2"));

		WebElement ballInZone1 = driver.findElement(By.xpath("//div[@id='droppable']/p"));

		action.dragAndDrop(ball, dropZone1).build().perform();

		Thread.sleep(2000);

		if(ballInZone1.getText().equalsIgnoreCase("Dropped!"))
		{
			System.out.println("Ball dropped in Dropzone 1");
		}
		else
		{
			System.out.println("Where is the ball");
		}

		action.dragAndDrop(ball, dropZone2).build().perform();

		// get the text.
		WebElement ballInZone2 = driver.findElement(By.xpath("//div[@id='dropzone2']/p"));

		if(ballInZone2.getText().equalsIgnoreCase("Dropped!"))
		{
			System.out.println("Ball dropped in Dropzone 2");
		}
		else
		{
			System.out.println("Where is the ball");
		}

		Thread.sleep(3000);
		
		driver.close();

	}

}
