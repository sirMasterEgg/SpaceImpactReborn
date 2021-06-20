package space.impact.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class Game extends JPanel implements ActionListener {
    static final int DELAY = 20;
    ArrayList<peluru> bullet = new ArrayList<>();
    ArrayList<Bot> bots = new ArrayList<>();
    int Start = 0;
    int xp = 100;
    int yp = 100;
    int wave = 1;
    int cek = 0;
    int delay = 0;
    int[] cekwave = new int[6];
    boolean running = false;
    int TEMBAK = 0;
    int atasbawah = 0;
    JLabel Background;
    JLabel pesawat;
    Timer timer;

    Game() {
        if (Start == 0) {
            cekwave[0] = 0;
            cekwave[1] = 0;
            cekwave[2] = 0;
            cekwave[3] = 0;
            cekwave[4] = 0;
            bots.add(new Bot(700, 100, 1, 1));
            bots.add(new Bot(700, 250, 1, 1));
            bots.add(new Bot(700, 400, 1, 1));
            for (Bot i : bots) {
                if (i.getJenisbot() == 1) {
                    i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/1.png"))));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot() + 1);
                }
            }
            pesawat = new JLabel(new ImageIcon(getClass().getResource("../../img/foto/hero.png")));
            pesawat.setSize(50, 50);
            pesawat.setLocation(xp, yp);
            this.add(pesawat);
            Background = new JLabel(new ImageIcon(getClass().getResource("../../img/foto/bg.jpg")));
            Background.setSize(1000, 700);
            Background.setLocation(0, 0);
            this.setLayout(null);
            this.setPreferredSize(new Dimension(1000, 700));
            this.setBackground(Color.white);
            this.setFocusable(true);
            this.addKeyListener(new MyKeyAdapter());
            this.add(Background);
        }
        startGame();
    }

    public void startGame() {
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        if (running) {
            if (wave == 2) {
                delay++;
                if (delay == 100) {
                    bots.add(new Bot(700, 100, 1, 1));
                    bots.add(new Bot(850, 50, 1, 1));
                    bots.add(new Bot(700, 250, 1, 1));
                    bots.add(new Bot(850, 200, 1, 1));
                    bots.add(new Bot(700, 400, 1, 1));
                    bots.add(new Bot(850, 350, 1, 1));
                    bots.add(new Bot(850, 500, 1, 1));
                    for (Bot i : bots) {
                        if (i.getJenisbot() == 1) {
                            i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/1.png"))));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        }
                    }
                    delay = 0;
                    wave = 0;
                }
            }
            if (wave == 3) {
                delay++;
                if (delay == 100) {
                    bots.add(new Bot(700, 100, 1, 1));
                    bots.add(new Bot(850, 50, 1, 1));
                    bots.add(new Bot(700, 250, 1, 1));
                    bots.add(new Bot(850, 200, 1, 1));
                    bots.add(new Bot(700, 400, 1, 1));
                    bots.add(new Bot(850, 350, 1, 1));
                    bots.add(new Bot(700, 550, 1, 1));
                    bots.add(new Bot(850, 500, 1, 1));
                    for (Bot i : bots) {
                        if (i.getJenisbot() == 1) {
                            i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/1.png"))));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        }
                    }
                    delay = 0;
                    wave = 0;
                }
            }

            if (wave == 4) {
                delay++;
                if (delay == 100) {
                    bots.add(new Bot(700, 100, 1, 1));

                    bots.add(new Bot(850, 200, 1, 1));


                    for (Bot i : bots) {
                        if (i.getJenisbot() == 1) {
                            i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/1.png"))));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        }
                    }
                    delay = 0;
                    wave = 0;
                }
            }

            if (wave == 5) {
                delay++;
                if (delay == 100) {
                    bots.add(new Bot(700, 100, 1, 1));

                    for (Bot i : bots) {
                        if (i.getJenisbot() == 1) {
                            i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/1.png"))));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        }
                    }
                    delay = 0;
                    wave = 0;
                }
            }

            for (Bot i : bots) {
                if (i.getJenisbot() == 1) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/1.png"))));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot() + 1);
                } else if (i.getJenisbot() == 2) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/2.png"))));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot() + 1);

                } else if (i.getJenisbot() == 3) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/3.png"))));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot() + 1);

                } else if (i.getJenisbot() == 4) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/4.png"))));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot() + 1);

                } else if (i.getJenisbot() == 5) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/5.png"))));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot() + 1);

                } else if (i.getJenisbot() == 6) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/6.png"))));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot() + 1);

                } else if (i.getJenisbot() == 7) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/7.png"))));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot() + 1);

                } else if (i.getJenisbot() == 8) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/bot/8.png"))));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot() + 1);
                }
                if (i.getDelaybot() == 5) {
                    if (i.getJenisbot() == 1) {
                        i.setJenisbot(2);
                    } else if (i.getJenisbot() == 2) {
                        i.setJenisbot(3);
                    } else if (i.getJenisbot() == 3) {
                        i.setJenisbot(4);
                    } else if (i.getJenisbot() == 4) {
                        i.setJenisbot(5);
                    } else if (i.getJenisbot() == 5) {
                        i.setJenisbot(6);
                    } else if (i.getJenisbot() == 6) {
                        i.setJenisbot(7);
                    } else if (i.getJenisbot() == 7) {
                        i.setJenisbot(8);
                    } else if (i.getJenisbot() == 8) {
                        i.setJenisbot(1);
                    }
                    i.setDelaybot(1);
                }
            }
            if (cekwave[0] == 3) {
                wave = 2;
                cekwave[0] = 0;
                cek++;
            }
            if (cekwave[1] == 7) {
                wave = 3;
                cekwave[1] = 0;
                cek++;
            }

            if (cekwave[2] == 8) {
                wave = 4;
                cekwave[2] = 0;
                cek++;
            }

            if (cekwave[3] == 2) {
                wave = 5;
                cekwave[3] = 0;
                cek++;
            }


            if (TEMBAK == 1) {
                bullet.add(new peluru(xp + 15, yp - 25, 0));
                TEMBAK = 0;
                for (peluru i : bullet) {
                    if (i.getPeluruaktif() == 0) {
                        i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/foto/unnamed.png"))));
                        i.getSprite().setSize(100, 100);
                        i.getSprite().setLocation(i.getPelurux(), i.getPeluruy());
                        this.add(i.getSprite());
                        i.setPeluruaktif(1);
                    }
                }
            }

            if (Start == 0) {
                for (peluru i : bullet) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon(getClass().getResource("../../img/foto/unnamed.png"))));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getPelurux(), i.getPeluruy());
                    this.add(i.getSprite());
                    if (i.getPelurux() >= 900) {
                        this.remove(i.getSprite());
                        bullet.remove(i);
                        break;
                    }
                    for (Bot j : bots) {
                        if (j.getXbot() <= i.getPelurux() && j.getXbot() + 60 >= i.getPelurux() && j.getYbot() - 50 <= i.getPeluruy() && j.getYbot() + 20 >= i.getPeluruy()) {
                            this.remove(j.getSprite());
                            bots.remove(j);
                            cekwave[cek]++;
                            break;
                        }
                    }
                }
                this.remove(pesawat);
                pesawat = new JLabel(new ImageIcon(getClass().getResource("../../img/foto/hero.png")));
                pesawat.setSize(50, 50);
                pesawat.setLocation(xp, yp);
                this.add(pesawat);
                this.remove(Background);
                Background = new JLabel(new ImageIcon(getClass().getResource("../../img/foto/bg.jpg")));
                Background.setSize(1000, 700);
                Background.setLocation(0, 0);
                this.add(Background);
            }
        }

    }

    public void moveBot() {
        for (peluru i : bullet) {
            i.setPelurux(i.getPelurux() + 15);
        }
        for (Bot i : bots) {
            if (atasbawah == 0) {
                i.setYbot(i.getYbot() + 5);
            }
            if (atasbawah == 1) {
                i.setYbot(i.getYbot() - 5);
            }
        }
        for (Bot i : bots) {
            if (atasbawah == 0) {
                if (i.getYbot() == 600) {
                    atasbawah = 1;
                }
            }
            if (atasbawah == 1) {
                if (i.getYbot() == 0) {
                    atasbawah = 0;
                }
            }
        }
    }


    public void tubruk() {
        if (yp >= 635) {
            yp = 635;
        }
        if (yp <= 15) {
            yp = 15;
        }
        if (xp <= 15) {
            xp = 15;
        }
        if (xp >= 900) {
            xp = 900;
        }
        if (!running) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            moveBot();
            tubruk();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    yp -= 15;
                    break;
                case KeyEvent.VK_DOWN:
                    yp += 15;
                    break;
                case KeyEvent.VK_SPACE:
                    TEMBAK = 1;
                    break;
                case KeyEvent.VK_RIGHT:
                    xp += 15;
                    break;
                case KeyEvent.VK_LEFT:
                    xp -= 15;
                    break;
            }
        }
    }
}
