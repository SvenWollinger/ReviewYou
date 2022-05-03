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



    public GUI() {
        window = new JFrame("Leistungsbericht Nachwuchskräfte");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.setSize(800,800);
        window.setLocationRelativeTo(null);
        window.add(panel);

        panel.setBackground(Color.red);
        panel.setPreferredSize(new Dimension(800,650));
        panel.setVisible(true);


        contentPane = window.getContentPane();
        contentPane.setLayout(layout);
        contentPane.add(next);
        contentPane.add(previous);
        previous.setVisible(false);


        next.setPreferredSize(new Dimension(80,30));
        previous.setPreferredSize(new Dimension(80,30));

        layout.putConstraint(SpringLayout.SOUTH, next, -25, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, next, 400, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.SOUTH, previous, -25, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.EAST, previous, -5, SpringLayout.WEST, next);


        startPanel();

    }
    public void checkPage(){
        if(page != 1) {
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

    public void startPanel(){

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



        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                secondPanel();
            }
        });



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


    public void secondPanel(){
        page = 2;
        checkPage();
        headline = new JLabel("Hallo i bims nicht");
        window.add(panel);
        panel.add(headline);

        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                startPanel();
            }
        });
    }

    JLabel abilitiesLabel = new JLabel("Fähigkeiten, praktische Leistungen, Verhalten:");
    JLabel strenghtLabel = new JLabel("Stärken:");
    JLabel developementsLabel = new JLabel("Entwicklungsfelder");
    JLabel perspectiveLabel = new JLabel("Perspektiven");
    JLabel othersLabel = new JLabel("Sonstige Anmerkungen");
    JTextField abilities = new JTextField();
//    JTextArea abilities = new JTextArea();
    JTextField strength;
    JTextField developements;
    JTextField perspective;
    JTextField others;




    public void thirdPanel(){
        headline = new JLabel("Wortbeschreibungen zur gezeigten Leistung");
        headline.setFont(font);
        window.add(panel);

        panel.add(headline);
        panel.add(abilitiesLabel);
        panel.add(abilities);


        // set name and name textfield
        layout.putConstraint(SpringLayout.WEST, headline, 200, SpringLayout.WEST, panel);
        headline.setFont(font);

        // SET ABILITIES LABEL AND TEXTFIELD
        layout.putConstraint(SpringLayout.WEST, abilitiesLabel, 0, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, abilitiesLabel, 60, SpringLayout.NORTH, panel);
        abilitiesLabel.setFont(font);

        layout.putConstraint(SpringLayout.NORTH, abilities,10, SpringLayout.SOUTH, abilitiesLabel);
        layout.putConstraint(SpringLayout.WEST, abilities,10, SpringLayout.WEST, panel);
        abilities.setPreferredSize(new Dimension(200,300));


    }

}
