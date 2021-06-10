package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9_1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		WebDriverWait wait = new WebDriverWait(driver,20);

		driver.get("https://training-support.net/selenium/selects");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		WebElement web = driver.findElement(By.xpath("//select[@id='single-select']"));
		
		Select sel = new Select(web);

		sel.selectByVisibleText("Option 2");
		
		sel.selectByIndex(3);

		sel.selectByValue("4");

		List<WebElement> list = driver.findElements(By.xpath("//select[@id='single-select']"));

		for(WebElement options : list)
		{
			System.out.println(options.getText());
		}
		
		driver.close();
	}

}
