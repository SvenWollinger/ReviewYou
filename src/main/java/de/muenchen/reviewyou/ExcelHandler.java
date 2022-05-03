package de.muenchen.reviewyou;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;


import java.io.*;


public class ExcelHandler {

    File myFile = new File("C:\\Users\\Leonhard Baumann\\Documents\\GitHub\\ReviewYou\\resources\\1_Überarbeitet.xlsx");
    InputStream fis = new FileInputStream(myFile);
    XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
    XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);


    public ExcelHandler() throws IOException {
    }


    public boolean writeCell(int identifier, String text) throws IOException {
        switch(identifier) {
            case 1:
                Cell cell = null;
                cell = xssfSheet.getRow(0).getCell(55);
                cell.setCellValue(text);
                fis.close();
                OutputStream outputStream = new FileOutputStream("C:\\Users\\Leonhard Baumann\\Documents\\GitHub\\ReviewYou\\resources\\1_Überarbeitet.xlsx");
                xssfWorkbook.write(outputStream);
                outputStream.close();
        }
        return true;
    }
}
