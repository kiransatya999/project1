package package2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_libs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		 driver.get("http://demo.guru99.com/test/delete_customer.php");			
 		
	      	
	        driver.findElement(By.name("cusid")).sendKeys("53920");					
	        driver.findElement(By.name("submit")).submit();			
	        
	       Alert alert = (Alert) driver.switchTo().alert();		
	          
	        String alertMessage= driver.switchTo().alert().getText();		
	        
	        System.out.println(alertMessage);	
	        Thread.sleep(5000);
	        	
	        alert.accept();		
		
	}

	private void accept() {
		// TODO Auto-generated method stub
		
	}

}
