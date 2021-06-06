package testcases;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import makemytripActions.SearchAction;
import trivagoActions.copy.StayAction;
import utility.BrowserSetup;
import utility.GenericFun;
import utility.ReadData;

public class MakeMyTrip extends BrowserSetup {
	
	SearchAction objSearchAction;
	StayAction objStayAction;
	GenericFun objGenericFun;
	
	@BeforeClass
	public void url() {
		//Step1
		driver.get("https://www.makemytrip.com/");
		driver.navigate().refresh();
		objSearchAction = new SearchAction();
		objStayAction = new StayAction();
		objGenericFun = new GenericFun();
	}
	
	@Test(priority=1)
	public void search_flight() throws ParseException {
		//Step 2 Click on Search button 
		objSearchAction.clickOn_search();
		//Step 3 Click FROM text, enter City - Ahmedabad (search it and select)
		objSearchAction.select_fcity();
		//Step 4 Click TO text, enter City - Bangaluru (search it and select)
		objSearchAction.select_tcity();
		//Step 5 Click DEPART - Select Next 2 days date.
		objSearchAction.depart_select();
		//Step 6 Click on Search button
		objSearchAction.flight_search();
		//Step 7 Get Price any Airline from search grid.
		String price = objSearchAction.get_price();
		String s=Character.toString(price.charAt(0));
		price = price.replaceAll(s, "");
		price = price.replaceAll(",", "");
		price = price.trim();
		System.out.println(price);
		int i=Integer.parseInt(price);  
		if(i!=4000) {
		Assert.assertEquals(false, true,"Assert Fail - Amount is not equal to 4000  " + i);
		}
		
	}
	
	@Test(priority=2)
	public void trivago() throws ParseException, InterruptedException {
		((JavascriptExecutor)driver).executeScript("window.open()");
		String window1 = driver.getWindowHandle();
		String window2 = "";
		String window3 = "";
		String window4 = "";
		System.out.println(window1);
		Set<String> totalwin = driver.getWindowHandles();
		System.out.println(totalwin.size());
		for(String obj: totalwin) {
			if(!obj.equals(window1)) {
				driver.switchTo().window(obj);
				window2=obj;
			}
		}
		//Steps 1 Open New Tab --> Open new application.Enter URL: https://www.trivago.in/
		driver.get(" https://www.trivago.in/");
		//Step 2 Click on Flights from Header section.
		objStayAction.click_flight();
		Set<String> totalwin2 = driver.getWindowHandles();
		System.out.println(totalwin2.size());
		for(String obj: totalwin2) {
			if(!obj.equals(window1) && !obj.equals(window2)) {
				driver.switchTo().window(obj);
				window3=obj;
			}
		}
		//Step 3 Go to All Stayes -> enter 'Ahmedabad'
		objStayAction.click_stay();
		Set<String> totalwin3 = driver.getWindowHandles();
		System.out.println(totalwin3.size());
		for(String obj: totalwin3) {
			if(!obj.equals(window1) && !obj.equals(window2) && !obj.equals(window3)) {
				driver.switchTo().window(obj);
				window4=obj;
			}
		}
		objStayAction.search_stay();
		//Step 4 Select Check In & Check Out, Room
		objStayAction.check_instay();
		//Steps 5 Click on search button.
		objStayAction.click_search();
		// Step 6 Take screenshot and save into local PC.
		Thread.sleep(3000);
		objGenericFun.ScreenShot("trivagosearchresult", driver);
	}
	
	

}
