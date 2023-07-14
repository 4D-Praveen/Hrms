package hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneOnOneFeedback {
	  //one on one feedback  -->incompleted
    @Test
    public void oneononefeedback() throws InterruptedException  {
	  
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://localhost/4dhrms/login");
		System.out.println("the current page title is " + driver.getTitle());
		// login -->4dhrms
		driver.findElement(By.id("emp_id")).sendKeys("a001");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
		Thread.sleep(2000);
		//click one on one feedback modules 
		driver.findElement(By.xpath("/html/body/div[2]/ul/li[5]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\'managerfeedback_wrapper\']/div[2]/button[1]/span/i")).click();
		//choose emp names 
		Thread.sleep(2000);
	    WebElement empnamesel=driver.findElement(By.xpath("//*[@id=\'select2-emp_id-container\']"));
	    empnamesel.click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[@title='M155/Sumathi M']")).click();
	    

    }        
}	




