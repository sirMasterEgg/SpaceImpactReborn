package space.impact.game;

import space.impact.source.Path;

import javax.swing.*;
import java.awt.*;

public class inGame extends JPanel {

    private Image bg;

    public inGame() {
        // main code
        setPreferredSize(Path.frameSize);
        this.bg = new ImageIcon(Path.bgtitle).getImage();
        this.setLayout(null);

        drawIcon();
        drawTitle();
    }

    private void drawIcon() {
        ImageIcon logo = new ImageIcon(Path.iconPath);
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        logoLabel.setHorizontalAlignment(JLabel.LEFT);
        logoLabel.setBounds(-30, 0, 200, 200);
        this.add(logoLabel);
    }

    private void drawTitle() {
        ImageIcon logo = new ImageIcon(Path.titlePath);
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        logoLabel.setHorizontalAlignment(JLabel.RIGHT);
        logoLabel.setBounds(155,50, 311, 100);
        this.add(logoLabel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int x = (this.getWidth() - this.bg.getWidth(null)) /2;
        int y = (this.getHeight() - this.bg.getHeight(null))/2;
        g2d.drawImage(this.bg, 0, 0,getWidth(),getHeight(), null);
    }
}
