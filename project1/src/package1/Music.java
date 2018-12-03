package package1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Music {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a artist name to search");
		String name=sc.nextLine();
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,20);
		driver.get("https://play.google.com/music/listen#/home");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Sign in'])[3]")));
		driver.findElement(By.xpath("(//*[text()='Sign in'])[3]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.findElement(By.name("identifier")).sendKeys("kiran.satya999");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));		
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("9948552244++");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));		
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input']")));
		driver.findElement(By.xpath("//*[@id='input']")).sendKeys(name+Keys.ENTER);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='details-inner'])[1]")));
		driver.findElement(By.xpath("(//div[@class='details-inner'])[1]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='buttonContent'])[1]")));	
		driver.findElement(By.xpath("(//*[@id='buttonContent'])[1]")).click();
		//driver.findElement(By.xpath("(//*[@class='play-button-container'])[1]")).click();
		Thread.sleep(30000);
		driver.close();
	}

}
