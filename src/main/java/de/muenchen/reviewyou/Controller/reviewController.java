package de.muenchen.reviewyou.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reviewController {
    //Dummies
    JButton calc = new JButton();
    JButton saveAndNew = new JButton();
    JButton saveAndExit = new JButton();

    public reviewController() {

        //TODO: Ask Excel-Group if the code is good + how should we do the 2x big tables? + what does writePoints?
        
        ActionListener actionListenerSafeData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Dummies
                JTextField instructorName = new JTextField();
                JTextField instructorTelephone = new JTextField();
                JTextField currentDate = new JTextField();
                JTextField txtTraineeName = new JTextField();
                JTextField txtBirthDate = new JTextField();
                JTextField txtApartmentStreet = new JTextField();
                JTextField txtTraineeYear = new JTextField();
                JTextField txtCourse = new JTextField();
                JTextField txtFrom = new JTextField();
                JTextField txtTill = new JTextField();
                JTextField txtIntershipSelection = new JTextField();
                JTextField txtTrainingArea = new JTextField();
                JTextField txtSessions = new JTextField();
                JTextField txtTrainingsPlan = new JTextField();
                JTextField txtInternimTalk = new JTextField();
                JTextArea abilities = new JTextArea();
                JTextArea strength = new JTextArea();
                JTextArea developements = new JTextArea();
                JTextArea perspective = new JTextArea();
                JTextArea others = new JTextArea();

                //TODO: First every safe-statement, then the if-cases
                writeInstructorData(instructorName.getText(), instructorTelephone.getText(), currentDate.getText());
                writeStudentData(txtTraineeName.getText(), txtBirthDate.getText(), txtApartmentStreet.getText(),
                        txtTraineeYear.getText(), txtCourse.getText());
                writeAllocationPeriod(txtFrom.getText(), txtTill.getText(), txtIntershipSelection.getText());
                writeTrainingAreaAndPeriod(txtTrainingArea.getText());
                writeParticipations(txtSessions.getText());
                writeDates(txtTrainingsPlan.getText(), txtInternimTalk.getText());
                //writePerformance();
                //TODO: Values from sliders gives text (make function for that) and then insert them into
                //      TODO: ability, strength, ... -> Aks Olli which points from sliders gives which text

                if(e.getSource().equals(saveAndNew)) {
                    //Button "Speichern und neuer Leistungsbericht"
                    //Delete data from second Page (only trainee). Everything else from first/second page is the same
                    //  as before. But reset every slider and open page 1
                }

                else if(e.getSource().equals(saveAndExit)) {
                    //Button "Speichern und schließen"
                    //Safe data and end programm
                }
            }
        };


        ActionListener actionListenerCalculate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Button "Berechnen"
                //Calculate "Punktzahl" and "Gesamturteil" -> writeTotalandAverage() (Josef)
            }
        };


        //Dummies for add jButton to actionListener
        saveAndNew.addActionListener(actionListenerSafeData);
        saveAndExit.addActionListener(actionListenerSafeData);
        calc.addActionListener(actionListenerSafeData);








//        ActionListener actionListenerSafeData = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                data.setFirstName(xxx.getText());
//                data.setLastName(xxx.getText());
//                data.setStreet(xxx.getText());
//                data.setHouseNumber(xxx.getText());
//                data.setPostalCode(xxx.getText());
//                data.setLocation(xxx.getText());
//                data.setCourse(xxx.getText());
//                data.setIntershipSection(xxx.getText());
//                data.setTrainingArea(xxx.getText());
//                data.setParticipationInCourses(xxx.getText());
//                data.setTraineesRating(xxx.getText()); "Gesamturteil" -> means if i have x points i get y Text (Ask Olli how they calculate it)
//                data.setTraineesSkills(xxx.getText());
//                data.setTraineesStrengths(xxx.getText());
//                data.setTraineesDevelopmentFields(xxx.getText());
//                data.setTraineesPerspectives(xxx.getText());
//                data.setTraineesOtherRemarks(xxx.getText());
//                data.setVintage(xxx.getText());
//                data.setAverageScore(xxx.getText()); "Durchschnittliche Punktzahl" -> Ask Olli how they calculate it
//                data.setDateOfBirth(xxx.getText());
//                data.setPeriodStart(xxx.getText());
//                data.setPeriodOfEmployment(xxx.getText());
//                data.setTrainingPlan(xxx.getText());
//                data.setInternalTalk(xxx.getText());
//            }
//        };

//        //ActionListener for "Weiter" button
//        ActionListener actionListenerNextPage = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //Tell Manu that they have to delete "page = 2;" and "checkPage();" + page at the begin of the code = 1
//                switch (page) {
//                    case 1:
//                        GUI.setPage(GUI.getPage() + 1);
//                        secondPanel();
//                        secondPanel.setVisibility(true);
//                        startPanel.setVisibility(false);
//                        break;
//                    case 2:
//                        GUI.setPage(GUI.getPage() + 1);
//                        thirdPanel();
//                        thirdPanel.setVisibility(true);
//                        secondPanel.setVisibility(false);
//                        break;
//                    case 3:
//                        GUI.setPage(GUI.getPage() + 1);
//                        fourthPanel();
//                        fourthPanel.setVisibility(true);
//                        thirdPanel.setVisibility(false);
//                        break;
//                }
//            }
//        };
//
//        //ActionListener for "Zurück" button
//        ActionListener actionListenerPreviousPage = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //Tell Manu that they have to delete "page = 2;" and "checkPage();"
//                switch (page) {
//                    case 1:
//                        break;
//                    case 2:
//                        GUI.setPage(GUI.getPage() - 1);
//                        startPanel();
//                        startPanel.setVisibility(true);
//                        secondPanel().setVisibility(false);
//                        break;
//                    case 3:
//                        GUI.setPage(GUI.getPage() - 1);
//                        secondPanel();
//                        secondPanel.setVisibility(true);
//                        thirdPanel.setVisibility(false);
//                        break;
//                    case 4:
//                        GUI.setPage(GUI.getPage() - 1);
//                        thirdPanel();
//                        thirdPanel.setVisibility(true);
//                        fourthPanel.setVisibility(false);
//                }
//            }
//        };
//
//        //Add "Weiter" button to ActionListener
//        next.addActionListener(actionListenerNextPage);
//        previous.addActionListener(actionListenerPreviousPage);
    }

    //Dummies
    public void writeInstructorData(String name, String telephone, String date) {}
    public void writeStudentData(String name, String birthdate, String address, String year, String course){}
    public void writeAllocationPeriod(String from, String to, String internshipSection){}
    public void writeTrainingAreaAndPeriod(String text){}
    public void writeParticipations(String coursesEtc){}
    public void writeDates(String trainingPlan, String interimTalk){}
    public void writeTotalandAverage(String total, String average){}
    public void writePerformance(String abilities, String strengths, String development, String perspectives, String other){}

}
