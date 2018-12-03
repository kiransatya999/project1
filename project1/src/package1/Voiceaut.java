package package1;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Voiceaut 
{
	public static void main(String[] args) throws Exception
	{
//		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.co.in");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your text");
		String x=sc.nextLine();
//		System.setProperty("mbrola.base", "C:\\Selenium\\mbrola");
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("kevin");
		v.allocate();
		v.speak(x);
		v.allocate();
	}
}
