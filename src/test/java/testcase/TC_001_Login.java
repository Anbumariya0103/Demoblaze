package testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.Homepage;

public class TC_001_Login extends ProjectSpecification {
	@BeforeTest
	public void setup() {
		
		excelfile="Logintestdata";
		
	}
	
	@Test( priority=1,dataProvider ="getData" )
	public void TC_001_Login (String login_username, String login_password) throws InterruptedException {
		
		new Homepage(driver)
		.clicklogin()
		.userName1(login_username) 	
		.Password1(login_password)
		.loginbuttonClick();
		Thread.sleep(3000);
		String Expected = "Welcome Samariya";
			 String actual =driver.findElement(By.xpath("//a[@id=\"nameofuser\"]")).getText();
		Assert.assertEquals(actual, Expected);}
			
	
	
}


