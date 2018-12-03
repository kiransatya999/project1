package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tours 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Kiran");
		driver.findElement(By.name("lastName")).sendKeys("Satya");
		driver.findElement(By.name("phone")).sendKeys("9948552244");
		driver.findElement(By.id("userName")).sendKeys("mail@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("RCPM");
		driver.findElement(By.name("address2")).sendKeys("RCPM");
		driver.findElement(By.name("city")).sendKeys("RCPM");
		driver.findElement(By.name("state")).sendKeys("RCPM");
		driver.findElement(By.name("postalCode")).sendKeys("533255");
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		s.selectByVisibleText("INDIA");
		driver.findElement(By.name("email")).sendKeys("kiran.satya999@gmail.com");
		driver.findElement(By.name("password")).sendKeys("9948552244");
		driver.findElement(By.name("confirmPassword")).sendKeys("9948552244");
		driver.findElement(By.name("register")).click();
		driver.close();
	}
	

}
