package de.muenchen.reviewyou.GUI.pages;

import de.muenchen.reviewyou.GUI.GUI;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

@Getter
public class StartPanel implements BasePage {

    private final JLabel name = new JLabel("Name");
    private final JLabel email = new JLabel("E-Mail");
    private final JLabel date = new JLabel("Datum");
    private final JLabel telephone = new JLabel("Tel");
    private final JTextField instructorName = new JTextField(15);
    private final JTextField instructorEmail = new JTextField(15);
    private final JTextField instructorTelephone = new JTextField(15);
    private final JTextField txtDate = new JTextField(15);

    @Override
    public void generate(GUI gui) {
        System.out.println("Generating");
        Font font = gui.getFont();

        gui.setPage(1);

        JPanel panel = gui.getPanel();

        SpringLayout layout = new SpringLayout();

        panel.setLayout(layout);

        panel.setPreferredSize(new Dimension(800, 700));

        JLabel headline = new JLabel("Angaben zum / zur Ausbilder:in");
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

        layout.putConstraint(SpringLayout.NORTH, headline, 50, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, headline, 250, SpringLayout.WEST, panel);

        // set name and name textfield
        layout.putConstraint(SpringLayout.WEST, name, 260, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, name, 50, SpringLayout.SOUTH, headline);
        name.setFont(font);

        // set instructorName
        layout.putConstraint(SpringLayout.WEST, instructorName, 12, SpringLayout.EAST, name);
        layout.putConstraint(SpringLayout.NORTH, instructorName, 4, SpringLayout.NORTH, name);


        // set email and email textfield
        layout.putConstraint(SpringLayout.WEST, email, 260, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, email, 20, SpringLayout.SOUTH, name);
        email.setFont(font);

        //set instrutorEmail
        layout.putConstraint(SpringLayout.WEST, instructorEmail, 7, SpringLayout.EAST, email);
        layout.putConstraint(SpringLayout.NORTH, instructorEmail, 4, SpringLayout.NORTH, email);


        // set telephone and telephone textfield
        layout.putConstraint(SpringLayout.WEST, telephone, 260, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, telephone, 20, SpringLayout.SOUTH, email);
        telephone.setFont(font);

        //setInstructorTelephone
        layout.putConstraint(SpringLayout.WEST, instructorTelephone, 38, SpringLayout.EAST, telephone);
        layout.putConstraint(SpringLayout.NORTH, instructorTelephone, 4, SpringLayout.NORTH, telephone);

        //setDate
        layout.putConstraint(SpringLayout.WEST, date, 260, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, date, 20, SpringLayout.SOUTH, telephone);
        date.setFont(font);

        //txtDate
        layout.putConstraint(SpringLayout.NORTH,txtDate, 27,SpringLayout.SOUTH,instructorTelephone);
        layout.putConstraint(SpringLayout.WEST,txtDate,8,SpringLayout.EAST,date);

        txtDate.setText(gui.getStartTime().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));
    }
}
