package de.muenchen.reviewyou.excelhandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class ExcelHandler {

    private final File myFile = new File("FinalFile.xlsx");
    private FileInputStream fis;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet xssfSheet;



    public ExcelHandler() throws IOException {
        InputStream src = ExcelHandler.class.getResourceAsStream("/Gradingtable.xlsx");
        Files.copy(src, Paths.get(myFile.getName()), StandardCopyOption.REPLACE_EXISTING);
    }


    private void writeCell(int columnnumber,int rownumber, String text) throws IOException {
        if(fis == null || xssfWorkbook == null ||xssfSheet == null) {
            fis = new FileInputStream(myFile);
            xssfWorkbook = new XSSFWorkbook(fis);
            xssfSheet = xssfWorkbook.getSheet("Leistungsbericht");
        }
        Cell cell = xssfSheet.getRow(rownumber).getCell(columnnumber);
        cell.setCellValue(text);
        fis.close();
        FileOutputStream outputStream = new FileOutputStream(myFile.getName());
        xssfWorkbook.write(outputStream);
        outputStream.close();
    }

    public void copyFinalFile(String fileName) throws IOException {
        FileDialog fd = new FileDialog(new JFrame(), "Speichern", FileDialog.SAVE);
        fd.setVisible(true);
        System.out.println(fd.getFile());
        File clonedWb = new File(fd.getDirectory() + fd.getFile());
        Files.copy(myFile.toPath(), clonedWb.toPath());
    }

    public void writeInstructorData(String name, String telephone, String date, String eMail) throws IOException {
        writeCell(3, 0, date);
        writeCell(0, 3, name);
        writeCell(3, 1, telephone);
        writeCell(0,4, eMail);
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

    public void writeTotalandAverage(String total, String average) throws IOException {
        writeCell(0, 70, total);
        writeCell(10,70 , average);
    }

    public void writePerformance(String abilities, String strengths, String development, String perspectives, String other) throws IOException {
        writeCell(0, 109, abilities);
        writeCell(0,111, strengths);
        writeCell(0,113, development);
        writeCell(0,115,perspectives);
        writeCell(0, 117, other);
    }

    public void writePoints(int row, int points) throws IOException {
        writeCell(19-points,row,"X");
    }

    public void writeCourse(String jobName) throws IOException {
        writeCell(7,48,jobName);
    }
}


