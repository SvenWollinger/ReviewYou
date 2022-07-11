package de.muenchen.reviewyou.GUI;

import de.muenchen.reviewyou.Utils;
import de.muenchen.reviewyou.excelhandler.Azubi;
import lombok.Getter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class GUI {

    private final Container contentPane;
    private final JFrame window;

    private final JButton next = new JButton("Weiter");
    private final JButton previous = new JButton("Zurück");
    private final JButton moreInfo = new JButton("Info");
    private final JButton btnTraineedata = new JButton("Azubidaten");
    private int page = 0;

    private final JPanel panel = new JPanel();
    private final JPanel secondPanel = new JPanel();
    private final JPanel thirdPanel = new JPanel();
    private final JPanel fourthPanel = new JPanel();
    private final JPanel fifthPanel = new JPanel();
    private final JPanel sixthPanel = new JPanel();
    private final JPanel seventhPanel = new JPanel();
    private final JPanel eigthPanel = new JPanel();
    private final JPanel ninethPanel = new JPanel();

    private final JPanel thirdPagePanel = new JPanel();
    private final JPanel[] panelArr = new JPanel[9];
    private final Font font = new Font(null, Font.PLAIN, 20);
    private final Font fontt = new Font(null, Font.PLAIN, 17);
    private final SpringLayout[] layoutArr = new SpringLayout[4];
    private final SpringLayout layout = new SpringLayout();

    private final String[] arrSoicalBehavior1 = new String[2];
    private final JList pickSocialBehavior = new JList(arrSoicalBehavior1);

    private final String[] arrSocialBehavior2 = new String[3];
    private final JList pickSocialBehavior2 = new JList(arrSocialBehavior2);

    private final String[] arrSocialBehavior3 = new String[3];
    private final JList pickSocialBehavior3 = new JList(arrSocialBehavior3);

    private final String[] arrWorkResult1 = new String[2];
    private final JList pickWorkResult1 = new JList(arrWorkResult1);

    private final String[] arrWorkResult2 = new String[3];
    private final JList pickWorkResult2 = new JList(arrWorkResult2);

    private final String[] arrWorkResult3 = new String[4];
    private final JList pickWorkResult3 = new JList(arrWorkResult3);

    private final String[] arrParticipationInTheLesson1 = new String[3];
    private final JList pickParticipationInTheLesson1 = new JList(arrParticipationInTheLesson1);

    private final String[] arrParticipationInTheLesson2 = new String[2];
    private final JList pickParticipationInTheLesson2 = new JList(arrParticipationInTheLesson2);

    private final String[] arrParticipationInTheLesson3 = new String[4];
    private final JList pickParticipationInTheLesson3 = new JList(arrParticipationInTheLesson3);

    private final String[] arrIndependentWork1 = new String[2];
    private final JList pickIndependentWork1 = new JList(arrIndependentWork1);

    private final String[] arrIndependentWork2 = new String[2];
    private final JList pickIndependentWork2 = new JList(arrIndependentWork2);

    private final String[] arrIndependentWork3 = new String[4];
    private final JList pickIndependentWork3 = new JList(arrIndependentWork3);

    private final String[] arrSupportColleagues1 = new String[2];
    private final JList pickSupportColleagues1 = new JList(arrSupportColleagues1);

    private final String[] arrSupportColleagues2 = new String[2];
    private final JList pickSupportColleagues2 = new JList(arrSupportColleagues2);

    private final String[] arrSupportColleagues3 = new String[1];
    private final JList pickSupportColleagues3 = new JList(arrSupportColleagues3);

    //Getter
    public JButton getMoreInfo() {
        return moreInfo;
    }

    public JButton getBtnTraineedata() {
        return btnTraineedata;
    }

    public JButton getNext() {
        return next;
    }

    public JButton getPrevious() {
        return previous;
    }

    public int getPage() {
        return page;
    }

    public JFrame getWindow() {
        return window;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getPanelByI(int i){
        return panelArr[i];
    }

    public JPanel getThirdPagePanel() {
        return thirdPagePanel;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public JPanel getSecondPanel() {
        return secondPanel;
    }

    public JPanel getThirdPanel() {
        return thirdPanel;
    }

    public JPanel getFourthPanel() {
        return fourthPanel;
    }

    public JPanel getFifthPanel() {
        return fifthPanel;
    }

    public JPanel getSixthPanel() {
        return sixthPanel;
    }

    public JPanel getSeventhPanel() {
        return seventhPanel;
    }

    public JPanel getEigthPanel() {
        return eigthPanel;
    }

    public JPanel getNinethPanel() {
        return ninethPanel;
    }

    //constructor

    public GUI() {
        window = new JFrame("Leistungsbericht Nachwuchskräfte");
        window.setResizable(false);
        window.setSize(800, 800);
        window.setLocationRelativeTo(null);

       for (int i=0; i<layoutArr.length; i++) {
            layoutArr[i] = new SpringLayout();
        }

        /*for (int i=0; i<panelArr.length; i++) {
            panelArr[i] = new JPanel();
        }*/

        contentPane = window.getContentPane();
        window.setLayout(layout);
        window.add(next);
        window.add(previous);
        window.add(moreInfo);
        window.add(btnTraineedata);
        previous.setVisible(false);
        moreInfo.setVisible(false);
        btnTraineedata.setVisible(false);

        next.setPreferredSize(new Dimension(80, 30));
        previous.setPreferredSize(new Dimension(80, 30));
        moreInfo.setPreferredSize(new Dimension(80, 30));

        // set nextButton

        layout.putConstraint(SpringLayout.SOUTH, next, -25, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, next, 400, SpringLayout.WEST, contentPane);

        // set previousButton

        layout.putConstraint(SpringLayout.SOUTH, previous, -25, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.EAST, previous, -5, SpringLayout.WEST, next);

        // set moreInfoButton

        layout.putConstraint(SpringLayout.SOUTH, moreInfo, -25, SpringLayout.SOUTH,contentPane);
        layout.putConstraint(SpringLayout.EAST, moreInfo, -180, SpringLayout.WEST, previous);

        //set traineeDataButton

        layout.putConstraint(SpringLayout.SOUTH, btnTraineedata, -25, SpringLayout.SOUTH,contentPane);
        layout.putConstraint(SpringLayout.EAST, btnTraineedata, -180, SpringLayout.WEST, previous);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startPanel();
        secondPanel();
        thirdPanel();
        fourthPanel();
        fifthPanel();
        sixthPanel();
        seventhPanel();
        eightPanel();
        ninethPanel();



        btn1SocialBehavior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickSocialBehavior.setFont(fontt);
                pickSocialBehavior.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickSocialBehavior);


            }
        });
        btn2SocialBehavior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickSocialBehavior2.setFont(fontt);
                pickSocialBehavior2.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickSocialBehavior2);
            }
        });
        btn3SocialBehavior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickSocialBehavior3.setFont(fontt);
                pickSocialBehavior3.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickSocialBehavior3);
            }
        });

        btn1WorkResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickWorkResult1.setFont(fontt);
                pickWorkResult1.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickWorkResult1);
            }
        });

        btn2WorkResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickWorkResult2.setFont(fontt);
                pickWorkResult2.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickWorkResult2);
            }
        });

        btn3WorkResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickWorkResult3.setFont(fontt);
                pickWorkResult3.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickWorkResult3);
            }
        });

        btn1ParticipationInTheLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickParticipationInTheLesson1.setFont(fontt);
                pickParticipationInTheLesson1.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickParticipationInTheLesson1);
            }
        });

        btn2ParticipationInTheLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickParticipationInTheLesson2.setFont(fontt);
                pickParticipationInTheLesson2.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickParticipationInTheLesson2);
            }
        });

        btn3ParticipationInTheLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickParticipationInTheLesson3.setFont(fontt);
                pickParticipationInTheLesson3.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickParticipationInTheLesson3);
            }
        });

        btn1IndependentWork.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickIndependentWork1.setFont(fontt);
                pickIndependentWork1.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickIndependentWork1);
            }
        });

        btn2IndependentWork.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickIndependentWork2.setFont(fontt);
                pickIndependentWork2.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickIndependentWork2);
            }
        });

        btn3IndependentWork.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickIndependentWork3.setFont(fontt);
                pickIndependentWork3.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickIndependentWork3);
            }
        });

        btn1supportColleagues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickSupportColleagues1.setFont(fontt);
                pickSupportColleagues1.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickSupportColleagues1);
            }
        });

        btn2supportColleagues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickSupportColleagues2.setFont(fontt);
                pickSupportColleagues2.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickSupportColleagues2);
            }
        });

        btn3supportColleagues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startThirdPanel();
                pickSupportColleagues3.setFont(fontt);
                pickSupportColleagues3.setPreferredSize(new Dimension(800,200));
                thirdPagePanel.add(pickSupportColleagues3);
            }
        });

        genderMen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                arrSoicalBehavior1[0] = "Ist ein sehr freundlicher Auszubildender";
                arrSoicalBehavior1[1] = "Ist ein sehr freundlicher und hilfsbereiteter Auszubildender";
                arrSocialBehavior2[0] = "Ist ein freundlicher Auszubildender";
                arrSocialBehavior2[1] = "Ist ein freundlicher und hilfsbereiter Auszubildender";
                arrSocialBehavior2[2] = "Ist ein freundlicher, jedoch zurückhaltender Auszubildender";
                arrSocialBehavior3[0] = "Ist ein freundlicher jedoch sehr zurückhaldender Auszubildender";
                arrSocialBehavior3[1] = "Ist ein sehr zurückhaldender Auszubildender";
                arrSocialBehavior3[2] = "Ist ein sehr zurückgezogener Auszubildender";
                arrWorkResult1[0] = "Sein Fachwissen ist sehr fundiert ";
                arrWorkResult1[1] = "Die Arbeitsergebnisse sind sehr gut";
                arrWorkResult2[0] = "Sein Fachwissen ist fundiert ";
                arrWorkResult2[1] = "Gewisse Lücken sind in seinem Wissen noch vorhanden";
                arrWorkResult2[2] = "Die Arbeitsergebnisse sind gut";
                arrWorkResult3[0] = "Sein Fachwissen muss stark aufgebaut werden";
                arrWorkResult3[1] = "Weißt große Wissenslücken auf";
                arrWorkResult3[2] = "Oftmals ist Nacharbeit erforderlich ";
                arrWorkResult3[3] = "Oftmals ist große Nacharbeit erforderlich";
                arrParticipationInTheLesson1[0] = "Er beteiligt sich sehr aktiv im Unterricht";
                arrParticipationInTheLesson1[1] = "Stellt sehr sinnvolle Fragen, die das Unterrichtsgeschehen bereichern";
                arrParticipationInTheLesson1[2] = "Herr X ist sehr aktiv und ergreift Initiative um seine Kolleg*innen zu unterstützen";
                arrParticipationInTheLesson2[0] = "Er beteiligt sich oftmals im Unterricht";
                arrParticipationInTheLesson2[1] = "Stellt oftmals sinnvolle Fragen ";
                arrParticipationInTheLesson3[0] = "Er beteiligt sich selten im Unterricht ";
                arrParticipationInTheLesson3[1] = "Stellt meist wenig bis keine Fragen";
                arrParticipationInTheLesson3[2] = "Herr X lenkt sich oftmals selbst ab";
                arrParticipationInTheLesson3[3] = "Herr X lenkt sich und seine Kolleg*innen oftmals selbst ab";
                arrIndependentWork1[0] = "Seine Arbeit wird stets gewissenhaft erledigt";
                arrIndependentWork1[1] = "Seine Arbeit wird oftmals gewissenhaft erledigt";
                arrIndependentWork2[0] = "Er erledigt seine Arbeit ohne Nachfragen ";
                arrIndependentWork2[1] = "Lässt sich leicht ablenken";
                arrIndependentWork3[0] = "Lässt sich sehr leicht ablenken";
                arrIndependentWork3[1] = "Die Arbeit wird oftmals nicht selbstständig ausgeführt";
                arrIndependentWork3[2] = "Er kommt seiner Arbeit erst nach Aufforderung nach";
                arrIndependentWork3[3] = "Er ist oft unsicher und muss viel nachfragen um die Arbeit zu schaffen";
                arrSupportColleagues1[0] = "Herr X geht offen auf seine Kolleg*innen zu und unterstützt jene";
                arrSupportColleagues1[1] = "Herr X ist zurückhaltend, bringt sich jedoch sehr gut in Teams ein";
                arrSupportColleagues2[0] = "Herr X ist eher zurückhaltend";
                arrSupportColleagues2[1] = "Herr X bevorzugt es in der gleichen Gruppe zu arbeiten";
                arrSupportColleagues3[0] = "Herr X geht seinen Kolleg*innen aus dem Weg und arbeitet lieber alleine";

            }
        });
        genderWoman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                arrSoicalBehavior1[0] = "Ist eine sehr freundliche Auszubildende";
                arrSoicalBehavior1[1] = "Ist eine sehr freundliche und hilfsbereitete Auszubildende";
                arrSocialBehavior2[0] = "Ist eine freundliche Auszubildende";
                arrSocialBehavior2[1] = "Ist eine freundliche und hilfsbereite Auszubildende";
                arrSocialBehavior2[2] = "Ist eine freundliche, jedoch zurückhaldende Auszubildende";
                arrSocialBehavior3[0] = "Ist eine freundliche, jedoch sehr zurückhaltende Auszubildende";
                arrSocialBehavior3[1] = "Ist eine sehr zurückhaldende Auszubildende";
                arrSocialBehavior3[2] = "Ist eine sehr zurückgezogene Auszubildende";
                arrWorkResult1[0] = "Ihr Fachwissen ist sehr fundiert ";
                arrWorkResult1[1] = "Die Arbeitsergebnisse sind sehr gut";
                arrWorkResult2[0] = "Ihr Fachwissen ist fundiert ";
                arrWorkResult2[1] = "Gewisse Lücken sind in ihrem Wissen noch vorhanden";
                arrWorkResult2[2] = "Die Arbeitsergebnisse sind gut";
                arrWorkResult3[0] = "Ihr Fachwissen muss stark aufgebaut werden";
                arrWorkResult3[1] = "Weißt große Wissenslücken auf";
                arrWorkResult3[2] = "Oftmals ist Nacharbeit erforderlich ";
                arrWorkResult3[3] = "Oftmals ist große Nacharbeit erforderlich";
                arrParticipationInTheLesson1[0] = "Sie beteiligt sich sehr aktiv im Unterricht";
                arrParticipationInTheLesson1[1] = "Stellt sehr sinnvolle Fragen, die das Unterrichtsgeschehen bereichern ";
                arrParticipationInTheLesson1[2] = "Frau X ist sehr aktiv und ergreift Initiative um seine Kolleg*innen zu unterstützen";
                arrParticipationInTheLesson2[0] = "Sie beteiligt sich oftmals im Unterricht ";
                arrParticipationInTheLesson2[1] = "Stellt oftmals sinnvolle Fragen ";
                arrParticipationInTheLesson3[0] = "Sie beteiligt sich selten im Unterricht ";
                arrParticipationInTheLesson3[1] = "Stellt meist wenig bis keine Fragen";
                arrParticipationInTheLesson3[2] = "Frau X lenkt sich oftmals selbst ab";
                arrParticipationInTheLesson3[3] = "Frau X lenkt sich und seine Kolleg*innen oftmals selbst ab";
                arrIndependentWork1[0] = "Ihre Arbeit wird stets gewissenhaft erledigt";
                arrIndependentWork1[1] = "Ihre Arbeit wird oftmals gewissenhaft erledigt";
                arrIndependentWork2[0] = "Sie erledigt ihre Arbeit ohne Nachfragen ";
                arrIndependentWork2[1] = "Lässt sich leicht ablenken";
                arrIndependentWork3[0] = "Lässt sich sehr leicht ablenken";
                arrIndependentWork3[1] = "Die Arbeit wird oftmals nicht selbstständig ausgeführt";
                arrIndependentWork3[2] = "Sie kommt ihrer Arbeit erst nach Aufforderung nach";
                arrIndependentWork3[3] = "Sie ist oft unsicher und muss viel nachfragen um die Arbeit zu schaffen";
                arrSupportColleagues1[0] ="Frau X geht offen auf ihre Kolleg*innen zu und unterstützt jene";
                arrSupportColleagues1[1] ="Frau X ist zurückhaltend, bringt sich jedoch sehr gut in Teams ein";
                arrSupportColleagues2[0] ="Frau X ist eher zurückhaltend";
                arrSupportColleagues2[1] ="Frau X bevorzugt es in der gleichen Gruppe zu arbeiten";
                arrSupportColleagues3[0] ="Frau X geht ihren Kolleg*innen aus dem Weg und arbeitet lieber alleine";
            }
        });



    }

    public void startThirdPanel() {
        thirdPagePanel.setPreferredSize(new Dimension(800,250));
        window.add(thirdPagePanel);
        thirdPagePanel.setVisible(true);
        thirdPagePanel.removeAll();
        thirdPagePanel.revalidate();
        thirdPagePanel.repaint();
        layout.putConstraint(SpringLayout.NORTH,thirdPagePanel,420,SpringLayout.NORTH,contentPane);
    }

    public void goToFirstPanel() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        previous.setVisible(false);
        btnTraineedata.setVisible(false);
        next.setVisible(true);
        //startPanel();
    }
    
    // First page to get user data

    private final JLabel name = new JLabel("Name");
    private final JLabel email = new JLabel("E-Mail");
    private final JLabel date = new JLabel("Datum");
    private final JLabel telephone = new JLabel("Tel");
    private final JTextField instructorName = new JTextField(15);
    private final JTextField instructorEmail = new JTextField(15);
    private final JTextField instructorTelephone = new JTextField(15);

    @Getter
    private final JTextField txtDate = new JTextField(15);
    //private JLabel headline
    LocalDate today = LocalDate.now();

    //Getter
    public JTextField getInstructorName() {
        return instructorName;
    }

    public JTextField getInstructorEmail() {
        return instructorEmail;
    }

    public JTextField getInstructorTelephone() {
        return instructorTelephone;
    }

    // second page

    public void startPanel() {
        panel.setVisible(true);
        window.setVisible(true);
        page = 1;
        window.add(panel);


        panel.setLayout(layoutArr[0]);
        JLabel headline = new JLabel("Angaben zum / zur Ausbilder:in");

        panel.setPreferredSize(new Dimension(800, 700));

        headline.setFont(font);


        // add Components
        panel.add(headline);
        panel.add(name);
        panel.add(email);
        panel.add(date);
        panel.add(instructorName);
        panel.add(telephone);
        panel.add(instructorEmail);
        panel.add(instructorTelephone);
        panel.add(txtDate);

        layoutArr[0].putConstraint(SpringLayout.NORTH, headline, 50, SpringLayout.NORTH, panel);
        layoutArr[0].putConstraint(SpringLayout.WEST, headline, 250, SpringLayout.WEST, panel);

        // set name and name textfield
        layoutArr[0].putConstraint(SpringLayout.WEST, name, 260, SpringLayout.WEST, panel);
        layoutArr[0].putConstraint(SpringLayout.NORTH, name, 50, SpringLayout.SOUTH, headline);
        name.setFont(font);

        // set instructorName
        layoutArr[0].putConstraint(SpringLayout.WEST, instructorName, 12, SpringLayout.EAST, name);
        layoutArr[0].putConstraint(SpringLayout.NORTH, instructorName, 4, SpringLayout.NORTH, name);


        // set email and email textfield
        layoutArr[0].putConstraint(SpringLayout.WEST, email, 260, SpringLayout.WEST, panel);
        layoutArr[0].putConstraint(SpringLayout.NORTH, email, 20, SpringLayout.SOUTH, name);
        email.setFont(font);

        //set instrutorEmail
        layoutArr[0].putConstraint(SpringLayout.WEST, instructorEmail, 7, SpringLayout.EAST, email);
        layoutArr[0].putConstraint(SpringLayout.NORTH, instructorEmail, 4, SpringLayout.NORTH, email);


        // set telephone and telephone textfield
        layoutArr[0].putConstraint(SpringLayout.WEST, telephone, 260, SpringLayout.WEST, panel);
        layoutArr[0].putConstraint(SpringLayout.NORTH, telephone, 20, SpringLayout.SOUTH, email);
        telephone.setFont(font);

        //setInstructorTelephone
        layoutArr[0].putConstraint(SpringLayout.WEST, instructorTelephone, 38, SpringLayout.EAST, telephone);
        layoutArr[0].putConstraint(SpringLayout.NORTH, instructorTelephone, 4, SpringLayout.NORTH, telephone);

        //setDate
        layoutArr[0].putConstraint(SpringLayout.WEST, date, 260, SpringLayout.WEST, panel);
        layoutArr[0].putConstraint(SpringLayout.NORTH, date, 20, SpringLayout.SOUTH, telephone);
        date.setFont(font);

        //txtDate
        layoutArr[0].putConstraint(SpringLayout.NORTH,txtDate, 27,SpringLayout.SOUTH,instructorTelephone);
        layoutArr[0].putConstraint(SpringLayout.WEST,txtDate,8,SpringLayout.EAST,date);

        txtDate.setText(today.format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));

    }

    //Second Page created Labels, Txtfields and JDatePicker

    private final JLabel apprenticeship = new JLabel("Informationen zur Nachwuchskraft");
    private final JLabel traineeName = new JLabel("Name, Vorname:");
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

    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
    JDatePickerImpl txtFrom = new JDatePickerImpl(datePanel,new DateLabelFormatter());

    UtilDateModel model1 = new UtilDateModel();
    JDatePanelImpl datePanel1 = new JDatePanelImpl(model1,p);
    JDatePickerImpl txtTill = new JDatePickerImpl(datePanel1,new DateLabelFormatter());

    UtilDateModel model2 = new UtilDateModel();
    JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
    JDatePickerImpl pickerHandover = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
    JDatePickerImpl pickerMeeting = new JDatePickerImpl(datePanel2, new DateLabelFormatter());

    //Getter
    public JDatePickerImpl getTxtFrom() {
        return txtFrom;
    }

    public JDatePickerImpl getTxtTill() {
        return txtTill;
    }

    public JDatePickerImpl getPickerHandover() {
        return pickerHandover;
    }

    public JDatePickerImpl getPickerMeeting() {
        return pickerMeeting;
    }

    public UtilDateModel getModel() {
        return model;
    }

    public UtilDateModel getModel1() {
        return model1;
    }

    public UtilDateModel getModel2() {
        return model2;
    }

    public JComboBox getApprenticeshipSelector() {
        return apprenticeshipSelector;
    }

    public JTextField getTxtTraineeName() {
        return txtTraineeName;
    }

    public JTextField getTxtBirthDate() {
        return txtBirthDate;
    }

    public JTextField getTxtApartmentStreet() {
        return txtApartmentStreet;
    }

    public JTextField getTxtTraineeYear() {
        return txtTraineeYear;
    }

    public JTextField getTxtTrainingArea() {
        return txtTrainingArea;
    }

    public JTextField getTxtSessions() {
        return txtSessions;
    }

    public JTextField getTxtInternshipSelection() {
        return  txtInternshipSelection;
    }

    public JTextField getTxtCourse() {
        return txtCourse;
    }


    public JPanel getPanelArr(int i) {
        return panelArr[i];
    }

    // second Page

    public void secondPanel() {

        //set properties for JDatePanel

        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        //added components
        secondPanel.setVisible(false);
        secondPanel.setPreferredSize(new Dimension(800, 700));

        secondPanel.add(txtFrom);
        secondPanel.add(txtTill);
        secondPanel.add(pickerHandover);
        secondPanel.add(pickerMeeting);
        secondPanel.setLayout(layoutArr[1]);
        window.add(secondPanel);
        secondPanel.add(apprenticeship);
        secondPanel.add(traineeName);
        secondPanel.add(txtTraineeName);
        secondPanel.add(birthDate);
        secondPanel.add(txtBirthDate);
        secondPanel.add(apartmentStreet);
        secondPanel.add(txtApartmentStreet);
        secondPanel.add(allocationPeriod);
        secondPanel.add(from);
        secondPanel.add(till);
        secondPanel.add(internshipSelection);
        secondPanel.add(txtInternshipSelection);
        secondPanel.add(trainingArea);
        secondPanel.add(txtTrainingArea);
        secondPanel.add(sessions);
        secondPanel.add(txtSessions);
        secondPanel.add(traingPlan);
        secondPanel.add(interimTalk);
        secondPanel.add(traineeYear);
        secondPanel.add(txtTraineeYear);
        secondPanel.add(course);
        secondPanel.add(txtCourse);
        secondPanel.add(apprenticeshipSelector);

        // setFont for Labels

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

        // set appreticeship
        layoutArr[1].putConstraint(SpringLayout.WEST, apprenticeship, 100, SpringLayout.WEST, contentPane);
        layoutArr[1].putConstraint(SpringLayout.NORTH, apprenticeship, 30, SpringLayout.NORTH, contentPane);

        // set traineeName and Textfield
        layoutArr[1].putConstraint(SpringLayout.WEST, traineeName, 100, SpringLayout.WEST, contentPane);
        layoutArr[1].putConstraint(SpringLayout.NORTH, traineeName, 20, SpringLayout.SOUTH, apprenticeship);

        layoutArr[1].putConstraint(SpringLayout.NORTH, txtTraineeName, 4, SpringLayout.NORTH, traineeName);
        layoutArr[1].putConstraint(SpringLayout.WEST, txtTraineeName, 10, SpringLayout.EAST, traineeName);

        // set birthDate and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH, birthDate, 1, SpringLayout.NORTH, traineeName);
        layoutArr[1].putConstraint(SpringLayout.WEST, birthDate, 10, SpringLayout.EAST, txtTraineeName);

        layoutArr[1].putConstraint(SpringLayout.NORTH, txtBirthDate, 2, SpringLayout.NORTH, birthDate);
        layoutArr[1].putConstraint(SpringLayout.WEST, txtBirthDate, 8, SpringLayout.EAST, birthDate);

        // set apartmentStreet and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH, apartmentStreet, 10, SpringLayout.SOUTH, traineeName);
        layoutArr[1].putConstraint(SpringLayout.WEST, apartmentStreet, 100, SpringLayout.WEST, contentPane);

        layoutArr[1].putConstraint(SpringLayout.NORTH, txtApartmentStreet, 4, SpringLayout.NORTH, apartmentStreet);
        layoutArr[1].putConstraint(SpringLayout.WEST, txtApartmentStreet, 10, SpringLayout.EAST, apartmentStreet);

        // set allocationPeriod
        layoutArr[1].putConstraint(SpringLayout.EAST, apprenticeshipSelector, -205, SpringLayout.EAST, panel);
        layoutArr[1].putConstraint(SpringLayout.NORTH, apprenticeshipSelector, 30, SpringLayout.NORTH, contentPane);
        apprenticeshipSelector.setEditable(true);

        layoutArr[1].putConstraint(SpringLayout.NORTH, allocationPeriod, 20, SpringLayout.SOUTH, apartmentStreet);
        layoutArr[1].putConstraint(SpringLayout.WEST, allocationPeriod, 100, SpringLayout.WEST, contentPane);

        // set from and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH, from, 10, SpringLayout.SOUTH, allocationPeriod);
        layoutArr[1].putConstraint(SpringLayout.WEST, from, 100, SpringLayout.WEST, contentPane);

        layoutArr[1].putConstraint(SpringLayout.NORTH, txtFrom, 10, SpringLayout.SOUTH, allocationPeriod);
        layoutArr[1].putConstraint(SpringLayout.WEST, txtFrom, 10, SpringLayout.EAST, from);

        // set till and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH, till, 10, SpringLayout.SOUTH, allocationPeriod);
        layoutArr[1].putConstraint(SpringLayout.WEST, till, 10, SpringLayout.EAST, txtFrom);

        layoutArr[1].putConstraint(SpringLayout.NORTH, txtTill, 10, SpringLayout.SOUTH, allocationPeriod);
        layoutArr[1].putConstraint(SpringLayout.WEST, txtTill, 10, SpringLayout.EAST, till);

        // set internshipSelection and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH, internshipSelection, 10, SpringLayout.SOUTH, from);
        layoutArr[1].putConstraint(SpringLayout.WEST, internshipSelection, 100, SpringLayout.WEST, contentPane);

        layoutArr[1].putConstraint(SpringLayout.NORTH, txtInternshipSelection, 14, SpringLayout.SOUTH, from);
        layoutArr[1].putConstraint(SpringLayout.WEST, txtInternshipSelection, 10, SpringLayout.EAST, internshipSelection);

        // set tranieeYear and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH, traineeYear,10, SpringLayout.SOUTH,internshipSelection);
        layoutArr[1].putConstraint(SpringLayout.WEST,traineeYear,100,SpringLayout.WEST,contentPane);

        layoutArr[1].putConstraint(SpringLayout.NORTH,txtTraineeYear, 14, SpringLayout.SOUTH,internshipSelection);
        layoutArr[1].putConstraint(SpringLayout.WEST,txtTraineeYear,10,SpringLayout.EAST,traineeYear);

        // set course and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH,course,10,SpringLayout.SOUTH,internshipSelection);
        layoutArr[1].putConstraint(SpringLayout.WEST,course,10,SpringLayout.EAST,txtTraineeYear);

        layoutArr[1].putConstraint(SpringLayout.NORTH, txtCourse, 14, SpringLayout.SOUTH,internshipSelection);
        layoutArr[1].putConstraint(SpringLayout.WEST, txtCourse, 10 ,SpringLayout.EAST,course);

        // set trainingsArea and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH, trainingArea, 20, SpringLayout.SOUTH, traineeYear);
        layoutArr[1].putConstraint(SpringLayout.WEST, trainingArea, 100, SpringLayout.WEST, contentPane);

        layoutArr[1].putConstraint(SpringLayout.NORTH, txtTrainingArea, 5, SpringLayout.SOUTH, trainingArea);
        layoutArr[1].putConstraint(SpringLayout.WEST, txtTrainingArea, 100, SpringLayout.WEST, contentPane);

        // set sessions and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH, sessions, 20, SpringLayout.SOUTH, txtTrainingArea);
        layoutArr[1].putConstraint(SpringLayout.WEST, sessions, 100, SpringLayout.WEST, contentPane);

        layoutArr[1].putConstraint(SpringLayout.NORTH, txtSessions, 14, SpringLayout.SOUTH, sessions);
        layoutArr[1].putConstraint(SpringLayout.WEST, txtSessions, 100, SpringLayout.WEST, contentPane);

        // set trainingsPlan and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH, traingPlan, 20, SpringLayout.SOUTH, txtSessions);
        layoutArr[1].putConstraint(SpringLayout.WEST, traingPlan, 100, SpringLayout.WEST, contentPane);

        layoutArr[1].putConstraint(SpringLayout.NORTH, pickerHandover, 10, SpringLayout.SOUTH, traingPlan);
        layoutArr[1].putConstraint(SpringLayout.WEST, pickerHandover, 100, SpringLayout.WEST, contentPane);

        // set interimTalk and Textfield
        layoutArr[1].putConstraint(SpringLayout.NORTH, interimTalk, 20, SpringLayout.SOUTH, pickerHandover);
        layoutArr[1].putConstraint(SpringLayout.WEST, interimTalk, 100, SpringLayout.WEST, contentPane);

        layoutArr[1].putConstraint(SpringLayout.NORTH, pickerMeeting, 10, SpringLayout.SOUTH, interimTalk);
        layoutArr[1].putConstraint(SpringLayout.WEST, pickerMeeting, 100, SpringLayout.WEST, contentPane);

        pickerHandover.getJFormattedTextField().setText(today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    // set Insets

    Insets headlineInsets = new Insets(0,0,200,0);
    Insets sliderInsets = new Insets(-60, 0, 70, 0);
    private final List<JSlider> jSliders = createSliders();

    //Getter
    public List<JSlider> getjSliders() {
        return jSliders;
    }

    private final JRadioButton genderMen = new JRadioButton("Männlich");
    private final JRadioButton genderWoman = new JRadioButton("Weiblich");
    private final ButtonGroup genderGroup = new ButtonGroup();
    private final JLabel socialBehavior = new JLabel("Sozialverhalten");
    private final JRadioButton btn1SocialBehavior = new JRadioButton("1");
    private final JRadioButton btn2SocialBehavior = new JRadioButton("2");
    private final JRadioButton btn3SocialBehavior = new JRadioButton("3");
    private final ButtonGroup socialBehaviorGroup = new ButtonGroup();
    private final JLabel workResult = new JLabel("Arebitsergebnisse/ -erfolg");
    private final JRadioButton btn1WorkResult = new JRadioButton("1");
    private final JRadioButton btn2WorkResult = new JRadioButton("2");
    private final JRadioButton btn3WorkResult = new JRadioButton("3");
    private final ButtonGroup workResultGroup = new ButtonGroup();
    private final JLabel participationInTheLesson = new JLabel("Mitarbeit im Unterricht");
    private final JRadioButton btn1ParticipationInTheLesson = new JRadioButton("1");
    private final JRadioButton btn2ParticipationInTheLesson = new JRadioButton("2");
    private final JRadioButton btn3ParticipationInTheLesson = new JRadioButton("3");
    private final ButtonGroup participationInTheLessonGroup = new ButtonGroup();
    private final JLabel independentWork = new JLabel("Selbstständiges Arbeiten");
    private final JRadioButton btn1IndependentWork = new JRadioButton("1");
    private final JRadioButton btn2IndependentWork = new JRadioButton("2");
    private final JRadioButton btn3IndependentWork = new JRadioButton("3");
    private final ButtonGroup independentWorkGroup = new ButtonGroup();
    private final JLabel supportColleagues = new JLabel("Unterstützung Kolleg*innen");
    private final JRadioButton btn1supportColleagues= new JRadioButton("1");
    private final JRadioButton btn2supportColleagues = new JRadioButton("2");
    private final JRadioButton btn3supportColleagues = new JRadioButton("3");
    private final ButtonGroup supportColleaguesGroup = new ButtonGroup();

    //third Page

    public void thirdPanel() {

        thirdPanel.setVisible(false);
        thirdPanel.setPreferredSize(new Dimension(800, 700));

        window.add(thirdPanel);
        thirdPanel.setLayout(layoutArr[3]);

        //add Elements

        genderGroup.add(genderMen);
        genderGroup.add(genderWoman);
        socialBehaviorGroup.add(btn1SocialBehavior);
        socialBehaviorGroup.add(btn2SocialBehavior);
        socialBehaviorGroup.add(btn3SocialBehavior);
        workResultGroup.add(btn1WorkResult);
        workResultGroup.add(btn2WorkResult);
        workResultGroup.add(btn3WorkResult);
        participationInTheLessonGroup.add(btn1ParticipationInTheLesson);
        participationInTheLessonGroup.add(btn2ParticipationInTheLesson);
        participationInTheLessonGroup.add(btn3ParticipationInTheLesson);
        independentWorkGroup.add(btn1IndependentWork);
        independentWorkGroup.add(btn2IndependentWork);
        independentWorkGroup.add(btn3IndependentWork);
        supportColleaguesGroup.add(btn1supportColleagues);
        supportColleaguesGroup.add(btn2supportColleagues);
        supportColleaguesGroup.add(btn3supportColleagues);


        thirdPanel.add(genderMen);
        thirdPanel.add(genderWoman);
        thirdPanel.add(socialBehavior);
        thirdPanel.add(btn1SocialBehavior);
        thirdPanel.add(btn2SocialBehavior);
        thirdPanel.add(btn3SocialBehavior);
        thirdPanel.add(workResult);
        thirdPanel.add(btn1WorkResult);
        thirdPanel.add(btn2WorkResult);
        thirdPanel.add(btn3WorkResult);
        thirdPanel.add(participationInTheLesson);
        thirdPanel.add(btn1ParticipationInTheLesson);
        thirdPanel.add(btn2ParticipationInTheLesson);
        thirdPanel.add(btn3ParticipationInTheLesson);
        thirdPanel.add(independentWork);
        thirdPanel.add(btn1IndependentWork);
        thirdPanel.add(btn2IndependentWork);
        thirdPanel.add(btn3IndependentWork);
        thirdPanel.add(supportColleagues);
        thirdPanel.add(btn1supportColleagues);
        thirdPanel.add(btn2supportColleagues);
        thirdPanel.add(btn3supportColleagues);

        genderWoman.setFont(fontt);
        genderMen.setFont(fontt);
        socialBehavior.setFont(font);
        btn1SocialBehavior.setFont(font);
        btn2SocialBehavior.setFont(font);
        btn3SocialBehavior.setFont(font);
        workResult.setFont(font);
        btn1WorkResult.setFont(font);
        btn2WorkResult.setFont(font);
        btn3WorkResult.setFont(font);
        participationInTheLesson.setFont(font);
        btn1ParticipationInTheLesson.setFont(font);
        btn2ParticipationInTheLesson.setFont(font);
        btn3ParticipationInTheLesson.setFont(font);
        independentWork.setFont(font);
        btn1IndependentWork.setFont(font);
        btn2IndependentWork.setFont(font);
        btn3IndependentWork.setFont(font);
        supportColleagues.setFont(font);
        btn1supportColleagues.setFont(font);
        btn2supportColleagues.setFont(font);
        btn3supportColleagues.setFont(font);


        layoutArr[3].putConstraint(SpringLayout.NORTH, genderMen,30,SpringLayout.NORTH,contentPane);
        layoutArr[3].putConstraint(SpringLayout.WEST,genderMen,95,SpringLayout.WEST,contentPane);

        layoutArr[3].putConstraint(SpringLayout.NORTH,genderWoman,30,SpringLayout.NORTH,contentPane);
        layoutArr[3].putConstraint(SpringLayout.WEST,genderWoman,5,SpringLayout.EAST,genderMen);

        layoutArr[3].putConstraint(SpringLayout.NORTH,socialBehavior,10,SpringLayout.SOUTH,genderMen);
        layoutArr[3].putConstraint(SpringLayout.WEST,socialBehavior, 100,SpringLayout.WEST,contentPane);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn1SocialBehavior,10,SpringLayout.SOUTH,genderMen);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn1SocialBehavior,150,SpringLayout.EAST,socialBehavior);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn2SocialBehavior,10,SpringLayout.SOUTH,genderMen);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn2SocialBehavior,50,SpringLayout.EAST,btn1SocialBehavior);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn3SocialBehavior,10,SpringLayout.SOUTH,genderMen);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn3SocialBehavior,50, SpringLayout.EAST,btn2SocialBehavior);

        layoutArr[3].putConstraint(SpringLayout.NORTH,workResult,50,SpringLayout.SOUTH,socialBehavior);
        layoutArr[3].putConstraint(SpringLayout.WEST,workResult,100,SpringLayout.WEST,contentPane);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn1WorkResult,40,SpringLayout.SOUTH,btn1SocialBehavior);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn1WorkResult,54,SpringLayout.EAST,workResult);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn2WorkResult,40,SpringLayout.SOUTH,btn1SocialBehavior);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn2WorkResult,50,SpringLayout.EAST,btn1WorkResult);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn3WorkResult,40,SpringLayout.SOUTH,btn1SocialBehavior);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn3WorkResult,50, SpringLayout.EAST,btn2WorkResult);

        layoutArr[3].putConstraint(SpringLayout.NORTH,participationInTheLesson,50,SpringLayout.SOUTH,workResult);
        layoutArr[3].putConstraint(SpringLayout.WEST,participationInTheLesson, 100,SpringLayout.WEST,contentPane);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn1ParticipationInTheLesson,40,SpringLayout.SOUTH,btn1WorkResult);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn1ParticipationInTheLesson,88,SpringLayout.EAST,participationInTheLesson);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn2ParticipationInTheLesson,40,SpringLayout.SOUTH,btn1WorkResult);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn2ParticipationInTheLesson,50,SpringLayout.EAST,btn1ParticipationInTheLesson);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn3ParticipationInTheLesson,40,SpringLayout.SOUTH,btn1WorkResult);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn3ParticipationInTheLesson,50, SpringLayout.EAST,btn2ParticipationInTheLesson);

        layoutArr[3].putConstraint(SpringLayout.NORTH,independentWork,50,SpringLayout.SOUTH,participationInTheLesson);
        layoutArr[3].putConstraint(SpringLayout.WEST,independentWork, 100,SpringLayout.EAST,contentPane);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn1IndependentWork,40,SpringLayout.SOUTH,btn1ParticipationInTheLesson);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn1IndependentWork,63,SpringLayout.EAST,independentWork);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn2IndependentWork,40,SpringLayout.SOUTH,btn1ParticipationInTheLesson);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn2IndependentWork,50,SpringLayout.EAST,btn1IndependentWork);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn3IndependentWork,40,SpringLayout.SOUTH,btn1ParticipationInTheLesson);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn3IndependentWork,50, SpringLayout.EAST,btn2IndependentWork);

        layoutArr[3].putConstraint(SpringLayout.NORTH,supportColleagues,50,SpringLayout.SOUTH,independentWork);
        layoutArr[3].putConstraint(SpringLayout.WEST,supportColleagues, 100,SpringLayout.WEST,contentPane);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn1supportColleagues,40,SpringLayout.SOUTH,btn1IndependentWork);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn1supportColleagues,48,SpringLayout.EAST,supportColleagues);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn2supportColleagues,40,SpringLayout.SOUTH,btn1IndependentWork);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn2supportColleagues,50,SpringLayout.EAST,btn1supportColleagues);

        layoutArr[3].putConstraint(SpringLayout.NORTH,btn3supportColleagues,40,SpringLayout.SOUTH,btn1IndependentWork);
        layoutArr[3].putConstraint(SpringLayout.WEST,btn3supportColleagues,50, SpringLayout.EAST,btn2supportColleagues);

    }

    // third Page

    public void fourthPanel(){
        //panelArr[3].setVisible(false);
        fourthPanel.setPreferredSize(new Dimension(800, 700));
        fourthPanel.setVisible(false);
        JLabel headline = new JLabel("Fachliche Kompetenzen");
        headline.setFont(font);
        window.add(fourthPanel);
        fourthPanel.setLayout(gbl);

        gbc.insets = headlineInsets;
        gbc.gridx = 0;
        gbc.gridy = 0;

        fourthPanel.add(headline, gbc);

        // BEHERRSCHUNG DER DEUTSCHEN SPRACHE
        gbc.insets = sliderInsets;
        gbc.gridx = 0;
        gbc.gridy = 1;
        fourthPanel.add(createLabel("Beherrschung der deutschen Sprache").get(0), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        fourthPanel.add(jSliders.get(0), gbc);


        // IT-KENNTNISSE
        gbc.gridx = 0;
        gbc.gridy = 3;
        fourthPanel.add(createLabel("IT-Kenntnisse").get(0), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        fourthPanel.add(jSliders.get(1), gbc);


        // INTERESSE AM ARBEITSFELD
        gbc.gridx = 0;
        gbc.gridy = 5;
        fourthPanel.add(createLabel("Interesse am Arbeitsumfeld und Grundwissen zum Aufgabenbereich der Praktikumsstelle").get(0), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        fourthPanel.add(jSliders.get(2), gbc);

        }

        // fourth Page

        public void fifthPanel(){

            fifthPanel.setVisible(false);
            fifthPanel.setPreferredSize(new Dimension(800, 700));
            JLabel headline = new JLabel("Methodisches Denken");
            headline.setFont(font);
            window.add(fifthPanel);
            fifthPanel.setLayout(gbl);

            gbc.insets = headlineInsets;
            gbc.gridx = 0;
            gbc.gridy = 0;
            fifthPanel.add(headline, gbc);

            // ANALYTISCHES DENKEN
            gbc.insets = sliderInsets;
            gbc.gridx = 0;
            gbc.gridy = 1;
            fifthPanel.add(createLabel("Analytisches Denken").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            fifthPanel.add(jSliders.get(3), gbc);

            // GANZHEITLICHES UND VERNETZTES DENKEN
            gbc.gridx = 0;
            gbc.gridy = 3;
            fifthPanel.add(createLabel("Ganzheitliches und vernetztes Denken").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            fifthPanel.add(jSliders.get(4), gbc);

            // ARBEITS- UND LERNTECHNIKEN
            gbc.gridx = 0;
            gbc.gridy = 5;
            fifthPanel.add(createLabel("Arbeits- und Lerntechniken").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            fifthPanel.add(jSliders.get(5), gbc);
        }

        // fifth Page

        public void sixthPanel(){

            JLabel headline = new JLabel("Soziale Kompetenzen");
            sixthPanel.setVisible(false);
            sixthPanel.setPreferredSize(new Dimension(800, 700));
            headline.setFont(font);
            window.add(sixthPanel);
            sixthPanel.setLayout(gbl);

            gbc.insets = new Insets(0, 0, 100, 0);
            gbc.gridx = 0;
            gbc.gridy = 0;
            sixthPanel.add(headline, gbc);

            // KOMMUNIKATIONSFÄHIGKEIT
            gbc.insets = sliderInsets;
            gbc.gridx = 0;
            gbc.gridy = 1;
            sixthPanel.add(createLabel("Kommunikationsfähigkeit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            sixthPanel.add(jSliders.get(6), gbc);

            // KONTAKTFREUDIGKEIT
            gbc.gridx = 0;
            gbc.gridy = 3;
            sixthPanel.add(createLabel("Kontaktfreudigkeit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            sixthPanel.add(jSliders.get(7), gbc);

            // TEAMFÄHIGKEIT UND KOOPERATIONSBEREITSCHAFT
            gbc.gridx = 0;
            gbc.gridy = 5;
            sixthPanel.add(createLabel("Teamfähigkeit und Kooperationsbereitschaft").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            sixthPanel.add(jSliders.get(8), gbc);

            // KONFLIKTFÄHIGKEIT
            gbc.gridx = 0;
            gbc.gridy = 7;
            sixthPanel.add(createLabel("Konfliktfähigkeit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 8;
            sixthPanel.add(jSliders.get(9), gbc);

            // EINFÜHLUNGSVERMÖGEN
            gbc.gridx = 0;
            gbc.gridy = 9;
            sixthPanel.add(createLabel("Einfühlungsvermögen").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 10;
            sixthPanel.add(jSliders.get(10), gbc);

            // RESPEKT UND UMGANG MIT ANDEREN KULTUREN
            gbc.gridx = 0;
            gbc.gridy = 11;
            sixthPanel.add(createLabel("Respekt und kompetenter Umgang mit anderen Kulturen").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 12;
            sixthPanel.add(jSliders.get(11), gbc);
        }

        // sixth Page

        public void seventhPanel(){

            seventhPanel.setVisible(false);
            seventhPanel.setPreferredSize(new Dimension(800, 700));
            JLabel headline = new JLabel("Persönliche Kompetenzen");
            headline.setFont(font);
            window.add(seventhPanel);
            seventhPanel.setLayout(gbl);

            gbc.insets = new Insets(10, 0, 60, 0);
            gbc.gridx = 0;
            gbc.gridy = 0;
            seventhPanel.add(headline, gbc);

            // OFFENHEIT
            gbc.insets = new Insets(-30, 0, 40, 0);
            gbc.gridx = 0;
            gbc.gridy = 1;
            seventhPanel.add(createLabel("Offenheit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            seventhPanel.add(jSliders.get(12), gbc);

            // GEWISSENHAFTIGKEIT UND INTEGRITÄT
            gbc.gridx = 0;
            gbc.gridy = 3;
            seventhPanel.add(createLabel("Gewissenhaftigkeit und Integrität").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            seventhPanel.add(jSliders.get(13), gbc);

            // MOTIVATION
            gbc.gridx = 0;
            gbc.gridy = 5;
            seventhPanel.add(createLabel("Motivation").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            seventhPanel.add(jSliders.get(14), gbc);

            // STRESSTOLERANZ
            gbc.gridx = 0;
            gbc.gridy = 7;
            seventhPanel.add(createLabel("Stresstoleranz").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 8;
            seventhPanel.add(jSliders.get(15), gbc);

            // IDENTIFIKATION
            gbc.gridx = 0;
            gbc.gridy = 9;
            seventhPanel.add(createLabel("Identifikation").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 10;
            seventhPanel.add(jSliders.get(16), gbc);

            // SELBSTSTÄNDIGKEIT
            gbc.gridx = 0;
            gbc.gridy = 11;
            seventhPanel.add(createLabel("Selbstständigkeit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 12;
            seventhPanel.add(jSliders.get(17), gbc);

            // KRITIKFÄHIGKEIT
            gbc.gridx = 0;
            gbc.gridy = 13;
            seventhPanel.add(createLabel("Kritikfähigkeit").get(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 14;
            seventhPanel.add(jSliders.get(18), gbc);
        }

    // ELEMENTS FOR SEVENTH PAGE

    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    Dimension preferedSize = new Dimension(600, 50);
    Dimension maximumSize = new Dimension(600, 70);

    @Getter
    JTextArea abilities = Utils.getDescJTextArea(preferedSize, maximumSize);
    @Getter
    JTextArea strength = Utils.getDescJTextArea(preferedSize, maximumSize);
    @Getter
    JTextArea developements = Utils.getDescJTextArea(preferedSize, maximumSize);
    @Getter
    JTextArea perspective = Utils.getDescJTextArea(preferedSize, maximumSize);
    @Getter
    JTextArea others = Utils.getDescJTextArea(preferedSize, maximumSize);

    // CREATE SEVENTH PAGE
    public void eightPanel() {

        JLabel headline = new JLabel("Wortbeschreibung zur gezeigten Leistung insgesamt");
        JLabel whiteSpace = new JLabel();
        eigthPanel.setVisible(false);
        eigthPanel.setPreferredSize(new Dimension(800, 700));
        window.add(eigthPanel);
        eigthPanel.setLayout(gbl);

        gbc.insets = new Insets(-10, 20, 80, 20);
        gbc.gridx = 0;

        gbc.gridy = 0;
        headline.setFont(font);
        eigthPanel.add(headline, gbc);

        gbc.insets = new Insets(0, 20, 10, 20);

        gbc.gridy = 2;
        eigthPanel.add(Utils.getJLabel("Fähigkeiten, praktische Leistungen, Verhalten", font), gbc);

        gbc.gridy++;
        eigthPanel.add(abilities, gbc);

        gbc.gridy++;
        eigthPanel.add(Utils.getJLabel("Stärken", font), gbc);

        gbc.gridy++;
        eigthPanel.add(strength, gbc);

        gbc.gridy++;
        eigthPanel.add(Utils.getJLabel("Entwicklungsfelder", font), gbc);

        gbc.gridy++;
        eigthPanel.add(developements, gbc);

        gbc.gridy++;
        eigthPanel.add(Utils.getJLabel("Perspektiven", font), gbc);

        gbc.gridy++;
        eigthPanel.add(perspective, gbc);

        gbc.gridy++;
        eigthPanel.add(Utils.getJLabel("Sonstige Anmerkungen", font), gbc);

        gbc.gridy++;
        eigthPanel.add(others, gbc);
    }

    // elements for eight Page

    @Getter
    JButton calc = new JButton("Berechnen");
    @Getter
    JButton saveAndNew = new JButton("Speichern und neuer Leistungsbericht");
    @Getter
    JButton saveAndExit = new JButton("Speichern und Schließen");
    @Getter
    JLabel score = new JLabel("Punktzahl:");
    @Getter
    JLabel review = new JLabel("Gesamturteil:");
    @Getter
    JLabel txtPoints = new JLabel();
    @Getter
    JLabel txtReview = new JLabel();

    // eight Page

    public void ninethPanel(){

        JLabel headline = new JLabel("Abschluss des Leistungsberichts von " + txtTraineeName.getText());
        ninethPanel.setVisible(false);
        window.add(ninethPanel);
        ninethPanel.setPreferredSize(new Dimension(800, 700));
        ninethPanel.setLayout(layoutArr[2]);

        //add Elements
        ninethPanel.add(headline);
        ninethPanel.add(score);
        ninethPanel.add(review);
        ninethPanel.add(calc);
        ninethPanel.add(saveAndNew);
        ninethPanel.add(saveAndExit);
        ninethPanel.add(txtPoints);
        ninethPanel.add(txtReview);

        //set Font
        headline.setFont(font);
        score.setFont(font);
        review.setFont(font);
        txtPoints.setFont(font);
        txtReview.setFont(font);

        //set size of the calculate Button
        calc.setPreferredSize(new Dimension(150,26));

        //set headline
        layoutArr[2].putConstraint(SpringLayout.WEST,headline,80,SpringLayout.WEST,contentPane);
        layoutArr[2].putConstraint(SpringLayout.NORTH,headline,280,SpringLayout.NORTH,contentPane);

        //set score
        layoutArr[2].putConstraint(SpringLayout.NORTH,score,30,SpringLayout.SOUTH,headline);
        layoutArr[2].putConstraint(SpringLayout.WEST,score,100,SpringLayout.WEST,contentPane);

        //set review
        layoutArr[2].putConstraint(SpringLayout.NORTH,review,5,SpringLayout.SOUTH,score);
        layoutArr[2].putConstraint(SpringLayout.WEST,review,100,SpringLayout.WEST,contentPane);

        //set calc
        layoutArr[2].putConstraint(SpringLayout.NORTH,calc,30,SpringLayout.SOUTH,review);
        layoutArr[2].putConstraint(SpringLayout.WEST,calc,80,SpringLayout.WEST,contentPane);

        //set saveAndNew
        layoutArr[2].putConstraint(SpringLayout.NORTH,saveAndNew,30,SpringLayout.SOUTH,review);
        layoutArr[2].putConstraint(SpringLayout.WEST,saveAndNew,40,SpringLayout.EAST,calc);

        //set saveAndExit
        layoutArr[2].putConstraint(SpringLayout.NORTH,saveAndExit,30,SpringLayout.SOUTH,review);
        layoutArr[2].putConstraint(SpringLayout.WEST,saveAndExit,40,SpringLayout.EAST,saveAndNew);

        //set txtPoints
        layoutArr[2].putConstraint(SpringLayout.NORTH,txtPoints,30,SpringLayout.SOUTH,headline);
        layoutArr[2].putConstraint(SpringLayout.WEST,txtPoints,50,SpringLayout.EAST,score);

        //set txtReview
        layoutArr[2].putConstraint(SpringLayout.NORTH,txtReview,5,SpringLayout.SOUTH,txtPoints);
        layoutArr[2].putConstraint(SpringLayout.WEST,txtReview,50,SpringLayout.EAST,score);
    }

    // sliders

    java.util.List<JSlider> createSliders(){
        final int minScore = 0;
        final int maxScore = 15;
        final int scoreInit = 0;
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

    // Elements for moreInfo page

    private final JLabel PointsDistribution = new JLabel("Folgende Punktezahlen können vergeben werden: ");
    private final JLabel particularly = new JLabel("  15 - 13 Punkte: Eine besonders hervorragende Leistung.");
    private final JLabel good = new JLabel(" 12 -10 Punkte: Eine Leistung, die die durchschnittlichen Anforderungen übertrifft.");
    private final JLabel average = new JLabel(" 9 - 7 Punkte: Eine Leistung, die in jeder Hinsicht durchschnittlichen Anforderungen entspricht.");
    private final JLabel defects = new JLabel(" 6 - 4 Punkte: Eine Leistung, die trotz ihrer Mängel durchschnittlichen Anforderungen noch entspricht.");
    private final JLabel badly = new JLabel(" 3 - 1 Punkte: Eine an erheblichen Mängeln leidende, im Ganzen nicht mehr brauchbare Leistung.");
    private final JLabel useless = new JLabel("0 Punkte: Eine völlig unbrauchbare Leistung.");
    private final JFrame popup = new JFrame("Info");
    private final JPanel popupPanel = new JPanel();

    //Getter
    public JFrame getPopup() {
        return popup;
    }

    // Moreinfo page

    public void moreInfo(){
        popup.setVisible(true);
        popup.setSize(805, 350);
        popup.add(popupPanel);
        popup.setLocation(75, 300);
        popupPanel.setLayout(layout);
        JLabel headline = new JLabel("Bewertung: ");
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