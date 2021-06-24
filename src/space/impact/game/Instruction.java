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
        kamikazeDirection();
        missileDirection();
        invisibelDirection();
        backButton();
        kamikaze();
        Mlaucher();
        Invisibel();
    }
    private void drawDirection() {
        ImageIcon logo = new ImageIcon(ImageClass.scaleImage(Path.instructionArrowPath,0.4));
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        logoLabel.setHorizontalAlignment(JLabel.LEFT);
        logoLabel.setBounds(100,100, ImageClass.imgWidth(), ImageClass.imgHeight());
        this.add(logoLabel);
    }

    private void kamikazeDirection(){
        ImageIcon killself = new ImageIcon(ImageClass.scaleImage(Path.instructionSkill1Path, 0.2));
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(killself);
        logoLabel.setHorizontalAlignment(JLabel.LEADING);
        logoLabel.setBounds(40, 150, ImageClass.imgWidth(), ImageClass.imgHeight());
        this.add(logoLabel);
    }

    private void missileDirection(){
        ImageIcon launcher = new ImageIcon(ImageClass.scaleImage(Path.instructionSkill2Path, 0.2));
        JLabel logolabel = new JLabel();
        logolabel.setIcon(launcher);
        logolabel.setHorizontalAlignment(JLabel.LEADING);
        logolabel.setBounds(50, 300, ImageClass.imgWidth(), ImageClass.imgHeight());
        this.add(logolabel);
    }

    private void invisibelDirection(){
        ImageIcon disappear = new ImageIcon(ImageClass.scaleImage(Path.instructionSkill3Path, 2.5));
        JLabel logolabel = new JLabel();
        logolabel.setIcon(disappear);
        logolabel.setHorizontalAlignment(JLabel.LEADING);
        logolabel.setBounds(80, 475, ImageClass.imgWidth(), ImageClass.imgHeight());
        this.add(logolabel);
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
    private void kamikaze(){
        //kamikaze => hotkey(...)
        Rectangle rect = new Rectangle(300,110,750,300);
        JLabel Klabel = new JLabel("<html> <table> \n" +
                "   <tr>\n" +
                "       <td> -Press (k) to kill every enemy ahead and yourself but you score x2\n" +
                "\n" +
                "       </tr>\n" +
                "       </table> </html>");
        Klabel.setFont(font.deriveFont(35.0f));
        Klabel.setForeground(new Color(255,255,255));
        Klabel.setBounds(rect);
        Klabel.setVisible(true);
        this.add(Klabel);
    }

    private void Mlaucher(){
        //missile launcher => hotkey(...)
        Rectangle rect = new Rectangle(300,250,700,300);
        JLabel MLlabel = new JLabel("<html> <table> \n" +
                "   <tr>\n "+
                "       <td> -by pressing the (A) button shoot 3 bullet at the same time" +
                "           </tr>\n" +
                " </table> </html>");
        MLlabel.setFont(font.deriveFont(35.0f));
        MLlabel.setForeground(new Color(255,255,255));
        MLlabel.setBounds(rect);
        MLlabel.setVisible(true);
        this.add(MLlabel);
    }

    private void Invisibel(){
        //invisibility => hotkey(...)
        Rectangle rect = new Rectangle(300,400,800,300);
        JLabel Ilabel = new JLabel("<html> <table> \n" +
                "   <tr>\n " +
                "       <td> -become immune from enemy attack for 3 seconds by pressing (c)\n" +
                "invisible");
        Ilabel.setFont(font.deriveFont(35.0f));
        Ilabel.setForeground(new Color(255,255,255));
        Ilabel.setBounds(rect);
        Ilabel.setVisible(true);
        this.add(Ilabel);
    }

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
