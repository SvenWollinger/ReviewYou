package de.muenchen.reviewyou.Controller;

import de.muenchen.reviewyou.GUI.GUI;
import de.muenchen.reviewyou.excelhandler.*;
import javax.swing.*;
import java.awt.*;
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
                    /*String[] name = gui.getTxtTraineeName().getText().split(",");
                    gui.setNameStudent(name[0]);*/

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
                FileDialog fileChooser = new FileDialog(new JFrame(), "Azubidaten", FileDialog.LOAD);
                fileChooser.setVisible(true);
                String path = fileChooser.getDirectory();
                String fileName = fileChooser.getFile();
                String pathAndName = path + fileName;
                if (path != null || fileName != null) {
                    File file = new File(pathAndName);
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
        gui.getGenderMen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableAllButtons();
            }
        });
        gui.getGenderWoman().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableAllButtons();
            }
        });

        //"Weiter" button
        gui.getNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (gui.getPage()) {
                    case 1:
                        gui.setPage(2);
                        gui.getPanel().setVisible(false);
                        gui.getSecondPanel().setVisible(true);
                        gui.getPrevious().setVisible(true);
                        gui.getBtnTraineedata().setVisible(true);
                        break;
                    case 2:
                        gui.setPage(3);
                        gui.getSecondPanel().setVisible(false);
                        gui.getThirdPanel().setVisible(true);
                        gui.getMoreInfo().setVisible(true);
                        gui.getBtnTraineedata().setVisible(false);
                        gui.getThirdPagePanel().setVisible(true);
                        if (!gui.getGenderMen().isSelected() && !gui.getGenderWoman().isSelected()){
                            disableAllButtons();
                        }
                        String[] name = gui.getTxtTraineeName().getText().split(",");
                        gui.setNameStudent(name[0]);
                        break;

                    case 3:
                        socialBehaviorString();
                        developmentsString();
                        othersString();
                        perspectivesString();
                        workResultString();
                        gui.setPage(4);
                        gui.getThirdPanel().setVisible(false);
                        gui.getFourthPanel().setVisible(true);
                        break;
                    case 4:
                        gui.setPage(5);
                        gui.getFourthPanel().setVisible(false);
                        gui.getFifthPanel().setVisible(true);
                        gui.getThirdPagePanel().setVisible(false);
                        break;
                    case 5:
                        gui.setPage(6);
                        gui.getFifthPanel().setVisible(false);
                        gui.getSixthPanel().setVisible(true);
                        break;
                    case 6:
                        gui.setPage(7);
                        gui.getSixthPanel().setVisible(false);
                        gui.getSeventhPanel().setVisible(true);
                        break;
                    case 7:
                        gui.setPage(8);
                        gui.getSeventhPanel().setVisible(false);
                        gui.getEigthPanel().setVisible(true);
                        gui.getMoreInfo().setVisible(false);
                        gui.getPopup().setVisible(false);
                        break;
                    case 8:
                        gui.setPage(9);
                        gui.getEigthPanel().setVisible(false);
                        gui.getNinethPanel().setVisible(true);
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
                        gui.setPage(8);
                        gui.getNinethPanel().setVisible(false);
                        gui.getEigthPanel().setVisible(true);
                        gui.getNext().setVisible(true);
                        //gui.eightPanel();
                        break;
                    case 8:
                        gui.setPage(7);
                        gui.getEigthPanel().setVisible(false);
                        gui.getSeventhPanel().setVisible(true);
                        gui.getMoreInfo().setVisible(true);
                        //gui.seventhPanel();
                        break;
                    case 7:
                        gui.setPage(6);
                        gui.getSeventhPanel().setVisible(false);
                        gui.getSixthPanel().setVisible(true);
                        break;
                    case 6:
                        gui.setPage(5);
                        gui.getSixthPanel().setVisible(false);
                        gui.getFifthPanel().setVisible(true);
                        break;
                    case 5:
                        gui.setPage(4);
                        gui.getFifthPanel().setVisible(false);
                        gui.getFourthPanel().setVisible(true);
                        break;
                    case 4:
                        socialBehaviorString();
                        developmentsString();
                        othersString();
                        perspectivesString();
                        workResultString();

                        gui.setPage(3);
                        gui.getFourthPanel().setVisible(false);
                        gui.getThirdPanel().setVisible(true);
                        gui.getThirdPagePanel().setVisible(true);
                        break;
                    case 3:
                        gui.setPage(2);
                        gui.getThirdPanel().setVisible(false);
                        gui.getSecondPanel().setVisible(true);
                        gui.getMoreInfo().setVisible(false);
                        gui.getPopup().setVisible(false);
                        gui.getBtnTraineedata().setVisible(true);
                        //gui.secondPanel();
                        gui.getThirdPagePanel().setVisible(false);
                        break;
                    case 2:
                        gui.setPage(1);
                        gui.getSecondPanel().setVisible(false);
                        gui.getPanel().setVisible(true);
                        gui.getPrevious().setVisible(false);
                        gui.getBtnTraineedata().setVisible(false);
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

    private void disableButtons(ButtonGroup buttonGroup){
        Enumeration<AbstractButton> enumeration = buttonGroup.getElements();
        while (enumeration.hasMoreElements()){
            JRadioButton button = (JRadioButton) enumeration.nextElement();
            button.setEnabled(false);
        }
    }

    private void enableButtons(ButtonGroup buttonGroup){
        Enumeration<AbstractButton> enumeration = buttonGroup.getElements();
        while (enumeration.hasMoreElements()){
            JRadioButton button = (JRadioButton) enumeration.nextElement();
            button.setEnabled(true);
        }
    }

    private void disableAllButtons(){
        disableButtons(gui.getIndependentWorkGroup());
        disableButtons(gui.getSocialBehaviorGroup());
        disableButtons(gui.getSupportColleaguesGroup());
        disableButtons(gui.getWorkResultGroup());
        disableButtons(gui.getParticipationInTheLessonGroup());
    }

    private void enableAllButtons(){
        enableButtons(gui.getParticipationInTheLessonGroup());
        enableButtons(gui.getWorkResultGroup());
        enableButtons(gui.getSupportColleaguesGroup());
        enableButtons(gui.getIndependentWorkGroup());
        enableButtons(gui.getSocialBehaviorGroup());
    }


}
