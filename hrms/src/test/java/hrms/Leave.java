package hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leave {
	// leave module 
    @Test
       public void applyleave() throws InterruptedException  {
  	  
  		WebDriverManager.chromedriver().setup();
  		ChromeOptions options= new ChromeOptions();
  		options.addArguments("--remote-allow-origins=*");
  		WebDriver driver = new ChromeDriver(options);
  		driver.manage().window().maximize();
  		driver.get("http://localhost/4dhrms/login");
  		System.out.println("the current page title is " + driver.getTitle());
  		// login -->4dhrms apply WFM
  		driver.findElement(By.id("emp_id")).sendKeys("a001");
  		driver.findElement(By.name("password")).sendKeys("12345");
  		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
  		Thread.sleep(2000);
  		//Click Leave Moduls 
  		driver.findElement(By.xpath("/html/body/div[2]/ul/li[3]/a/span")).click();
  		Thread.sleep(3000);
  		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/button[2]/span")).click();
  		Thread.sleep(2000);
  		//choose category 
  		//user-->1 apply Full-day in admin side 
  		WebElement cate=driver.findElement(By.id("category")); 
  		Select selcategory= new Select(cate);
  		selcategory.selectByIndex(1);
  		Thread.sleep(2000);
  		//choose type -->WFM
  		WebElement leavetype=driver.findElement(By.id("type"));
  		Select selectype=new Select(leavetype);
  		selectype.selectByIndex(3);
  		Thread.sleep(2000);
  		//start date and end date selection
  		driver.findElement(By.xpath("//*[@id=\'date_start\']")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("/html/body/div[6]/div[1]/table/tbody/tr[4]/td[4]")).click();
  		//end date selection
  		driver.findElement(By.xpath("//*[@id=\'date_end\']")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("/html/body/div[6]/div[1]/table/tbody/tr[4]/td[5]")).click();
  		//reason
  		driver.findElement(By.id("leave_reason")).sendKeys("test not consoider");
  		Thread.sleep(2000);
  		driver.findElement(By.id("addBtn")).click();
  		Thread.sleep(3000);

  		//sucessfully close popup
  	  	driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[5]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click(); 
  	    Thread.sleep(2000);
  	  	System.out.println("WFH leave added sucessfully");
		driver.findElement(By.xpath("//*[@id=\'page-top\']/div[6]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click(); 
  	    
  		//logout
  		driver.findElement(By.xpath("/html/body/div[2]/div/div/nav/ul/li[6]/a")).click();  
  		
  		//user 2 --->apply leave
  		// login -->4dhrms
  		driver.findElement(By.id("emp_id")).sendKeys("m1102");
  		driver.findElement(By.name("password")).sendKeys("admin");
  		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
  		Thread.sleep(2000);
  		//Click Leave Moduls 
  		driver.findElement(By.xpath("/html/body/div[2]/ul/li[3]/a/span")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/button[2]/span")).click();
  		Thread.sleep(2000);
  		//choose category 
  		//user-->1 apply lop leave in admin side 
  		WebElement catee=driver.findElement(By.id("category"));
  		Thread.sleep(2000);
  		Select selcategoryy= new Select(catee);
  		selcategoryy.selectByIndex(1);
  		Thread.sleep(2000);
  		//choose type  --> leave
  		WebElement leavetypee=driver.findElement(By.id("type"));
  		Select selectypee=new Select(leavetypee);
  		selectypee.selectByIndex(1);
  		Thread.sleep(2000);
  		//start date and end date selection
  		driver.findElement(By.xpath("//*[@id=\'date_start\']")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("/html/body/div[6]/div[1]/table/tbody/tr[4]/td[4]")).click();
  		//end date selection
  		driver.findElement(By.xpath("//*[@id=\'date_end\']")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("/html/body/div[6]/div[1]/table/tbody/tr[4]/td[5]")).click();
  		//reason
  		driver.findElement(By.id("leave_reason")).sendKeys("test not consoider");
  		Thread.sleep(3000);
  		driver.findElement(By.id("addBtn")).click();
  		Thread.sleep(3000);
  	    //sucessfully close popup
  		driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();
  		Thread.sleep(2000);
  		//logout
  		driver.findElement(By.xpath("/html/body/div[2]/div/div/nav/ul/li[6]/a/i")).click();
      	Thread.sleep(2000);	
    }

}
