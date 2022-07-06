package de.muenchen.reviewyou.GUI;

import de.muenchen.reviewyou.GUI.pages.StartPanel;
import de.muenchen.reviewyou.Utils;
import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class GUI {

    @Getter
    private final LocalDate startTime = LocalDate.now();

    private final JFrame window;
    @Getter
    private JPanel panel = new JPanel();

    @Getter
    @Setter
    private JLabel traineeName = new JLabel();

    //Pages
    @Getter
    private StartPanel pageStart = new StartPanel();

    @Getter
    private final Container contentPane;

    private final JButton next = new JButton("Weiter");
    private final JButton previous = new JButton("Zurück");
    private final JButton moreInfo = new JButton("Info");
    private final JButton btnTraineedata = new JButton("Azubidaten");

    @Getter
    @Setter
    private int page = 0;

    @Getter
    private final Font font = new Font(null, Font.PLAIN, 20);
    @Getter
    private final Font fontSmall = new Font(null, Font.PLAIN, 17);

    private final JPanel thirdPagePanel = new JPanel();
    private final SpringLayout layout = new SpringLayout();
    private final SpringLayout layout2 = new SpringLayout();
    private final SpringLayout layout3 = new SpringLayout();
    private final SpringLayout layout4 = new SpringLayout();
    private final SpringLayout layout5 = new SpringLayout();

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

    //constructor

    public GUI() {
        window = new JFrame("Leistungsbericht Nachwuchskräfte");
        window.setResizable(true);
        window.setSize(800, 800);
        window.setLocationRelativeTo(null);

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
        window.setVisible(true);
        getPageStart().generate(this);
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
        pageStart.generate(this);
        window.setVisible(true);
    }

    // second Page


    // set Insets

    Insets headlineInsets = new Insets(0,0,200,0);
    Insets sliderInsets = new Insets(-60, 0, 70, 0);
    private final List<JSlider> jSliders = createSliders();


    @Getter
    Properties datePickerProperties = new Properties();

    //Getter
    public List<JSlider> getjSliders() {
        datePickerProperties.put("text.today", "Today");
        datePickerProperties.put("text.month", "Month");
        datePickerProperties.put("text.year", "Year");

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
        page = 3;

        //set Panel

        window.add(panel);
        panel.setVisible(true);
        panel.setLayout(layout4);

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


        panel.add(genderMen);
        panel.add(genderWoman);
        panel.add(socialBehavior);
        panel.add(btn1SocialBehavior);
        panel.add(btn2SocialBehavior);
        panel.add(btn3SocialBehavior);
        panel.add(workResult);
        panel.add(btn1WorkResult);
        panel.add(btn2WorkResult);
        panel.add(btn3WorkResult);
        panel.add(participationInTheLesson);
        panel.add(btn1ParticipationInTheLesson);
        panel.add(btn2ParticipationInTheLesson);
        panel.add(btn3ParticipationInTheLesson);
        panel.add(independentWork);
        panel.add(btn1IndependentWork);
        panel.add(btn2IndependentWork);
        panel.add(btn3IndependentWork);
        panel.add(supportColleagues);
        panel.add(btn1supportColleagues);
        panel.add(btn2supportColleagues);
        panel.add(btn3supportColleagues);

        genderWoman.setFont(fontSmall);
        genderMen.setFont(fontSmall);
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


        layout4.putConstraint(SpringLayout.NORTH, genderMen,30,SpringLayout.NORTH,contentPane);
        layout4.putConstraint(SpringLayout.WEST,genderMen,95,SpringLayout.WEST,contentPane);

        layout4.putConstraint(SpringLayout.NORTH,genderWoman,30,SpringLayout.NORTH,contentPane);
        layout4.putConstraint(SpringLayout.WEST,genderWoman,5,SpringLayout.EAST,genderMen);

        layout4.putConstraint(SpringLayout.NORTH,socialBehavior,10,SpringLayout.SOUTH,genderMen);
        layout4.putConstraint(SpringLayout.WEST,socialBehavior, 100,SpringLayout.WEST,contentPane);

        layout4.putConstraint(SpringLayout.NORTH,btn1SocialBehavior,10,SpringLayout.SOUTH,genderMen);
        layout4.putConstraint(SpringLayout.WEST,btn1SocialBehavior,150,SpringLayout.EAST,socialBehavior);

        layout4.putConstraint(SpringLayout.NORTH,btn2SocialBehavior,10,SpringLayout.SOUTH,genderMen);
        layout4.putConstraint(SpringLayout.WEST,btn2SocialBehavior,50,SpringLayout.EAST,btn1SocialBehavior);

        layout4.putConstraint(SpringLayout.NORTH,btn3SocialBehavior,10,SpringLayout.SOUTH,genderMen);
        layout4.putConstraint(SpringLayout.WEST,btn3SocialBehavior,50, SpringLayout.EAST,btn2SocialBehavior);

        layout4.putConstraint(SpringLayout.NORTH,workResult,50,SpringLayout.SOUTH,socialBehavior);
        layout4.putConstraint(SpringLayout.WEST,workResult,100,SpringLayout.WEST,contentPane);

        layout4.putConstraint(SpringLayout.NORTH,btn1WorkResult,40,SpringLayout.SOUTH,btn1SocialBehavior);
        layout4.putConstraint(SpringLayout.WEST,btn1WorkResult,54,SpringLayout.EAST,workResult);

        layout4.putConstraint(SpringLayout.NORTH,btn2WorkResult,40,SpringLayout.SOUTH,btn1SocialBehavior);
        layout4.putConstraint(SpringLayout.WEST,btn2WorkResult,50,SpringLayout.EAST,btn1WorkResult);

        layout4.putConstraint(SpringLayout.NORTH,btn3WorkResult,40,SpringLayout.SOUTH,btn1SocialBehavior);
        layout4.putConstraint(SpringLayout.WEST,btn3WorkResult,50, SpringLayout.EAST,btn2WorkResult);

        layout4.putConstraint(SpringLayout.NORTH,participationInTheLesson,50,SpringLayout.SOUTH,workResult);
        layout4.putConstraint(SpringLayout.WEST,participationInTheLesson, 100,SpringLayout.WEST,contentPane);

        layout4.putConstraint(SpringLayout.NORTH,btn1ParticipationInTheLesson,40,SpringLayout.SOUTH,btn1WorkResult);
        layout4.putConstraint(SpringLayout.WEST,btn1ParticipationInTheLesson,88,SpringLayout.EAST,participationInTheLesson);

        layout4.putConstraint(SpringLayout.NORTH,btn2ParticipationInTheLesson,40,SpringLayout.SOUTH,btn1WorkResult);
        layout4.putConstraint(SpringLayout.WEST,btn2ParticipationInTheLesson,50,SpringLayout.EAST,btn1ParticipationInTheLesson);

        layout4.putConstraint(SpringLayout.NORTH,btn3ParticipationInTheLesson,40,SpringLayout.SOUTH,btn1WorkResult);
        layout4.putConstraint(SpringLayout.WEST,btn3ParticipationInTheLesson,50, SpringLayout.EAST,btn2ParticipationInTheLesson);

        layout4.putConstraint(SpringLayout.NORTH,independentWork,50,SpringLayout.SOUTH,participationInTheLesson);
        layout4.putConstraint(SpringLayout.WEST,independentWork, 100,SpringLayout.EAST,contentPane);

        layout4.putConstraint(SpringLayout.NORTH,btn1IndependentWork,40,SpringLayout.SOUTH,btn1ParticipationInTheLesson);
        layout4.putConstraint(SpringLayout.WEST,btn1IndependentWork,63,SpringLayout.EAST,independentWork);

        layout4.putConstraint(SpringLayout.NORTH,btn2IndependentWork,40,SpringLayout.SOUTH,btn1ParticipationInTheLesson);
        layout4.putConstraint(SpringLayout.WEST,btn2IndependentWork,50,SpringLayout.EAST,btn1IndependentWork);

        layout4.putConstraint(SpringLayout.NORTH,btn3IndependentWork,40,SpringLayout.SOUTH,btn1ParticipationInTheLesson);
        layout4.putConstraint(SpringLayout.WEST,btn3IndependentWork,50, SpringLayout.EAST,btn2IndependentWork);

        layout4.putConstraint(SpringLayout.NORTH,supportColleagues,50,SpringLayout.SOUTH,independentWork);
        layout4.putConstraint(SpringLayout.WEST,supportColleagues, 100,SpringLayout.WEST,contentPane);

        layout4.putConstraint(SpringLayout.NORTH,btn1supportColleagues,40,SpringLayout.SOUTH,btn1IndependentWork);
        layout4.putConstraint(SpringLayout.WEST,btn1supportColleagues,48,SpringLayout.EAST,supportColleagues);

        layout4.putConstraint(SpringLayout.NORTH,btn2supportColleagues,40,SpringLayout.SOUTH,btn1IndependentWork);
        layout4.putConstraint(SpringLayout.WEST,btn2supportColleagues,50,SpringLayout.EAST,btn1supportColleagues);

        layout4.putConstraint(SpringLayout.NORTH,btn3supportColleagues,40,SpringLayout.SOUTH,btn1IndependentWork);
        layout4.putConstraint(SpringLayout.WEST,btn3supportColleagues,50, SpringLayout.EAST,btn2supportColleagues);

    }

    // third Page

    public void fourthPanel(){
        page = 4;
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

        // fourth Page

        public void fifthPanel(){
            page = 5;
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

        // fifth Page

        public void sixthPanel(){
            page = 6;
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

        // sixth Page

        public void seventhPanel(){

            page = 7;
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
        page = 8;
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

        gbc.gridy = 2;
        panel.add(Utils.getJLabel("Fähigkeiten, praktische Leistungen, Verhalten", font), gbc);

        gbc.gridy++;
        panel.add(abilities, gbc);

        gbc.gridy++;
        panel.add(Utils.getJLabel("Stärken", font), gbc);

        gbc.gridy++;
        panel.add(strength, gbc);

        gbc.gridy++;
        panel.add(Utils.getJLabel("Entwicklungsfelder", font), gbc);

        gbc.gridy++;
        panel.add(developements, gbc);

        gbc.gridy++;
        panel.add(Utils.getJLabel("Perspektiven", font), gbc);

        gbc.gridy++;
        panel.add(perspective, gbc);

        gbc.gridy++;
        panel.add(Utils.getJLabel("Sonstige Anmerkungen", font), gbc);

        gbc.gridy++;
        panel.add(others, gbc);
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
        page = 9;
        JLabel headline = new JLabel("Abschluss des Leistungsberichts von " + traineeName.getText());
        window.add(panel);
        panel.setLayout(layout3);
        panel.setVisible(true);

        //add Elements
        panel.add(headline);
        panel.add(score);
        panel.add(review);
        panel.add(calc);
        panel.add(saveAndNew);
        panel.add(saveAndExit);
        panel.add(txtPoints);
        panel.add(txtReview);

        //set Font
        headline.setFont(font);
        score.setFont(font);
        review.setFont(font);
        txtPoints.setFont(font);
        txtReview.setFont(font);

        //set size of the calculate Button
        calc.setPreferredSize(new Dimension(150,26));

        //set headline
        layout3.putConstraint(SpringLayout.WEST,headline,80,SpringLayout.WEST,contentPane);
        layout3.putConstraint(SpringLayout.NORTH,headline,280,SpringLayout.NORTH,contentPane);

        //set score
        layout3.putConstraint(SpringLayout.NORTH,score,30,SpringLayout.SOUTH,headline);
        layout3.putConstraint(SpringLayout.WEST,score,100,SpringLayout.WEST,contentPane);

        //set review
        layout3.putConstraint(SpringLayout.NORTH,review,5,SpringLayout.SOUTH,score);
        layout3.putConstraint(SpringLayout.WEST,review,100,SpringLayout.WEST,contentPane);

        //set calc
        layout3.putConstraint(SpringLayout.NORTH,calc,30,SpringLayout.SOUTH,review);
        layout3.putConstraint(SpringLayout.WEST,calc,80,SpringLayout.WEST,contentPane);

        //set saveAndNew
        layout3.putConstraint(SpringLayout.NORTH,saveAndNew,30,SpringLayout.SOUTH,review);
        layout3.putConstraint(SpringLayout.WEST,saveAndNew,40,SpringLayout.EAST,calc);

        //set saveAndExit
        layout3.putConstraint(SpringLayout.NORTH,saveAndExit,30,SpringLayout.SOUTH,review);
        layout3.putConstraint(SpringLayout.WEST,saveAndExit,40,SpringLayout.EAST,saveAndNew);

        //set txtPoints
        layout3.putConstraint(SpringLayout.NORTH,txtPoints,30,SpringLayout.SOUTH,headline);
        layout3.putConstraint(SpringLayout.WEST,txtPoints,50,SpringLayout.EAST,score);

        //set txtReview
        layout3.putConstraint(SpringLayout.NORTH,txtReview,5,SpringLayout.SOUTH,txtPoints);
        layout3.putConstraint(SpringLayout.WEST,txtReview,50,SpringLayout.EAST,score);
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
        JLabel headline = Utils.getJLabel("Bewertung: ", font);
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
        particularly.setFont(fontSmall);

        layout.putConstraint(SpringLayout.NORTH, good, 0, SpringLayout.SOUTH, particularly);
        layout.putConstraint(SpringLayout.WEST, good, 35, SpringLayout.WEST, contentPane);
        good.setFont(fontSmall);

        layout.putConstraint(SpringLayout.NORTH, average, 0, SpringLayout.SOUTH, good);
        layout.putConstraint(SpringLayout.WEST, average, 48, SpringLayout.WEST, contentPane);
        average.setFont(fontSmall);

        layout.putConstraint(SpringLayout.NORTH, defects, 0, SpringLayout.SOUTH, average);
        layout.putConstraint(SpringLayout.WEST, defects, 48, SpringLayout.WEST, contentPane);
        defects.setFont(fontSmall);

        layout.putConstraint(SpringLayout.NORTH, badly, 0, SpringLayout.SOUTH, defects);
        layout.putConstraint(SpringLayout.WEST, badly, 48, SpringLayout.WEST, contentPane);
        badly.setFont(fontSmall);

        layout.putConstraint(SpringLayout.NORTH, useless, 0, SpringLayout.SOUTH, badly);
        layout.putConstraint(SpringLayout.WEST, useless, 24, SpringLayout.WEST, badly);
        useless.setFont(fontSmall);
        }
    }