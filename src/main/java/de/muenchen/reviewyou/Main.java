package de.muenchen.reviewyou;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        System.out.println("Hi");

        ExcelHandler excelHandler = new ExcelHandler();
        excelHandler.writeCell(1, "Baumann Leonhard");
            }
}
