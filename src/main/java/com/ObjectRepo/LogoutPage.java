package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	//Declaration
	@FindBy(xpath="//input[@type='button']")
	private WebElement logoutbtn;
	
	//initialization
	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	//Buisness logics
	public void clickOnLogoutButton()
	{
		logoutbtn.click();
	}

}
