package dataprovider;

import org.testng.annotations.DataProvider;

public class Testng6 {
	@DataProvider (name="TestData")
	public Object[][] getData(){
	Object[][] data=new Object[3][2];
data[0][0]="mercury";
		data[0][1]="mercury";
		
		data[1][0]="Admin";
		data[1][1]="admin123";
		
		data[2][0]="mercury";
		data[2][1]="mercury";
return (data);


}
}