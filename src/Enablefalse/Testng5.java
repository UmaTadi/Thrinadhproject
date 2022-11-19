package Enablefalse;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng5 {

	
		@Test (priority=1)
		public void userReg() {
			System.out.println("To validate user registration");
			Assert.assertEquals("ABCD", "ABCD");
		}
		
		@Test (priority=2, enabled= false)
		public void userLogin() {
			System.out.println("To validate login functionality");
			
		}

	}

