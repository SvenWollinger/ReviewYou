package de.muenchen.reviewyou;


import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.text.DateFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;




public class GUI {


    private Container contentPane;
    private JFrame window;


    private JButton next = new JButton("Weiter");
    private JButton previous = new JButton("Zurück");
    private JButton moreInfo = new JButton("Info");
    private int page = 0;


    JPanel panel = new JPanel();
    Font font = new Font(null, Font.PLAIN, 20);
    Font fontt = new Font(null, Font.PLAIN, 17);
    SpringLayout layout = new SpringLayout();
    SpringLayout layout1 = new SpringLayout();


    public GUI() {
        window = new JFrame("Leistungsbericht Nachwuchskräfte");
        window.setResizable(false);
        window.setSize(800, 800);
        window.setLocationRelativeTo(null);

        contentPane = window.getContentPane();
        window.setLayout(layout);
        window.add(next);
        window.add(previous);
        window.add(moreInfo);
        previous.setVisible(false);
        moreInfo.setVisible(false);



        next.setPreferredSize(new Dimension(80, 30));
        previous.setPreferredSize(new Dimension(80, 30));
        moreInfo.setPreferredSize(new Dimension(80, 30));

        layout.putConstraint(SpringLayout.SOUTH, next, -25, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, next, 400, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.SOUTH, previous, -25, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.EAST, previous, -5, SpringLayout.WEST, next);

        layout.putConstraint(SpringLayout.SOUTH, moreInfo, -25, SpringLayout.SOUTH,contentPane);
        layout.putConstraint(SpringLayout.EAST, moreInfo, -180, SpringLayout.WEST, previous);



        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startPanel();

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (page) {
                    case 1:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        previous.setVisible(true);
                        secondPanel();
                        break;
                    case 2:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        thirdPanel();
                        moreInfo();
                        moreInfo.setVisible(true);
                        break;
                    case 3:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        fourthPanel();
                        break;
                    case 4:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        fifthPanel();
                        break;
                    case 5:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        sixthPanel();
                        break;
                    case 6:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        seventhPanel();
                        moreInfo.setVisible(false);
                        popup.setVisible(false);
                        break;
                    case 7:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        eightPanel();
                        next.setVisible(false);
                        break;

                }
            }
        });

        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (page) {
                    case 8:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        seventhPanel();
                        next.setVisible(true);
                        break;
                    case 7:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        sixthPanel();
                        moreInfo.setVisible(true);
                        break;
                    case 6:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        fifthPanel();
                        break;
                    case 5:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        fourthPanel();
                        break;
                    case 4:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        thirdPanel();
                        break;
                    case 3:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        moreInfo.setVisible(false);
                        popup.setVisible(false);
                        secondPanel();
                        break;
                    case 2:
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        previous.setVisible(false);
                        startPanel();
                        break;
                }
            }
        });

        moreInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moreInfo();
              }
            });

    }

    // First page to get user data

    private JLabel name = new JLabel("Name");
    private JLabel email = new JLabel("E-Mail");
    private JLabel date = new JLabel("Datum");
    private JLabel telephone = new JLabel("Tel");
    private JTextField instructorName = new JTextField(15);
    private JTextField instructorEmail = new JTextField(15);
    private JTextField currentDate = new JTextField(15);
    private JTextField instructorTelephone = new JTextField(15);
    private JTextField txtdate = new JTextField(15);
    private JLabel headline;
    LocalDate today = LocalDate.now();

//    UtilDateModel model = new UtilDateModel();
//    Properties p = new Properties();
//    JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
//    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateFormat().format(("dd.MM.uuuu"));


    // second page

    public void startPanel() {
//        p.put("text.today", "Today");
//        p.put("text.month", "Month");
//        p.put("text.year", "Year");
        window.setVisible(true);
        page = 1;
        window.add(panel);
        panel.setLayout(layout1);

        panel.setPreferredSize(new Dimension(800, 700));

        headline = new JLabel("Angaben zum / zur Ausbilder:in");
        headline.setFont(font);
 

        panel.add(headline);
        panel.add(name);
        panel.add(email);
        panel.add(date);
        panel.add(instructorName);
        panel.add(telephone);
        panel.add(instructorEmail);
        panel.add(instructorTelephone);
        panel.add(txtdate);

        layout1.putConstraint(SpringLayout.NORTH, headline, 50, SpringLayout.NORTH, panel);
        layout1.putConstraint(SpringLayout.WEST, headline, 250, SpringLayout.WEST, panel);

        // set name and name textfield
        layout1.putConstraint(SpringLayout.WEST, name, 260, SpringLayout.WEST, panel);
        layout1.putConstraint(SpringLayout.NORTH, name, 50, SpringLayout.SOUTH, headline);
        name.setFont(font);


        layout1.putConstraint(SpringLayout.WEST, instructorName, 12, SpringLayout.EAST, name);
        layout1.putConstraint(SpringLayout.NORTH, instructorName, 4, SpringLayout.NORTH, name);


// set email and email textfield
        layout1.putConstraint(SpringLayout.WEST, email, 260, SpringLayout.WEST, panel);
        layout1.putConstraint(SpringLayout.NORTH, email, 20, SpringLayout.SOUTH, name);
        email.setFont(font);


        layout1.putConstraint(SpringLayout.WEST, instructorEmail, 7, SpringLayout.EAST, email);
        layout1.putConstraint(SpringLayout.NORTH, instructorEmail, 4, SpringLayout.NORTH, email);


        // set telephone and telephone textfield
        layout1.putConstraint(SpringLayout.WEST, telephone, 260, SpringLayout.WEST, panel);
        layout1.putConstraint(SpringLayout.NORTH, telephone, 20, SpringLayout.SOUTH, email);
        telephone.setFont(font);


        layout1.putConstraint(SpringLayout.WEST, instructorTelephone, 38, SpringLayout.EAST, telephone);
        layout1.putConstraint(SpringLayout.NORTH, instructorTelephone, 4, SpringLayout.NORTH, telephone);


        layout1.putConstraint(SpringLayout.WEST, date, 260, SpringLayout.WEST, panel);
        layout1.putConstraint(SpringLayout.NORTH, date, 20, SpringLayout.SOUTH, telephone);
        date.setFont(font);


        layout1.putConstraint(SpringLayout.NORTH,txtdate, 27,SpringLayout.SOUTH,instructorTelephone);
        layout1.putConstraint(SpringLayout.WEST,txtdate,8,SpringLayout.EAST,date);

        txtdate.setText(String.valueOf(today.format(DateTimeFormatter.ofPattern("dd.MM.uuuu"))));

    }


    private JLabel apprenticeship = new JLabel("Informationen zur Nachwuchskraft");
    private JLabel traineeName = new JLabel("Name, Vorname:");
    private JTextField txtTraineeName = new JTextField(8);
    private JLabel birthDate = new JLabel("Geburtsdatum: ");
    private JTextField txtBirthDate = new JTextField(8);
    private JLabel apartmentStreet = new JLabel("Straße, Haus-Nr., PLZ, Ort:");
    private JTextField txtApartmentStreet = new JTextField(22);
    private JLabel allocationPeriod = new JLabel("Zuweisungszeitraum:");
    private JLabel from = new JLabel("vom:");
    private JTextField txtfrom = new JTextField(10);
    private JLabel till = new JLabel("bis:");
    private JTextField txtTill = new JTextField(10);
    private JLabel internshipSelection = new JLabel("Praktikumsabschnitt:");
    private JTextField txtInternshipSelection = new JTextField(20);
    private JLabel trainingArea = new JLabel("<html><body>Ausbildungsbereich und Zeitraum der Beschäftigung<br>" +
            "in den einzelnen Ausbildungsgebieten:</body></html>");
    private JTextField txtTrainingArea = new JTextField(45);
    private JLabel sessions = new JLabel("<html><body>Teilnahme an Lehrgängen, Versammlungen, Sitzungen, " +
            "<br>Besichtigungen usw.: </body></html>");
    private JTextField txtSessions = new JTextField(45);
    private JLabel traingPlan = new JLabel("<html><body>Örtlicher Ausbildungsplan vorgestellt und Kopie <br> " +
            "ausgehändigt am: </body></html>");
    private JTextField txtTrainingsPlan = new JTextField(45);
    private JLabel interimTalk = new JLabel("Zwischengespräch geführt am:");
    private JTextField txtInterimTalk = new JTextField(45);
    private JLabel overallRating = new JLabel("Gesamtbewetung");
    private JLabel traineeYear = new JLabel("Jahrgang:");
    private JTextField txtTraineeYear = new JTextField(7);
    private JLabel course = new JLabel("Kurs:");
    private JTextField txtCourse = new JTextField(7);

    public void secondPanel() {
        page = 2;

        panel.setLayout(layout);
        window.add(panel);

        panel.add(apprenticeship);
        panel.add(traineeName);
        panel.add(txtTraineeName);
        panel.add(birthDate);
        panel.add(txtBirthDate);
        panel.add(apartmentStreet);
        panel.add(txtApartmentStreet);
        panel.add(allocationPeriod);
        panel.add(from);
        panel.add(txtfrom);
        panel.add(till);
        panel.add(txtTill);
        panel.add(internshipSelection);
        panel.add(txtInternshipSelection);
        panel.add(trainingArea);
        panel.add(txtTrainingArea);
        panel.add(sessions);
        panel.add(txtSessions);
        panel.add(traingPlan);
        panel.add(txtTrainingsPlan);
        panel.add(interimTalk);
        panel.add(txtInterimTalk);
        panel.add(traineeYear);
        panel.add(txtTraineeYear);
        panel.add(course);
        panel.add(txtCourse);


        apprenticeship.setFont(fontt);
        traineeName.setFont(fontt);
        birthDate.setFont(fontt);
        apartmentStreet.setFont(fontt);
        allocationPeriod.setFont(fontt);
        from.setFont(fontt);
        till.setFont(fontt);
        internshipSelection.setFont(fontt);
        trainingArea.setFont(fontt);
        sessions.setFont(fontt);
        traingPlan.setFont(fontt);
        interimTalk.setFont(fontt);
        traineeYear.setFont(fontt);
        course.setFont(fontt);


        layout.putConstraint(SpringLayout.WEST, apprenticeship, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, apprenticeship, 30, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, traineeName, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, traineeName, 20, SpringLayout.SOUTH, apprenticeship);

        layout.putConstraint(SpringLayout.NORTH, txtTraineeName, 4, SpringLayout.NORTH, traineeName);
        layout.putConstraint(SpringLayout.WEST, txtTraineeName, 10, SpringLayout.EAST, traineeName);

        layout.putConstraint(SpringLayout.NORTH, birthDate, 1, SpringLayout.NORTH, traineeName);
        layout.putConstraint(SpringLayout.WEST, birthDate, 10, SpringLayout.EAST, txtTraineeName);

        layout.putConstraint(SpringLayout.NORTH, txtBirthDate, 2, SpringLayout.NORTH, birthDate);
        layout.putConstraint(SpringLayout.WEST, txtBirthDate, 10, SpringLayout.EAST, birthDate);

        layout.putConstraint(SpringLayout.NORTH, apartmentStreet, 10, SpringLayout.SOUTH, traineeName);
        layout.putConstraint(SpringLayout.WEST, apartmentStreet, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, txtApartmentStreet, 4, SpringLayout.NORTH, apartmentStreet);
        layout.putConstraint(SpringLayout.WEST, txtApartmentStreet, 10, SpringLayout.EAST, apartmentStreet);

        layout.putConstraint(SpringLayout.NORTH, allocationPeriod, 20, SpringLayout.SOUTH, apartmentStreet);
        layout.putConstraint(SpringLayout.WEST, allocationPeriod, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, from, 10, SpringLayout.SOUTH, allocationPeriod);
        layout.putConstraint(SpringLayout.WEST, from, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, txtfrom, 14, SpringLayout.SOUTH, allocationPeriod);
        layout.putConstraint(SpringLayout.WEST, txtfrom, 10, SpringLayout.EAST, from);

        layout.putConstraint(SpringLayout.NORTH, till, 10, SpringLayout.SOUTH, allocationPeriod);
        layout.putConstraint(SpringLayout.WEST, till, 10, SpringLayout.EAST, txtfrom);

        layout.putConstraint(SpringLayout.NORTH, txtTill, 14, SpringLayout.SOUTH, allocationPeriod);
        layout.putConstraint(SpringLayout.WEST, txtTill, 10, SpringLayout.EAST, till);

        layout.putConstraint(SpringLayout.NORTH, internshipSelection, 10, SpringLayout.SOUTH, from);
        layout.putConstraint(SpringLayout.WEST, internshipSelection, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, txtInternshipSelection, 14, SpringLayout.SOUTH, from);
        layout.putConstraint(SpringLayout.WEST, txtInternshipSelection, 10, SpringLayout.EAST, internshipSelection);

        layout.putConstraint(SpringLayout.NORTH, traineeYear,10, SpringLayout.SOUTH,internshipSelection);
        layout.putConstraint(SpringLayout.WEST,traineeYear,100,SpringLayout.WEST,contentPane);

        layout.putConstraint(SpringLayout.NORTH,txtTraineeYear, 14, SpringLayout.SOUTH,internshipSelection);
        layout.putConstraint(SpringLayout.WEST,txtTraineeYear,10,SpringLayout.EAST,traineeYear);

        layout.putConstraint(SpringLayout.NORTH,course,10,SpringLayout.SOUTH,internshipSelection);
        layout.putConstraint(SpringLayout.WEST,course,10,SpringLayout.EAST,txtTraineeYear);

        layout.putConstraint(SpringLayout.NORTH, txtCourse, 14, SpringLayout.SOUTH,internshipSelection);
        layout.putConstraint(SpringLayout.WEST, txtCourse, 10 ,SpringLayout.EAST,course);

        layout.putConstraint(SpringLayout.NORTH, trainingArea, 20, SpringLayout.SOUTH, traineeYear);
        layout.putConstraint(SpringLayout.WEST, trainingArea, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, txtTrainingArea, 5, SpringLayout.SOUTH, trainingArea);
        layout.putConstraint(SpringLayout.WEST, txtTrainingArea, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, sessions, 20, SpringLayout.SOUTH, txtTrainingArea);
        layout.putConstraint(SpringLayout.WEST, sessions, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, txtSessions, 14, SpringLayout.SOUTH, sessions);
        layout.putConstraint(SpringLayout.WEST, txtSessions, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, traingPlan, 20, SpringLayout.SOUTH, txtSessions);
        layout.putConstraint(SpringLayout.WEST, traingPlan, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, txtTrainingsPlan, 10, SpringLayout.SOUTH, traingPlan);
        layout.putConstraint(SpringLayout.WEST, txtTrainingsPlan, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, interimTalk, 20, SpringLayout.SOUTH, txtTrainingsPlan);
        layout.putConstraint(SpringLayout.WEST, interimTalk, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, txtInterimTalk, 10, SpringLayout.SOUTH, interimTalk);
        layout.putConstraint(SpringLayout.WEST, txtInterimTalk, 100, SpringLayout.WEST, contentPane);
    }


    Insets headlineInsets = new Insets(0,0,200,0);
    Insets sliderInsets = new Insets(-60, 0, 70, 0);
    private List<JSlider> jSliders = createSliders();


    public void thirdPanel(){
        page = 3;
        JLabel headline = new JLabel("Fachliche Kompetenzen");
        headline.setFont(font);
        window.add(panel);
        panel.setVisible(true);
        panel.setLayout(gbl);

        gbc.insets = headlineInsets;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(headline, gbc);

        // BEHERRSCHUNG DER DEUTSCHEN SPRACHE
        gbc.insets = sliderInsets;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(createLabel("Beherrschung der deutschen Sprache").get(0), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(jSliders.get(0), gbc);


        // IT-KENNTNISSE

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(createLabel("IT-Kenntnisse").get(0), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(jSliders.get(1), gbc);


        // INTERESSE AM ARBEITSFELD

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(createLabel("Interesse am Arbeitsumfeld und Grundwissen zum Aufgabenbereich der Praktikumsstelle").get(0), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(jSliders.get(2), gbc);


        }

        public void fourthPanel(){
            page = 4;
            JLabel headline = new JLabel("Methodisches Denken");
            headline.setFont(font);
            window.add(panel);
            panel.setVisible(true);
            panel.setLayout(gbl);

            gbc.insets = headlineInsets;
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(headline, gbc);

            // ANALYTISCHES DENKEN
            gbc.insets = sliderInsets;
            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(createLabel("Analytisches Denken").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(jSliders.get(3), gbc);


            // GANZHEITLICHES UND VERNETZTES DENKEN
            gbc.gridx = 0;
            gbc.gridy = 3;
            panel.add(createLabel("Ganzheitliches und vernetztes Denken").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            panel.add(jSliders.get(4), gbc);

            // ARBEITS- UND LERNTECHNIKEN

            gbc.gridx = 0;
            gbc.gridy = 5;
            panel.add(createLabel("Arbeits- und Lerntechniken").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            panel.add(jSliders.get(5), gbc);
        }


        public void fifthPanel(){
            page = 5;
            JLabel headline = new JLabel("Soziale Kompetenzen");
            headline.setFont(font);
            window.add(panel);
            panel.setVisible(true);
            panel.setLayout(gbl);

            gbc.insets = new Insets(0, 0, 100, 0);
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(headline, gbc);

            // KOMMUNIKATIONSFÄHIGKEIT

            gbc.insets = sliderInsets;
            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(createLabel("Kommunikationsfähigkeit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(jSliders.get(6), gbc);


            // KONTAKTFREUDIGKEIT
            gbc.gridx = 0;
            gbc.gridy = 3;
            panel.add(createLabel("Kontaktfreudigkeit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            panel.add(jSliders.get(7), gbc);

            // TEAMFÄHIGKEIT UND KOOPERATIONSBEREITSCHAFT

            gbc.gridx = 0;
            gbc.gridy = 5;
            panel.add(createLabel("Teamfähigkeit und Kooperationsbereitschaft").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            panel.add(jSliders.get(8), gbc);

            // KONFLIKTFÄHIGKEIT

            gbc.gridx = 0;
            gbc.gridy = 7;
            panel.add(createLabel("Konfliktfähigkeit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 8;
            panel.add(jSliders.get(9), gbc);

            // EINFÜHLUNGSVERMÖGEN

            gbc.gridx = 0;
            gbc.gridy = 9;
            panel.add(createLabel("Einfühlungsvermögen").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 10;
            panel.add(jSliders.get(10), gbc);

            // RESPEKT UND UMGANG MIT ANDEREN KULTUREN

            gbc.gridx = 0;
            gbc.gridy = 11;
            panel.add(createLabel("Respekt und kompetenter Umgang mit anderen Kulturen").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 12;
            panel.add(jSliders.get(11), gbc);
        }

        public void sixthPanel(){

            page = 6;
            JLabel headline = new JLabel("Persönliche Kompetenzen");
            headline.setFont(font);
            window.add(panel);
            panel.setVisible(true);
            panel.setLayout(gbl);

            gbc.insets = new Insets(10, 0, 60, 0);
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(headline, gbc);

            // OFFENHEIT

            gbc.insets = new Insets(-30, 0, 40, 0);
            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(createLabel("Offenheit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(jSliders.get(12), gbc);


            // GEWISSENHAFTIGKEIT UND INTEGRITÄT
            gbc.gridx = 0;
            gbc.gridy = 3;
            panel.add(createLabel("Gewissenhaftigkeit und Integrität").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            panel.add(jSliders.get(13), gbc);

            // MOTIVATION

            gbc.gridx = 0;
            gbc.gridy = 5;
            panel.add(createLabel("Motivation").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            panel.add(jSliders.get(14), gbc);

            // STRESSTOLERANZ

            gbc.gridx = 0;
            gbc.gridy = 7;
            panel.add(createLabel("Stresstoleranz").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 8;
            panel.add(jSliders.get(15), gbc);

            // IDENTIFIKATION

            gbc.gridx = 0;
            gbc.gridy = 9;
            panel.add(createLabel("Identifikation").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 10;
            panel.add(jSliders.get(16), gbc);

            // SELBSTSTÄNDIGKEIT

            gbc.gridx = 0;
            gbc.gridy = 11;
            panel.add(createLabel("Selbstständigkeit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 12;
            panel.add(jSliders.get(17), gbc);

            // KRITIKFÄHIGKEIT

            gbc.gridx = 0;
            gbc.gridy = 13;
            panel.add(createLabel("Kritikfähigkeit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 14;
            panel.add(jSliders.get(18), gbc);
        }


    // ELEMENTS FOR SEVENTH PAGE
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JLabel abilitiesLabel = new JLabel("Fähigkeiten, praktische Leistungen, Verhalten");
    JLabel strengthLabel = new JLabel("Stärken");
    JLabel developementsLabel = new JLabel("Entwicklungsfelder");
    JLabel perspectiveLabel = new JLabel("Perspektiven");
    JLabel othersLabel = new JLabel("Sonstige Anmerkungen");
    JTextArea abilities = new JTextArea();
    JTextArea strength = new JTextArea();
    JTextArea developements = new JTextArea();
    JTextArea perspective = new JTextArea();
    JTextArea others = new JTextArea();
    Dimension preferedSize = new Dimension(600, 50);
    Dimension maximumSize = new Dimension(600, 70);


    // CREATE THIRD PANEL
    public void seventhPanel() {
        page = 7;
        JLabel headline = new JLabel("Wortbeschreibung zur gezeigten Leistung insgesamt");
        JLabel whiteSpace = new JLabel();
        window.add(panel);
        panel.setLayout(gbl);

        gbc.insets = new Insets(-10, 20, 80, 20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        headline.setFont(font);
        panel.add(headline, gbc);

        gbc.insets = new Insets(0, 20, 10, 20);

        gbc.gridx = 0;
        gbc.gridy = 2;
        abilitiesLabel.setFont(font);
        panel.add(abilitiesLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        abilities.setPreferredSize(preferedSize);
        abilities.setMaximumSize(maximumSize);
        abilities.setLineWrap(true);
        panel.add(abilities, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        strengthLabel.setFont(font);
        panel.add(strengthLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        strength.setPreferredSize(preferedSize);
        strength.setMaximumSize(maximumSize);
        strength.setLineWrap(true);
        panel.add(strength, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        developementsLabel.setFont(font);
        panel.add(developementsLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        developements.setPreferredSize(preferedSize);
        developements.setMaximumSize(maximumSize);
        developements.setLineWrap(true);
        panel.add(developements, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        perspectiveLabel.setFont(font);
        panel.add(perspectiveLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        perspective.setPreferredSize(preferedSize);
        perspective.setMaximumSize(maximumSize);
        perspective.setLineWrap(true);
        panel.add(perspective, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        othersLabel.setFont(font);
        panel.add(othersLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        others.setPreferredSize(preferedSize);
        others.setMaximumSize(maximumSize);
        others.setLineWrap(true);
        panel.add(others, gbc);

    }

    JButton calc = new JButton("Berechnen");
    JButton saveAndNew = new JButton("Speichern und neuer Leistungsbericht");
    JButton saveAndExit = new JButton("Speichern und Schließen");
    JPanel panel1 = new JPanel();
    JLabel score = new JLabel("Punktzahl");
    JLabel review = new JLabel("Gesamturteil");
    GridBagConstraints gbc1 = new GridBagConstraints();

    public void eightPanel(){
        page = 8;
        JLabel headline = new JLabel("Abschluss des Leistungsberichts von " + txtTraineeName.getText());
        headline.setFont(font);
        window.add(panel);
        panel.setVisible(true);
        panel.setLayout(gbl);
        next.setVisible(false);

        score.setFont(font);
        review.setFont(font);

        panel1.setVisible(true);
        panel1.setLayout(gbl);
        panel1.setPreferredSize(new Dimension(150,100));

        gbc1.insets = new Insets(0,20,0, 20);


        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridwidth = 3;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        panel.add(headline, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.gridwidth = 1;
        panel.add(panel1, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 0;
        panel1.add(score, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 2;
        panel1.add(review, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 2;
        panel.add(calc,gbc1);

        gbc1.gridx = 1;
        gbc1.gridy = 2;
        panel.add(saveAndNew,gbc1);

        gbc1.gridx = 2;
        gbc1.gridy = 2;
        panel.add(saveAndExit,gbc1);


    }


    static final int minScore = 0;
    static final int maxScore = 15;
    static final int scoreInit = 0;

    java.util.List<JSlider> createSliders(){
        List<JSlider> sliders = new ArrayList<>();
        for (int i = 0; i < 19 ; i++) {

            sliders.add(new JSlider(JSlider.HORIZONTAL,minScore, maxScore, scoreInit));
            sliders.get(i).setPaintTicks(true);
            sliders.get(i).setMajorTickSpacing(1);
            sliders.get(i).setPaintTicks(true);
            sliders.get(i).setPaintTrack(true);
            sliders.get(i).setPaintLabels(true);
            sliders.get(i).setPreferredSize(new Dimension(300, 50));

        }

        return sliders;
    }
    List<JLabel> createLabel(String name) {
        List<JLabel> labels = new ArrayList<>();
            for (int i = 0; i < 18; i++){
                labels.add(new JLabel(name));

        }
            return labels;
    }

    // MORE INFO PAGE

    private JLabel PointsDistribution = new JLabel("Folgende Punktezahlen können vergeben werden: ");
    private JLabel particularly = new JLabel("  15 - 13 Punkte: Eine besonders hervorragende Leistung.");
    private JLabel good = new JLabel(" 12 -10 Punkte: Eine Leistung, die die durchschnittlichen Anforderungen übertrifft.");
    private JLabel average = new JLabel(" 9 - 7 Punkte: Eine Leistung, die in jeder Hinsicht durchschnittlichen Anforderungen entspricht.");
    private JLabel defects = new JLabel(" 6 - 4 Punkte: Eine Leistung, die trotz ihrer Mängel durchschnittlichen Anforderungen noch entspricht.");
    private JLabel badly = new JLabel(" 3 - 1 Punkte: Eine an erheblichen Mängeln leidende, im Ganzen nicht mehr brauchbare Leistung.");
    private JLabel useless = new JLabel("0 Punkte: Eine völlig unbrauchbare Leistung.");
    private JFrame popup = new JFrame("Info");
    private JPanel popupPanel = new JPanel();


    public void moreInfo(){
        popup.setVisible(true);
        popup.setSize(805, 350);
        popup.add(popupPanel);
        popup.setLocation(75, 300);
        popupPanel.setLayout(layout);
        headline = new JLabel("Bewertung: ");
        headline.setFont(font);
        popupPanel.add(headline);
        popupPanel.add(PointsDistribution);
        popupPanel.add(particularly);
        popupPanel.add(good);
        popupPanel.add(average);
        popupPanel.add(defects);
        popupPanel.add(badly);
        popupPanel.add(useless);

        layout.putConstraint(SpringLayout.NORTH, headline,20,SpringLayout.NORTH,contentPane);
        layout.putConstraint(SpringLayout.WEST, headline, 20, SpringLayout.WEST, contentPane);
        headline.setFont(font);

        layout.putConstraint(SpringLayout.NORTH, PointsDistribution, 40, SpringLayout.SOUTH, headline);
        layout.putConstraint(SpringLayout.WEST, PointsDistribution, 20, SpringLayout.WEST, contentPane);
        PointsDistribution.setFont(font);

        layout.putConstraint(SpringLayout.NORTH, particularly, 40, SpringLayout.SOUTH, PointsDistribution);
        layout.putConstraint(SpringLayout.WEST, particularly, 29, SpringLayout.WEST, contentPane);
        particularly.setFont(fontt);

        layout.putConstraint(SpringLayout.NORTH, good, 0, SpringLayout.SOUTH, particularly);
        layout.putConstraint(SpringLayout.WEST, good, 35, SpringLayout.WEST, contentPane);
        good.setFont(fontt);

        layout.putConstraint(SpringLayout.NORTH, average, 0, SpringLayout.SOUTH, good);
        layout.putConstraint(SpringLayout.WEST, average, 48, SpringLayout.WEST, contentPane);
        average.setFont(fontt);

        layout.putConstraint(SpringLayout.NORTH, defects, 0, SpringLayout.SOUTH, average);
        layout.putConstraint(SpringLayout.WEST, defects, 48, SpringLayout.WEST, contentPane);
        defects.setFont(fontt);

        layout.putConstraint(SpringLayout.NORTH, badly, 0, SpringLayout.SOUTH, defects);
        layout.putConstraint(SpringLayout.WEST, badly, 48, SpringLayout.WEST, contentPane);
        badly.setFont(fontt);

        layout.putConstraint(SpringLayout.NORTH, useless, 0, SpringLayout.SOUTH, badly);
        layout.putConstraint(SpringLayout.WEST, useless, 24, SpringLayout.WEST, badly);
        useless.setFont(fontt);


        }


    }





