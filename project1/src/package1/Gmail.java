package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","F:\\Test\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("https://accounts.google.com/ServiceLogin/identifier?passive=1209600&continue=https%3A%2F%2Faccounts.google.com%2Fb%2F0%2FAddMailService&followup=https%3A%2F%2Faccounts.google.com%2Fb%2F0%2FAddMailService&flowName=GlifWebSignIn&flowEntry=AddSession");
		d.findElement(By.name("identifier")).sendKeys("kiran.satya999");
		d.findElement(By.xpath("//*[@id='identifierNext']")).click();
		d.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/div")).sendKeys("9948552244//");
		
		

	}

}
