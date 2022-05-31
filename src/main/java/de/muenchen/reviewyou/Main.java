package de.muenchen.reviewyou;

import de.muenchen.reviewyou.Controller.reviewController;
import de.muenchen.reviewyou.GUI.GUI;
import de.muenchen.reviewyou.excelhandler.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new reviewController(new ExcelHandler(), new GUI());
        }
    }
