package framework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DDT_JXL_W2S 
{
	public static void main(String[] args) throws Exception 
	{
		//Open .xls file
		File f=new File("w2sms.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);
		int nour=rsh.getRows();
		//open excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);
		//Set color, font to columns
		WritableFont wf=new WritableFont(WritableFont.TIMES,12,WritableFont.BOLD);
		wf.setColour(Colour.BLUE);
		WritableCellFormat wcf=new WritableCellFormat(wf);
//		wcf.setAlignment(Alignment.JUSTIFY);
//		wcf.setAlignment(Alignment.CENTRE);
//		//Set font style, colour and alignment for test passed
		WritableFont wf1=new WritableFont(WritableFont.TIMES,12);
		wf1.setColour(Colour.GREEN);
		WritableCellFormat wcf1=new WritableCellFormat(wf1);
//		wcf1.setAlignment(Alignment.CENTRE);
		//Set font style, colour and alignment for test failed
		WritableFont wf2=new WritableFont(WritableFont.TIMES,12);
		wf2.setColour(Colour.RED);
		WritableCellFormat wcf2=new WritableCellFormat(wf2);
//		wcf2.setAlignment(Alignment.CENTRE);
		//create result column
		ChromeDriver driver=null;
		int nouc=rsh.getColumns();
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		Date d=new Date();
		String x=sf.format(d);
		Label l=new Label(nouc,0,x);
		wsh.addCell(l);
		for(int i=1; i<nour;i++)
		{
			String mbno=rsh.getCell(0,i).getContents();
			String mbnoc=rsh.getCell(1,i).getContents();
			String pwd=rsh.getCell(2,i).getContents();
			String pwdc=rsh.getCell(3,i).getContents();
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
				driver.findElement(By.name("mobileNo")).sendKeys(mbno);
				driver.findElement(By.name("password")).sendKeys(pwd);
				driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
				//Validations
				if(mbno.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
					Label l1=new Label(nouc,i,"Blank mobile number test passed");
					wsh.addCell(l1);
				}
				else if(mbno.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					Label l2=new Label(nouc,i,"wrong mobile number test passed");
					wsh.addCell(l2);
				}
				else if(pwd.length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
				{
					Label l3=new Label(nouc,i,"Blank pwd test passed");
					wsh.addCell(l3);
				}
				else if(mbnoc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'not register with us')])[1]")).isDisplayed())
				{
					Label l4=new Label(nouc,i,"invalid mobile number test passed");
					wsh.addCell(l4);
				}
				else if(mbnoc.equalsIgnoreCase("valid") && pwdc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
				{
					Label l5=new Label(nouc,i,"invalid pwd test passed");
					wsh.addCell(l5);
				}
				else if(mbnoc.equalsIgnoreCase("valid") && pwdc.equalsIgnoreCase("valid"))
				{
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[contains(text(),'Instant Delivery')]")).isDisplayed();
					Label l6=new Label(nouc,i,"Valid Login test passed");
					wsh.addCell(l6);
				}
				else
				{
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					Label l7=new Label(nouc,i,"Login test failed"+(fname));
					wsh.addCell(l7);
				}
				driver.close();
			}
			catch(Exception ex)
			{
				driver.close();
				Label l8=new Label(nouc,i,ex.getMessage());
				wsh.addCell(l8);
			}
		}
		wwb.write();
		rwb.close();
		wwb.close();
	}
}

