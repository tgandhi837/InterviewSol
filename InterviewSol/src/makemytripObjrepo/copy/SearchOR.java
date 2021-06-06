package makemytripObjrepo.copy;

import org.openqa.selenium.By;

import utility.BrowserSetup;

public class SearchOR extends BrowserSetup {
	
	
	public By search_btn = By.xpath("//a[text()='Search']");
	public By from_city = By.xpath("//input[@id ='fromCity']");
	public By enter_city = By.xpath("//input[@placeholder ='Enter City']");
	//span[@class='sr_city '][text()='Ahmedabad, India']
	public By select_city_value = By.xpath("//li[@id ='react-autowhatever-1-section-0-item-0']");// or span[@class='sr_city '][text()='Ahmedabad, India']
	//public By select_tcity = By.xpath("//li[@id ='react-autowhatever-1-section-0-item-0']");
	public By to_city = By.xpath("//input[@id='toCity']");	
	public By depart = By.xpath("//input[@id='departure']");
	public By search_button = By.xpath("//button[@id='search-button']");	
	public By price_get = By.xpath("//div[@id='premEcon']//div[@class='fli-list '][1]//div[@class='priceSection']//p[1]");
}
