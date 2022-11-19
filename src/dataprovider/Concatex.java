package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Concatex {
	@Test (dataProvider="MyStrings")
	public void concateStrings(String a, String b) {
		
		System.out.println(a+b);
	}
	
	@DataProvider (name="MyStrings")
	public Object[][] getData(){
		Object[][] data= new Object[3][2];
		data[0][0]="mindq";
		data[0][1]="systems";
		
		data[1][0]="anjani";
		data[1][1]="uma";
		
		data[2][0]="sai";
		data[2][1]="3nadh";
		return(data);


}
}