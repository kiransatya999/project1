package package1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Voiceaut2 
{
	public static void main(String[] args) throws Exception
	{
		//Get text
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your text");
		String x=sc.nextLine();
		//Launch site 
		ChromeOptions co=new ChromeOptions();
		co.addArguments("use-fake-ui-for-media-stream=1");
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(co);
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("gsri_ok0")));
		//Click on mic icon
		driver.findElement(By.id("gsri_ok0")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("spch")));
		//Send voice using FreeTTS+Mbrola+VBCable driver
		
		VoiceManager vm=VoiceManager.getInstance();
		System.setProperty("mbrola.base","C:\\Selenium\\mbrola");
		Voice v=vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate(); 
	}
}

