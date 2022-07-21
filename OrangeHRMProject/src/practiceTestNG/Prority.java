package practiceTestNG;

import org.testng.annotations.Test;

public class Prority {
//	WebDriver driver;
	
	@Test(priority=2)
	public void test1() {
		System.out.println("inside test1");
	}
	
	
	
	@Test(priority=1)
	public void test2() {
		System.out.println("inside test2");
	}
	
	@Test(priority=3)
	public void test3() {
		System.out.println("inside test3");
	}

}
