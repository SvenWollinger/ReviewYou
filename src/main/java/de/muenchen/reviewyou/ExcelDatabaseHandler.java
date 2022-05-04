package de.muenchen.reviewyou;

import java.util.ArrayList;

public class ExcelDatabaseHandler {
    private int[][] grades = new int[15][19];
    private ArrayList<String> possiblesForGerman;
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
    private ArrayList<String> possiblesForCrtics;












    public void setGrade(int i, int j, int grade) {
        this.grades[i][j] = grade;

    }
}
