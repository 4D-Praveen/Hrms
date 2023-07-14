package hrms;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

 

public class Test {
	@org.testng.annotations.Test
	public void google() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

	   driver.get("http://google.com");
	    System.out.println(driver.getTitle());
	    
	    if (driver.getTitle().equals("Google")) {
	    	System.out.println("is correct");
			
		} else {
			System.out.println("is not correct");

		}

 
	}}

