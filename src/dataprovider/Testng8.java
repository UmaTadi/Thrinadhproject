package dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testng8 {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver=new ChromeDriver();		
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@DataProvider (name="TestData")
	public Object[][] getData(){
		Object[][] data= new Object[3][2];
		data[0][0]="mercury";
		data[0][1]="mercury";

		data[1][0]="Admin";	
		data[1][1]="admin123";

		data[2][0]="mercury";
		data[2][1]="mercury";

		return data; 
	}

	@Test (dataProvider="TestData")
	public void userLogin(String username, String pwd) throws InterruptedException {
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);

		//TestNg Assert class to validate page title
		Assert.assertEquals(driver.getTitle(), " Login: Mercury Tours");
				//to send user msg into XML reports and log section
				Reporter.log("Successful Login operation", true);


	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}



