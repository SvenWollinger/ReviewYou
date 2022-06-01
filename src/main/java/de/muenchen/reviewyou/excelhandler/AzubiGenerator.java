package de.muenchen.reviewyou.excelhandler;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AzubiGenerator {

   private static Object AzubiGenerator;


   FileInputStream fis;
   XSSFWorkbook xssfWorkbook;
   XSSFSheet xssfSheet;



   public List<Azubi> getAzubiList(String excelPath) throws IOException {
      File file = new File(excelPath);
      if(fis == null || xssfWorkbook == null ||xssfSheet == null) {
         fis = new FileInputStream(file);
         xssfWorkbook = new XSSFWorkbook(fis);
         xssfSheet = xssfWorkbook.getSheetAt(0);
      }
      int lastRow = xssfSheet.getLastRowNum();
      List<Azubi> list = new ArrayList<>();
      for (int i = 1; i <= lastRow; i++) {
         Row row = xssfSheet.getRow(i);
         list.add(new Azubi(
               row.getCell(0).getStringCellValue(),
               row.getCell(1).getLocalDateTimeCellValue().toLocalDate(),
               row.getCell(2).getStringCellValue(),
               (int)row.getCell(3).getNumericCellValue(),
               row.getCell(4).getStringCellValue(),
               row.getCell(5).getLocalDateTimeCellValue().toLocalDate(),
               row.getCell(6).getLocalDateTimeCellValue().toLocalDate(),
                         (byte)row.getCell(7).getNumericCellValue())
               );
      }
      return list;
   }

}
