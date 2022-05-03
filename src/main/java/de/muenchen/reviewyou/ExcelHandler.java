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


    private void writeCell(int columnnumber,int rownumber, String text) throws IOException {
        if(fis == null || xssfWorkbook == null ||xssfSheet == null) {
            fis = new FileInputStream(myFile);
            xssfWorkbook = new XSSFWorkbook(fis);
            xssfSheet = xssfWorkbook.getSheetAt(0);
        }
                Cell cell = xssfSheet.getRow(rownumber).getCell(columnnumber);
                cell.setCellValue(text);
                fis.close();
                FileOutputStream outputStream = new FileOutputStream(myFile.getName());
                xssfWorkbook.write(outputStream);
                outputStream.close();
    }

    public void writeStudentData(String name, String birthdate, String address, String year, String course) throws IOException {
        writeCell(0,55, name);
        writeCell(12,55, birthdate);
        writeCell(0,57, address);
        writeCell(12, 57, year);
        writeCell(16,57,course);
    }

    public void writeAllocationPeriod(String from, String to, String internshipSection) throws IOException {
        writeCell(0,61,from);
        writeCell(5,61,to);
        writeCell(12, 61, internshipSection);
    }

    public void writeTrainingAreaAndPeriod(String text) throws IOException {
        writeCell(0,64, text);
    }

    public void writeParticipations(String coursesEtc) throws IOException {
        writeCell(0, 66, coursesEtc);
    }

    public void writeDates(String trainingPlan, String interimTalk) throws IOException {
        writeCell(16,67, trainingPlan);
        writeCell(16, 68, interimTalk);
    }

    public void 


}

