package package1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NestedIF 
{ 
	public static void main(String[] args) throws Exception
	{
		//create a html results file
		ExtentReports er=new ExtentReports("gmailloginres.html",false);
		ExtentTest et=er.startTest("Gmail Login Test");
		//Get test data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user id");
		String uid=sc.nextLine();
		System.out.println("Enetr user id criteria");
		String uidc=sc.nextLine();
		String pwd="";
		String pwdc="";
		if(uidc.equals("valid"))
		{
			System.out.println("Enter pwd");
			pwd=sc.nextLine();
			System.out.println("Enetr pwd criteria");
			pwdc=sc.nextLine();
		}
		//Launch site
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		
		//User id testing
		driver.findElement(By.name("identifier")).sendKeys(uid);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		NestedIF obj=new NestedIF();
		if(uid.length()==0)
		{
			try
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Enter an email')]")));
				et.log(LogStatus.PASS, "Blank UID test passed");
			}
			catch(Exception ex)
			{
				String x=obj.screenshot(driver);
				et.log(LogStatus.FAIL, "Blank UID test failed"+ex.getMessage()+et.addScreenCapture(x));
			}
		}
		else if(uidc.equals("invalid"))
		{
			try
			{
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'find your Google')])[2]")));
			et.log(LogStatus.PASS, "Invalid UID test passed");
			}
			catch(Exception ex)
			{
				String x=obj.screenshot(driver);
				et.log(LogStatus.FAIL, "Invalid UID test failed"+ex.getMessage()+et.addScreenCapture(x));
			}
		}
		else
		{
			try
			{
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			et.log(LogStatus.PASS, "Valid UID test passed");
			
			//password Testing
			
			driver.findElement(By.name("password")).sendKeys(pwd);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			if(pwd.length()==0)
			{
				try
				{
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enter a password']")));
					et.log(LogStatus.PASS, "Blank PWD test passed");
				}
				catch(Exception ex)
				{
					String x=obj.screenshot(driver);
					et.log(LogStatus.FAIL, "Blank PWD test failed"+ex.getMessage()+et.addScreenCapture(x));
				}
			}
			else if(pwdc.equals("invalid"))
			{
				try
				{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Wrong password')]")));
				et.log(LogStatus.PASS, "Invalid PWD test passed");
				}
				catch(Exception ex)
				{
					String x=obj.screenshot(driver);
					et.log(LogStatus.FAIL, "Invalid PWD test failed"+ex.getMessage()+et.addScreenCapture(x));
				}
			}
			else
			{
				try
				{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
				et.log(LogStatus.PASS, "Valid PWD test passed");
				}
				catch(Exception ex)
				{
					String x=obj.screenshot(driver);
					et.log(LogStatus.FAIL, "Valid PWD test failed"+ex.getMessage()+et.addScreenCapture(x));
				}
			}
			
			}
			catch(Exception ex)
			{
				String x=obj.screenshot(driver);
				et.log(LogStatus.FAIL, "Valid UID test failed"+ex.getMessage()+et.addScreenCapture(x));
			}
		}
		//close site
		driver.close();
		//save results
		er.endTest(et);
		er.flush();
	}
	public String screenshot(ChromeDriver driver) throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date d=new Date();
		String fname=sf.format(d)+".png";
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File(fname);
		FileHandler.copy(src, dest);
		return(fname);
	}
}
