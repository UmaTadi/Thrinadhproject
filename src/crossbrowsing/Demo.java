package crossbrowsing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;
		
	@BeforeClass
	@Parameters({"myBrowser"})
	public void setUp(String testBrowser) {
		
		switch (testBrowser.toUpperCase())
		{
		case "chrome":
			System.out.println("Script executing on Chrome browser");
			System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			break;
		
		case "ff":
			System.out.println("Script executing on Firefox browser");
			System.setProperty("webdriver.gecko.driver", "./Drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
			break;
			}
			
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
		public void userLogin() throws InterruptedException {
		 driver.findElement(By.name("username")).sendKeys("Admin");
		 Thread.sleep(3000);
         driver.findElement(By.name("password")).sendKeys("admin123");
         Thread.sleep(3000);
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
          Thread.sleep(3000);
          
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		//to send user msg into XML reports and log section
		Reporter.log("Successful Login operation", true);

	}
	
	@AfterClass	//to close application
	public void tearDown() {
		driver.close();
	}

}



