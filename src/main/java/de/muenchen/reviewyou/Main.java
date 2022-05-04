package de.muenchen.reviewyou;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        System.out.println("Hi");

        ExcelHandler excelHandler = new ExcelHandler();
        ExcelDatabaseHandler excelDatabaseHandler = ExcelDatabaseHandler.getInstance();

/*        excelHandler.writeStudentData("Baumann Leonhard", "30.04.1998", "Geheim", "1", "Schnitzel");
        excelHandler.writePerformance("Stinkt","Stinkt","Mehr Stinken","Stinker", "Stinkt gut");
        excelHandler.writeAllocationPeriod("10.10.10", "11.11.11", "Dusche");
        excelHandler.writeDates("10.10.10", "11.10.10");
        excelHandler.writeTrainingAreaAndPeriod("Dusche und von heute bis gestern");
        excelHandler.writeParticipations("BlahBlah sagt Bumbo in the Schrein");
        excelHandler.writePoints(133, 10);
        excelHandler.writeTotalandAverage("Geeignet", "13");*/
        excelDatabaseHandler.addRecommendation(5, 7,"Leo stinkt manchmal ganz schoen");
        System.out.println(excelDatabaseHandler.createRecListFromExcel());
            }
}
