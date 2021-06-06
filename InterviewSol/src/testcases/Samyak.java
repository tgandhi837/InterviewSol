package testcases;


import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import samyakActions.ContactAction;
import utility.BrowserSetup;
import utility.ExcelWriter;
import utility.GenericFun;
import utility.ReadData;


public class Samyak extends BrowserSetup{
	ContactAction objContactAction;
	GenericFun objGenericFun;
	ExcelWriter objExcelWriter;
	@BeforeClass
	public void url() {
		objContactAction = new ContactAction();
		objGenericFun = new GenericFun();
		objExcelWriter = new ExcelWriter();
		//Step1
		driver.get("http://samyak.com/");
	}

	@Test
	public void contactus() throws IOException {
		String testcasename = new Object(){}.getClass().getEnclosingMethod().getName();//it will return method name
		ReadData obj1 = new ReadData();
		HashMap<String ,String> dataRepository = obj1.dataRepository("samyak", testcasename);
		//Step 2 Go to CONTACT
		objContactAction.clickOn_Contact();
		//Step 3 Scroll Down
		objGenericFun.scrollDown();
		//Step 4 and 5 Fill information in 'Get in Touch' section using Excel/Property file/ notepad etc Utility.
		objContactAction.fill_getInTouch(dataRepository.get("Name"), dataRepository.get("CompanyName"), dataRepository.get("Email"), dataRepository.get("Phone"));
		//Step 6 Copy text from screen "Thank you for contacting us. We will be in touch with you very soon." and write in Excel.
		String success_msg = objContactAction.get_successmsg();
		System.out.println(success_msg);
		objExcelWriter.writeToExcel("Samyak",testcasename,success_msg);

	}



}
