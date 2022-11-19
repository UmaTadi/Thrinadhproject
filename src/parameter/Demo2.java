package parameter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo2 {
	WebDriver driver;
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}

	@Test
	@Parameters({"uid","pwd"})	//to read data from TestNg xml file
	public void userLogin(String userid, String passwd) throws InterruptedException{
		//to perform login operation
		driver.findElement(By.name("userName")).sendKeys();
		driver.findElement(By.name("password")).sendKeys();
		driver.findElement(By.name("submit")).click();
		
		
	//TestNg Assert class to validate page title
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		//to send user msg into XML reports and log section
		Reporter.log("Successful Login operation", true);
		
	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}
}



