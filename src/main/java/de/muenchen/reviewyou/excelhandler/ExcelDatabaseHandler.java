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
            list.add(new AnswerSuggestionModel(
                  row.getCell(0).getNumericCellValue(),
                  row.getCell(1).getNumericCellValue(),
                  row.getCell(2).getStringCellValue()));
        }
        return list;
    }

    public String getRecString(int gender, int grade, String azubiName) throws IOException {
        String recString = null;
        String tempString = null;
        List<AnswerSuggestionModel> recList = createRecListFromExcel();
        for (int i = 0; i < recList.size() ; i++) {
            if (recList.get(i).getGender() == gender && recList.get(i).getGrade() == grade){
                tempString = recList.get(i).getRecommended();
            }
        }
        if (gender == 1 ) {
        recString = "Herr " + azubiName + "ist ein " + tempString + " Auszubildender";
        }
        else if (gender == 2 ) {
            recString = "Frau " + azubiName + "ist eine " + tempString + " Auszubildende";
        }
        return recString;
    }










   /* public  List<AnswerSuggestionModel> specificListForQuestion(int a, int b, List<AnswerSuggestionModel> list){
        List<AnswerSuggestionModel> specificList = new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i).getGender() == a && list.get(i).getGrade() == b){
                specificList.add(list.get(i));
            }
        }
        return specificList;
    }*/

   /* public String bla(int[] arrayListSlider) throws IOException {
        String sentences = "";
        List<AnswerSuggestionModel> bliblablub = createRecListFromExcel();
        for(int i = 0; i<19; i++) {
            sentences = sentences + bliblablub.get(i).specificListForQuestion(arrayListSlider[i], i, bliblablub).get(0).getRecommended();
            System.out.println(sentences);
        }
        if(sentences.length() == 0) {
            return "Leberkas";
        }
        return sentences;
    }*/

    //TODO ARRAY IDENTIFIER 1 WHICH QUESTION ?? SO 0-18
    //TODO ARRAY IDENTIFIER 2 WHICH GRADE?? 0-5
    //TODO ARRAY MESSAGE STRINGS

}

