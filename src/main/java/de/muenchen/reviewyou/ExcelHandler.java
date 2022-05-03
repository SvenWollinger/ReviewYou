package de.muenchen.reviewyou;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class ExcelHandler {

    File myFile = new File("FinalFile.xlsx");
    FileInputStream fis;
    XSSFWorkbook xssfWorkbook;
    XSSFSheet xssfSheet;


    public ExcelHandler() throws IOException {
        InputStream src = ExcelHandler.class.getResourceAsStream("/Gradingtable.xlsx");
        Files.copy(src, Paths.get(myFile.getName()), StandardCopyOption.REPLACE_EXISTING);
    }


    public boolean writeCell(int identifier, String text) throws IOException {
        if(fis == null || xssfWorkbook == null ||xssfSheet == null) {
            fis = new FileInputStream(myFile);
            xssfWorkbook = new XSSFWorkbook(fis);
            xssfSheet = xssfWorkbook.getSheetAt(0);
        }

        switch(identifier) {
            case 1:
                Cell cell = xssfSheet.getRow(55).getCell(0);
                cell.setCellValue(text);
                fis.close();
                FileOutputStream outputStream = new FileOutputStream(myFile.getName());
                xssfWorkbook.write(outputStream);
                outputStream.close();
        }
        return true;
    }
}
