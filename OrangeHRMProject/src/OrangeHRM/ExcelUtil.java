package OrangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static File file;
	static FileInputStream istream;
  public void setUp(String filename, String sheetName) throws IOException {
	     file = new File(filename);
		 istream = new FileInputStream(file);
		 workbook = new XSSFWorkbook(istream);
		 sheet = workbook.getSheet(sheetName);
		 
  }
  
  public String getCell(int rn, int cn) {
	  return sheet.getRow(rn).getCell(cn).getStringCellValue();
  }
  
  public int rowCount() {
	  return sheet.getLastRowNum() - sheet.getFirstRowNum() ;
	  
  }
  
  public int cellCount() {
	  return (sheet.getRow(0).getLastCellNum() - sheet.getRow(0).getFirstCellNum());
  }
  
  public void setCellValue(int rn, int cn,String cellValue, String filePath) throws IOException {
		sheet.getRow(rn).createCell(cn).setCellValue(cellValue);
		FileOutputStream ostream = new FileOutputStream(filePath);
		workbook.write(ostream);
	}
  public void closeWorkbook() throws IOException {
	  workbook.close();
  }
}
