package space.impact.game;

import javax.swing.*;

public class newGame extends JFrame{
    private String usertemp;
    newGame(String usertemp){
        this.add(new Game(usertemp,this));
        this.setTitle("Space Impact Reborn");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}