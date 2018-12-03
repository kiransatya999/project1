package package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mailcount 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://gmail.com/");
		WebDriverWait w= new WebDriverWait(driver,20);
		driver.manage().window().maximize();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.findElement(By.name("identifier")).sendKeys("ksskiran1989");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));		
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("9948552244**");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));		
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[4]")));
		driver.findElement(By.xpath("//*[@class='bBe']")).click();
		//Get expected count of mails in page
		int enoam=0;
		do
		{
			WebElement mbt=driver.findElement(By.xpath("(//table)[4]"));
			List<WebElement> mails=mbt.findElements(By.tagName("tr"));
			int nomp=mails.size();
			// All count of mails in page to total mails count
			enoam=enoam+nomp;
			// GO to next page
			try
			{
				if(driver.findElement(By.xpath("//*[@data-tooltip='Older']")).getAttribute("aria-disabled").equals("true"))
				{
					break;//terminate loop
				}
			}
			catch(Exception ex)
			{
				driver.findElement(By.xpath("//*[@data-tooltip='Older']")).click();
				Thread.sleep(5000);// to load next page
			}
		}while(2>1);
		//Get actual count from page
		String temp=driver.findElement(By.xpath("//*[@data-tooltip='Newer']/preceding::span[1]")).getText();
		int anoam=Integer.parseInt(temp);
		//Validation
		System.out.println(enoam+" "+anoam);
		if(enoam==anoam)
		{
			System.out.println("Gmail mails count test passed");
		}
		else
		{
			System.out.println("Gmail mails count test failed");
		}
		//Do logout
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		//close site
		driver.close();

	}

}
