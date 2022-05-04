package de.muenchen.reviewyou;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class GUI {


    private Container contentPane;
    private JFrame window;


    private JButton next = new JButton("Weiter");
    private JButton previous = new JButton("Zurück");
    private int page = 0;

    SpringLayout layout = new SpringLayout();
    JPanel panel = new JPanel();
    Font font = new Font(null, Font.PLAIN, 20);
    Font fontt = new Font(null, Font.PLAIN, 15);


    public GUI() {
        window = new JFrame("Leistungsbericht Nachwuchskräfte");
        window.setResizable(false);
        window.setSize(800, 800);
        window.setLocationRelativeTo(null);
        window.add(panel);

        panel.setBackground(Color.red);
        panel.setPreferredSize(new Dimension(800, 650));
        panel.setVisible(true);


        contentPane = window.getContentPane();
        contentPane.setLayout(layout);
        contentPane.add(next);
        contentPane.add(previous);
        previous.setVisible(false);


        next.setPreferredSize(new Dimension(80, 30));
        previous.setPreferredSize(new Dimension(80, 30));

        layout.putConstraint(SpringLayout.SOUTH, next, -25, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, next, 400, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.SOUTH, previous, -25, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.EAST, previous, -5, SpringLayout.WEST, next);

        window.setVisible(true);
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
                    secondPanel();
                    break;
                    case 2:
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    thirdPanel();
                    break;
                }
            }
        });

        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (page) {
                    case 3:
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    secondPanel();
                    break;
                    case 2:
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                    startPanel();
                    break;
                }
            }
        });
    }

    public void checkPage() {
        if (page != 1) {
            previous.setVisible(true);
        } else previous.setVisible(false);
    }

    // First page to get user data

    private JLabel name = new JLabel("Name:");
    private JLabel email = new JLabel("E-Mail:");
    private JLabel date = new JLabel("Datum");
    private JLabel telephone = new JLabel("Tel:");
    private JTextField instructorName = new JTextField(15);
    private JTextField instructorEmail = new JTextField(15);
    private JLabel currentDate = new JLabel(LocalDateTime.now().toString());
    private JTextField instructorTelephone = new JTextField(15);
    private JLabel headline;

    // second page


    public void startPanel() {

        headline = new JLabel("Angaben zum / zur Ausbilder:in");
        headline.setFont(font);
        window.add(panel);

        // CHECK PAGE
        page = 1;
        checkPage();

        panel.setLayout(layout);

        panel.add(headline);
        panel.add(name);
        panel.add(email);
        panel.add(instructorName);
        panel.add(telephone);
        panel.add(instructorEmail);
        panel.add(instructorTelephone);

        layout.putConstraint(SpringLayout.WEST, headline, 250, SpringLayout.WEST, panel);

        // set name and name textfield
        layout.putConstraint(SpringLayout.WEST, name, 260, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, name, 50, SpringLayout.NORTH, panel);
        name.setFont(font);

        layout.putConstraint(SpringLayout.WEST, instructorName, 10, SpringLayout.EAST, name);
        layout.putConstraint(SpringLayout.NORTH, instructorName, 4, SpringLayout.NORTH, name);

        // set email and email textfield
        layout.putConstraint(SpringLayout.WEST, email, 260, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, email, 90, SpringLayout.NORTH, panel);
        email.setFont(font);

        layout.putConstraint(SpringLayout.WEST, instructorEmail, 7, SpringLayout.EAST, email);
        layout.putConstraint(SpringLayout.NORTH, instructorEmail, 4, SpringLayout.NORTH, email);

        // set telephone and telephone textfield
        layout.putConstraint(SpringLayout.WEST, telephone, 260, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, telephone, 130, SpringLayout.NORTH, panel);
        telephone.setFont(font);

        layout.putConstraint(SpringLayout.WEST, instructorTelephone, 36, SpringLayout.EAST, telephone);
        layout.putConstraint(SpringLayout.NORTH, instructorTelephone, 4, SpringLayout.NORTH, telephone);


    }

    // GETTER FOR FIRST PAGE
    public JTextField getInstructorName() {
        return instructorName;
    }

    public JTextField getInstructorEmail() {
        return instructorEmail;
    }

    public JTextField getInstructorTelephone() {
        return instructorTelephone;
    }
    private JLabel apprenticeship = new JLabel("Informationen zur Nachwuchskraft:");
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

    public void secondPanel() {
        page = 2;
        checkPage();

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


        layout.putConstraint(SpringLayout.WEST, apprenticeship, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.WEST, traineeName, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, traineeName, 10, SpringLayout.SOUTH, apprenticeship);

        layout.putConstraint(SpringLayout.NORTH, txtTraineeName, 10, SpringLayout.SOUTH, apprenticeship);
        layout.putConstraint(SpringLayout.WEST, txtTraineeName, 10, SpringLayout.EAST, traineeName);

        layout.putConstraint(SpringLayout.NORTH, birthDate, 10, SpringLayout.SOUTH, apprenticeship);
        layout.putConstraint(SpringLayout.WEST, birthDate, 10, SpringLayout.EAST, txtTraineeName);

        layout.putConstraint(SpringLayout.NORTH, txtBirthDate, 10, SpringLayout.SOUTH, apprenticeship);
        layout.putConstraint(SpringLayout.WEST, txtBirthDate, 10, SpringLayout.EAST, birthDate);

        layout.putConstraint(SpringLayout.NORTH, apartmentStreet, 10, SpringLayout.SOUTH, traineeName);
        layout.putConstraint(SpringLayout.WEST, apartmentStreet, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.WEST, txtApartmentStreet, 10, SpringLayout.EAST, apartmentStreet);
        layout.putConstraint(SpringLayout.NORTH, txtApartmentStreet, 10, SpringLayout.SOUTH, txtBirthDate);

        layout.putConstraint(SpringLayout.NORTH, allocationPeriod, 20, SpringLayout.SOUTH, apartmentStreet);
        layout.putConstraint(SpringLayout.WEST, allocationPeriod, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, from, 10, SpringLayout.SOUTH, allocationPeriod);
        layout.putConstraint(SpringLayout.WEST, from, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, txtfrom, 10, SpringLayout.SOUTH, allocationPeriod);
        layout.putConstraint(SpringLayout.WEST, txtfrom, 10, SpringLayout.EAST, from);

        layout.putConstraint(SpringLayout.NORTH, till, 10, SpringLayout.SOUTH, allocationPeriod);
        layout.putConstraint(SpringLayout.WEST, till, 10, SpringLayout.EAST, txtfrom);

        layout.putConstraint(SpringLayout.NORTH, txtTill, 10, SpringLayout.SOUTH, allocationPeriod);
        layout.putConstraint(SpringLayout.WEST, txtTill, 10, SpringLayout.EAST, till);

        layout.putConstraint(SpringLayout.NORTH, internshipSelection, 10, SpringLayout.SOUTH, from);
        layout.putConstraint(SpringLayout.WEST, internshipSelection, 100, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, txtInternshipSelection, 10, SpringLayout.SOUTH, from);
        layout.putConstraint(SpringLayout.WEST, txtInternshipSelection, 10, SpringLayout.EAST, internshipSelection);

        layout.putConstraint(SpringLayout.NORTH, trainingArea, 20, SpringLayout.SOUTH, internshipSelection);
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
        public void thirdPanel() {
            page = 3;
        }
    }

