package makemytripActions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import makemytripObjrepo.copy.SearchOR;
import utility.GenericFun;

public class SearchAction extends SearchOR {
	GenericFun objGenericFun;

	public SearchAction() {
		objGenericFun = new GenericFun();
	}

	public void clickOn_search() {
		driver.findElement(search_btn).click();
	}
	public void select_fcity() {

		driver.findElement(from_city).click();
		objGenericFun.select_value(enter_city, "Ahmedabad");
		objGenericFun.click_value(select_city_value);

	}
	public void select_tcity() {
		
		//driver.findElement(to_city).click();
		objGenericFun.select_value(enter_city, "Bangaluru");
		objGenericFun.click_value(select_city_value);

	}

	public void depart_select() throws ParseException {
		//driver.findElement(depart).click();
		select_nxt2date();
	}

	public void select_nxt2date() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("EEEEEE, d MMMM yyyy");  
		Date date = new Date(); 
		String dt = formatter.format(date); 

		Calendar c = Calendar.getInstance();
		c.setTime(formatter.parse(dt));
		c.add(Calendar.DATE, 3);  // number of days to add
		dt = formatter.format(c.getTime());  // dt is now the new date
		System.out.println(dt);
		objGenericFun.click_value(By.xpath("//div[@aria-label='"+dt+"']"));
	
	}
	public void flight_search() {
		driver.findElement(search_button).click();
	}
	public String get_price() {
		String price_value= driver.findElement(price_get).getText();
		System.out.println(price_value);
		return price_value;
	}

}
