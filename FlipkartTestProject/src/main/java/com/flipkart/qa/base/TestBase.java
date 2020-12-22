package com.flipkart.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.qa.util.TestUtil;


//This is base class consist of all the common methods which can be use in any TestClass
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	// Read config.property file
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\6354\\Desktop\\Eclipse\\Workspace\\FlipkartTestProject\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//selecting browser followed by maximize, clean history and timeouts
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/6354/Desktop/Automation/Selenium/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\6354\\Desktop\\Automation\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	//Screenshot Block
	public static void Screenshotby() throws IOException {
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("C:\\Users\\6354\\Desktop\\Eclipse\\Workspace\\FlipkartTestProject\\Screenshots\\flipkart.png"));
	}

	//Explicite wait code block
	public static void clickOn(WebDriver driver, WebElement locator, int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
}
