package space.impact.game;

import javax.swing.*;

public class newGame extends JFrame{

    newGame(){
        this.add(new Game());
        this.setTitle("TESTINGGGGGGGGGG");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}