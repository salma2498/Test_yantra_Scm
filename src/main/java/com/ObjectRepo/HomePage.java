package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage {
	//declaration
	@FindBy(xpath="//a[text()='Add Products']")
	private WebElement addProductsLink;
	
	@FindBy(xpath="//a[text()='Add Retailers']")
	private WebElement addRetailersLink;
	
	@FindBy(xpath="//a[text()='Add Manufacturer']")
	private WebElement addManufacturerLink;
	
	@FindBy(xpath="//a[text()='Retailers']")
	private WebElement retailersLink;
	
	@FindBy(xpath="//a[text()='Manufacturers']")
	private WebElement manufacturerslink;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productsLink;
	
	@FindBy(xpath="//a[text()='Orders']")
	private WebElement orderslink;
	
	//Initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    //utilization
	public WebElement getAddProductsLink() {
		return addProductsLink;
	}

	public WebElement getAddRetailersLink() {
		return addRetailersLink;
	}

	public WebElement getAddManufacturerLink() {
		return addManufacturerLink;
	}

	public WebElement getRetailersLink() {
		return retailersLink;
	}

	public WebElement getManufacturerslink() {
		return manufacturerslink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getOrderslink() {
		return orderslink;
	}
	
	//Business logics
	
	public void clickonaddproductlink()
	{
		addProductsLink.click();
	}
	public void clickOnProductsLink()
	{
		productsLink.click();
	}
	public void clickOnRetailersLink()
	{
		retailersLink.click();
	}
	public void clickOnAddRetailersLink()
	{
		addRetailersLink.click();
	}
	public void ManufacturerHomePageConfirmationSA(WebDriver driver)
	{
		//validating actual with accepted data
		String Actualtitle = driver.getTitle();
		Assert.assertEquals(Actualtitle, "Manufacturer: Home");
		
	}
	public void AddProductConfirmatio(WebDriver driver)
	{
		String actualProductTitle=driver.getTitle();
		Assert.assertEquals(actualProductTitle, "Add Product");
	}
	public void AdminHomePageConfirmation(WebDriver driver)
	{
		String Actualtitle = driver.getTitle();
		Assert.assertEquals(Actualtitle, "Admin: Home");
	}
	public void AddRetailerPageConfirmation(WebDriver driver) {
		
	
	String Retailerpage = driver.getTitle();
	Assert.assertEquals(Retailerpage, "Add Retailer");
	}

}
