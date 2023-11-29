package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {
	//Declaration
	@FindBy(xpath="//a[text()='My Orders']")
	private WebElement myOrdersLink;
	
	//Initialization
	public RetailerHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getMyOrdersLink() {
		return myOrdersLink;
	}
	
	//Buisness logics
	public void clickOnMyOrdersLink()
	{
		myOrdersLink.click();
	}

}
