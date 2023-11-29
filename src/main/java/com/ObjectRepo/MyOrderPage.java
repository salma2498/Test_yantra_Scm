package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scmflex.Genericutils.WebDriverUtils;

public class MyOrderPage extends WebDriverUtils{
	@FindBy(id="cmbFilter")
	private WebElement searchdropdown;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchbutton;
	
	@FindBy(xpath="//input[@id='txtId']")
	private WebElement idTextfield;
	
	@FindBy(id="datepicker")
	private WebElement dateTextfield;
	
	@FindBy(xpath="//select[@data-handler='selectMonth']")
	private WebElement monthDropdown;
	
	@FindBy(xpath="//a[text()='10']")
	private WebElement selectedDate;
	
	@FindBy(xpath="//select[@id='cmbStatus']")
	private WebElement statusDropdown;
	
	@FindBy(xpath="//select[@id='cmbApproved']")
	private WebElement approvalDropdown;
	
	@FindBy(xpath="//span[@class='error_message']")
	private WebElement errorMessage;
	
	//Initializing
	public MyOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
     
	//Utilization
	public WebElement getSearchdropdown() {
		return searchdropdown;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getIdTextfield() {
		return idTextfield;
	}

	public WebElement getDateTextfield() {
		return dateTextfield;
	}

	public WebElement getMonthDropdown() {
		return monthDropdown;
	}

	public WebElement getSelectedDate() {
		return selectedDate;
	}

	public WebElement getStatusDropdown() {
		return statusDropdown;
	}

	public WebElement getApprovalDropdown() {
		return approvalDropdown;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}
	
	//BuisnessLogics
	
	public void searchbyitemId(String Idoption,String Idnum)
	{
		dropdownByVisibleText(searchdropdown, Idnum);
		idTextfield.sendKeys(Idnum);
		searchbutton.click();
	}
	public void searchbyitemDate(String dateoption,String monthoption)
	{
		dropdownByVisibleText(searchdropdown, dateoption);
		dateTextfield.click();
		dropdownByVisibleText(monthDropdown, monthoption);
		selectedDate.click();
		searchbutton.click();
	}
	public void seachbyitemstatus(String statusoption,String option)
	{
		dropdownByVisibleText(searchdropdown, statusoption);
		dropdownByVisibleText(statusDropdown, option);
		searchbutton.click();
		
	}
	public void seachByItemApprovedoption(String approvaloption,String option)
	{
		dropdownByVisibleText(searchdropdown, approvaloption);
		dropdownByVisibleText(approvalDropdown, option);
		searchbutton.click();
		
	}

	
	
	

	

	
	
	

	
	

}
