package de.muenchen.reviewyou;

import de.muenchen.reviewyou.Controller.reviewController;
import de.muenchen.reviewyou.GUI.GUI;
import de.muenchen.reviewyou.excelhandler.*;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
   /*     try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }*/
        reviewController reviewController = new reviewController(new ExcelHandler(), new GUI(), ExcelDatabaseHandler.getInstance(), new AzubiGenerator());
    }
}
