package de.muenchen.reviewyou.Controller;

import de.muenchen.reviewyou.GUI.GUI;
import de.muenchen.reviewyou.excelhandler.ExcelHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class reviewController {
    GUI gui; //Now everything out of scope can take this

    public reviewController(ExcelHandler excelHandler, GUI gui) {
        this.gui = gui;
        ActionListener actionListenerSafeData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                traineeRating traineeRating = new traineeRating();

                //Give values to Excel-Group
                try{
                    excelHandler.writeInstructorData(gui.getInstructorName().getText(),
                            gui.getInstructorTelephone().getText(), gui.getCurrentDate().getText()); //TODO: Missing "E-Mail"
                    excelHandler.writeStudentData(gui.getTxtTraineeName().getText(), gui.getTxtBirthDate().getText(),
                            gui.getTxtApartmentStreet().getText(), gui.getTxtTraineeYear().getText(),
                            gui.getTxtCourse().getText());
                    excelHandler.writeAllocationPeriod(gui.getTxtFrom().getJFormattedTextField().getText(),
                            gui.getTxtTill().getJFormattedTextField().getText(),
                            gui.getTxtInternshipSelection().getText());
                    excelHandler.writeTrainingAreaAndPeriod(gui.getTxtTrainingArea().getText());
                    excelHandler.writeParticipations(gui.getTxtSessions().getText());
                    excelHandler.writeDates(gui.getTxtTrainingsPlan().getText(), gui.getTxtInterimTalk().getText());
                    excelHandler.writePerformance(traineeRating.abilities(), traineeRating.strength(),
                            traineeRating.developments(), traineeRating.perspective(), traineeRating.others());
                    excelHandler.writeTotalandAverage(gui.getTxtPoints().getText(), gui.getTxtReview().getText());
                    //excelHandler.writePoints(xxx, gui.getTxtPoints().getText()); //TODO: Write it
                } catch (IOException ioException) {
                    System.out.println("Error in SQL!" + ioException.getMessage());
                }

                if (e.getSource().equals(gui.getSaveAndNew())) { //"Speichern und neuer Leistungsbericht" button
                    for(int i = 0; i < 19; i++) {
                        //Reset every slider
                        gui.getjSliders().get(i).setValue(gui.getjSliders().get(i).getMinimum());
                    }

                    //Clear text
                    String placeholder = "";
                    gui.getTxtTraineeName().setText(placeholder);
                    gui.getTxtBirthDate().setText(placeholder);
                    gui.getTxtApartmentStreet().setText(placeholder);

                    gui.goToFirstPanel();
                } else if (e.getSource().equals(gui.getSaveAndExit())) { //"Speichern und Schließen" button
                    System.exit(0);
                }
            }
        };

        //Add both buttons to ActionListener
        gui.getSaveAndNew().addActionListener(actionListenerSafeData);
        gui.getSaveAndExit().addActionListener(actionListenerSafeData);

        //Calculate-button
        gui.getCalc().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.getTxtPoints().setText(String.valueOf(calculateAveragePoints(gui)));
                gui.getTxtReview().setText(calculateAverage(gui));
            }
        });
    }



    public String calculateAverage(GUI gui) {
        String average = "";
        for(int i = 0; i < calculateAveragePoints(gui); i++) {
            if(calculateAveragePoints(gui) <= 15 && calculateAveragePoints(gui) >= 6) {
                average = "Geeignet";
            } else if(calculateAveragePoints(gui) <= 5.99 && calculateAveragePoints(gui) >= 3) {
                average = "Noch nicht geeignet";
            } else if(calculateAveragePoints(gui) <= 2.99 && calculateAveragePoints(gui) >= 0) {
                average = "Nicht geeignet";
            }
        }
        return average;
    }

    public double calculateAveragePoints(GUI gui) {
        int totalPoints = 0;
        double averagePoints = 0;
        for(int i = 0; i < 19; i++) {
            totalPoints = totalPoints + gui.getjSliders().get(i).getValue();
        }
        averagePoints = totalPoints / 19;
        return averagePoints;
    }

    /*public void textForTraineeRating(traineeRating traineeRating) { //TODO: Ask Excel how they did it
        abilities.setText(traineeRating.abilities());
        strength.setText(traineeRating.strength());
        developements.setText(traineeRating.developments());
        perspective.setText(traineeRating.perspective());
        others.setText(traineeRating.others());
    }*/
}