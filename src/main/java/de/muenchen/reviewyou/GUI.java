package de.muenchen.reviewyou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {


    private Container contentPane;
    private JFrame window;

    private JButton next = new JButton("Weiter");
    private JButton previous = new JButton("Zurück");
    SpringLayout layout = new SpringLayout();
    private int page = 0;
    JPanel panel = new JPanel();
    


    public GUI() {
        window = new JFrame("Bewertungsbogen für Nachwuchskräfte");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.setSize(600,600);

        contentPane = window.getContentPane();
        contentPane.setLayout(layout);
        contentPane.add(next);


        next.setPreferredSize(new Dimension(80,30));
        previous.setPreferredSize(new Dimension(80,30));

        layout.putConstraint(SpringLayout.NORTH, next, 510, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, next, 480, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.EAST, previous, -10, SpringLayout.WEST, next);
        layout.putConstraint(SpringLayout.NORTH, previous, 0, SpringLayout.NORTH, next);

        startPanel();

    }

    public void checkPage(){
        if(page != 1) {
            contentPane.add(previous);
        }
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
    private boolean isOpen;

    public void startPanel(){
        page = 1;
        checkPage();
        JLabel label = new JLabel("Hallo i bims");
        window.add(panel);
        panel.setBackground(Color.red);
        panel.setPreferredSize(new Dimension(500,500));
        panel.add(label);
        label.add(name);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
//                panel.repaint();
                secondPanel();
            }
        });

    }
    public void secondPanel(){
        page = 2;
        checkPage();
        JLabel label = new JLabel("Hallo i bims nicht");
        panel.add(label);
        panel.setVisible(true);
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                startPanel();
            }
        });


    }

}
