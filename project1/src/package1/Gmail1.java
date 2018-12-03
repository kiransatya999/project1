package package1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail1 {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1st word to search and delete");
		String x=sc.nextLine();
		System.out.println("Enter 2nd word to search and delete");
		String y=sc.nextLine();
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://gmail.com/");
		WebDriverWait w= new WebDriverWait(driver,20);
		driver.manage().window().maximize();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.findElement(By.name("identifier")).sendKeys("kiran.satya999");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));		
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("9948552244++");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));		
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search mail']")));		
		driver.findElement(By.xpath("//*[@aria-label='Search mail']")).sendKeys(x+Keys.ENTER);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-label='Select'])[2]/div/div")));		
		driver.findElement(By.xpath("(//*[@aria-label='Select'])[2]/div/div")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Unread'])[2]")));		
		driver.findElement(By.xpath("(//*[text()='Unread'])[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Delete']")));		
		driver.findElement(By.xpath("//*[@aria-label='Delete']")).click();
		driver.findElement(By.xpath("//*[contains(@data-tooltip,'Inbox')]/div/div[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search mail']")));		
		driver.findElement(By.xpath("//*[@aria-label='Search mail']")).sendKeys(y+Keys.ENTER);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-label='Select'])[2]/div/div")));		
		driver.findElement(By.xpath("(//*[@aria-label='Select'])[2]/div/div")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Unread'])[2]")));		
		driver.findElement(By.xpath("(//*[text()='Unread'])[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Delete']")));		
		driver.findElement(By.xpath("//*[@aria-label='Delete']")).click();
		
		
		
		
		
		
	}

}
