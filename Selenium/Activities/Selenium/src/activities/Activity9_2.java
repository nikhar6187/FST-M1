package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9_2 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	

		driver.get("https://training-support.net/selenium/selects");
		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The title is : "+title);

		WebElement web = driver.findElement(By.xpath("//select[@id='multi-select']"));
		
		Select sel = new Select(web);
		
		if(sel.isMultiple())
		{
		
			sel.selectByVisibleText("Javascript");
			sel.selectByValue("node");
			sel.selectByIndex(5);
			sel.selectByIndex(6);
			sel.selectByIndex(7);
			sel.deselectByValue("node");
			sel.deselectByIndex(7);
			

			WebElement firstSel = sel.getFirstSelectedOption();
			System.out.println("First selected option is : "+firstSel.getText());

			List<WebElement> selectedOption = sel.getOptions();
			for(WebElement item : selectedOption)
			{
				if(item.isSelected())
					System.out.println(item.getText());
			}

			sel.deselectAll();				
		}
		
		Thread.sleep(5000);
		
		driver.close();

	}

}
