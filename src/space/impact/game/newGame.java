package space.impact.game;

import javax.swing.*;
import java.awt.event.*;

public class newGame extends JFrame implements KeyListener {
    JLabel xLabel;
    ImageIcon icon;

    newGame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,700);
        this.setLayout(null);
        this.addKeyListener(this);
        icon = new ImageIcon("res/foto/hero.png");
        xLabel=new JLabel();
        xLabel.setBounds(100,100,68,138);
        xLabel.setIcon(icon);
        this.add(xLabel);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        switch(e.getKeyChar()){
//            case 'a': xLabel.setLocation(xLabel.getX()-10,xLabel.getY());if(xLabel.getX()<0){
//                xLabel.setLocation(0,xLabel.getY());
//            }
//                break;
//            case 'w': xLabel.setLocation(xLabel.getX(),xLabel.getY()-10);if(xLabel.getY()<0){
//                xLabel.setLocation(xLabel.getX(),0);
//            }
//                break;
//            case 's': xLabel.setLocation(xLabel.getX(),xLabel.getY()+10);if(xLabel.getHeight()+xLabel.getY()>this.getHeight()){
//                xLabel.setLocation(xLabel.getX(),this.getHeight()-xLabel.getHeight());
//            }
//                break;
//            case 'd': xLabel.setLocation(xLabel.getX()+10,xLabel.getY());if(xLabel.getWidth()+xLabel.getX()>this.getWidth()){
//                xLabel.setLocation(this.getWidth()-xLabel.getWidth(),xLabel.getY());
//            }
//                break;
//        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT: xLabel.setLocation(xLabel.getX()-10,xLabel.getY());if(xLabel.getX()<0){
                xLabel.setLocation(0,xLabel.getY());
            }
                break;
            case KeyEvent.VK_UP: xLabel.setLocation(xLabel.getX(),xLabel.getY()-10);if(xLabel.getY()<0){
                xLabel.setLocation(xLabel.getX(),0);
            }
                break;
            case KeyEvent.VK_DOWN: xLabel.setLocation(xLabel.getX(),xLabel.getY()+10);if(xLabel.getHeight()+xLabel.getY()>this.getHeight()){
                xLabel.setLocation(xLabel.getX(),this.getHeight()-xLabel.getHeight());
            }
                break;
            case KeyEvent.VK_RIGHT: xLabel.setLocation(xLabel.getX()+10,xLabel.getY());if(xLabel.getWidth()+xLabel.getX()>this.getWidth()){
                xLabel.setLocation(this.getWidth()-xLabel.getWidth(),xLabel.getY());
            }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
