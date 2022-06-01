package de.muenchen.reviewyou;

import de.muenchen.reviewyou.Controller.reviewController;
import de.muenchen.reviewyou.GUI.GUI;
import de.muenchen.reviewyou.excelhandler.Azubi;
import de.muenchen.reviewyou.excelhandler.ExcelHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        reviewController reviewController = new reviewController(new ExcelHandler(), new GUI());
    }
}
