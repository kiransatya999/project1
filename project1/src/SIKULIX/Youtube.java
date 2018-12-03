package SIKULIX;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class Youtube 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,20);
		driver.get("https://www.youtube.com");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		//Search for video
		driver.findElement(By.id("search")).sendKeys("abdulkalam sir speeches");
		driver.findElement(By.xpath("(//*[@aria-label='Search'])[3]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Kalam in European Parliament')])[1]")));
		//start video
		driver.findElement(By.xpath("(//*[contains(text(),'Kalam in European Parliament')])[1]")).click();
		Thread.sleep(5000);
		//skip ad if exists
		Screen s=new Screen();
		if(s.exists("Skipad.png")!=null)
		{
			s.click("Skipad.png");
		}

	}

}
