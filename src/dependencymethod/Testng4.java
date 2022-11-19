package dependencymethod;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng4 {
	@Test (priority=1)
	public void userReg() {
		System.out.println("To validate user registration");
		Assert.assertEquals("ABCD", "ABCD12");
	}
	
	@Test (priority=2, dependsOnMethods= {"userReg"})
	public void userLogin() {
		System.out.println("To validate login functionality");
		
	}


}
