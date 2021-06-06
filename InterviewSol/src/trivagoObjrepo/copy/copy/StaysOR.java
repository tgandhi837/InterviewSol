package trivagoObjrepo.copy.copy;

import org.openqa.selenium.By;

import utility.BrowserSetup;

public class StaysOR extends BrowserSetup {
	
	public By flight_lnk = By.xpath("//a[@href='/flights']");
	public By stays_lnk = By.xpath("//span[text()='Stays']");
	public By enter_hotel = By.id("querytext");
	public By select_city = By.xpath("//mark[text()='Ahmedabad']//following::span[text()='City - Gujarat, India']");
	public By check_in = By.xpath("//span[text()='Check in']");
	public By datetime = By.xpath("//time[@datetime='2021-06-06']");
	public By search_btn = By.xpath("//span[text()='Search']");
}
