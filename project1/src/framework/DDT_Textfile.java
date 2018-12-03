package framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDT_Textfile 
{
	public static void main(String[] args) throws Exception 
	{
		//get text from HDD
		File f=new File("w2sms.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		//Extent reports
		ExtentReports er=new ExtentReports("w2smsddt.html",false);
		ExtentTest et=er.startTest("Way2SMS Login Testing");
		//DDT
		ChromeDriver driver=null;
		String l="";
		while((l=br.readLine())!=null)
		{
			String[] p=l.split(",");
			try
			{
				//Launch site
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://www.way2sms.com");
				driver.manage().window().maximize();
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
				//Login to site
				driver.findElement(By.name("mobileNo")).sendKeys(p[0]);
				driver.findElement(By.name("password")).sendKeys(p[2]);
				driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
				//Validations
				if(p[0].length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Blank mobile number test passed");
				}
				else if(p[0].length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Wrong mobile size test passed");
				}
				else if(p[2].length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Blank PWD test passed");
				}
				else if(p[1].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
				{
					et.log(LogStatus.PASS, "invalid mobile number test passed");
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
				{
					et.log(LogStatus.PASS, "invalid PWD test passed");
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("valid"))
				{
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[contains(text(),'Instant Delivery')]")).isDisplayed();
					et.log(LogStatus.PASS, "Valid Login test passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					et.log(LogStatus.FAIL, "Login test failed"+et.addScreenCapture(fname));
				}
				driver.close();
			}
			catch(Exception ex)
			{
				driver.close();
				et.log(LogStatus.ERROR, ex.getMessage());
			}
		}
		//save results
		er.endTest(et);
		er.flush();
	}
}
