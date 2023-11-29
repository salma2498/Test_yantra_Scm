package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scmflex.Genericutils.WebDriverUtils;

public class LoginPage extends WebDriverUtils {
	//Declaration
	@FindBy(id="login:username")
	private WebElement username;
	
	@FindBy(id="login:password")
	private WebElement password;
	
	@FindBy(id="login:type")
	private WebElement logintypedd;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginbutton;
	
	//Initialization
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getUsername() {
		return username;
	}



	public WebElement getPassword() {
		return password;
	}



	public WebElement getLogintypedd() {
		return logintypedd;
	}



	public WebElement getLoginbutton() {
		return loginbutton;
	}


	
	
	//Buisness loics
	public void enterUsernameAndPassword(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
	}
	

	public void EnterloginType(String logintype)
	{
		dropdownByVisibleText(logintypedd, logintype);
		logintypedd.sendKeys(logintype);
	}
	public void clickOnLoginButton()
	{
		loginbutton.click();
	}
	
	
	
	

}
