package hrms;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class reports {
	  @Test
      public static void brokenimageinHRMS() throws InterruptedException, IOException  {
 	  
 		WebDriverManager.chromedriver().setup();
 		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
 		driver.manage().window().maximize();
 		driver.get("http://localhost/4dhrms/login");
 		System.out.println("the current page title is " + driver.getTitle());
 		
 		// login -->4dhrms
 		driver.findElement(By.id("emp_id")).sendKeys("a001");
 		driver.findElement(By.name("password")).sendKeys("12345");
 		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
 		Thread.sleep(2000);
 		//Click --> reports 
 		driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/li[13]/a")).click();
 		Thread.sleep(2000);
 		//clicl reports --> employee
 		driver.findElement(By.xpath("/html/body/div[2]/ul/li[13]/div/div/a[2]")).click();
 		Thread.sleep(2000);
 		
 		//dashboard  
 		//Find links 
 		List<WebElement>images=driver.findElements(By.tagName("img"));
 		System.out.println("total HRMS Dashboard URL image Count is "+ images.size());
 		for (WebElement image : images) {
 			String imagesrc=image.getAttribute("src");
 			
 			try {
				URL url=new URL(imagesrc);
				URLConnection urlconnection=url.openConnection();
				HttpURLConnection httpurlconnection=(HttpURLConnection)urlconnection;
				httpurlconnection.setConnectTimeout(5000);
				httpurlconnection.connect();
				if (httpurlconnection.getResponseCode() == 200) {
					System.out.println(imagesrc + ">>" +httpurlconnection.getResponseCode()+ ">>" + httpurlconnection.getResponseMessage());
				}
				else {
				
					System.err.println(imagesrc + ">>" +httpurlconnection.getResponseCode()+ ">>" + httpurlconnection.getResponseMessage());
				    httpurlconnection.disconnect();
				    }} 
 		catch (Exception e) {
			  System.err.println(imagesrc);		 
			}	
 		}} 
      

}
