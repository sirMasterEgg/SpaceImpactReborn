package space.impact.game;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Game extends JPanel implements ActionListener{
    static final int DELAY = 20;
    ArrayList<peluru> bullet = new ArrayList<>();
    ArrayList<peluruMusuh> bulletM = new ArrayList<>();
    ArrayList<Bot> bots = new ArrayList<>();
    int Start=0;
    int xp=100;
    int yp=100;
    int only=0;
    Random rn = new Random();
    int wave=1;
    int cek=0;
    int tembakanbot=0;
    int nyawa=3;
    int delay=0;
    int delayp=0;
    int delaypeluru=0;
    int []cekwave=new int [6];
    boolean running = false;
    int TEMBAK=0;
    int atasbawah=0;
    int shoot=0;
    int time=0;
    int tx = 0;
    JLabel Background ;
    JLabel pesawat ;
    JLabel hati1 ;
    JLabel hati2 ;
    JLabel hati3 ;
    JLabel barrier;
    Timer timer;

    Game() {
        if(Start==0){
            cekwave[0]=0;
            cekwave[1]=0;
            cekwave[2]=0;
            cekwave[3]=0;
            cekwave[4]=0;
            bots.add(new Bot(700,100,1,1));
            bots.add(new Bot(700,250,1,1));
            bots.add(new Bot(700,400,1,1));
            for(Bot i : bots) {
                if (i.getJenisbot() == 1) {
                    i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot() + 1);
                }
            }
            hati1 = new JLabel(new ImageIcon("res/foto/Hati.png"));
            hati1.setSize(50, 50);
            hati1.setLocation(20, 650);
            this.add(hati1);
            hati2 = new JLabel(new ImageIcon("res/foto/Hati.png"));
            hati2.setSize(50, 50);
            hati2.setLocation(60, 650);
            this.add(hati2);
            hati3 = new JLabel(new ImageIcon("res/foto/Hati.png"));
            hati3.setSize(50, 50);
            hati3.setLocation(100, 650);
            this.add(hati3);
            pesawat = new JLabel(new ImageIcon("res/foto/hero.png"));
            pesawat.setSize(50, 50);
            pesawat.setLocation(xp, yp);
            this.add(pesawat);
            Background = new JLabel(new ImageIcon("res/foto/bg.jpg"));
            Background.setSize(1000, 700);
            Background.setLocation(0, 0);
            this.setLayout(null);
            this.setPreferredSize(new Dimension(1000,700));
            this.setBackground(Color.white);
            this.setFocusable(true);
            this.addKeyListener(new MyKeyAdapter());
            this.add(Background);
        }
        startGame();
    }
    public void startGame() {
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        g.setColor(Color.black);
        if(running) {
            if(time==3){
                only=10;
                this.remove(barrier);
                time=0;
            }
            if(tx==30){
                tx=0;
                time++;
            }
            if(only==1){
                barrier=new JLabel(new ImageIcon("res/foto/barrier.png"));
                barrier.setSize(100, 100);
                barrier.setLocation(xp-30,yp-27);
                this.add(barrier);
                only=2;
            }

            if(only==2){
                tx++;
                this.remove(barrier);
                barrier=new JLabel(new ImageIcon("res/foto/barrier.png"));
                barrier.setSize(100, 100);
                barrier.setLocation(xp-30,yp-27);
                this.add(barrier);
            }

            if(wave==2){
                delay++;
                if(delay==100) {
                    bots.add(new Bot(700, 100, 1, 1));
                    bots.add(new Bot(850, 50, 1, 1));
                    bots.add(new Bot(700, 250, 1, 1));
                    bots.add(new Bot(850, 200, 1, 1));
                    bots.add(new Bot(700, 400, 1, 1));
                    bots.add(new Bot(850, 350, 1, 1));
                    bots.add(new Bot(850, 500, 1, 1));
                    for (Bot i : bots) {
                        if (i.getJenisbot() == 1) {
                            i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        }
                    }
                    delay=0;
                    wave = 0;
                }
            }
            if(wave==3){
                delay++;
                if(delay==100) {
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
                            i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        }
                    }
                    delay=0;
                    wave = 0;
                }
            }
            for(Bot i : bots){
                if (i.getJenisbot()== 1) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot()+1);
                } else if (i.getJenisbot() == 2) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon("res/foto/2.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot()+1);

                } else if (i.getJenisbot()== 3) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon("res/foto/3.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot()+1);

                } else if (i.getJenisbot() == 4) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon("res/foto/4.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot()+1);

                } else if (i.getJenisbot() == 5) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon("res/foto/5.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot()+1);

                } else if (i.getJenisbot() == 6) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon("res/foto/6.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot()+1);

                } else if (i.getJenisbot() == 7) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon("res/foto/7.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot()+1);

                } else if (i.getJenisbot()== 8) {
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon("res/foto/8.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getXbot(), i.getYbot());
                    this.add(i.getSprite());
                    i.setDelaybot(i.getDelaybot()+1);
                }
                if (i.getDelaybot()== 5) {
                    if (i.getJenisbot()== 1) {
                        i.setJenisbot(2);
                    } else if (i.getJenisbot() == 2) {
                        i.setJenisbot(3);
                    } else if (i.getJenisbot() == 3) {
                        i.setJenisbot(4);
                    } else if (i.getJenisbot()== 4) {
                        i.setJenisbot(5);
                    } else if (i.getJenisbot() == 5) {
                        i.setJenisbot(6);
                    } else if (i.getJenisbot()== 6) {
                        i.setJenisbot(7);
                    } else if (i.getJenisbot()== 7) {
                        i.setJenisbot(8);
                    } else if (i.getJenisbot()== 8) {
                        i.setJenisbot(1);
                    }
                    i.setDelaybot(1);
                }
            }
            if(cekwave[0]==3){
                wave=2;
                cekwave[0]=0;
                cek++;
            }
            if(cekwave[1]==7){
                wave=3;
                cekwave[1]=0;
                cek++;
            }
            if(TEMBAK==1){
                bullet.add(new peluru(xp+15,yp-25,0));
                TEMBAK=0;
                for(peluru i : bullet) {
                    if (i.getPeluruaktif() == 0) {
                        i.setSprite(new JLabel(new ImageIcon("res/foto/unnamed.png")));
                        i.getSprite().setSize(100, 100);
                        i.getSprite().setLocation(i.getPelurux(), i.getPeluruy());
                        this.add(i.getSprite());
                        i.setPeluruaktif(1);
                    }
                }
            }

            for(Bot i : bots){

                int randomizer = rn.nextInt(200) + 1;
                if(randomizer==1 || randomizer==2 ){
                    tembakanbot=1;
                    bulletM.add(new peluruMusuh(i.getXbot()-50,i.getYbot()-25,1));

                }
            }
            for(peluruMusuh i : bulletM){
                if(i.getPeluruaktif()==1) {
                    i.setPelurux(i.getPelurux()-15);
                    i.setSprite(new JLabel(new ImageIcon("res/foto/lasergreen.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getPelurux(), i.getPeluruy());
                    this.add(i.getSprite());
                    i.setPeluruaktif(0);
                }if(i.getPeluruaktif()==0) {
                    i.setPelurux(i.getPelurux()-15);
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon("res/foto/lasergreen.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getPelurux(), i.getPeluruy());
                    this.add(i.getSprite());
                    if(only!=2) {
                        if (xp + 3 >= i.getPelurux() && yp - 50 <= i.getPeluruy() && yp >= i.getPeluruy()) {
                            if (nyawa == 3) {
                                nyawa--;
                                this.remove(hati3);
                                i.setPeluruaktif(2);
                            } else if (nyawa == 2) {
                                nyawa--;
                                this.remove(hati2);
                                i.setPeluruaktif(2);
                            } else if (nyawa == 1) {
                                nyawa--;
                                this.remove(hati1);
                                i.setPeluruaktif(2);

                            } else if (nyawa == 0){

                            }
                        }
                    }
                }
                if(i.getPelurux()<15){
                    i.setPeluruaktif(2);
                }
            }
            for(peluruMusuh i : bulletM){
                if(i.getPeluruaktif()==2){
                    this.remove(i.getSprite());
                    bulletM.remove(i);
                    break;
                }
            }
            if(Start==0){
                for(peluru i : bullet){
                    this.remove(i.getSprite());
                    i.setSprite(new JLabel(new ImageIcon("res/foto/unnamed.png")));
                    i.getSprite().setSize(100, 100);
                    i.getSprite().setLocation(i.getPelurux(), i.getPeluruy());
                    this.add(i.getSprite());
                    if(i.getPelurux()>=900){
                        this.remove(i.getSprite());
                        bullet.remove(i);
                        break;
                    }
                    for(Bot j : bots){
                        if(j.getXbot()<=i.getPelurux()&& j.getXbot()+60>=i.getPelurux() && j.getYbot()-50<=i.getPeluruy() && j.getYbot()+20>=i.getPeluruy()){
                            this.remove(j.getSprite());
                            bots.remove(j);
                            cekwave[cek]++;
                            break;
                        }
                    }
                }
                this.remove(pesawat);
                pesawat = new JLabel(new ImageIcon("res/foto/hero.png"));
                pesawat.setSize(50, 50);
                pesawat.setLocation(xp, yp);
                this.add(pesawat);
                this.remove(Background);
                Background = new JLabel(new ImageIcon("res/foto/bg.jpg"));
                Background.setSize(1000, 700);
                Background.setLocation(0, 0);
                this.add(Background);
            }
        }

    }

    public void moveBot(){

        if(delayp==0){
            delaypeluru++;
        }
        if(delaypeluru==10){
            delaypeluru=0;
            delayp=1;
        }
        for(peluru i : bullet){
            i.setPelurux(i.getPelurux()+15);
        }
        for (Bot i : bots){
            if(atasbawah==0){
                i.setYbot(i.getYbot()+5);
            }
            if(atasbawah==1){
                i.setYbot(i.getYbot()-5);
            }
        }
        for (Bot i : bots){
            if(atasbawah==0){
                if(i.getYbot()==600){
                    atasbawah=1;
                }
            }
            if(atasbawah==1){
                if(i.getYbot()==0){
                    atasbawah=0;
                }
            }
        }
    }
    public void sound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Clip pew = AudioSystem.getClip();
        Clip duar = AudioSystem.getClip();
        if(shoot==1){
            File co = new File("res/sound/Pew Dor.wav");
            AudioInputStream audioc = AudioSystem.getAudioInputStream(co);
            pew.open(audioc);
            pew.start();
            shoot=0;
        }
        if(tembakanbot==1){
            File cs = new File("res/sound/Pew ship.wav");
            AudioInputStream audiocs = AudioSystem.getAudioInputStream(cs);
            duar.open(audiocs);
            duar.start();
            tembakanbot=0;
        }
    }

    public void tubruk() {
        if(yp >= 635) {
            yp=635;
        }
        if(yp <= 15) {
            yp=15;
        }
        if(xp<=15){
            xp=15;
        }
        if(xp>=900){
            xp=900;
        }
        if(!running) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            moveBot();
            tubruk();
            try {
                sound();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (delayp == 1) {
                    delayp = 0;
                    TEMBAK = 1;
                    shoot = 1;
                }
            }
            switch (e.getKeyChar()){
                case 'w':
                    yp-=15;
                    break;
                case 's':
                    yp+=15;
                    break;
                case 'c':
                    if(only==0){
                        only=1;
                    }
                    break;

                case 'd':
                    xp+=15;
                    break;
                case 'a':
                    xp-=15;
                    break;
            }

        }

    }
}