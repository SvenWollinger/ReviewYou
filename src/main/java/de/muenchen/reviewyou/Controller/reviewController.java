package de.muenchen.reviewyou.Controller;

import de.muenchen.reviewyou.GUI.GUI;
import de.muenchen.reviewyou.excelhandler.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;

public class reviewController {
    GUI gui;
    private final int[] arrayListSlider = new int[19];
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public reviewController(ExcelHandler excelHandler, GUI gui) {
        this.gui = gui;

        //Sett current year from "Zuweisungszeitraum"
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int lastYear = currentYear -1;
        gui.getModel().setDate(lastYear,8,1);
        gui.getModel().setSelected(true);

        gui.getModel1().setDate(currentYear,7,31);
        gui.getModel1().setSelected(true);

        ActionListener actionListenerSafeData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Give values to Excel-Group
                try {
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
                    excelHandler.writeDates(gui.getPickerHandover().getJFormattedTextField().getText(),
                            gui.getPickerMeeting().getJFormattedTextField().getText());
                    excelHandler.writePerformance(gui.getAbilities().getText(),gui.getStrength().getText(),
                            gui.getDevelopements().getText(),gui.getPerspective().getText(),gui.getOthers().getText());
                    excelHandler.writeTotalandAverage(gui.getTxtReview().getText(), gui.getTxtPoints().getText());
                    excelHandler.writeCourse(getStringCourse());

                    //Create excel file with the name of the trainee
                    try {
                        excelHandler.copyFinalFile(gui.getTxtTraineeName().getText());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    //Get every value and give them to excel
                    int pointsFromSliders = 0;
                    int row = 133;
                    for (int i = 0; i < 19; i++) {
                        pointsFromSliders = gui.getjSliders().get(i).getValue();
                        excelHandler.writePoints(row, pointsFromSliders);
                        row = row + 1;
                        if (row == 136) {
                            row = 139;
                        } else if (row == 142) {
                            row = 145;
                        } else if (row == 151) {
                            row = 154;
                        }
                    }
                } catch (IOException ioException) {
                    System.out.println("Error in SQL!" + ioException.getMessage());
                }

                if (e.getSource().equals(gui.getSaveAndNew())) { //"Speichern und neuer Leistungsbericht" button
                    for (int i = 0; i < 19; i++) {
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

        gui.getApprenticeshipSelector().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(gui.getApprenticeshipSelector().getSelectedItem());
                Azubi azubi = (Azubi) gui.getApprenticeshipSelector().getSelectedItem();
                if (azubi != null) {
                    gui.getTxtTraineeName().setText(azubi.getName());
                    gui.getTxtApartmentStreet().setText(azubi.getAddress());
                    gui.getTxtBirthDate().setText(azubi.getBirthday().toString());
                    gui.getTxtBirthDate().setText(azubi.getBirthday().format(sdf));
                    gui.getTxtFrom().getJFormattedTextField().setText(azubi.getAllocationPeriodFrom().format(sdf));
                    gui.getTxtTill().getJFormattedTextField().setText(azubi.getAllocationPeriodTo().format(sdf));
                    gui.getTxtCourse().setText(azubi.getCourse());
                    gui.getTxtInternshipSelection().setText(String.valueOf(azubi.getInternshipSection()));
                    gui.getTxtTraineeYear().setText(String.valueOf(azubi.getYear()));
                }
            }
        });

        gui.getMoreInfo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.moreInfo();
            }
        });

        gui.getBtnTraineedata().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                int optiion = fileChooser.showOpenDialog(null);
                if (optiion == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    AzubiGenerator azubiGenerator = new AzubiGenerator();
                    try {
                        List<Azubi> azubis = azubiGenerator.getAzubiList(file.getPath());
                        for(int i = 0; i < azubis.size(); i++) {
                            gui.getApprenticeshipSelector().addItem(azubis.get(i));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        gui.getNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (gui.getPage()) {
                    case 1:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPrevious().setVisible(true);
                        gui.getBtnTraineedata().setVisible(true);
                        gui.secondPanel();
                        break;
                    case 2:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.thirdPanel();
                        gui.getMoreInfo().setVisible(true);
                        gui.getBtnTraineedata().setVisible(false);
                        break;
                    case 3:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.fourthPanel();
                        break;
                    case 4:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.fifthPanel();
                        break;
                    case 5:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.sixthPanel();
                        break;
                    case 6:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.seventhPanel();
                        gui.getMoreInfo().setVisible(false);
                        gui.getPopup().setVisible(false);
                        break;
                    case 7:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.eightPanel();
                        gui.getNext().setVisible(false);
                        break;

                }
            }
        });

        gui.getPrevious().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (gui.getPage()) {
                    case 8:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.seventhPanel();
                        gui.getNext().setVisible(true);
                        break;
                    case 7:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.sixthPanel();
                        gui.getMoreInfo().setVisible(true);
                        break;
                    case 6:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.fifthPanel();
                        break;
                    case 5:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.fourthPanel();
                        break;
                    case 4:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.thirdPanel();
                        break;
                    case 3:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getMoreInfo().setVisible(false);
                        gui.getPopup().setVisible(false);
                        gui.getBtnTraineedata().setVisible(true);
                        gui.secondPanel();
                        break;
                    case 2:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPrevious().setVisible(false);
                        gui.getBtnTraineedata().setVisible(false);
                        gui.startPanel();
                        break;
                }
            }
        });

        //Add both buttons to ActionListener
        gui.getSaveAndNew().addActionListener(actionListenerSafeData);
        gui.getSaveAndExit().addActionListener(actionListenerSafeData);
    }



    public String calculateAverage(GUI gui) {
        String average = "";
        for (int i = 0; i < calculateAveragePoints(gui); i++) {
            if (calculateAveragePoints(gui) <= 15 && calculateAveragePoints(gui) >= 6) {
                average = "Geeignet";
            } else if (calculateAveragePoints(gui) <= 5.99 && calculateAveragePoints(gui) >= 3) {
                average = "Noch nicht geeignet";
            } else if (calculateAveragePoints(gui) <= 2.99 && calculateAveragePoints(gui) >= 0) {
                average = "Nicht geeignet";
            }
        }
        return average;
    }

    public double calculateAveragePoints(GUI gui) {
        double totalPoints = 0;
        double averagePoints = 0;
        for (int i = 0; i < 19; i++) {
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

    public String getStringCourse() {
        if (gui.getTxtCourse().getText().equals("FIAE")) {
            return "zur Fachinformatikerin/ zum Fachinformatiker - Anwendungsentwicklung";
        }
        else if (gui.getTxtCourse().getText().equals("FISI")) {
            return "zur Fachinformatikerin/ zum Fachinformatiker - Systemintegration";
        }
        else if (gui.getTxtCourse().getText().equals("ITSE")) {
            return "zur IT-Systemelektronikerin / zum IT-Systemelektroniker";
        }
        return null;
    }
}