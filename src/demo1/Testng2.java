package demo1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testng2 {

	@AfterClass
	public void sai() {
		System.out.println(" she become a manual tester");
	}

	@BeforeMethod
	public void anjali() {
		System.out.println("become a qa tester");
	}

	@Test(priority = 1)
	public void frnd() {
		System.out.println("we are frnds forever");
	}

	@Test(priority = 2)
	public void students() {
		System.out.println("mind q students");
	}

	@Test(priority = 3)
	public void jobholders1() {
		System.out.println("we are hardworkers");
	}

	@Test(priority = 4)
	public void jobholders2() {
		System.out.println("we are students");
	}

	@Test(priority = 5)
	public void jobholders3() {
		System.out.println("we are gourgeous");
	}

	@AfterMethod
	public void uma() {
		System.out.println("she  is become a developer come tester");
	}

	@BeforeClass
	public void faculty() {
		System.out.println("trainer");
	}

}
