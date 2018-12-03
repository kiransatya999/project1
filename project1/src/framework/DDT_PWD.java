package framework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDT_PWD 
{
	public static void main(String[] args) throws Exception
	{
		//Get test data
		ArrayList<String> pwds=new ArrayList<String>();
		ArrayList<String> cs=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter test data size");
		int noi=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noi;i++)
		{
			System.out.println("Enter PWD");
			pwds.add(sc.nextLine());
			System.out.println("Enter UID criteria");
			cs.add(sc.nextLine());
		}
		// Create html reports file
		ExtentReports er=new ExtentReports("gmailddt.html",false);
		ExtentTest et=er.startTest("Gmail PWD testing");
		//Data driven testing
		ChromeDriver driver=null;
		
		for(int i=0;i<noi;i++)
		{
			try
			{
				System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("https://www.gmail.com");
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
				driver.manage().window().maximize();
				//Enter UID and click next
				driver.findElement(By.name("identifier")).sendKeys("kiran.satya999");
				w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(5000);
				
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
				driver.manage().window().maximize();
				//Enter UID and click next
				driver.findElement(By.name("password")).sendKeys(pwds.get(i));
				w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(5000);
				//Validations
				if(pwds.get(i).length()==0 && driver.findElement(By.xpath("//*[text()='Enter a password']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank PWD Test passed");					
				}
				else if(cs.get(i).equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Invalid PWD test Passed");
				}
				else if(cs.get(i).equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Valid PWD test passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					et.log(LogStatus.FAIL, "PWD Test failed"+et.addScreenCapture(fname));
				}
				//close site
				driver.close();
			}
			catch(Exception ex)
			{
				driver.close();
				et.log(LogStatus.ERROR, ex.getMessage());
			}
		}
	// save result
		er.endTest(et);
		er.flush();
	}
}



