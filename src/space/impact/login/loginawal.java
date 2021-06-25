package space.impact.login;

import space.impact.game.Play;
import space.impact.source.PlayerInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class loginawal {
    private JPanel menulogin;
    private JTextField inputannama;
    private JButton mainbutton;

    private static final JFrame frame = new JFrame("Login");

            public static void main(String[] args) {
                PlayerInfo<String> pI;
                JFrame frame = new JFrame();
                frame.setSize(960, 540);
                frame.setLayout(null);

                JLabel panellogin = new JLabel();
                panellogin.setBounds(0, 0, 960, 540);
                panellogin.setIcon(new ImageIcon("res/foto/backgroundlogin.gif"));
                frame.setResizable(true);
                frame.add(panellogin);

                JTextField nama = new JTextField();
                nama.setBounds(320, 300, 300, 40);
                panellogin.add(nama);
                pI = new PlayerInfo<>(nama.getText());



                JButton confirmnama = new JButton("Confirm");
                confirmnama.setBounds(370, 400, 200, 40);
                panellogin.add(confirmnama);

                frame.setVisible(true);

                confirmnama.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (confirmnama.isEnabled() && nama.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong!","Warning", JOptionPane.ERROR_MESSAGE);
                        }else {
                            if (confirmnama.isEnabled()) {
                                Play f = new Play(new JFrame("Space Impact Reborn"));
                                frame.setVisible(false);
                            }
                        }
                    }
                });

                nama.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER){
                            if (confirmnama.isEnabled() && nama.getText().isEmpty()){
                                JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong!","Warning",JOptionPane.ERROR_MESSAGE);
                            }else {
                                if (confirmnama.isEnabled()) {
                                    Play f = new Play(new JFrame("Space Impact Reborn"));
                                    frame.setVisible(false);
                                }
                            }
                        }
                    }
                });
            }

}

