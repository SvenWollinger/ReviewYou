package de.muenchen.reviewyou.Controller;

import de.muenchen.reviewyou.GUI.GUI;
import de.muenchen.reviewyou.excelhandler.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

public class reviewController {
    GUI gui; //Now everything out of scope can take this
    private int[] arrayListSlider = new int[19];

    public reviewController(ExcelHandler excelHandler, GUI gui, ExcelDatabaseHandler excelDatabaseHandler, AzubiGenerator azubiGenerator) throws IOException {
        this.gui = gui;

        //Dummies
        JComboBox jComboBox = new JComboBox();

        //Add every azubiName to comboBox
        for(int i = 0; i < azubiGenerator.getAzubiList("").size(); i++) {
            jComboBox.addItem(azubiGenerator.getAzubiList("").get(i));
        }

        ActionListener actionListenerSafeData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Give values to Excel-Group
                try{
                    excelHandler.writeInstructorData(gui.getInstructorName().getText(),
                            gui.getInstructorTelephone().getText(), gui.getTxtdate().getText(),
                            gui.getInstructorEmail().getText());
                    excelHandler.writeStudentData(gui.getTxtTraineeName().getText(), gui.getTxtBirthDate().getText(),
                            gui.getTxtApartmentStreet().getText(), gui.getTxtTraineeYear().getText(),
                            gui.getTxtCourse().getText());
                    excelHandler.writeAllocationPeriod(gui.getTxtFrom().getJFormattedTextField().getText(),
                            gui.getTxtTill().getJFormattedTextField().getText(),
                            gui.getTxtInternshipSelection().getText());
                    excelHandler.writeTrainingAreaAndPeriod(gui.getTxtTrainingArea().getText());
                    excelHandler.writeParticipations(gui.getTxtSessions().getText());
                    excelHandler.writeDates(gui.getTxtTrainingsPlan().getText(), gui.getTxtInterimTalk().getText());
                    excelHandler.writePerformance(gui.getAbilities().getText(),gui.getStrength().getText(),gui.getDevelopements().getText(),gui.getPerspective().getText(),gui.getOthers().getText());
                    //excelDatabaseHandler.bla(arrayListSlider);
                    excelHandler.writeTotalandAverage(gui.getTxtReview().getText(), gui.getTxtPoints().getText());

                    //Get every value and give them to excel
                    int pointsFromSliders = 0;
                    int row = 133;
                    for(int i = 0; i < 19; i++) {
                        pointsFromSliders = gui.getjSliders().get(i).getValue();
                        excelHandler.writePoints(row, pointsFromSliders);
                        row = row + 1;
                        if(row == 136) {
                            row = 139;
                        }
                        else if(row == 142) {
                            row = 145;
                        }
                        else if(row == 151) {
                            row = 154;
                        }
                    }
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

        //Calculate-button
        gui.getCalc().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.getTxtPoints().setText(String.valueOf(calculateAveragePoints(gui)));
                gui.getTxtReview().setText(calculateAverage(gui));
            }
        });

        ActionListener actionListenerComboBox = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Insert azubiData from the name the user clicked on
                    //Create new azubi based on the comboBox. Then setter/getter are working
                    for(int i = 0; i < azubiGenerator.getAzubiList("").size(); i++) {
                        if(e.getSource().equals(azubiGenerator.getAzubiList("").get(i))) {
                            //Dummie
                            Azubi azubi = new Azubi("", "", "", 1, "", "", "");

                            gui.getTxtTraineeName().setText(azubi.getName());
                            gui.getTxtBirthDate().setText(String.valueOf(azubi.getBirthday()));
                            gui.getTxtApartmentStreet().setText(azubi.getAddress());
                            //gui.getTxtFrom().set
                            //gui.getTxtTill().set
                            gui.getTxtTraineeYear().setText(String.valueOf(azubi.getYear()));
                            gui.getTxtCourse().setText(azubi.getCourse());
                        }
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        //Add both buttons to ActionListener
        gui.getSaveAndNew().addActionListener(actionListenerSafeData);
        gui.getSaveAndExit().addActionListener(actionListenerSafeData);
        jComboBox.addActionListener(actionListenerComboBox);
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
        double totalPoints = 0;
        double averagePoints = 0;
        for(int i = 0; i < 19; i++) {
            totalPoints = totalPoints + gui.getjSliders().get(i).getValue();
            arrayListSlider[i] = gui.getjSliders().get(i).getValue(); //Fill array
        }
        averagePoints = totalPoints / 19;
        averagePoints = round(averagePoints, 2);
        return averagePoints;
    }

    public static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}