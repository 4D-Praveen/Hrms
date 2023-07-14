package hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Separation {
	@Test
	public void separation() throws InterruptedException  {
		// preboarding ---> Documents views
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://localhost/4dhrms/login");
		System.out.println("the current page title is " + driver.getTitle());

		// login -->4dhrms
		driver.findElement(By.id("emp_id")).sendKeys("m1102");
		driver.findElement(By.name("password")).sendKeys("a001");
		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
		
		// click separation 
		driver.findElement(By.xpath("//*[@id=\'accordionSidebar\']/li[6]/a")).click();
		Thread.sleep(2000);
		//add separation 
		driver.findElement(By.id("openaddform")).click();
		//selecte category 
		WebElement catsel = driver.findElement(By.id("resignation_Category"));
		Select selectcate= new Select(catsel);
		selectcate.selectByIndex(2);
		
		//add reason
		driver.findElement(By.id("resign_reason")).sendKeys("test not consider");
		//click submit button
		driver.findElement(By.xpath("//*[@id=\'addform\']/div/div/div[3]/button[1]")).click();
		Thread.sleep(2000);
		System.out.println("M1102- praveenkumar -->separation added sucessfully");
		//popupclick
		driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[4]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();
		//logout user 
		driver.findElement(By.xpath("//*[@id=\'content\']/nav/ul/li[6]/a/i")).click();
		// login -->repective manager
		driver.findElement(By.id("emp_id")).sendKeys("m1050");
		driver.findElement(By.name("password")).sendKeys("a001");
	    driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
	    System.out.println("manager login sucessfully");
	   if (true) {
		   driver.findElement(By.xpath("//*[@id=\'welcomenotif\']/div/div/div/div/div[1]/div/div[1]/div/div/div/div/div[1]/div[3]/button")).click();
		
	   } else {
}
	   //separation click 
	    driver.findElement(By.xpath("//*[@id=\'accordionSidebar\']/li[6]/a")).click();
	    Thread.sleep(2000);
	    //click edit button
	    driver.findElement(By.xpath("//*[@id=\'printview\']/tbody/tr[1]/td[1]/div/button")).click();
	    Thread.sleep(2000);
	   //click view button
	    driver.findElement(By.xpath("//*[@id=\'printview\']/tbody/tr[1]/td[1]/div/div/a[1]")).click();
	   //manager comment
	    driver.findElement(By.id("managercommand")).sendKeys("test not consider");
	    
	   
	   
	   
	   
	    
	    
		 

}
}
