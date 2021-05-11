package space.impact.login;

import space.impact.game.Play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class loginawal {
    private JPanel menulogin;
    private JTextField inputannama;
    private JButton mainButton;

    private static JFrame frame = new JFrame("Login");


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(960,540);
        frame.setLayout(null);

        JLabel panellogin = new JLabel();
        panellogin.setBounds(0,0,960,540);
        panellogin.setIcon(new ImageIcon("res/foto/backgroundlogin.gif"));
        frame.setResizable(true);
        frame.add(panellogin);

        JTextField nama = new JTextField();
        nama.setBounds(320,300,300,40);
        panellogin.add(nama);

        JButton confirmnama = new JButton("Confirm");
        confirmnama.setBounds(370,400,200,40);
        panellogin.add(confirmnama);

        frame.setVisible(true);
    }
}
