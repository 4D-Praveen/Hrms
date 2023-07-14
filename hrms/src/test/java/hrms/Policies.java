package hrms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Policies {
	//HR Desk --> Policies sample test p4p policies --> random test one policies  --> completed
			@Test
			public void verifypolicy() throws InterruptedException {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options= new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				WebDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("http://localhost/4dhrms/login");
				System.out.println("the current page title is " + driver.getTitle());
				// login -->4dhrms
				driver.findElement(By.id("emp_id")).sendKeys("a001");
				driver.findElement(By.name("password")).sendKeys("12345");
				driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
				//click hr desk --> policy
				driver.findElement(By.xpath("/html/body/div[2]/ul/li[2]/a/span")).click();
				driver.findElement(By.xpath("//*[@id=\'accordionSidebar1\']")).click();
				// view --> HR Policy   
				driver.findElement(By.xpath("//*[@id=\"hr_policy\"]/div/a[1]/div[1]")).click();
				//click ->p4p policy
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div/div[1]/div/a[1]/div[1]")).click();
				Thread.sleep(3000);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("window.scrollBy(0,400)");
			    Thread.sleep(3000);
				//next click--> page2 
				driver.findElement(By.xpath("//*[@id=\'next-page\']")).click();
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
			    js1.executeScript("window.scrollBy(0,-400)");
			    Thread.sleep(3000);
			    js1.executeScript("window.scrollBy(0,400)");
			    //next click--> page3
			    driver.findElement(By.xpath("//*[@id=\'next-page\']")).click();
			    JavascriptExecutor js2 = (JavascriptExecutor) driver;
			    js2.executeScript("window.scrollBy(0,-400)");
			    Thread.sleep(3000);
			    js2.executeScript("window.scrollBy(0,400)");
			    
			    //next click--> page4
			    driver.findElement(By.xpath("//*[@id=\'next-page\']")).click();
			    JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    js3.executeScript("window.scrollBy(0,-280)");
			    Thread.sleep(3000);
			    js3.executeScript("window.scrollBy(0,280)");
			    System.out.println("all page is open properly");
			    //close current wdw
			    driver.close();
			}

}
