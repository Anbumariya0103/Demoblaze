package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class Homepage extends ProjectSpecification {
	@FindBy(xpath="//a[text()='Sign up']")
	WebElement signup;
	@FindBy(xpath="//a[text()='Log in']")
	WebElement login;
	public Homepage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public Signup clicksignup() {
		click(signup);
		return new Signup(driver);
		}

	public Login clicklogin() {
		click(login);
		return new Login(driver);
	}

	
	}


