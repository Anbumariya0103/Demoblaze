package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.Homepage;

public class TC_001_Signup  extends ProjectSpecification{
	
	@BeforeTest
	public void setup() {
		
		excelfile="Signuptestdata";
		
	}
	
	@Test( priority=1,dataProvider ="getData" )
	public void TC_001_Signup (String username, String password) {
		
		new Homepage(driver)
		.clicksignup()
		.userName(username)
		.Password(password)
		.signupbuttonClick();
		//.alert();
		
	}
	
}


