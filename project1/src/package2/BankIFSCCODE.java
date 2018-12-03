package package2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankIFSCCODE {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_libs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get("https://www.ifsccodebank.com/");
		
		Select bank = new Select(driver.findElement(By.id("BC_ddlBank")));
		bank.selectByVisibleText("State Bank Of India");
		
		Select state = new Select(driver.findElement(By.id("BC_ddlState")));
		state.selectByVisibleText("Andhra Pradesh");
		
		Select district = new Select(driver.findElement(By.id("BC_ddlDistrict")));
		district.selectByVisibleText("East Godavari");
		
		Select city= new Select(driver.findElement(By.id("BC_ddlCity")));
		city.selectByVisibleText("Ramachandrapuram");
		
		Select branch = new Select(driver.findElement(By.id("BC_ddlBranch")));
		branch.selectByVisibleText("Ramachandra Puram (SBIN0000907)");
		
		driver.close();


	}

}
