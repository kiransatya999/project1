package Robot;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Winmenu
{
	public static void main(String[] args) throws Exception 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("http://www.seleniumhq.org");
		WebDriverWait w=new WebDriverWait(d,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		//Rt click on link
		WebElement e=d.findElement(By.linkText("Download"));
		Actions a=new Actions(d);
		a.contextClick(e).build().perform();
		Thread.sleep(2000);
		//Automate win-menu(Java Robot(JDK))
		Robot r=new Robot();
		for(int i=1;i<=2;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
}
