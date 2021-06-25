package space.impact.game;

import space.impact.source.ButtonMaker;
import space.impact.source.FontMaker;
import space.impact.source.ImageClass;
import space.impact.source.Path;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class highscore extends JPanel {
    private Image bg;
    private Font font = new FontMaker(Path.mainFont).getFont();

    public highscore() {
        setPreferredSize(Path.frameSize);
        this.bg = new ImageIcon(Path.bgMainMenu).getImage();
        this.setLayout(null);


        backButton();
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int x = (this.getWidth() - this.bg.getWidth(null)) /2;
        int y = (this.getHeight() - this.bg.getHeight(null))/2;
        g2d.drawImage(this.bg, 0, 0,getWidth(),getHeight(), null);
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


}
