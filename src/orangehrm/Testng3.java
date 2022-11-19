package orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testng3 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("initialization script executed");
	}
	
	
	
	@Test
	public void adminLogin() {
		try {
		if(driver.findElement(By.name("username")).isDisplayed()) {
			Reporter.log("'User name' Editbox displayed and Login script is executing...");
			
			//to perfrom login operation
			driver.findElement(By.name("username")).sendKeys("Admin");
	         driver.findElement(By.name("password")).sendKeys("admin123");

		    driver.findElement(By.xpath("//button[@type='submit']")).click();
	          
	         
			//to check element present
			boolean myStatus= driver.findElement(By.partialLinkText("Welcome")).isDisplayed();
			Assert.assertEquals(myStatus, true);
			Reporter.log("Successful login operation", true);
			
			
		}
		else {
			Reporter.log("'Username' editbox doesn't exist, login script not executed");
		}
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		System.out.println("Application closed");
		
	}

}








