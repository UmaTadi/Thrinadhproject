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

public class Demo {
	WebDriver driver;

	// to initialize browser
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	// to perform login validation
	@Test
	@Parameters({ "uid", "pwd" })
	public void userLogin(String userId, String passWd) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(userId);
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(passWd);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		// to send user msg into XML reports and log section
		Reporter.log("Successful Login operation", true);

	}

	@AfterClass
	// to close application
	public void tearDown() {
		driver.close();
	}

}
