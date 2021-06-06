package utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserSetup {
	public static WebDriver driver;
	//	public static WebDriverWait wait;
	

	@BeforeTest
	@Parameters("browser")
	public  WebDriver WebDriverSetup(String browser) {

		if(browser.contentEquals("chrome")) 
		{
			String chromeDriverPath = new File("Resources/chromedriver.exe").getAbsolutePath();
			System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");

			driver = new ChromeDriver(chromeOptions);
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;

	}

	
	  @AfterTest 
	  public void testmethod() { 
		  driver.quit();
	  
	  }
	 
	

}
