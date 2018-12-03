package package2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDFCNetbanking {
	static WebDriver driver = null;

		public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(null);
		driver.findElement(By.xpath("//button[@class='q4UYxb']")).click();
		driver.findElement(By.xpath("//*[@id='view_container']/form/div[2]/div/div/div/ul[1]/li[1]/div/div[2]/div/svg/path[1]")).click();
		
		//driver.findElement(By.linkText("continue")).click();
	}

	

}
