package de.muenchen.reviewyou.GUI.pages;

import de.muenchen.reviewyou.GUI.DateLabelFormatter;
import de.muenchen.reviewyou.GUI.GUI;
import de.muenchen.reviewyou.excelhandler.Azubi;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class SecondPanel implements BasePage {

    private final JLabel apprenticeship = new JLabel("Informationen zur Nachwuchskraft");
    private final JTextField txtTraineeName = new JTextField(10);
    private final JComboBox apprenticeshipSelector = new JComboBox<Azubi>();
    private final JLabel birthDate = new JLabel("Geburtsdatum: ");
    private final JTextField txtBirthDate = new JTextField(9);
    private final JLabel apartmentStreet = new JLabel("Straße, Haus-Nr., PLZ, Ort:");
    private final JTextField txtApartmentStreet = new JTextField(24);
    private final JLabel allocationPeriod = new JLabel("Zuweisungszeitraum:");
    private final JLabel from = new JLabel("vom:");
    private final JLabel till = new JLabel("bis:");
    private final JLabel internshipSelection = new JLabel("Praktikumsabschnitt:");
    private final JTextField txtInternshipSelection = new JTextField(20);
    private final JLabel trainingArea = new JLabel("<html><body>Ausbildungsbereich und Zeitraum der Beschäftigung<br>" +
            "in den einzelnen Ausbildungsgebieten:</body></html>");
    private final JTextField txtTrainingArea = new JTextField(45);
    private final JLabel sessions = new JLabel("<html><body>Teilnahme an Lehrgängen, Versammlungen, Sitzungen, " +
            "<br>Besichtigungen usw.: </body></html>");
    private final JTextField txtSessions = new JTextField(45);
    private final JLabel traingPlan = new JLabel("<html><body>Örtlicher Ausbildungsplan vorgestellt und Kopie <br> " +
            "ausgehändigt am: </body></html>");
    private final JLabel interimTalk = new JLabel("Zwischengespräch geführt am:");
    private final JLabel traineeYear = new JLabel("Jahrgang:");
    private final JTextField txtTraineeYear = new JTextField(7);
    private final JLabel course = new JLabel("Kurs:");
    private final JTextField txtCourse = new JTextField(6);

    @Override
    public void generate(GUI gui) {
        gui.setPage(2);
        //set properties for JDatePanel

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, gui.getDatePickerProperties());
        JDatePickerImpl txtFrom = new JDatePickerImpl(datePanel,new DateLabelFormatter());

        UtilDateModel model1 = new UtilDateModel();
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, gui.getDatePickerProperties());
        JDatePickerImpl txtTill = new JDatePickerImpl(datePanel1,new DateLabelFormatter());

        UtilDateModel model2 = new UtilDateModel();
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, gui.getDatePickerProperties());
        JDatePickerImpl pickerHandover = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        JDatePickerImpl pickerMeeting = new JDatePickerImpl(datePanel2, new DateLabelFormatter());

        Properties p = gui.getDatePickerProperties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JPanel panel = gui.getPanel();

        //added components

        JLabel traineeName = gui.getTraineeName();

        panel.add(txtFrom);
        panel.add(txtTill);
        panel.add(pickerHandover);
        panel.add(pickerMeeting);
        SpringLayout layout2 = new SpringLayout();
        panel.setLayout(layout2);
        panel.add(apprenticeship);
        panel.add(traineeName);
        panel.add(txtTraineeName);
        panel.add(birthDate);
        panel.add(txtBirthDate);
        panel.add(apartmentStreet);
        panel.add(txtApartmentStreet);
        panel.add(allocationPeriod);
        panel.add(from);
        panel.add(till);
        panel.add(internshipSelection);
        panel.add(txtInternshipSelection);
        panel.add(trainingArea);
        panel.add(txtTrainingArea);
        panel.add(sessions);
        panel.add(txtSessions);
        panel.add(traingPlan);
        panel.add(interimTalk);
        panel.add(traineeYear);
        panel.add(txtTraineeYear);
        panel.add(course);
        panel.add(txtCourse);
        panel.add(apprenticeshipSelector);

        // setFont for Labels

        Font fontSmall = gui.getFontSmall();
        Container contentPane = gui.getContentPane();

        apprenticeship.setFont(fontSmall);
        traineeName.setFont(fontSmall);
        birthDate.setFont(fontSmall);
        apartmentStreet.setFont(fontSmall);
        allocationPeriod.setFont(fontSmall);
        from.setFont(fontSmall);
        till.setFont(fontSmall);
        internshipSelection.setFont(fontSmall);
        trainingArea.setFont(fontSmall);
        sessions.setFont(fontSmall);
        traingPlan.setFont(fontSmall);
        interimTalk.setFont(fontSmall);
        traineeYear.setFont(fontSmall);
        course.setFont(fontSmall);

        // set appreticeship
        layout2.putConstraint(SpringLayout.WEST, apprenticeship, 100, SpringLayout.WEST, contentPane);
        layout2.putConstraint(SpringLayout.NORTH, apprenticeship, 30, SpringLayout.NORTH, contentPane);

        // set traineeName and Textfield
        layout2.putConstraint(SpringLayout.WEST, traineeName, 100, SpringLayout.WEST, contentPane);
        layout2.putConstraint(SpringLayout.NORTH, traineeName, 20, SpringLayout.SOUTH, apprenticeship);

        layout2.putConstraint(SpringLayout.NORTH, txtTraineeName, 4, SpringLayout.NORTH, traineeName);
        layout2.putConstraint(SpringLayout.WEST, txtTraineeName, 10, SpringLayout.EAST, traineeName);

        // set birthDate and Textfield
        layout2.putConstraint(SpringLayout.NORTH, birthDate, 1, SpringLayout.NORTH, traineeName);
        layout2.putConstraint(SpringLayout.WEST, birthDate, 10, SpringLayout.EAST, txtTraineeName);

        layout2.putConstraint(SpringLayout.NORTH, txtBirthDate, 2, SpringLayout.NORTH, birthDate);
        layout2.putConstraint(SpringLayout.WEST, txtBirthDate, 8, SpringLayout.EAST, birthDate);

        // set apartmentStreet and Textfield
        layout2.putConstraint(SpringLayout.NORTH, apartmentStreet, 10, SpringLayout.SOUTH, traineeName);
        layout2.putConstraint(SpringLayout.WEST, apartmentStreet, 100, SpringLayout.WEST, contentPane);

        layout2.putConstraint(SpringLayout.NORTH, txtApartmentStreet, 4, SpringLayout.NORTH, apartmentStreet);
        layout2.putConstraint(SpringLayout.WEST, txtApartmentStreet, 10, SpringLayout.EAST, apartmentStreet);

        // set allocationPeriod
        layout2.putConstraint(SpringLayout.EAST, apprenticeshipSelector, -205, SpringLayout.EAST, panel);
        layout2.putConstraint(SpringLayout.NORTH, apprenticeshipSelector, 30, SpringLayout.NORTH, contentPane);
        apprenticeshipSelector.setEditable(true);

        layout2.putConstraint(SpringLayout.NORTH, allocationPeriod, 20, SpringLayout.SOUTH, apartmentStreet);
        layout2.putConstraint(SpringLayout.WEST, allocationPeriod, 100, SpringLayout.WEST, contentPane);

        // set from and Textfield
        layout2.putConstraint(SpringLayout.NORTH, from, 10, SpringLayout.SOUTH, allocationPeriod);
        layout2.putConstraint(SpringLayout.WEST, from, 100, SpringLayout.WEST, contentPane);

        layout2.putConstraint(SpringLayout.NORTH, txtFrom, 10, SpringLayout.SOUTH, allocationPeriod);
        layout2.putConstraint(SpringLayout.WEST, txtFrom, 10, SpringLayout.EAST, from);

        // set till and Textfield
        layout2.putConstraint(SpringLayout.NORTH, till, 10, SpringLayout.SOUTH, allocationPeriod);
        layout2.putConstraint(SpringLayout.WEST, till, 10, SpringLayout.EAST, txtFrom);

        layout2.putConstraint(SpringLayout.NORTH, txtTill, 10, SpringLayout.SOUTH, allocationPeriod);
        layout2.putConstraint(SpringLayout.WEST, txtTill, 10, SpringLayout.EAST, till);

        // set internshipSelection and Textfield
        layout2.putConstraint(SpringLayout.NORTH, internshipSelection, 10, SpringLayout.SOUTH, from);
        layout2.putConstraint(SpringLayout.WEST, internshipSelection, 100, SpringLayout.WEST, contentPane);

        layout2.putConstraint(SpringLayout.NORTH, txtInternshipSelection, 14, SpringLayout.SOUTH, from);
        layout2.putConstraint(SpringLayout.WEST, txtInternshipSelection, 10, SpringLayout.EAST, internshipSelection);

        // set tranieeYear and Textfield
        layout2.putConstraint(SpringLayout.NORTH, traineeYear,10, SpringLayout.SOUTH,internshipSelection);
        layout2.putConstraint(SpringLayout.WEST,traineeYear,100,SpringLayout.WEST,contentPane);

        layout2.putConstraint(SpringLayout.NORTH,txtTraineeYear, 14, SpringLayout.SOUTH,internshipSelection);
        layout2.putConstraint(SpringLayout.WEST,txtTraineeYear,10,SpringLayout.EAST,traineeYear);

        // set course and Textfield
        layout2.putConstraint(SpringLayout.NORTH,course,10,SpringLayout.SOUTH,internshipSelection);
        layout2.putConstraint(SpringLayout.WEST,course,10,SpringLayout.EAST,txtTraineeYear);

        layout2.putConstraint(SpringLayout.NORTH, txtCourse, 14, SpringLayout.SOUTH,internshipSelection);
        layout2.putConstraint(SpringLayout.WEST, txtCourse, 10 ,SpringLayout.EAST,course);

        // set trainingsArea and Textfield
        layout2.putConstraint(SpringLayout.NORTH, trainingArea, 20, SpringLayout.SOUTH, traineeYear);
        layout2.putConstraint(SpringLayout.WEST, trainingArea, 100, SpringLayout.WEST, contentPane);

        layout2.putConstraint(SpringLayout.NORTH, txtTrainingArea, 5, SpringLayout.SOUTH, trainingArea);
        layout2.putConstraint(SpringLayout.WEST, txtTrainingArea, 100, SpringLayout.WEST, contentPane);

        // set sessions and Textfield
        layout2.putConstraint(SpringLayout.NORTH, sessions, 20, SpringLayout.SOUTH, txtTrainingArea);
        layout2.putConstraint(SpringLayout.WEST, sessions, 100, SpringLayout.WEST, contentPane);

        layout2.putConstraint(SpringLayout.NORTH, txtSessions, 14, SpringLayout.SOUTH, sessions);
        layout2.putConstraint(SpringLayout.WEST, txtSessions, 100, SpringLayout.WEST, contentPane);

        // set trainingsPlan and Textfield
        layout2.putConstraint(SpringLayout.NORTH, traingPlan, 20, SpringLayout.SOUTH, txtSessions);
        layout2.putConstraint(SpringLayout.WEST, traingPlan, 100, SpringLayout.WEST, contentPane);

        layout2.putConstraint(SpringLayout.NORTH, pickerHandover, 10, SpringLayout.SOUTH, traingPlan);
        layout2.putConstraint(SpringLayout.WEST, pickerHandover, 100, SpringLayout.WEST, contentPane);

        // set interimTalk and Textfield
        layout2.putConstraint(SpringLayout.NORTH, interimTalk, 20, SpringLayout.SOUTH, pickerHandover);
        layout2.putConstraint(SpringLayout.WEST, interimTalk, 100, SpringLayout.WEST, contentPane);

        layout2.putConstraint(SpringLayout.NORTH, pickerMeeting, 10, SpringLayout.SOUTH, interimTalk);
        layout2.putConstraint(SpringLayout.WEST, pickerMeeting, 100, SpringLayout.WEST, contentPane);

        pickerHandover.getJFormattedTextField().setText(gui.getStartTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

    }
}
