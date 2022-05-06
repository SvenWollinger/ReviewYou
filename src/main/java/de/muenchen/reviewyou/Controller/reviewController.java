package de.muenchen.reviewyou.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reviewController {
    //Dummies
    int question1Points;
    int question2Points;
    int question3Points;
    int question4Points;
    int question5Points;
    int question6Points;
    int question7Points;
    int question8Points;
    int question9Points;
    int question10Points;
    int question11Points;
    int question12Points;
    int question13Points;
    int question14Points;
    int question15Points;
    int question16Points;
    int question17Points;
    int question18Points;
    int question19Points;

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

    public reviewController() {

        //TODO: Ask Excel-Group if the code is good + how should we do the 2x big tables? + what does writePoints?
        //TODO: + tell them that we have E-Mail now

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

                if (e.getSource().equals(saveAndNew)) {
                    //TODO: Need Josef´s code for the slider reset

                    String placeholder = "";
                    txtTraineeName.setText(placeholder);
                    txtBirthDate.setText(placeholder);
                    txtApartmentStreet.setText(placeholder);

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
                //Button "Berechnen"
                //Calculate "Punktzahl" and "Gesamturteil" -> writeTotalandAverage() (Josef)
                double OverallAssessment = ( question1Points + question2Points + question3Points + question4Points + question5Points +
                                        question6Points + question7Points + question8Points + question9Points + question10Points +
                                        question11Points + question12Points + question13Points + question14Points + question15Points +
                                        question16Points + question17Points + question18Points + question19Points) / 19;

            }
        };
)

        //Dummies for add jButton to actionListener
        saveAndNew.addActionListener(actionListenerSafeData);
        saveAndExit.addActionListener(actionListenerSafeData);
        calc.addActionListener(actionListenerSafeData);
    }

    public void textForTraineeRating(traineeRating traineeRating) {
        abilities.setText(traineeRating.abilities());
        strength.setText(traineeRating.strength());
        developements.setText(traineeRating.developments());
        perspective.setText(traineeRating.perspective());
        others.setText(traineeRating.others());
    }

    //Dummies
    public void writeInstructorData(String name, String telephone, String date, String eMail) {
    }

    public void writeStudentData(String name, String birthdate, String address, String year, String course) {
    }

    public void writeAllocationPeriod(String from, String to, String internshipSection) {
    }

    public void writeTrainingAreaAndPeriod(String text) {
    }

    public void writeParticipations(String coursesEtc) {
    }

    public void writeDates(String trainingPlan, String interimTalk) {
    }

    public void writeTotalandAverage(String total, String average) {

    }

    public void writePerformance(String abilities, String strengths, String development, String perspectives, String other) {
    }

    public void startPanel() {
    }

    ActionListener actionListenercontinue= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int question1Points = jSliders.get(0).getValue();
            int question2Points = jSliders.get(1).getValue();
            int question3Points = jSliders.get(2).getValue();
        }
    };
    ActionListener actionListenercontinue2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int question4Points = jSliders.get(3).getValue();
            int question5Points = jSliders.get(4).getValue();
            int question6Points = jSliders.get(5).getValue();
        }
    };
    ActionListener actionListenercontinue3 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int question7Points = jSliders.get(6).getValue();
            int question8Points = jSliders.get(7).getValue();
            int question9Points = jSliders.get(8).getValue();
            int question10Points = jSliders.get(9).getValue();
            int question11Points = jSliders.get(10).getValue();
            int question12Points = jSliders.get(11).getValue();
        }
    };
    ActionListener actionListenercontinue4 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int question13Points = jSliders.get(12).getValue();
            int question14Points = jSliders.get(13).getValue();
            int question15Points = jSliders.get(14).getValue();
            int question16Points = jSliders.get(15).getValue();
            int question17Points = jSliders.get(16).getValue();
            int question18Points = jSliders.get(17).getValue();
            int question19Points = jSliders.get(18).getValue();
        }
    };

    panel.add(jSliders.get(0), gbc);






}