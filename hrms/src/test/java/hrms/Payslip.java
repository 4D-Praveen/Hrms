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

public class Payslip {
	@Test
	public void payslip() throws InterruptedException {
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
		Thread.sleep(2000);
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

}
