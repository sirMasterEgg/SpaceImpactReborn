package space.impact.game;

import space.impact.source.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inGame extends JPanel {

    private Image bg;
    private Font font = new FontMaker(Path.mainFont).getFont();

    public inGame() {
        // main menu
        setPreferredSize(Path.frameSize);
        this.bg = new ImageIcon(Path.bgMainMenu).getImage();
        this.setLayout(null);

        drawTitle();
        newGameButton();
        instructionButton();
        highscoreButton();
    }

    private void drawTitle() {
        ImageIcon logo = new ImageIcon(Path.titlePath);
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        logoLabel.setHorizontalAlignment(JLabel.RIGHT);
        logoLabel.setBounds(147,50, 706, 196);
        this.add(logoLabel);
    }

    private void newGameButton() {
        // Creating and customizing the button
        Rectangle rect = new Rectangle(325, 300+10, 350, 50);
        JButton button = new ButtonMaker("New Game", rect).getButton();
        button.setFont(font);
        // Adding the button to the panel with actionListener
        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Music change
//                Path.titleMusic.stopMusic();
//                Path.clickForward.playMusic(Commons.forwardClick);
                //Changing panel and start the game
//                Play.frame2.setContentPane();
                Play.frame2.pack();
            }
        });
    }

    private void instructionButton() {
        // Creating and customizing the button
        Rectangle rect = new Rectangle(325, 375+10, 350, 50);
        JButton button = new ButtonMaker("Instruction", rect).getButton();
        button.setFont(font);
        // Adding the button to the panel with actionListener
        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Music change
//                Path.titleMusic.stopMusic();
//                Path.clickForward.playMusic(Commons.forwardClick);
                //Changing panel and start the game
//                Play.frame2.setContentPane();
                Play.frame2.pack();
            }
        });
    }

    private void highscoreButton() {
        // Creating and customizing the button
        Rectangle rect = new Rectangle(325, 450+10, 350, 55);
        JButton button = new ButtonMaker("Highscore", rect).getButton();
        button.setFont(font);
        // Adding the button to the panel with actionListener
        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Music change
//                Path.titleMusic.stopMusic();
//                Path.clickForward.playMusic(Commons.forwardClick);
                //Changing panel and start the game
//                Play.frame2.setContentPane();
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
