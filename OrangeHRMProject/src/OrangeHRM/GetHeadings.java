package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetHeadings {
	WebDriver driver;
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/usr/bin/deadshot");
				
		driver  = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(1000);
		//driver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void fetchHeading() throws Exception {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
	Thread.sleep(2000);
		driver.findElement(By.linkText("Admin")).click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("Leave")).click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
		
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
