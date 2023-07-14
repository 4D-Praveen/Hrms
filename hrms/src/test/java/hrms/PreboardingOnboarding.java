package hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

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
		driver.findElement(By.name("password")).sendKeys("@dmin");
		driver.findElement(By.xpath("//button[@class='mt-4 bg-[#0284c7] text-white py-2 px-22 rounded-lg']")).click();

		// random users resume check
		// click hrdesk
		driver.findElement(By.xpath("//*[@id=\'accordionSidebar\']/li[2]/a")).click();
		Thread.sleep(3000);
		// click preboarding
		driver.findElement(By.id("accordionSidebar2")).click();
		Thread.sleep(2000);
		// 1)test-->user1 (premkumar resume check)
		String oldwindow = driver.getWindowHandle();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\'candidatelist\']/tbody/tr[5]/td[1]")).click();
		Thread.sleep(3000);
		// resume preview/download
		driver.findElement(By.xpath("//*[@id=\'candidatelist\']/tbody/tr[6]/td/table/tbody/tr[7]/td[5]/a/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\'resumeview\']/a/div")).click();
		Thread.sleep(3000);
		driver.switchTo().window(oldwindow);
		Thread.sleep(3000);
		System.out.println("resume download sucessfully");
		Thread.sleep(2000);
		driver.navigate().back();
		// popopu closer
//		boolean b;
//		driver.findElement(By.xpath(
//				"//*[@id=\'welcomenotif\']/div/div/div/div/div[1]/div/div[1]/div/div/div/div/div[1]/div[3]/button"))
//				.click();
		// onboading documents views
		driver.findElement(By.xpath("//*[@id=\'accordionSidebar\']/li[2]/a")).click();
		Thread.sleep(2000);
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
		driver.findElement(By.xpath("//*[@id=\"candidatelist\"]/tbody/tr[2]/td/table/tbody/tr[7]/td[5]/a")).click();
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
		System.out.println("user 2-->aadharcard download sucessfully");
		// 2.pancard view
		Thread.sleep(2000);
		String oldwindowdocumentspann = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.switchTo().window(oldwindowdocumentspann);
		System.out.println("users 2 -->pancard download sucessfully");
		// payslip1 view
		Thread.sleep(2000);
		String crntwdwpayslip11 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.switchTo().window(crntwdwpayslip11);
		System.out.println("user 2-->payslip1 download sucessfully");
		// payslip2 view
		Thread.sleep(2000);
		String crntwdwpayslip22 = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\'docviewpopupview\']/table/tbody/tr[4]/td[2]/a")).click();
		Thread.sleep(2000);
		driver.switchTo().window(crntwdwpayslip22);
		System.out.println("usesr 2 -->payslip2 download sucessfully");
		// payslip3
		Thread.sleep(2000);
		String crntwdwpayslip33 = driver.getWindowHandle();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div/div/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr[5]/td[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.switchTo().window(crntwdwpayslip33);
		Thread.sleep(2000);
		System.out.println("users 2 --> payslip3 download sucessfully");
		// close popup
		driver.findElement(By.xpath("//*[@id=\'docviewpopup\']/div/div/div[3]/button[2]")).click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}


}
