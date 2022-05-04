package de.muenchen.reviewyou;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ExcelDatabaseHandler {


    File myFile = new File("/Gradingtable.xlsx");
    FileInputStream fis;
    XSSFWorkbook xssfWorkbook;
    XSSFSheet xssfSheet;


    private int[][] grades = new int[15][19];
    private static ExcelDatabaseHandler excelDatabaseHandler = new ExcelDatabaseHandler();


    public static ExcelDatabaseHandler getInstance(){
        return excelDatabaseHandler;
    }

    private ExcelDatabaseHandler(){
        InputStream src = ExcelHandler.class.getResourceAsStream("/Gradingtable.xlsx");

    }

    public void addRecommendation(String id1, String id2, String recommendation) throws IOException {
        if(fis == null || xssfWorkbook == null ||xssfSheet == null) {
            fis = new FileInputStream(myFile);
            xssfWorkbook = new XSSFWorkbook(fis);
            xssfSheet = xssfWorkbook.getSheetAt(1);
        }
        int lastRow = xssfSheet.getLastRowNum();
        xssfSheet.createRow(++lastRow).getCell(0).setCellValue(id1);
        xssfSheet.getRow(++lastRow).getCell(1).setCellValue(id2);
        xssfSheet.getRow(++lastRow).getCell(2).setCellValue(recommendation);
    }







/*    private ArrayList<String> possiblesForGerman;
    private ArrayList<String> possiblesForIt;
    private ArrayList<String> possiblesForInterest;
    private ArrayList<String> possiblesForAnalyticalThinking;
    private ArrayList<String> possiblesForConnectedThinking;
    private ArrayList<String> possiblesForCommunication;
    private ArrayList<String> possiblesForContacts;
    private ArrayList<String> possiblesForEmpathy;
    private ArrayList<String> possiblesForNotRacist;
    private ArrayList<String> possiblesForOpeness;
    private ArrayList<String> possiblesForIntegrity;
    private ArrayList<String> possiblesForMotivation;
    private ArrayList<String> possiblesForStressTolerance;
    private ArrayList<String> possiblesForIdentification;
    private ArrayList<String> possiblesForIndependence;
    private ArrayList<String> possiblesForCrtics;*/


    private String[][] irgendwas;

    //TODO ARRAY IDENTIFIER 1 WHICH QUESTION ?? SO 0-18
    //TODO ARRAY IDENTIFIER 2 WHICH GRADE?? 0-5
    //TODO ARRAY MESSAGE STRINGS














    public void setGrade(int i, int j, int grade) {
        this.grades[i][j] = grade;

    }
}
