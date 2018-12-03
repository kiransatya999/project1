package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mercurytravels 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mercurytravels.co.in");
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Flights")).click();
		try
		{	
			WebElement e=driver.findElement(By.name("tripType"));
			if(e.isDisplayed())
			{
				System.out.println("Displayed");
				if(e.isEnabled())
				{
					System.out.println("Enabled");
					if(e.isSelected())
					{
						System.out.println("Selected");
					}
					else
					{
						System.out.println("Not selected");
					}
				}
				else
				{
					System.out.println("Disabled");
				}
			}
			else
			{
				System.out.println("Hidden");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		driver.close();
	}

}
