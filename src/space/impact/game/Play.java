package space.impact.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import space.impact.source.*;

public class Play extends JFrame{
    public static JFrame frame2;
    private JPanel panelgame;
    private String usertemp;

    public Play(JFrame frame3,String usertemp) {
        this.usertemp=usertemp;
        setFrame2(frame3);
        frame2.setContentPane(new inGame(usertemp));
        frame2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                int result = JOptionPane.showConfirmDialog(frame2,"Do you want to Exit ?", "Exit Confirmation ", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        frame2.pack();
        frame2.setVisible(true);
        setPreferredSize(Path.frameSize);
//        frame2.setSize(Path.WIDTH, Path.HEIGHT);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
    }

    public Play(String usertemp) {
        this.usertemp=usertemp;
        frame2.setContentPane(new inGame(usertemp));
//        frame2.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent we) {
//                int result = JOptionPane.showConfirmDialog(frame2,"Do you want to Exit ?", "Exit Confirmation ", JOptionPane.YES_NO_OPTION);
//                if (result == JOptionPane.YES_OPTION) frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                else frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//            }
//        });
        frame2.pack();
        frame2.setVisible(true);
        setPreferredSize(Path.frameSize);
//        frame2.setSize(Path.WIDTH, Path.HEIGHT);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
    }


    public JFrame getFrame2() {
        return frame2;
    }

    public static void setFrame2(JFrame frame2) {
        Play.frame2 = frame2;
    }

}
