package package2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.className("gb_P")).click();
		//driver.findElement(By.className("whsOnd zHQkBf"));
		WebElement textfield = driver.findElement(By.xpath("//input[@type='email'][@id='identifierId']"));
		textfield.sendKeys("kiran.satya999");
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		Thread.sleep(2000);
		WebElement textfield1 = driver.findElement(By.xpath("//input[@type='password']"));
		textfield1.sendKeys("");
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		Thread.sleep(5000);
		WebElement mail = driver.findElement(By.xpath("//textarea[@id=':og']"));
		mail.sendKeys("kiran.satya999@gmail.com");
		WebElement subject = driver.findElement(By.xpath("//input[@id=':nz']"));
		subject.sendKeys("Test");
		driver.findElement(By.xpath("//div[@id=':np']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/?tab=wm#inbox']")).click();
		//Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id=':3u']/div")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='ar9 T-I-J3 J-J5-Ji']")).click();
		Thread.sleep(5000);
	}

}
