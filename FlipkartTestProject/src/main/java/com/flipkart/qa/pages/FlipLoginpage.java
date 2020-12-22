package com.flipkart.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class FlipLoginpage extends TestBase{
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement username;
	
	@FindBy(xpath = "//input[@type = 'password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit' and @class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement submit;
	
	@FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div[1]/a[2]/div/img[2]")
	WebElement iphoneLink;
	
	public FlipLoginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String user, String pwd)  {
		
		username.sendKeys(user);
		password.sendKeys(pwd);
		submit.click();
	}

}
