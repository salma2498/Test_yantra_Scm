package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scmflex.Genericutils.WebDriverUtils;

public class ProductsPage extends WebDriverUtils {
	//Declaration
	
	@FindBy(xpath="//td[text()=' Choclate ']/preceding-sibling::td[text()=' 251 ']/parent::tr/descendant::a")
	private WebElement editProduct;
	
	@FindBy(xpath="//input[@value='Update Product']")
	private WebElement updateProductBtn;
	
	//initializaion
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    //utilization
	public WebElement getEditProduct() {
		return editProduct;
	}

	public WebElement getUpdateProductBtn() {
		return updateProductBtn;
	}
	
	//Buisness logics
	public void clickonedit()
	{
		editProduct.click();
	}
	
	public void clickOnUpdateProduct()
	{
		updateProductBtn.click();
	}

}
