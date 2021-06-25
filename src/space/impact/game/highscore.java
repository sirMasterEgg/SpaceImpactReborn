package space.impact.game;

import space.impact.source.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class highscore extends JPanel {
    private Image bg;
    private Font font = new FontMaker(Path.mainFont).getFont();
    private JLabel score;
    private String usertemp;

    public highscore(String usertemp) {
        this.usertemp=usertemp;
        setPreferredSize(Path.frameSize);
        this.bg = new ImageIcon(Path.bgMainMenu).getImage();
        this.setLayout(null);

        drawTitle();

        score = new JLabel();
        score.setText(cetakBeautyHighscore());
        score.setForeground(Color.WHITE);
        score.setFont(font.deriveFont(35f));
        score.setBounds(0,0,Path.WIDTH,Path.HEIGHT);
        score.setHorizontalAlignment(JLabel.CENTER);
        this.add(score);

        backButton();
    }

    private void drawTitle(){
        JLabel highscoreTitle = new JLabel("Highscore");
        highscoreTitle.setForeground(Color.WHITE);
        highscoreTitle.setFont(font);
        highscoreTitle.setBounds(0,0,Path.WIDTH,200);
        highscoreTitle.setHorizontalAlignment(JLabel.CENTER);
        this.add(highscoreTitle);
    }

    private String cetakBeautyHighscore(){
        MyFileHandler file = new TextClass();

        ArrayList<String> nama = file.loadNama(Path.saveHighscore,Path.pemisahHighscore);
        ArrayList<Integer> skor = file.loadScore(Path.saveHighscore,Path.pemisahHighscore);

        StringBuilder data = new StringBuilder("<html><table>");

        for (int i = 0; i < nama.size(); i++) {
            data.append("<tr><td>").append(nama.get(i)).append("</td><td>-</td><td>").append(skor.get(i)).append("</td></tr>");
        }
        data.append("</table><html>");
        String temp = String.valueOf(data);
        return temp;
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
                Play.frame2.setContentPane(new inGame(usertemp));
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
