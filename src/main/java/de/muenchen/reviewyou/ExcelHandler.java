package de.muenchen.reviewyou;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExcelHandler {

    File myFile = new File("C:\\Users\\Leonhard Baumann\\Downloads\\1_Überarbeitet.xlsm");
    FileInputStream fis = new FileInputStream(myFile);
    XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
    XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);


    public ExcelHandler() throws IOException {
    }
}
