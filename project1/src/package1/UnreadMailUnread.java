package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UnreadMailUnread 
{
	public static void main(String[] args) throws Exception
	{
		//Save results in html using extent reports
		ExtentReports er=new ExtentReports("gmails count.html",false);
		ExtentTest et=er.startTest("Gmail unread mails count testing");
		//Launch Gmail Site
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,30);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.findElement(By.name("identifier")).sendKeys("kiran.satya999");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("9948552244++");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[4]")));
		//close notification dailog
		//driver.findElement(By.xpath("//div[@class='bBe']")).click();
		//get expected count of unread mails in page
		int exmails=0;
		do
		{
			//get count of unread mails in current page
			int x=driver.findElement(By.xpath("(//table)[4]/tbody")).findElements(By.tagName("tr")).size();
			for(int i=1;i<=x;i++)
			{
				WebElement e=driver.findElement(By.xpath("(//table)[4]/tbody/tr["+i+"]/td[5]/div[1]"));
				driver.executeScript("var v=arguments[0].textContent; window.alert(v);", e);
				String z=driver.switchTo().alert().getText();
				if(z.contains("unread,"))
				{
					exmails=exmails+1;
				}
				driver.switchTo().alert().dismiss();
			}
			//goto next page
			try
			{
				if(driver.findElement(By.xpath("//div[@data-tooltip='Older']")).getAttribute("aria-disabled").equals("true"))
				{
					break;
				}
			}
			catch(Exception ex)
			{
				driver.findElement(By.xpath("//div[@data-tooltip='Older']")).click();
				//wait for loading...
				Thread.sleep(2000); 
				//if displayed
				if(driver.findElement(By.xpath("//span[text()='Loading...']")).isDisplayed())
				{
					//wait until invisible
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Loading...']")));
				}
			}
		}while(2>1); //infinite loop
		//get actual count from page
		String temp=driver.findElement(By.xpath("//div[@class='bsU']")).getText();
		//if "," character present replace with null (nothing but removing) 
		String x=temp.replaceAll(",", "");
		int acmails=Integer.parseInt(x);
		System.out.println(exmails+ " " +acmails);
		if(acmails==exmails)//validation
		{
			et.log(LogStatus.PASS, "Gmail unread mails counting test passed");
		}
		else
		{
			et.log(LogStatus.FAIL,"Gmail unread mails counting test failed");
		}
		//Do logout
		driver.findElement(By.xpath("//*[contains(@class,'gbii')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		//Close site
		driver.close();
		//Save results
		er.endTest(et);
		er.flush();

	}

}
