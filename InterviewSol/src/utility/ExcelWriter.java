package utility;

 
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
 
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
private static String[] columns = {"success_msg"};

public void writeToExcel( String ExcelName ,String sheetName, String msg) throws IOException{
	// Create a Workbook
	Workbook workbook = new XSSFWorkbook();
    //CreationHelper createHelper = workbook.getCreationHelper();
	// Create a sheet
    Sheet sheet =  workbook.createSheet(sheetName);
   // Create a font for styling header cells
    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short)14);
    headerFont.setColor(IndexedColors.RED.getIndex());
    // Create a CellStyle with the font
    CellStyle headeCellStyle = workbook.createCellStyle();
    headeCellStyle.setFont(headerFont);
    // Create a Row
    Row headerRow = sheet.createRow(0);
    // Create a Cell
    for(int i = 0; i <columns.length;i++){
    	Cell cell = headerRow.createCell(i);
    	cell.setCellValue(columns[i]);
    	cell.setCellStyle(headeCellStyle);
    }
    // Create a  Other rows and cells with result data 
    int rowNum = 1;
        
    	Row row = sheet.createRow(rowNum++);
    	row.createCell(0).setCellValue(msg);
    	for( int i =0;i<columns.length;i++){
    		sheet.autoSizeColumn(i);
        }
    	
    // Write the output to a file
    FileOutputStream fileOut = new FileOutputStream(ExcelName+".xlsx");
    workbook.write(fileOut);
    fileOut.close();
    // Closing the workbook
    workbook.close();
    
}
}

