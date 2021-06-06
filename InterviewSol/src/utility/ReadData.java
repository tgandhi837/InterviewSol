package utility;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ReadData {
	

	public HashMap<String ,String> dataRepository(String SheetName,String TestCaseName){
		HashMap<String ,String> dataRepository = new HashMap<>();
		DataFormatter formatter = new DataFormatter(); // creating Formatter
		try{
		String dataSheet = "excel/"+ "contactus.xlsx";
		String DataSheetpath = new File(dataSheet).getAbsolutePath();
		File file = new File(DataSheetpath);
		FileInputStream inputStream = new FileInputStream(file); 
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sh = wb.getSheet(SheetName);
		Iterator<Row> it = sh.iterator();
		it.next();     /// Leave the First Row
		while(it.hasNext()){
			XSSFRow rw = (XSSFRow) it.next();
			Iterator<Cell> itrow = rw.iterator();
			XSSFCell cell = (XSSFCell) itrow.next();
			String firstcellvalue = cell.getStringCellValue();
			if(TestCaseName.equals(firstcellvalue)){
				while(itrow.hasNext()){
					XSSFCell cell1 = (XSSFCell) itrow.next();
					//String key = cell1.getStringCellValue();
				String	key =formatter.formatCellValue(cell1); // this formatter will convert cell in string format regardless of cell type	
					XSSFCell cell2 = (XSSFCell) itrow.next();
					//String value = cell2.getStringCellValue();
					String	value =formatter.formatCellValue(cell2);
					dataRepository.put(key, value);
				}
			}
		}
		wb.close();
		inputStream.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return dataRepository;
	}

}
