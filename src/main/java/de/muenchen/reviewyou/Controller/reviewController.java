package de.muenchen.reviewyou.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reviewController {
    //TODO: We make the actionListener for UI group
    //TODO: At the end is a "weiter" button. If you click the button, the inserted data gets safed. On every page (expect first page) is a "zurück" button
    //TODO: If you click on "zurück" the safed data from every JTextField gets inserted again into their previous TextField

    ActionListener actionListenerNextPage = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Click on "weiter" -> inserdetData gets safed
        }
    };

    ActionListener actionListenerPreviousPage = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: Get and set -> Save informations in JTextFields.
            //TODO: Load Data Class with Informations


        }
    };


}
