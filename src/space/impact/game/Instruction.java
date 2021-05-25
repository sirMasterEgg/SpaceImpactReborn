package space.impact.game;

import space.impact.source.ButtonMaker;
import space.impact.source.FontMaker;
import space.impact.source.ImageClass;
import space.impact.source.Path;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Instruction extends JPanel {

    private Image bg;
    private Font font = new FontMaker(Path.mainFont).getFont();


    public Instruction() {
        //set display, bg
        setPreferredSize(Path.frameSize);
        this.bg = new ImageIcon(Path.bgMainMenu).getImage();
        this.setLayout(null);

        //set component
        drawDirection();
        drawTextDirection();
        backButton();
    }

    private void drawDirection() {
        ImageIcon logo = new ImageIcon(ImageClass.scaleImage(Path.instructionArrowPath,0.4));
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        logoLabel.setHorizontalAlignment(JLabel.LEFT);
        logoLabel.setBounds(100,100, ImageClass.imgWidth(), ImageClass.imgHeight());
        this.add(logoLabel);
    }

    private void drawTextDirection() {
        Rectangle rect = new Rectangle(300,85,500,100);
        JLabel label = new JLabel("<html> <table>\n" +
                "        <tr>\n" +
                "            <td>W - Up</td>\n" +
                "            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n" +
                "            <td>A - Left</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>S - Down</td>\n" +
                "            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n" +
                "            <td>D - Right</td>\n" +
                "        </tr>\n" +
                "    </table> </html>");
        label.setFont(font.deriveFont(35.0f));
        label.setForeground(new Color(255,255,255));
        label.setBounds(rect);
        label.setVisible(true);
        this.add(label);
    }

    //kamikaze => hotkey(...)
    //missile launcher => hotkey(...)
    //invisibility => hotkey(...)

    private void drawSkill1() {
        ImageIcon logo = new ImageIcon(ImageClass.scaleImage(Path.instructionArrowPath,0.4));
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        logoLabel.setHorizontalAlignment(JLabel.RIGHT);
        logoLabel.setBounds(125,125, ImageClass.imgWidth(), ImageClass.imgHeight());
        this.add(logoLabel);
    }

    private void backButton() {
        //create button
        JButton backButton;
        Rectangle rect = new Rectangle(400, 600, 200, 100);
        backButton = new ButtonMaker("Back", rect).getButton();
        backButton.setFont(font);
        backButton.setVisible(true);
        this.add(backButton);
        //button command
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Play.frame2.setContentPane(new inGame());
                Play.frame2.pack();
            }
        });
    }

    // render background
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int x = (this.getWidth() - this.bg.getWidth(null)) /2;
        int y = (this.getHeight() - this.bg.getHeight(null))/2;
        g2d.drawImage(this.bg, 0, 0,getWidth(),getHeight(), null);
    }

}
