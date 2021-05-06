package space.impact.game;

import javax.swing.*;
import java.awt.*;

public class Play extends JFrame{
    JFrame frame2;

    public Play(JFrame frame2) {
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);
        frame2.setSize(1000, 700);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);

    }

    public JFrame getFrame2() {
        return frame2;
    }

}
