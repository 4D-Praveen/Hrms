package hrms;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHrms {
	//login ---> incompleted
	@Test
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://localhost/4dhrms/login");
		System.out.println("the current page title is " + driver.getTitle());
		// login -->4dhrms
		driver.findElement(By.id("emp_id")).sendKeys("a001");
		driver.findElement(By.name("password")).sendKeys("appu");
		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
		Thread.sleep(5000);

		// DASBOARD
		// a)calender
		WebElement empselection = driver.findElement(By.name("useridemp"));
		Select selectemployee = new Select(empselection);
		List<WebElement> sel = selectemployee.getOptions();
		// find total no employee
		int totalemp = sel.size();
		System.out.println("total emp is calender is " + totalemp);
		// print all empid/emp name
		for (WebElement printempnamesandid : sel) {
			System.out.println(" emp id and name"  + printempnamesandid.getText());
		}
		// select empid m1050
		selectemployee.selectByVisibleText("M1050/Deepesh Pravin Rana");

		driver.findElement(By.xpath("//*[@id=\'tableprint\']/tr[1]/td[4]/btn")).click();
		driver.findElement(By.xpath("//*[@id='viewdatedata']/div/div/div[1]/button/span")).click();
		driver.quit();

//			if (printempnamesandid.getText().equals("A001/Admin")) {
//				System.out.println("valid emp id :" +printempnamesandid.getText());
//				System.out.println(printempnamesandid.getText());
//				break;	
//				} else {
//				System.out.println("invalid emp is:"+printempnamesandid.getText());

	}
	
	
	//----------------------------------------------------------------------------------------------------------------------//
	
   //payslip  ---> completed 
	
	@Test
	public void payslip() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://192.168.2.193/4dhrms/login");
		System.out.println("the current page title is " + driver.getTitle());
		// login -->4dhrms
		driver.findElement(By.id("emp_id")).sendKeys("a001");
		driver.findElement(By.name("password")).sendKeys("appu");
		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
		// payslip (01-01-2023)
		driver.findElement(By.xpath("//*[@id=\'accordionSidebar\']/li[11]/a/span")).click();
		WebElement selpayslip = driver.findElement(By.id("emp_id"));
		selpayslip.click();
		Select payslip = new Select(selpayslip);
		List<WebElement> payslips = payslip.getOptions();
		int payslipcounts = payslips.size();
		System.out.println("payslip users visible counts is  " + payslipcounts);
		for (WebElement webElementpayslip : payslips) {
			System.out.println("payslip empis/name is " + webElementpayslip.getText());
		}
		// 5 random users download payslips in admin
		// users1
		payslip.selectByIndex(10);
		driver.findElement(By.id("otpvalidate")).click();
		// payslip download
		driver.findElement(By.xpath("//*[@id=\'container-wrapper\']/div[3]/div[2]/div[1]/button/i")).click();
		// users2
		payslip.selectByIndex(111);
		driver.findElement(By.id("otpvalidate")).click();
		// payslip download
		driver.findElement(By.xpath("//*[@id=\'container-wrapper\']/div[3]/div[2]/div[1]/button/i")).click();
		// users3
		payslip.selectByIndex(211);
		driver.findElement(By.id("otpvalidate")).click();
		// payslip download
		driver.findElement(By.xpath("//*[@id=\'container-wrapper\']/div[3]/div[2]/div[1]/button/i")).click();
		// user4
		payslip.selectByIndex(300);
		driver.findElement(By.id("otpvalidate")).click();
		// payslip download
		driver.findElement(By.xpath("//*[@id=\'container-wrapper\']/div[3]/div[2]/div[1]/button/i")).click();
		// user5
		payslip.selectByIndex(99);
		driver.findElement(By.id("otpvalidate")).click();
		// payslip download
		driver.findElement(By.xpath("//*[@id=\'container-wrapper\']/div[3]/div[2]/div[1]/button/i")).click();
		// logout
		driver.findElement(By.xpath("//*[@id=\'content\']/nav/ul/li[6]/a/i")).click();
		// login users
		// users profile download payslip
		driver.get("http://192.168.2.193/4dhrms/login");
		System.out.println("the current page title is " + driver.getTitle());
		// login -->4dhrms
		driver.findElement(By.id("emp_id")).sendKeys("m1102");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
		// users download payslip (01-01-2023)

		driver.findElement(By.id("otpvalidate")).click();
		// logout
		driver.findElement(By.xpath("//*[@id=\'content\']/nav/ul/li[6]/a/i")).click();
		driver.close();

	}

	
	//------------------------------------------------------------------------------------------------------------------------//
	
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
			driver.findElement(By.name("password")).sendKeys("appu");
			driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();
			//click hr desk --> policy
			driver.findElement(By.xpath("/html/body/div[2]/ul/li[2]/a/span")).click();
			driver.findElement(By.xpath("//*[@id=\'accordionSidebar1\']")).click();
			// view --> HR Policy   
			driver.findElement(By.xpath("//*[@id=\"hr_policy\"]/div/a[1]/div[1]")).click();
			//click ->p4p policy
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div/div[1]/div/a[1]/div[1]")).click();
			Thread.sleep(2000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,400)");
		    Thread.sleep(2000);
			//next click--> page2 
			driver.findElement(By.xpath("//*[@id=\'next-page\']")).click();
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    js1.executeScript("window.scrollBy(0,-400)");
		    Thread.sleep(2000);
		    js1.executeScript("window.scrollBy(0,400)");
		    //next click--> page3
		    driver.findElement(By.xpath("//*[@id=\'next-page\']")).click();
		    JavascriptExecutor js2 = (JavascriptExecutor) driver;
		    js2.executeScript("window.scrollBy(0,-400)");
		    Thread.sleep(2000);
		    js2.executeScript("window.scrollBy(0,400)");
		    
		    //next click--> page4
		    driver.findElement(By.xpath("//*[@id=\'next-page\']")).click();
		    JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    js3.executeScript("window.scrollBy(0,-280)");
		    Thread.sleep(2000);
		    js3.executeScript("window.scrollBy(0,280)");
		    System.out.println("all page is open properly");
		    //close current wdw
		    driver.close();
		}
   //-----------------------------------------------------------------------------------//

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
    		// login -->4dhrms apply leave
    		driver.findElement(By.id("emp_id")).sendKeys("a001");
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
    		WebElement cate=driver.findElement(By.id("category")); 
    		Select selcategory= new Select(cate);
    		selcategory.selectByIndex(1);
    		Thread.sleep(2000);
    		//choose type -->lop
    		WebElement leavetype=driver.findElement(By.id("type"));
    		Select selectype=new Select(leavetype);
    		selectype.selectByIndex(1);
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
    		Thread.sleep(2000);
    	    //sucessfully close popup
    	    driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click(); 
    		Thread.sleep(2000);
    		//logout
    		driver.findElement(By.xpath("/html/body/div[2]/div/div/nav/ul/li[6]/a")).click();  
    		
    		//user 2 --->apply work from home
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
    		selectypee.selectByIndex(2);
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
      
     //--------------------------------------------------------------------------------------------------------//

      //find how many broken links in hrms 
      @Test
      public void brokenlinksHRMS() throws InterruptedException, IOException  {
 	  
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
 		//Find links 
 		List<WebElement>Links=driver.findElements(By.tagName("a"));
 		System.out.println("total HRMS link Count is "+ Links.size());
 		
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
		}}   
}    
      //----------------------------------------------------------------------------------------------------//         
      //find how many broken image in HRMS 
      @Test
      public static void brokenimageinHRMS() throws InterruptedException, IOException  {
 	  
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
      
   //--------------------------------------------------------------------------------------------------//

public class PreboardingOnboarding {
	@Test
	public void preboading() throws InterruptedException {
		// preboarding ---> Documents views
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://localhost/4dhrms/login");
		System.out.println("the current page title is " + driver.getTitle());

		// login -->4dhrms
		driver.findElement(By.id("emp_id")).sendKeys("a001");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();

		// random users resume check
		// click hrdesk
		driver.findElement(By.xpath("//*[@id=\'accordionSidebar\']/li[2]/a")).click();
		Thread.sleep(2000);
		// click preboarding
		driver.findElement(By.id("accordionSidebar2")).click();
		// 1)test-->user1 (premkumar resume check)
		String oldwindow = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[1]/div/div[2]/table/tbody/tr[4]/td[1]"))
				.click();
		Thread.sleep(2000);
		System.out.println(2);
		// resume preview/download
		driver.findElement(By.xpath("//*[@id=\"candidatelist\"]/tbody/tr[5]/td/table/tbody/tr[7]/td[5]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div/div/div[1]/div/a/div")).click();
		Thread.sleep(3000);
		driver.switchTo().window(oldwindow);
		Thread.sleep(3000);
		System.out.println("resume download sucessfully");
		driver.navigate().back();
		// popopu closer
		boolean b;
		driver.findElement(By.xpath(
				"//*[@id=\'welcomenotif\']/div/div/div/div/div[1]/div/div[1]/div/div/div/div/div[1]/div[3]/button"))
				.click();
		// onboading documents views
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'accordionSidebar\']/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'accordionSidebar3\']")).click();
		// click user1
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/table/tbody/tr[4]/td[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/table/tbody/tr[5]/td/table/tbody/tr[2]/td[5]/span"))
				.click();
		Thread.sleep(2000);
		// 1.aadharcard view
		String oldwindowdocuments = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\'docviewpopupview\']/table/tbody/tr[1]/td[2]/a")).click();
		Thread.sleep(2000);
		driver.switchTo().window(oldwindowdocuments);
		System.out.println("user1-->aadharcard download sucessfully");
		// 2.pancard view
		Thread.sleep(2000);
		String oldwindowdocumentspan = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.switchTo().window(oldwindowdocumentspan);
		System.out.println("users1 -->pancard download sucessfully");
		// payslip1 view
		Thread.sleep(2000);
		String crntwdwpayslip1 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.switchTo().window(crntwdwpayslip1);
		System.out.println("user 1-->payslip1 download sucessfully");
		// payslip2 view
		Thread.sleep(2000);
		String crntwdwpayslip2 = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\'docviewpopupview\']/table/tbody/tr[4]/td[2]/a")).click();
		Thread.sleep(2000);
		driver.switchTo().window(crntwdwpayslip2);
		System.out.println("usesr 1 -->payslip2 download sucessfully");
		// payslip3
		Thread.sleep(2000);
		String crntwdwpayslip3 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr[5]/td[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.switchTo().window(crntwdwpayslip3);
		Thread.sleep(2000);
		System.out.println("users 1 --> payslip3 download sucessfully");
		// close popup
		driver.findElement(By.xpath("//*[@id=\'docviewpopup\']/div/div/div[3]/button[2]")).click();
		Thread.sleep(2000);

		// user2
		// click preboarding
		driver.findElement(By.xpath("//*[@id=\'accordionSidebar2\']")).click();
		Thread.sleep(2000);
		// click uesr2 details button
		driver.findElement(By.xpath("//*[@id=\'candidatelist\']/tbody/tr[1]/td[1]")).click();
		Thread.sleep(2000);
		// click eye button
		driver.findElement(By.xpath(
				"/html/body/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[1]/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[5]/a"))
				.click();
		Thread.sleep(2000);

		// download resume
		String oldwindow2 = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'resumeview\']/a/div")).click();
		Thread.sleep(3000);
		System.out.println("users 2 resume download sucessfully");
		driver.switchTo().window(oldwindow2);
		driver.navigate().back();

		// onboarding check
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'accordionSidebar3\']")).click();

		// click user2
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/table/tbody/tr[1]/td[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[5]/span"))
				.click();
		Thread.sleep(2000);
		// 1.aadharcard view
		String oldwindowdocuments2 = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\'docviewpopupview\']/table/tbody/tr[1]/td[2]/a")).click();
		Thread.sleep(2000);
		driver.switchTo().window(oldwindowdocuments2);
		System.out.println("user1-->aadharcard download sucessfully");
		// 2.pancard view
		Thread.sleep(2000);
		String oldwindowdocumentspann = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.switchTo().window(oldwindowdocumentspann);
		System.out.println("users1 -->pancard download sucessfully");
		// payslip1 view
		Thread.sleep(2000);
		String crntwdwpayslip11 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.switchTo().window(crntwdwpayslip11);
		System.out.println("user 1-->payslip1 download sucessfully");
		// payslip2 view
		Thread.sleep(2000);
		String crntwdwpayslip22 = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\'docviewpopupview\']/table/tbody/tr[4]/td[2]/a")).click();
		Thread.sleep(2000);
		driver.switchTo().window(crntwdwpayslip22);
		System.out.println("usesr 1 -->payslip2 download sucessfully");
		// payslip3
		Thread.sleep(2000);
		String crntwdwpayslip33 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr[5]/td[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.switchTo().window(crntwdwpayslip33);
		Thread.sleep(2000);
		System.out.println("users 1 --> payslip3 download sucessfully");
		// close popup
		driver.findElement(By.xpath("//*[@id=\'docviewpopup\']/div/div/div[3]/button[2]")).click();
		Thread.sleep(2000);

	}

}
   //--------------------------------------------------------------------------------------------------//   
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

