package package2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Browser1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				//System.setProperty("webdriver.gecko.driver", "C:\\Selenium_libs\\geckodriver.exe");
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium_libs\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				//driver.get("http://www.seleniumhq.com/");
				//Thread.sleep(2000);
				
				//WebElement textfield = driver.findElement(By.id("q"));
				//textfield.sendKeys("Selenium");
				//Thread.sleep(2000);
				//driver.findElement(By.linkText("Download")).click();
				//Thread.sleep(2000);
				
				driver.get("http://toolsqa.com/automation-practice-form/");
				//Thread.sleep(2000);
				WebElement fname = driver.findElement(By.name("firstname"));
				fname.sendKeys("Kiran");
				WebElement lname = driver.findElement(By.name("lastname"));
				lname.sendKeys("Satya");
				driver.findElement(By.id("sex-0")).click();
				driver.findElement(By.id("exp-1")).click();
				WebElement date = driver.findElement(By.id("datepicker"));
				date.sendKeys("02-01-2018");
				driver.findElement(By.id("profession-1")).click();
				driver.findElement(By.id("tool-1")).click();
				driver.findElement(By.id("tool-2")).click();
				Select continents = new Select(driver.findElement(By.id("continents"))); 
				continents.selectByIndex(3);
				Thread.sleep(2000);
				continents.selectByVisibleText("Antartica");
				driver.findElement(By.linkText("Test File to Download")).click(); 
				Select command = new Select(driver.findElement(By.id("selenium_commands")));
				//command.selectByVisibleText("Switch Commands");
				//Thread.sleep(2000);
				command.selectByIndex(3);
				Thread.sleep(2000);
				//driver.findElement(By.xpath("//*[@id='selenium_commands']/option[3]")).click();
				driver.findElement(By.id("submit")).click();
				
				//driver.close();

	}

}
