package samyakActions;

import samyakObjrepo.ContactOR;

public class ContactAction extends ContactOR {
	
	public void clickOn_Contact() {
		
		driver.findElement(contact_lnk).click();
		
	}
	
	public void fill_getInTouch(String fname, String cname, String emailid,String ph) {
		driver.findElement(name).sendKeys(fname);
		driver.findElement(company_name).sendKeys(cname);
		driver.findElement(email).sendKeys(emailid);
		driver.findElement(phone).sendKeys(ph);
		driver.findElement(submit).click();
	}
	
	public String get_successmsg(){
		return driver.findElement(message).getText();
		
	}
	
}
