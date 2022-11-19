package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testng7 {
	@Test (dataProvider="String data")
	public void stringConcat(String x, String y) {
		System.out.println(x+"  "+y);
	}
	
	
	@DataProvider (name="String data")
	public Object[][] getData(){
		
		Object[][]  myData= new Object[3][2];
		myData[0][0]="Smith";
		myData[0][1]="Selenium";
		
		myData[1][0]="Rahul";
		myData[1][1]="UFT";
		
		myData[2][0]="Kiran";
		myData[2][1]="TOSCA";
		
		return (myData);
	}

}


