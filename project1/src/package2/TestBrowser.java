package package2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium_lib\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium_libs\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.seleniumhq.org/");
		
		WebElement textfield = driver.findElement(By.id("q"));
		
		textfield.sendKeys("Selenium");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Download")).click();
		Thread.sleep(2000);
		
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		//driver.findElement(By.id("continents"))
		Select continents = new Select(driver.findElement(By.id("continents")));
		continents.selectByIndex(2);
		Thread.sleep(2000);
		continents.selectByVisibleText("Antartica");
		Thread.sleep(2000);
		WebElement testcheckbox = driver.findElement(By.id("profession-0"));
		if(!testcheckbox.isSelected()) {
			System.out.println("Selecting text box");
			testcheckbox.click();
		}
		Thread.sleep(2000);
		driver.close();
			
	}

}
