package de.muenchen.reviewyou.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    JLabel jLabelTotal = new JLabel();
    JLabel jLabelAverage = new JLabel();
    private List<JSlider> jSliders = createSliders();

    public reviewController() {

        ActionListener actionListenerSafeData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                traineeRating traineeRating = new traineeRating();

                //Give values to Excel-Group
                writeInstructorData(instructorName.getText(), instructorTelephone.getText(), currentDate.getText(), instructorEmail.getText());
                writeStudentData(txtTraineeName.getText(), txtBirthDate.getText(), txtApartmentStreet.getText(),
                        txtTraineeYear.getText(), txtCourse.getText());
                writeAllocationPeriod(txtFrom.getText(), txtTill.getText(), txtIntershipSelection.getText());
                writeTrainingAreaAndPeriod(txtTrainingArea.getText());
                writeParticipations(txtSessions.getText());
                writeDates(txtTrainingsPlan.getText(), txtInternimTalk.getText());
                writePerformance(traineeRating.abilities(), traineeRating.strength(), traineeRating.developments(),
                        traineeRating.perspective(), traineeRating.others());
                writeTotalandAverage(jLabelTotal.getText(), jLabelAverage.getText());

                if (e.getSource().equals(saveAndNew)) {
                    for(int i = 0; i < 19; i++) {
                        //Reset every slider
                        jSliders.get(i).setValue(jSliders.get(i).getMaximum() / 2);
                    }

                    //Clear text
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


        //Calculate-button
        ActionListener actionListenerCalculate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabelTotal.setText(String.valueOf(calculateTotal()));
                jLabelAverage.setText(calculateAverage());
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
            totalPoints = totalPoints + jSliders.get(i).getValue();
        }
        return totalPoints;
    }

    public String calculateAverage() {
        String average = "";
        int totalPoints = 0;
        for(int i = 0; i < 19; i++) {
            totalPoints = totalPoints + jSliders.get(i).getValue();
        }
        //TODO: Output a text based on the values from sliders
        return average;
    }

    //Dummies
    public void writeInstructorData(String name, String telephone, String date, String eMail) {}
    public void writeStudentData(String name, String birthdate, String address, String year, String course) {}
    public void writeAllocationPeriod(String from, String to, String internshipSection) {}
    public void writeTrainingAreaAndPeriod(String text) {}
    public void writeParticipations(String coursesEtc) {}
    public void writeDates(String trainingPlan, String interimTalk) {}
    public void writeTotalandAverage(String total, String average) {}
    public void writePerformance(String abilities, String strengths, String development, String perspectives, String other) {}
    public void startPanel() {}
    public List<JSlider> createSliders(){
        return null;
    }
}