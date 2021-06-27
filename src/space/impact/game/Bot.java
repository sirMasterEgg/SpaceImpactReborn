package space.impact.game;

import javax.swing.*;

public class Bot{
    int jenisbot;
    int delaybot;
    int xbot;
    int ybot;
    int tipebot;

    public JLabel getSprite() {
        return sprite;
    }

    public void setSprite(JLabel sprite) {
        this.sprite = sprite;
    }

    protected JLabel sprite;

    public int getTipebot() {
        return tipebot;
    }

    public void setTipebot(int tipebot) {
        this.tipebot = tipebot;
    }

    public Bot(int xbot, int ybot, int jenisbot, int delaybot, int tipebot) {
        this.jenisbot = jenisbot;
        this.delaybot = delaybot;
        this.xbot= xbot;
        this.ybot=ybot;
        this.tipebot = tipebot;
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