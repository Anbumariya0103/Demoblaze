package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;

public class Login extends ProjectSpecification {
	@FindBy(id="loginusername")
	WebElement userName1;
	@FindBy(id="loginpassword")
	WebElement Password1;
	@FindBy(xpath="//button[@onclick=\"logIn()\"]")
	WebElement loginbutton;
public Login (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
		public Login userName1(String login_username) {
			
			sendKeys(userName1, login_username);
			return this;
		}
public Login Password1(String login_password) {
			
			sendKeys(Password1, login_password);
			return this;
}
public Login  loginbuttonClick(){
	
	click( loginbutton);
	return this;
}
}

