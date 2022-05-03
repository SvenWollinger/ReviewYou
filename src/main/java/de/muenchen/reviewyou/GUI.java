package de.muenchen.reviewyou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI {


    private Container contentPane;
    private JFrame window;

    private JButton next = new JButton("Weiter");
    private JButton previous = new JButton("Zurück");
    SpringLayout layout = new SpringLayout();

    public GUI() {
        window = new JFrame("Bewertungsbogen für Nachwuchskräfte");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = window.getContentPane();
        window.setSize(600,600);
        contentPane.setLayout(layout);
        window.setVisible(true);
        contentPane.add(next);
        contentPane.add(previous);

        next.setPreferredSize(new Dimension(80,30));
        previous.setPreferredSize(new Dimension(80,30));

        layout.putConstraint(SpringLayout.NORTH, next, 510, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, next, 480, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.EAST, previous, -10, SpringLayout.WEST, next);
        layout.putConstraint(SpringLayout.NORTH, previous, 0, SpringLayout.NORTH, next);

        startPanel();
    }

    // First page to get user data

    private JLabel name = new JLabel("Name:");
    private JLabel email = new JLabel("E-Mail:");
    private JLabel date = new JLabel("Datum");
    private JLabel telephone = new JLabel("Tel:");
    private JTextField instructorName = new JTextField();
    private JTextField instructorEmail = new JTextField();
    private JTextField currentDate = new JTextField();
    private JTextField instructorTelephone = new JTextField();

    public void startPanel(){
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Hallo i bims");
        window.add(panel);
        panel.setBackground(Color.red);
        panel.setPreferredSize(new Dimension(500,500));
        panel.add(label);
        label.add(name);


    }
}
