package OrangeHRM;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	ExcelUtil excel = new ExcelUtil();
	
	
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/usr/bin/deadshot");
		driver  = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(2000); 
	}
	
	
	@Test(dataProvider="dp")
	public void loginSetup(String usrName, String pasword, int rc) throws InterruptedException, IOException {
		excel.setUp("data.xlsx", "data");
		String authUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		
		Thread.sleep(1000);
		driver.findElement(By.name("txtUsername")).sendKeys(usrName);
		driver.findElement(By.name("txtPassword")).sendKeys(pasword);
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().equalsIgnoreCase(authUrl)) {
			System.out.println(usrName + " user exists");
			excel.setCellValue(rc, 2, "yes", "data.xlsx");
		}
		else {
			System.out.println(usrName + " user don't exist");
			excel.setCellValue(rc, 2, "no", "data.xlsx");
		}
		try {
			System.out.println("clicked on welcome");
			driver.findElement(By.partialLinkText("Welcome")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Logout")).click();
			//System.out.println(usrName + " user exists");
			
			
			}catch(Exception e) {
				System.out.println(e);
			}
	}
	
	@AfterTest
	public void closing() throws IOException {
		excel.closeWorkbook();
		driver.close();
	}
	
	
	@DataProvider(name="dp")
	public Object[][] data() throws IOException{
		
		excel.setUp("data.xlsx", "data");
		int rc = excel.rowCount();
		System.out.println(excel.cellCount());
		
		Object[][] dataObj = new Object[rc][3];
		for(int i=1; i<=rc; i++) {
			for(int j=0; j<=2; j++) {
				if(j==2) {
					dataObj[i-1][j] = i;
				}else {
				dataObj[i-1][j] = excel.getCell(i, j);
				}
			}
		}
		excel.closeWorkbook();
		return dataObj;
		
		
	}
	
	@DataProvider(name="dp2")
	public Object[][] datObj(){
		return new Object[][] {
			{"Admin","admin123"},
			{"vineet","javascript"},
			{"miraj", "python"}
		};
	}
	
}
	

