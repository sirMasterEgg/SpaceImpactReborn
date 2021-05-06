package space.impact.login;

import space.impact.game.Play;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;

public class loginawal{
    private JPanel menulogin;
    private JTextField inputannama;
    private JButton mainButton;

    private static JFrame frame = new JFrame("Login");

    public loginawal() {
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputannama.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong!","Warning",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if (mainButton.isEnabled()) {
                        Play f = new Play(new JFrame("Space Impact Reborn"));
                        frame.setVisible(false);
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        frame.setContentPane(new loginawal().menulogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
    }
}