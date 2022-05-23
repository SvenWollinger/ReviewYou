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
    JPanel panel1 = new JPanel();
    JTextField instructorName = new JTextField();
    JTextField instructorTelephone = new JTextField();
    JTextField currentDate = new JTextField();
    JTextField instructorEmail = new JTextField();
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
    JLabel txtTotal = new JLabel();
    JLabel txtAverage = new JLabel();

    public reviewController() {

        ActionListener actionListenerSafeData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                traineeRating traineeRating = new traineeRating();

                writeInstructorData(instructorName.getText(), instructorTelephone.getText(), currentDate.getText(), instructorEmail.getText());
                writeStudentData(txtTraineeName.getText(), txtBirthDate.getText(), txtApartmentStreet.getText(),
                        txtTraineeYear.getText(), txtCourse.getText());
                writeAllocationPeriod(txtFrom.getText(), txtTill.getText(), txtIntershipSelection.getText());
                writeTrainingAreaAndPeriod(txtTrainingArea.getText());
                writeParticipations(txtSessions.getText());
                writeDates(txtTrainingsPlan.getText(), txtInternimTalk.getText());
                writePerformance(traineeRating.abilities(), traineeRating.strength(), traineeRating.developments(),
                        traineeRating.perspective(), traineeRating.others());
                writeTotalandAverage(calculateTotal(), calculateAverage());
                txtTotal.setText(String.valueOf(calculateTotal()));
                txtAverage.setText(calculateAverage());
                if (e.getSource().equals(saveAndNew)) {
                    for(int i = 0; i < 19; i++) {
                        //Reset every slider
                    }

                    String placeholder = "";
                    txtTraineeName.setText(placeholder);
                    txtBirthDate.setText(placeholder);
                    txtApartmentStreet.setText(placeholder);

                    //Go to page 1
                    panel1.removeAll();
                    panel1.revalidate();
                    panel1.repaint();
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    startPanel();
                } else if (e.getSource().equals(saveAndExit)) {
                    System.exit(0);
                }
            }
        };


        ActionListener actionListenerCalculate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
                calculateAverage();
                //TODO: Tell GUI-Group that they don´t have JLabels for "calculatedPoints" and "overallRating"
            }
        };


        //Dummies for add jButton to actionListener
        saveAndNew.addActionListener(actionListenerSafeData);
        saveAndExit.addActionListener(actionListenerSafeData);
        calc.addActionListener(actionListenerSafeData);
    }

    public void textForTraineeRating(traineeRating traineeRating) { //TODO: Ask Excel how they did it
        abilities.setText(traineeRating.abilities());
        strength.setText(traineeRating.strength());
        developements.setText(traineeRating.developments());
        perspective.setText(traineeRating.perspective());
        others.setText(traineeRating.others());
    }

    public int calculateTotal() {
        int totalPoints = 0;
        for(int i = 0; i < 19; i++) {
            totalPoints = totalPoints; // + JSlider[i]; TODO: get JSlider int
        }
        return totalPoints;
    }

    public String calculateAverage() {
        String average = "";
        int totalPoints = 0;
        for(int i = 0; i < 19; i++) {
            totalPoints = totalPoints; // + JSlider[i]; TODO: get JSlider int
        }
        //TODO: A text is output based on the values of the sliders
        return average;
    }

    //Dummies
    public void writeInstructorData(String name, String telephone, String date, String eMail) {}
    public void writeStudentData(String name, String birthdate, String address, String year, String course) {}
    public void writeAllocationPeriod(String from, String to, String internshipSection) {}
    public void writeTrainingAreaAndPeriod(String text) {}
    public void writeParticipations(String coursesEtc) {}
    public void writeDates(String trainingPlan, String interimTalk) {}
    public void writeTotalandAverage(int total, String average) {} //TODO: Tell Excel that i changed String to int
    public void writePerformance(String abilities, String strengths, String development, String perspectives, String other) {}
    public void startPanel() {}
}