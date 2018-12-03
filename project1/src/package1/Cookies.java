package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cookies {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.orangescrum.com/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		WebElement e=driver.findElement(By.xpath("(//*[contains(text(),'Features')])[1]"));
		a.moveToElement(e).build().perform();
		Thread.sleep(5000);
		
		if(driver.manage().getCookies()!=null)
		{
			System.out.println("Cookies present");
		}
		else
		{
			System.out.println("Cookies not present");
		}
		driver.close();
	}

}
