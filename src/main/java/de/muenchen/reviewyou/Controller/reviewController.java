package de.muenchen.reviewyou.Controller;

import de.muenchen.reviewyou.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reviewController {
    //Dummies
    JButton calc = new JButton();
    JButton saveAndNew = new JButton();
    JButton saveAndExit = new JButton();
    JPanel panel = new JPanel();
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

    public reviewController() {

        //TODO: Ask Excel-Group if the code is good + how should we do the 2x big tables? + what does writePoints?

        ActionListener actionListenerSafeData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                if (e.getSource().equals(saveAndNew)) {
                    //TODO: Need Josef´s code for the slider reset

                    String placeholder = "";
                    txtTraineeName.setText(placeholder);
                    txtBirthDate.setText(placeholder);
                    txtApartmentStreet.setText(placeholder);

                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    startPanel();
                    //TODO: Panel1 extra clearen + panelclearen
                } else if (e.getSource().equals(saveAndExit)) {
                    System.exit(0);
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
    public void startPanel(){}
}
