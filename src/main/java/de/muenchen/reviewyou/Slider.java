package de.muenchen.reviewyou;

import javax.swing.*;
import java.awt.*;

public class Slider {
    GUI gui = new GUI();
    static final int minScore = 0;
    static final int maxScore = 15;
    static final int scoreInit = 7;
    JLabel competenceLabel = new JLabel("Fachliche Kompetenzen");
    JSlider germanSpeech = new JSlider(JSlider.HORIZONTAL,minScore, maxScore, scoreInit );

    public Slider() {
        logic();
    }

    public void logic() {
        competenceLabel = new JLabel(String.valueOf(germanSpeech.getValue()));
        //gui.getPanel().add(competenceLabel);

        germanSpeech.setMinorTickSpacing(1);
        germanSpeech.setMajorTickSpacing(5);
        germanSpeech.setPaintTicks(true);
        germanSpeech.setPaintTrack(true);
        germanSpeech.setPaintLabels(true);
        germanSpeech.setPreferredSize(new Dimension(300, 100));


    }

    public JLabel getCompetenceLabel() {
        return competenceLabel;
    }
}
