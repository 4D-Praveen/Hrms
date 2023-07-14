package hrms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Dashboard {
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
		driver.findElement(By.name("password")).sendKeys("12345");
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
//
//	}
//	
	

}}
