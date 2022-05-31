package de.muenchen.reviewyou;

import de.muenchen.reviewyou.Controller.reviewController;
import de.muenchen.reviewyou.GUI.GUI;
import de.muenchen.reviewyou.excelhandler.AnswerSuggestionModel;
import de.muenchen.reviewyou.excelhandler.Azubi;
import de.muenchen.reviewyou.excelhandler.ExcelDatabaseHandler;
import de.muenchen.reviewyou.excelhandler.ExcelHandler;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        GUI gui = new GUI();
        reviewController reviewController = new reviewController(new ExcelHandler(), new GUI(), ExcelDatabaseHandler.getInstance());
    }
}
