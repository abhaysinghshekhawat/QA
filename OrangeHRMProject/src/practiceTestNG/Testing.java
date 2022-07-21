package practiceTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testing {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver","/usr/bin/deadshot");
		driver = new FirefoxDriver();
		driver.get("https://open-source-guide.com");
	}
	@Test(dataProvider="dp")
	public void demo(String url) throws InterruptedException {
		Thread.sleep(1000);
		//System.out.println(driver.getTitle());
		//driver.findElement(By.linkText("L'open Source"));
		driver.findElement(By.linkText(String.format("%s", url))).click();
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		driver.navigate().back();
		Thread.sleep(1000);
		
//		driver.findElement(By.xpath("//a[@href='/Presentation']")).click();
//		Thread.sleep(1000);
//		System.out.println(driver.getTitle());
//		driver.navigate().back();
//		Thread.sleep(1000);
//		
//		driver.findElement(By.xpath("//a[@href='/Actualites']")).click();
//		Thread.sleep(1000);
//		System.out.println(driver.getTitle());
//		driver.navigate().back();
//		Thread.sleep(1000);
//		
//		
//		//driver.findElement(By.xpath("//a[@href='/Solutions/Infrastructure']")).click();
	}
	
	@DataProvider(name="dp")
	public Object[][] data(){
		return new Object[][] {
			{"Présentation"}
	};
}
}
