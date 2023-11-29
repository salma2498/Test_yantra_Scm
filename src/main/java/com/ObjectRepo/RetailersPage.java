package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailersPage {
	//Decalaration
	@FindBy(xpath="//td[text()=' 6 ']/parent::tr/descendant::input[@name='chkId[]']")
	private WebElement RetailerToBeDeleted;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement DeleteButton;
	
	//Initialization
	public RetailersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getRetailerToBeDeleted() {
		return RetailerToBeDeleted;
	}

	public WebElement getDeleteButton() {
		return DeleteButton;
	}
	
	//Buisness Logics
	public void SelectedRetailertobedelted()
	{
		RetailerToBeDeleted.click();
	}
	public void ClickOnDeleteButton()
	{
		DeleteButton.click();
	}
	
	

}
