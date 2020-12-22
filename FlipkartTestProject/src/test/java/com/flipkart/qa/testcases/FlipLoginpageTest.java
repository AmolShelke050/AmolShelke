package com.flipkart.qa.testcases;


import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.Build;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.FlipHomepage;
import com.flipkart.qa.pages.FlipLoginpage;

public class FlipLoginpageTest extends TestBase{
	
	FlipLoginpage loginpage;
	FlipHomepage fliphomepage;

	public FlipLoginpageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new FlipLoginpage();
		
	}
	
	@Test
	public void LoginToFlipkart() throws Exception {
		
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		Screenshotby();
		
		// Below block is for navigate browser forward and back
		/*Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		*/
		//fliphomepage.searchin("iphone XR");
		
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("Iphone Xr",Keys.ENTER);
		
		driver.findElement(By.xpath("//div[text()='Apple iPhone XR (Black, 64 GB) (Includes EarPods, Power Adapter)']")).click();
		
		String oldTab = driver.getWindowHandle();
		driver.findElement(By.partialLinkText("Apple iPhone XR (Black, 64 GB)")).click();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
		Thread.sleep(3000);
		driver.switchTo().window(newTab.get(0));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")).click();
		//actions class use to handle mouse hovering
		//Actions a = new Actions(driver);
		//a.moveToElement(driver.findElement(By.xpath("//*[text()='Electronics']"))).build().perform();
		
		//Use of findElements 
		/*List<WebElement> ele = driver.findElements(By.tagName("a")); 
		for(int i = 0; i < ele.size();i++)
		{
			System.out.println(ele.get(i));
		}*/
				
	}
	
	
	
	
	@AfterMethod
	public void theEnd() {
		//driver.quit();
	}
}
