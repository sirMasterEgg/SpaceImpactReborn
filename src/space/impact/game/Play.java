package space.impact.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import space.impact.source.*;

public class Play extends JFrame{
    private JFrame frame2;
    private JPanel panelgame;

    public Play(JFrame frame2) {
        frame2.setContentPane(new inGame());
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                int result = JOptionPane.showConfirmDialog(frame2,
                        "Do you want to Exit ?", "Exit Confirmation ",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else if (result == JOptionPane.NO_OPTION)
                    frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        frame2.pack();
        frame2.setVisible(true);
        frame2.setSize(Path.WIDTH, Path.HEIGHT);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
    }

    public JFrame getFrame2() {
        return frame2;
    }

}
