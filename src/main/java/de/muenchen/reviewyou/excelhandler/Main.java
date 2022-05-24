package de.muenchen.reviewyou.excelhandler;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        ExcelHandler excelHandler = new ExcelHandler();
        ExcelDatabaseHandler excelDatabaseHandler = ExcelDatabaseHandler.getInstance();
        AzubiGenerator azubiGenerator = new AzubiGenerator();


/*      excelHandler.writeStudentData("Baumann Leonhard", "30.04.1998", "Geheim", "1", "Schnitzel");
        excelHandler.writePerformance("Redet","Singt","Tanzt","Lehrer", "Sowieso");
        excelHandler.writeAllocationPeriod("10.10.10", "11.11.11", "Dusche");
        excelHandler.writeDates("10.10.10", "11.10.10");
        excelHandler.writeTrainingAreaAndPeriod("Dusche und von heute bis gestern");
        excelHandler.writeParticipations("BlahBlah sagt Bumbo in the Schrein");
        excelHandler.writePoints(133, 10);
        excelHandler.writeTotalandAverage("Geeignet", "13");*/

        //excelDatabaseHandler.addRecommendation(5, 7,"Kann Gut Deutsch");
        //System.out.println(excelDatabaseHandler.createRecListFromExcel());
        //excelHandler.copyFinalFile("hallo");

        System.out.println(azubiGenerator.getAzubiList("src/main/resources/AzubiDaten.xlsx"));

    }
}
