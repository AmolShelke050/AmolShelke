package com.flipkart.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class FlipHomepage extends TestBase{
	
	@FindBy(xpath = "//img[@title='Flipkart']")
	WebElement fliplogo;
	
	@FindBy(xpath = "//input[@title='Search for products, brands and more']")
	WebElement flipsearchfield;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginlink;
	
	public FlipHomepage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyFliplogo() {
		return fliplogo.isDisplayed();
	}
	
	public void searchin(String searchtext) {
		flipsearchfield.sendKeys(searchtext,Keys.ENTER);
	}


	
}
