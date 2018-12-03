package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Unreadmailcount
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,20);
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
		//close notification
		driver.findElement(By.xpath("//*[@class='bBe']")).click();
		//Get count of unread mails via pagination
		int enourm=0;
		do
		{
			//Get count of unread mails from the page
			int x=driver.findElement(By.xpath("(//table)[4]/tbody")).findElements(By.tagName("tr")).size();
		//	int y=Integer.parseInt(x);
			System.out.println(x);
			for(int i=1;i<=x;i++)
			{
				WebElement e=driver.findElement(By.xpath("(//table)[4]/tbody/tr["+i+"]/td[5]/div[1]"));
				driver.executeScript("var v=arguments[0].textContent; window.alert(v);",e);
				String x1=driver.switchTo().alert().getText();
				if(x1.contains("unread,"))
				{
					enourm=enourm+1;
				}
				driver.switchTo().alert().dismiss();
			}
			// Go to next page
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
		System.out.println(enourm);
		//Get actual count of unread mails
		
		String a=driver.findElement(By.xpath("//*[contains(@data-tooltip,'Inbox')]")).getAttribute("data-tooltip");
		String b=a.substring(7, a.length()-1);
		int anourm=Integer.parseInt(b);
		System.out.println(anourm);
		//validation
		if(enourm==anourm)
		{
			System.out.println("Unread mail count test passed");
		}
		else
		{
			System.out.println("Unread mail count test failed");
		}
		//Do Logout
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		//close site
		driver.close();
	}
}
