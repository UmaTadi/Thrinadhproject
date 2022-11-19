package dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderorh {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

	}

	@DataProvider(name = "TestData")
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "Admin";
		data[1][1] = "admin123";

		data[2][0] = "Admin";
		data[2][1] = "admin123";

		return data;
	}

	@Test(dataProvider = "TestData")
	public void userLogin(String username, String pwd) throws InterruptedException {
		// to perform login operation
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pwd);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
