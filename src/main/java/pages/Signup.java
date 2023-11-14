package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class Signup  extends ProjectSpecification{
	@FindBy(id="sign-username")
	WebElement userName;
	@FindBy(id="sign-password")
	WebElement Password;
	@FindBy(xpath="(//button[@class=\"btn btn-primary\"])[2]")
	WebElement signupbutton;
	
	public Signup (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public Signup userName(String username) {
		
		sendKeys(userName, username);
		return this;
	}

public Signup Password(String password) {
	
	sendKeys(Password, password);
	return this;
}
public Signup signupbuttonClick(){
	
	signupbutton.click();
	return this;
	
	
}

}
