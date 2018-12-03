package package2;

import java.awt.TextField;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_libs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://w3softech.com:2096/logout/?locale=en");
		WebElement textfield = driver.findElement(By.id("user"));
		textfield.sendKeys("sivakiran.k@w3softech.com");
		WebElement textfield1 = driver.findElement(By.id("pass"));
		textfield1.sendKeys("");
		driver.findElement(By.id("login_submit")).click();
		
		driver.findElement(By.xpath("//a[@id='rcmbtn107']")).click();
		
		//Thread.sleep(5000);
		driver.findElement(By.id("lblLogout")).click();
		
		//driver.close();
	}

}
