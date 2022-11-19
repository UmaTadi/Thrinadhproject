package demo1;

import org.testng.annotations.Test;

public class Testng1 {
	@Test (priority=0)
	public void userReg() {
		System.out.println("To validate user registration");
	}
	
	@Test (priority=1)
	public void userLogin() {
		System.out.println("To validate login functionality");
		
	}
}




//(priority=0)
//(priority=1)