package space.impact.game;

import javax.swing.*;

public class botlevel2 {
    int jenisbot2;
    int delaybot2;
    int xbot2;
    int ybot2;

    public JLabel getSprite() {
        return sprite;
    }

    public void setSprite(JLabel sprite) {
        this.sprite = sprite;
    }

    protected JLabel sprite;

    public botlevel2(int xbot2,int ybot2,int jenisbot2, int delaybot2) {
        this.jenisbot2 = jenisbot2;
        this.delaybot2 = delaybot2;
        this.xbot2= xbot2;
        this.ybot2=ybot2;
    }
    public int getXbot2() {
        return xbot2;
    }

    public void setXbot2(int xbot2) {
        this.xbot2 = xbot2;
    }

    public int getYbot2() {
        return ybot2;
    }

    public void setYbot2(int ybot2) {
        this.ybot2 = ybot2;
    }
    public int getJenisbot2() {
        return jenisbot2;
    }

    public void setJenisbot2(int jenisbot2) {
        this.jenisbot2 = jenisbot2;
    }


    public int getDelaybot2() {
        return delaybot2;
    }

    public void setDelaybot2(int delaybot2) {
        this.delaybot2 = delaybot2;
    }
}
