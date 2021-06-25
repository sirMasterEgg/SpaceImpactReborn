package space.impact.game;

import javax.swing.*;

public class peluru {
    int pelurux;
    int peluruy;
    int peluruaktif;

    public JLabel getSprite() {
        return sprite;
    }

    public void setSprite(JLabel sprite) {this.sprite = sprite;
    }

    protected JLabel sprite;

    public int getPelurux() {
        return pelurux;
    }

    public void setPelurux(int pelurux) {
        this.pelurux = pelurux;
    }

    public int getPeluruy() {
        return peluruy;
    }

    public void setPeluruy(int peluruy) {
        this.peluruy = peluruy;
    }

    public int getPeluruaktif() {
        return peluruaktif;
    }

    public void setPeluruaktif(int peluruaktif) {
        this.peluruaktif = peluruaktif;
    }


    public peluru(int pelurux, int peluruy, int peluruaktif) {
        this.pelurux = pelurux;
        this.peluruy = peluruy;
        this.peluruaktif = peluruaktif;
    }

}