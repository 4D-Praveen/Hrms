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

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenIinks {

    //find how many broken links in hrms 
    @Test
    public void brokenlinksHRMS() throws InterruptedException, IOException  {
	  
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://192.168.2.193/4dhrms/login");
		System.out.println("the current page title is " + driver.getTitle());
		// login -->4dhrms
		driver.findElement(By.id("emp_id")).sendKeys("a001");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
		Thread.sleep(2000);
		
		//Find links 
		List<WebElement>Links=driver.findElements(By.tagName("a"));
		System.out.println("total Dashboard HRMS link Count is "+ Links.size());
		
		for (WebElement link : Links) {
		String linkurl=link.getAttribute("href");
		URL url=new URL(linkurl);
		URLConnection urlconnection=url.openConnection();
		HttpURLConnection httpurlconnection=(HttpURLConnection)urlconnection; 
		httpurlconnection.setConnectTimeout(5000);
		httpurlconnection.connect();
		if (httpurlconnection.getResponseCode() == 200) {
			System.out.println(linkurl + " - "  +httpurlconnection.getResponseMessage() );
			
		} else {
			System.err.println(linkurl + " - " + httpurlconnection.getResponseCode() );

		httpurlconnection.disconnect();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[8]/div/div/div/div/div[1]/div/div[1]/div/div/div/div/div[1]/div[3]/button")).click();
        Thread.sleep(5000);
		driver.quit();
		}} 
		// popopu closer
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[8]/div/div/div/div/div[1]/div/div[1]/div/div/div/div/div[1]/div[3]/button")).click();
		
}    
  
}
