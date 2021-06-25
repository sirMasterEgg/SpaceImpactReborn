package space.impact.game;

import javax.swing.*;

public class boss {
    int jenisbos;
    int delaybos;
    int xbos;
    int ybos;

    public JLabel getSprite() {
        return sprite;
    }

    public void setSprite(JLabel sprite) {
        this.sprite = sprite;
    }

    protected JLabel sprite;

    public boss(int xbos,int ybos,int jenisbos, int delaybos) {
        this.jenisbos = jenisbos;
        this.delaybos = delaybos;
        this.xbos = xbos;
        this.ybos =ybos;
    }
    public int getXbos() {
        return xbos;
    }

    public void setXbos(int xbos) {
        this.xbos = xbos;
    }

    public int getYbos() {
        return ybos;
    }

    public void setYbos(int ybos) {
        this.ybos = ybos;
    }
    public int getJenisbos() {
        return jenisbos;
    }

    public void setJenisbos(int jenisbos) {
        this.jenisbos = jenisbos;
    }


    public int getDelaybos() {
        return delaybos;
    }

    public void setDelaybos(int delaybos) {
        this.delaybos = delaybos;
    }
}
