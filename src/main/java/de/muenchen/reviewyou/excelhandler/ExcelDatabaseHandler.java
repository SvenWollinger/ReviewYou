package de.muenchen.reviewyou.excelhandler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDatabaseHandler {

    InputStream is = ClassLoader.getSystemResourceAsStream("/Gradingtable.xlsx");
    File file = new File("src/main/resources/Gradingtable.xlsx");
    FileInputStream fis;
    XSSFWorkbook xssfWorkbook;
    XSSFSheet xssfSheet;


    private int[][] grades = new int[15][19];
    private static ExcelDatabaseHandler excelDatabaseHandler;

    static {
        try {
            excelDatabaseHandler = new ExcelDatabaseHandler();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public static ExcelDatabaseHandler getInstance(){
        return excelDatabaseHandler;
    }

    private ExcelDatabaseHandler() throws URISyntaxException {

    }

    public void addRecommendation(int id1, int id2, String recommendation) throws IOException {
        if(fis == null || xssfWorkbook == null ||xssfSheet == null) {
            fis = new FileInputStream(file);
            xssfWorkbook = new XSSFWorkbook(fis);
            xssfSheet = xssfWorkbook.getSheetAt(1);
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        int lastRow = xssfSheet.getLastRowNum();
        Cell cellId1 = xssfSheet.createRow(++lastRow).createCell(0);
        cellId1.setCellValue(id1);
        //xssfWorkbook.write(outputStream);
        Cell cellId2 = xssfSheet.getRow(lastRow).createCell(1);
        cellId2.setCellValue(id2);
        //xssfWorkbook.write(outputStream);
        Cell cellRecommendation = xssfSheet.getRow(lastRow).createCell(2);
        cellRecommendation.setCellValue(recommendation);
        xssfWorkbook.write(outputStream);
        fis.close();
        outputStream.close();
    }

    public List<AnswerSuggestionModel> createRecListFromExcel() throws IOException {
        if(fis == null || xssfWorkbook == null ||xssfSheet == null) {
            fis = new FileInputStream(file);
            xssfWorkbook = new XSSFWorkbook(fis);
            xssfSheet = xssfWorkbook.getSheetAt(1);
        }
        int lastRow = xssfSheet.getLastRowNum();
        List<AnswerSuggestionModel> list = new ArrayList<>();
        for (int i = 1; i < lastRow; i++) {
            Row row = xssfSheet.getRow(i);
            list.add(new AnswerSuggestionModel(row.getCell(0).getNumericCellValue(),row.getCell(1).getNumericCellValue(),row.getCell(2).getStringCellValue()));
            System.out.println(row.getCell(0).getNumericCellValue());
        }
        return list;
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
