package space.impact.game;

import javax.swing.*;

public class Bot{
    int jenisbot;
    int delaybot;
    int xbot;
    int ybot;

    public JLabel getSprite() {
        return sprite;
    }

    public void setSprite(JLabel sprite) {
        this.sprite = sprite;
    }

    protected JLabel sprite;

    public Bot(int xbot,int ybot,int jenisbot, int delaybot) {
        this.jenisbot = jenisbot;
        this.delaybot = delaybot;
        this.xbot= xbot;
        this.ybot=ybot;
    }
    public int getXbot() {
        return xbot;
    }

    public void setXbot(int xbot) {
        this.xbot = xbot;
    }

    public int getYbot() {
        return ybot;
    }

    public void setYbot(int ybot) {
        this.ybot = ybot;
    }
    public int getJenisbot() {
        return jenisbot;
    }

    public void setJenisbot(int jenisbot) {
        this.jenisbot = jenisbot;
    }


    public int getDelaybot() {
        return delaybot;
    }

    public void setDelaybot(int delaybot) {
        this.delaybot = delaybot;
    }
}