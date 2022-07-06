package de.muenchen.reviewyou;

import javax.swing.*;
import java.awt.*;

public class Utils {
    public static JLabel getJLabel(String text, Font font) {
        JLabel l = new JLabel(text);
        l.setFont(font);
        return l;
    }

    public static JTextArea getDescJTextArea(Dimension preferredSize, Dimension maximumSize) {
        JTextArea txt = new JTextArea();
        txt.setPreferredSize(preferredSize);
        txt.setMaximumSize(maximumSize);
        txt.setLineWrap(true);
        return txt;
    }
}
