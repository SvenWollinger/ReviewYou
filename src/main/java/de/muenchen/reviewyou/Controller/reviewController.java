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
    //TODO: Ask Rinor what exactly happens in the actionListener
    //TODO: After that, make ONE actionListener and put everything else inside this one
    //TODO: Then ask Rinor what he thought about the gender men/women
    //TODO: Look others TODO in code
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
                        //Safe selected data
                        //TODO: Every ...String function + setValue from sliders
                        gui.getAbilities().setText(getSocialBehaviorString());
                        gui.getStrength().setText(getWorkResultString());
                        gui.getDevelopements().setText(getParticipationInTheLessonString());
                        gui.getPerspective().setText(getIndependentWorkString());
                        gui.getOthers().setText(getSupportColleaguesString());

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
                        break;
                    case 7:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.eightPanel();
                        gui.getMoreInfo().setVisible(false);
                        gui.getPopup().setVisible(false);
                        break;
                    case 8:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
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
                        gui.getNext().setVisible(true);
                        gui.eightPanel();
                        break;
                    case 8:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.getMoreInfo().setVisible(true);
                        gui.seventhPanel();
                        break;
                    case 7:
                        gui.getPanel().removeAll();
                        gui.getPanel().revalidate();
                        gui.getPanel().repaint();
                        gui.sixthPanel();
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
                        //Safe selected data
                        //TODO: Every ...String function + setValue from sliders
                        gui.getAbilities().setText(getSocialBehaviorString());
                        gui.getStrength().setText(getWorkResultString());
                        gui.getDevelopements().setText(getParticipationInTheLessonString());
                        gui.getPerspective().setText(getIndependentWorkString());
                        gui.getOthers().setText(getSupportColleaguesString());

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

    public String getSocialBehaviorString() {
        if(gui.getBtn1SocialBehavior().isSelected()) {
            return null;
        }
        else if(gui.getBtn2SocialBehavior().isSelected()) {
            return null;
        }
        else if(gui.getBtn3SocialBehavior().isSelected()) {
            return null;
        }
        return null;
    }

    public String getWorkResultString() {
        if(gui.getBtn1WorkResult().isSelected()) {
            return null;
        }
        else if(gui.getBtn2WorkResult().isSelected()) {
            return null;
        }
        else if(gui.getBtn3WorkResult().isSelected()) {
            return null;
        }
        return null;
    }

    public String getParticipationInTheLessonString() {
        if(gui.getBtn1ParticipationInTheLesson().isSelected()) {
            return null;
        }
        else if(gui.getBtn2ParticipationInTheLesson().isSelected()) {
            return null;
        }
        else if(gui.getBtn3ParticipationInTheLesson().isSelected()) {
            return null;
        }
        return null;
    }

    public String getIndependentWorkString() {
        if(gui.getBtn1IndependentWork().isSelected()) {
            return null;
        }
        else if(gui.getBtn2IndependentWork().isSelected()) {
            return null;
        }
        else if(gui.getBtn3IndependentWork().isSelected()) {
            return null;
        }
        return null;
    }

    public String getSupportColleaguesString() {
        if(gui.getBtn1supportColleagues().isSelected()) {
            return null;
        }
        else if(gui.getBtn2supportColleagues().isSelected()) {
            return null;
        }
        else if(gui.getBtn3supportColleagues().isSelected()) {
            return null;
        }
        return null;
    }
}
