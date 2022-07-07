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
import java.util.Enumeration;
import java.util.List;

public class reviewController {
    GUI gui;
    private final int[] arrayListSlider = new int[19];
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public reviewController(ExcelHandler excelHandler, GUI gui) {
        this.gui = gui;

        //Sett current dates
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int lastYear = currentYear -1;
        gui.getModel().setDate(lastYear,8,1);
        gui.getModel().setSelected(true);
        gui.getModel1().setDate(currentYear,7,31);
        gui.getModel1().setSelected(true);
        gui.getModel2().setSelected(true);

        ActionListener actionListenerSafeData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Give values to Excel-Group
                try {
                    excelHandler.writeInstructorData(gui.getInstructorName().getText(),
                            gui.getInstructorTelephone().getText(), gui.getTxtDate().getText(),
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

                //Create excel file with the name of the trainee
                try {
                    excelHandler.copyFinalFile(gui.getTxtTraineeName().getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
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

        //"Berechnen" button
        gui.getCalc().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.getTxtPoints().setText(String.valueOf(calculateAveragePoints(gui)));
                gui.getTxtReview().setText(calculateAverage(gui));
            }
        });

        //setText from loaded AzubiData.xlsx
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

        //"Info" button
        gui.getMoreInfo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.moreInfo();
            }
        });

        //Load AzubiDaten.xlsx
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
                        for (Azubi azubi : azubis) {
                            gui.getApprenticeshipSelector().addItem(azubi);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //"Weiter" button
        gui.getNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (gui.getPage()) {
                    case 1:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.getPrevious().setVisible(true);
                        gui.getBtnTraineedata().setVisible(true);
                        gui.secondPanel();
                        break;
                    case 2:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.thirdPanel();
                        gui.getMoreInfo().setVisible(true);
                        gui.getBtnTraineedata().setVisible(false);
                        break;
                    case 3:
                        //Safe selected data
                        socialBehaviorString();
                        workResultString();
                        developmentsString();
                        perspectivesString();
                        othersString();
                        gui.getPickSocialBehavior().setVisible(false);
                        gui.getPickSocialBehavior2().setVisible(false);
                        gui.getPickSocialBehavior3().setVisible(false);
                        gui.getPickWorkResult1().setVisible(false);
                        gui.getPickWorkResult2().setVisible(false);
                        gui.getPickWorkResult3().setVisible(false);
                        gui.getPickParticipationInTheLesson1().setVisible(false);
                        gui.getPickParticipationInTheLesson2().setVisible(false);
                        gui.getPickParticipationInTheLesson3().setVisible(false);
                        gui.getPickIndependentWork1().setVisible(false);
                        gui.getPickIndependentWork2().setVisible(false);
                        gui.getPickIndependentWork3().setVisible(false);
                        gui.getPickSupportColleagues1().setVisible(false);
                        gui.getPickSupportColleagues2().setVisible(false);
                        gui.getPickSupportColleagues3().setVisible(false);

                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.fourthPanel();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        break;
                    case 4:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.fifthPanel();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        break;
                    case 5:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.sixthPanel();
                        break;
                    case 6:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.seventhPanel();
                        break;
                    case 7:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.eightPanel();
                        gui.getMoreInfo().setVisible(false);
                        gui.getPopup().setVisible(false);
                        break;
                    case 8:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.ninethPanel();
                        gui.getNext().setVisible(false);
                        break;

                }
            }
        });

        //"Zurück" button
        gui.getPrevious().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (gui.getPage()) {
                    case 9:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.getNext().setVisible(true);
                        gui.eightPanel();
                        break;
                    case 8:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.getMoreInfo().setVisible(true);
                        gui.seventhPanel();
                        break;
                    case 7:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.sixthPanel();
                        break;
                    case 6:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.fifthPanel();
                        break;
                    case 5:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.fourthPanel();
                        break;
                    case 4:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getPanel().repaint();
                        gui.thirdPanel();

                        gui.getPickSocialBehavior().setVisible(true);
                        gui.getPickSocialBehavior2().setVisible(true);
                        gui.getPickSocialBehavior3().setVisible(true);
                        gui.getPickWorkResult1().setVisible(true);
                        gui.getPickWorkResult2().setVisible(true);
                        gui.getPickWorkResult3().setVisible(true);
                        gui.getPickParticipationInTheLesson1().setVisible(true);
                        gui.getPickParticipationInTheLesson2().setVisible(true);
                        gui.getPickParticipationInTheLesson3().setVisible(true);
                        gui.getPickIndependentWork1().setVisible(true);
                        gui.getPickIndependentWork2().setVisible(true);
                        gui.getPickIndependentWork3().setVisible(true);
                        gui.getPickSupportColleagues1().setVisible(true);
                        gui.getPickSupportColleagues2().setVisible(true);
                        gui.getPickSupportColleagues3().setVisible(true);
                        break;
                    case 3:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
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



    //Calculates String for "Gesamturteil"
    public String calculateAverage(GUI gui) {
        String average = "";
        for (int i = -1; i < calculateAveragePoints(gui); i++) {
            if (calculateAveragePoints(gui) <= 15 && calculateAveragePoints(gui) >= 6) {
                average = "Geeignet";
            } else if (calculateAveragePoints(gui) <= 5.99 && calculateAveragePoints(gui) >= 3) {
                average = "Noch nicht geeignet";
            } else {
                average = "Nicht geeignet";
            }
        }
        return average;
    }

    //Calculate double for "Durchschnittspunktzahl"
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

    //Round the double for averagePoints ("Durchschnittspunktzahl")
    public static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    //Return String for job-shortcut
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

    public void socialBehaviorString() {
        for (Enumeration<AbstractButton> buttons = gui.getSocialBehaviorGroup().getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                switch (button.getText()) {
                    case "1":
                        gui.getAbilities().setText(gui.getPickSocialBehavior().getSelectedValue().toString());
                        gui.getjSliders().get(0).setValue(12);
                        gui.getjSliders().get(6).setValue(12);
                        gui.getjSliders().get(7).setValue(12);
                        gui.getjSliders().get(8).setValue(12);
                        gui.getjSliders().get(9).setValue(12);
                        gui.getjSliders().get(10).setValue(12);
                        gui.getjSliders().get(11).setValue(12);
                        gui.getjSliders().get(12).setValue(12);
                        gui.getjSliders().get(13).setValue(12);
                        gui.getjSliders().get(15).setValue(12);
                        gui.getjSliders().get(18).setValue(12);
                        break;
                    case "2":
                        gui.getAbilities().setText(gui.getPickSocialBehavior2().getSelectedValue().toString());
                        gui.getjSliders().get(0).setValue(8);
                        gui.getjSliders().get(6).setValue(8);
                        gui.getjSliders().get(7).setValue(8);
                        gui.getjSliders().get(8).setValue(8);
                        gui.getjSliders().get(9).setValue(8);
                        gui.getjSliders().get(10).setValue(8);
                        gui.getjSliders().get(11).setValue(8);
                        gui.getjSliders().get(12).setValue(8);
                        gui.getjSliders().get(13).setValue(8);
                        gui.getjSliders().get(15).setValue(8);
                        gui.getjSliders().get(18).setValue(8);
                        break;
                    case "3":
                        gui.getAbilities().setText(gui.getPickSocialBehavior3().getSelectedValue().toString());
                        gui.getjSliders().get(0).setValue(4);
                        gui.getjSliders().get(6).setValue(4);
                        gui.getjSliders().get(7).setValue(4);
                        gui.getjSliders().get(8).setValue(4);
                        gui.getjSliders().get(9).setValue(4);
                        gui.getjSliders().get(10).setValue(4);
                        gui.getjSliders().get(11).setValue(4);
                        gui.getjSliders().get(12).setValue(4);
                        gui.getjSliders().get(13).setValue(4);
                        gui.getjSliders().get(15).setValue(4);
                        gui.getjSliders().get(18).setValue(4);
                        break;
                }
            }
        }
    }

    public void workResultString() {
        for (Enumeration<AbstractButton> buttons = gui.getWorkResultGroup().getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                switch (button.getText()) {
                    case "1":
                        gui.getStrength().setText(gui.getPickWorkResult1().getSelectedValue().toString());
                        gui.getjSliders().get(1).setValue(12);
                        break;
                    case "2":
                        gui.getStrength().setText(gui.getPickWorkResult2().getSelectedValue().toString());
                        gui.getjSliders().get(1).setValue(8);
                        break;
                    case "3":
                        gui.getStrength().setText(gui.getPickWorkResult3().getSelectedValue().toString());
                        gui.getjSliders().get(1).setValue(4);
                        break;
                }
            }
        }
    }

    public void developmentsString() {
        for (Enumeration<AbstractButton> buttons = gui.getParticipationInTheLessonGroup().getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                switch (button.getText()) {
                    case "1":
                        gui.getDevelopements().setText(gui.getPickParticipationInTheLesson1().getSelectedValue().toString());
                        gui.getjSliders().get(2).setValue(12);
                        gui.getjSliders().get(14).setValue(12);
                        break;
                    case "2":
                        gui.getDevelopements().setText(gui.getPickParticipationInTheLesson2().getSelectedValue().toString());
                        gui.getjSliders().get(2).setValue(8);
                        gui.getjSliders().get(14).setValue(8);
                        break;
                    case "3":
                        gui.getDevelopements().setText(gui.getPickParticipationInTheLesson3().getSelectedValue().toString());
                        gui.getjSliders().get(2).setValue(4);
                        gui.getjSliders().get(14).setValue(4);
                        break;
                }
            }
        }
    }

    public void perspectivesString() {
        for (Enumeration<AbstractButton> buttons = gui.getIndependentWorkGroup().getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                switch (button.getText()) {
                    case "1":
                        gui.getPerspective().setText(gui.getPickIndependentWork1().getSelectedValue().toString());
                        gui.getjSliders().get(3).setValue(12);
                        gui.getjSliders().get(4).setValue(12);
                        gui.getjSliders().get(5).setValue(12);
                        gui.getjSliders().get(17).setValue(12);
                        break;
                    case "2":
                        gui.getPerspective().setText(gui.getPickIndependentWork2().getSelectedValue().toString());
                        gui.getjSliders().get(3).setValue(8);
                        gui.getjSliders().get(4).setValue(8);
                        gui.getjSliders().get(5).setValue(8);
                        gui.getjSliders().get(17).setValue(8);
                        break;
                    case "3":
                        gui.getPerspective().setText(gui.getPickIndependentWork3().getSelectedValue().toString());
                        gui.getjSliders().get(3).setValue(4);
                        gui.getjSliders().get(4).setValue(4);
                        gui.getjSliders().get(5).setValue(4);
                        gui.getjSliders().get(17).setValue(4);
                        break;
                }
            }
        }
    }

    public void othersString() {
        for (Enumeration<AbstractButton> buttons = gui.getSupportColleaguesGroup().getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                switch (button.getText()) {
                    case "1":
                        gui.getOthers().setText(gui.getPickSupportColleagues1().getSelectedValue().toString());
                        gui.getjSliders().get(16).setValue(12);
                        break;
                    case "2":
                        gui.getOthers().setText(gui.getPickSupportColleagues2().getSelectedValue().toString());
                        gui.getjSliders().get(16).setValue(8);
                        break;
                    case "3":
                        gui.getOthers().setText(gui.getPickSupportColleagues3().getSelectedValue().toString());
                        gui.getjSliders().get(16).setValue(4);
                        break;
                }
            }
        }
    }
}
