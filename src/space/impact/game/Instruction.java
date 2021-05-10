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
    }

    private void drawDirection() {
        ImageIcon logo = new ImageIcon(ImageClass.scaleImage(Path.instructionArrowPath,0.4));
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        logoLabel.setHorizontalAlignment(JLabel.RIGHT);
        logoLabel.setBounds(125,125, ImageClass.imgWidth(), ImageClass.imgHeight());
        this.add(logoLabel);
    }

    //  bikin instruction yg lain
    //  bikin back button to main menu

    // render background
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int x = (this.getWidth() - this.bg.getWidth(null)) /2;
        int y = (this.getHeight() - this.bg.getHeight(null))/2;
        g2d.drawImage(this.bg, 0, 0,getWidth(),getHeight(), null);
    }

}
