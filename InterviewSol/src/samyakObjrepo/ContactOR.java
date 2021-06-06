package samyakObjrepo;

import org.openqa.selenium.By;

import utility.BrowserSetup;

public class ContactOR extends BrowserSetup {
	
	public By contact_lnk = By.xpath("//a[@href='contact']");
	public By name = By.xpath("//input[@id='txtFirstName']");
	public By company_name = By.xpath("//input[@id='txtComanyName']");
	public By email = By.xpath("//input[@id='txtEmailId']");
	public By phone = By.xpath("//input[@id='txtContactNumber']");
	public By submit = By.xpath("//input[@id='btnSubmit']");
	public By message = By.xpath("//p[@class='hide1']");
}
