package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

  Workbook excelData;

  public ExcelReader(String path) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(new File(path));
    this.excelData = new XSSFWorkbook(fileInputStream);
  }
  public Sheet getSheetByName(String sheetName){
    return excelData.getSheet(sheetName);
  }
}
