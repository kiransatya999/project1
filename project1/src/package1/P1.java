package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\Test\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("http://newtours.demoaut.com/");
		d.findElement(By.linkText("REGISTER")).click();
		d.findElement(By.name("firstName")).sendKeys("Kiran");
		d.findElement(By.name("lastName")).sendKeys("Satya");
		d.findElement(By.name("phone")).sendKeys("9876543210");
		d.findElement(By.name("userName")).sendKeys("kssk@gmail.com");
		d.findElement(By.name("address1")).sendKeys("Flat 102");
		d.findElement(By.name("address2")).sendKeys("Pragathi Nagar");
		d.findElement(By.name("city")).sendKeys("Hyderabad");
		d.findElement(By.name("state")).sendKeys("Telangana");
		d.findElement(By.name("postalCode")).sendKeys("500090");
		Thread.sleep(3000);
//		WebElement e=new WebElement();
//		Select s=new Select(e);
		d.findElement(By.name("email")).sendKeys("kssk45");
		d.findElement(By.name("password")).sendKeys("password");
		d.findElement(By.name("confirmPassword")).sendKeys("password");
		d.findElement(By.name("register")).click();
		d.close();
		

	}

}
