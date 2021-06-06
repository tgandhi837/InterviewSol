package trivagoActions.copy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import trivagoObjrepo.copy.copy.StaysOR;

public class StayAction extends StaysOR {
	
	public void click_flight() {
		driver.findElement(flight_lnk).click();
	}
	public void click_stay() {
		driver.findElement(stays_lnk).click();
	}	
	public void search_stay() {
		driver.findElement(enter_hotel).sendKeys("Ahmedabad");
		driver.findElement(select_city).click();
	}
	public void check_instay() throws ParseException {
		//driver.findElement(check_in).click();
		String currentdt = currentdt();
		System.out.println(currentdt);
		driver.findElement(By.xpath("//time[@datetime='"+currentdt+"']")).click();
		
	}
	public String currentdt() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = new Date(); 
		String dt = formatter.format(date); 

		return dt;
	}
	public void click_search() {
		driver.findElement(search_btn).click();
	}
	
}
