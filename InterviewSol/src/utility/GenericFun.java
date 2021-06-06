package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericFun extends BrowserSetup {

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)"); //Scroll vertically down by 1000 pixels	
	}

	public  void ScreenShot(String Name, WebDriver ldriver)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss"); // old format: yyyy-MM-dd_HH-mm-ss
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);           
		try 
		{
			String dataSheet = "Screenshot/";
			String DataSheetpath = new File(dataSheet).getAbsolutePath();
			// now copy the  screenshot to desired location using copyFile method
			System.out.println(DataSheetpath);
			DataSheetpath = DataSheetpath+"/";
			FileUtils.copyFile(src, new File(DataSheetpath +Name+"_"+(sdf.format(System.currentTimeMillis()))+".png"));                              
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage()); 
		}
	}
	public void select_value(By xpath, String value){	
		List <WebElement> search_city = driver.findElements(xpath);
		System.out.println(search_city.size());
		for(WebElement obj:search_city) {
			if(obj.isDisplayed()){
				obj.sendKeys(value);
				break;
			}
		}
	}
	public void click_value(By xpath) {
		 List <WebElement> checkbx = driver.findElements(xpath);
		  System.out.println(checkbx.size());
		  for(WebElement obj:checkbx) {
			 if(obj.isDisplayed()){
				 obj.click();
				 break;
			 }
			 			 
		  }
	}

}
