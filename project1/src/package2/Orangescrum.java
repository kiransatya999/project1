package package2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Orangescrum 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.orangescrum.com/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath("(//*[contains(text(),'Features')])[1]"));
		a.moveToElement(e1).build().perform();
		WebElement e2=driver.findElement(By.xpath("(//*[text()='Task Management'])[2]"));
		a.moveToElement(e2).click().build().perform();
		Thread.sleep(2000);
		//driver.findElement(By.linkText("Task Management")).click();
	}

}
