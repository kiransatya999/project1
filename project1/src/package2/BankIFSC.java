package package2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankIFSC {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_lib\\drivers\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Selenium_lib\\drivers\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get("https://www.ifsccodebank.com/");
		
		Select bank = new Select(driver.findElement(By.id("BC_ddlBank")));
		bank.selectByVisibleText("Bank Of India");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("BC_ddlState2")));
		
		Thread.sleep(2000);
	}

}
