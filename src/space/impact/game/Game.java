package space.impact.game;
import space.impact.source.*;

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.Timer;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Game extends JPanel implements ActionListener{
    private boolean kamikazee=false;
    private PlayerInfo<String> pI;
    private Font pixel = new FontMaker(Path.pixelFont).getFont();
    private Font font = new FontMaker(Path.mainFont).getFont();
    static final int DELAY = 20;
    ArrayList<peluru> bullet = new ArrayList<>();
    ArrayList<peluruMusuh> bulletM = new ArrayList<>();
    ArrayList<Bot> bots = new ArrayList<>();
    ArrayList<boss> bos = new ArrayList<>();
    int Start=0, xp=100, yp=100, only=0, jumlahbarrier=3, onlymisil = 0, misil = 10, kamikaze = 1, wave=1, cek=0, tembakanbot=0, nyawa=3, delay=0, delayp=0, delaypeluru=0;
    Random rn = new Random();
    int []cekwave=new int [99];
    boolean running = false;
    int TEMBAK=0, atasbawah=0, shoot=0, cheat=0, time=0, tx = 0, pause=0;
    JLabel Background, pesawat, hati1, hati2, hati3, barrier, Klabel, Kpeluru, Kkaze;

    Timer timer;
    int score = 0;
    private String usertemp;
    JFrame j;

    Game(String usertemp,JFrame j) {

        // music
        Path.gameMusic.playMusic(Path.gameMusicPath);
        Path.gameMusic.musicLoop();
        Path.gameMusic.setVolume(0.15f);

        Klabel = new JLabel();
        Kpeluru = new JLabel();
        Kkaze = new JLabel();
        this.usertemp=usertemp;
        this.j=j;
        if(Start==0){
            cekwave[0]=0;
            cekwave[1]=0;
            cekwave[2]=0;
            cekwave[3]=0;
            cekwave[4]=0;
            cekwave[5]=0;
            cekwave[6]=0;
            cekwave[7]=0;
            cekwave[8]=0;
//            cekwave[9]=0;
//            cekwave[10]=0;
//            cekwave[11]=0;
//            cekwave[12]=0;
//            cekwave[13]=0;
//            cekwave[14]=0;
//            cekwave[15]=0;
//            cekwave[16]=0;
//            cekwave[17]=0;
//            cekwave[18]=0;
//            cekwave[19]=0;
//            cekwave[20]=0;
//            cekwave[21]=0;
//            cekwave[22]=0;
//            cekwave[23]=0;
//            cekwave[24]=0;
//            cekwave[25]=0;
//            cekwave[26]=0;
//            cekwave[27]=0;
//            cekwave[28]=0;
//            cekwave[29]=0;
//            cekwave[30]=0;
//            cekwave[31]=0;
            bots.add(new Bot(700,100,1,1,0));
            bots.add(new Bot(700,250,1,1,0));
            bots.add(new Bot(700,400,1,1,0));
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
            Background = new JLabel(new ImageIcon("res/foto/bg.png"));
            Background.setSize(1000, 700);
            Background.setLocation(100, 100);
            this.setLayout(null);
            this.setPreferredSize(new Dimension(1000,700));
            this.setBackground(Color.black);
            this.setFocusable(true);
            this.addKeyListener(new MyKeyAdapter());
            this.add(Background);


        }
        startGame();
        missileDirection();
        barrierDirection();
        barrierDesign();
        kamikazeDirection();
        kamikazeDesign();
        missileDesign();

        Rectangle rect = new Rectangle(260,0,750,40);
        Rectangle rect1 = new Rectangle(300,0,750,40);
        Klabel.setText("<html> <table> \n" + " = "+jumlahbarrier);
        Klabel.setFont(font.deriveFont(35.0f));
        Klabel.setForeground(new Color(52, 239, 0));
        validate();
        Klabel.setBounds(rect1);
        Klabel.setVisible(true);
        this.add(Klabel);

        Rectangle recta = new Rectangle(460,0,750,50);
        Kpeluru.setText("<html> <table> \n" + " = " + misil);
        Kpeluru.setFont(font.deriveFont(35.0f));
        Kpeluru.setForeground(new Color(52, 239, 0));
        Kpeluru.setBounds(recta);
        Kpeluru.setVisible(true);
        this.add(Kpeluru);

        Rectangle rectangle = new Rectangle(650, 0 , 750, 50);
        Kkaze.setText("<html> <table> \n" + " = " + kamikaze);
        Kkaze.setFont(font.deriveFont(35.0f));
        Kkaze.setForeground(new Color(52, 239, 0));
        Kkaze.setBounds(rectangle);
        Kkaze.setVisible(true);
        this.add(Kkaze);
    }
    //untuk design tampilan skill game
    private void kamikazeDesign(){
        Kkaze.setText("<html> <table> \n" + " = " + kamikaze);
    }
    private void missileDesign(){
        Kpeluru.setText("<html> <table> \n" + " = " + misil);
    }

    private void barrierDesign(){
        Klabel.setText("<html> <table> \n" + " = "+jumlahbarrier);
    }

    void missileDirection(){
        ImageIcon missile = new ImageIcon(ImageClass.scaleImage(Path.instructionSkill2Path, 0.05));
        JLabel logolabel = new JLabel();
        logolabel.setIcon(missile);
        logolabel.setHorizontalAlignment(JLabel.LEADING);
        logolabel.setBounds(400, 0, ImageClass.imgWidth(), ImageClass.imgHeight());
        this.add(logolabel);
    }
    void barrierDirection(){
        ImageIcon disappear = new ImageIcon(ImageClass.scaleImage(Path.instructionSkill3Path, 0.5));
        JLabel logolabel = new JLabel();
        logolabel.setIcon(disappear);
        logolabel.setHorizontalAlignment(JLabel.LEADING);
        logolabel.setBounds(230, 5, ImageClass.imgWidth(), ImageClass.imgHeight());
        this.add(logolabel);
    }
    void kamikazeDirection(){
        ImageIcon killself = new ImageIcon(ImageClass.scaleImage(Path.instructionSkill1Path, 0.04));
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(killself);
        logoLabel.setHorizontalAlignment(JLabel.LEADING);
        logoLabel.setBounds(600, 0, ImageClass.imgWidth(), ImageClass.imgHeight());
        this.add(logoLabel);
    }

    public void startGame() {
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        barrierDesign();
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        if(running) {

            if (nyawa == 0) { //INI TEMPAT GAME OVER ()
                    running=false;
                    j.dispose();
                    Play p = new Play(usertemp);

                MyFileHandler file = new TextClass();
                ArrayList<String> save = file.loadBefore(Path.saveHighscore);
                String temp = "";
                int scorekamikaze = score/2;

                if (!kamikazee) {
                    Path.gameMusic.stopMusic();
                    JOptionPane.showMessageDialog(null, "<html>You Lose!<br>Score: " + score + "</html>", "You Lose!", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    Path.gameMusic.stopMusic();
                    JOptionPane.showMessageDialog(null, "<html>You Have been Kamikaze!<br>Score asli: " + scorekamikaze + "<br>Score kamikaze: "+ score +"</html>", "You Lose!", JOptionPane.INFORMATION_MESSAGE);
                }
                pI = new PlayerInfo<>(usertemp);
//                System.out.println(pI.getPlayerName());
//                System.out.println(score);
                temp += pI.getPlayerName() + Path.pemisahHighscore + score;
                save.add(temp);
                file.sortByScore(save);
                file.save(Path.saveHighscore, save);
            } else{

                if (pause == 0) {
                g.setColor(Color.green);
                g.setFont(pixel.deriveFont(20.0f));
                g.drawString(" SCORE  " + score, 20, 18);
//                    barrierDirection();
//                    barrierDesign();
                    if (time == 3) {
                    only = 0;
                    this.remove(barrier);
                    time = 0;
                }
                if (tx == 30) {
                    tx = 0;
                    time++;
                }
                if (only == 1) {
                    barrier = new JLabel(new ImageIcon("res/foto/barrier.png"));
                    barrier.setSize(100, 100);
                    barrier.setLocation(xp - 30, yp - 27);
                    this.add(barrier);
                    only = 2;
                }

                if (only == 2) {
                    tx++;
                    this.remove(barrier);
                    barrier = new JLabel(new ImageIcon("res/foto/barrier.png"));
                    barrier.setSize(100, 100);
                    barrier.setLocation(xp - 30, yp - 27);
                    this.add(barrier);
                }

                if (wave == 2) {
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 100, 1, 1,0));
                        bots.add(new Bot(850, 50, 1, 1,0));
                        bots.add(new Bot(700, 250, 1, 1,0));
                        bots.add(new Bot(850, 200, 1, 1,0));
                        bots.add(new Bot(700, 400, 1, 1,0));
                        bots.add(new Bot(850, 350, 1, 1,0));
                        bots.add(new Bot(850, 500, 1, 1,0));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
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
                        bots.add(new Bot(700, 100, 1, 1,0));
                        bots.add(new Bot(850, 50, 1, 1,0));
                        bots.add(new Bot(700, 250, 1, 1,0));
                        bots.add(new Bot(850, 200, 1, 1,0));
                        bots.add(new Bot(700, 400, 1, 1,0));
                        bots.add(new Bot(850, 350, 1, 1,0));
                        bots.add(new Bot(700, 550, 1, 1,0));
                        bots.add(new Bot(850, 500, 1, 1,0));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
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
                        bots.add(new Bot(700, 100, 1, 1,0));
                        bots.add(new Bot(850, 50, 1, 1,0));
                        bots.add(new Bot(700, 250, 1, 1,0));
                        bots.add(new Bot(850, 200, 1, 1,0));
                        bots.add(new Bot(700, 400, 1, 1,0));
                        bots.add(new Bot(850, 350, 1, 1,0));
                        bots.add(new Bot(700, 550, 1, 1,0));
                        bots.add(new Bot(850, 500, 1, 1,0));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
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
                        bots.add(new Bot(850, 50, 1, 1,0));
                        bots.add(new Bot(850, 200, 1, 1,0));
                        bots.add(new Bot(850, 350, 1, 1,0));
                        bots.add(new Bot(850, 500, 1, 1,0));
                        bots.add(new Bot(700, 150, 1, 1,0));
                        bots.add(new Bot(700, 300, 1, 1,0));
                        bots.add(new Bot(700, 450, 1, 1,0));
                        bots.add(new Bot(600, 200, 1, 1,0));
                        bots.add(new Bot(600, 350, 1, 1,0));


                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
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

                if (wave == 6) {
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(850, 50, 1, 1,0));
                        bots.add(new Bot(850, 200, 1, 1,0));
                        bots.add(new Bot(850, 350, 1, 1,0));
                        bots.add(new Bot(850, 500, 1, 1,0));
                        bots.add(new Bot(700, 150, 1, 1,0));
                        bots.add(new Bot(700, 300, 1, 1,0));
                        bots.add(new Bot(700, 450, 1, 1,0));
                        bots.add(new Bot(600, 200, 1, 1,0));
                        bots.add(new Bot(600, 350, 1, 1,0));
                        bots.add(new Bot(500, 260, 1, 1,0));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
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

                if (wave == 7) {
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 100, 1, 1,0));
                        bots.add(new Bot(850, 50, 1, 1 ,0));
                        bots.add(new Bot(700, 250, 1, 1,0));
                        bots.add(new Bot(850, 200, 1, 1,0));
                        bots.add(new Bot(700, 400, 1, 1,0));
                        bots.add(new Bot(850, 350, 1, 1,0));
                        bots.add(new Bot(700, 550, 1, 1,0));
                        bots.add(new Bot(850, 500, 1, 1,0));
                        bots.add(new Bot(600, 180, 1, 1,0));
                        bots.add(new Bot(600, 320, 1, 1,0));
                        bots.add(new Bot(600, 500, 1, 1,0));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
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

                if (wave == 8) {
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 100, 1, 1,0));
                        bots.add(new Bot(850, 50, 1, 1 ,0));
                        bots.add(new Bot(700, 250, 1, 1,0));
                        bots.add(new Bot(850, 200, 1, 1,0));
                        bots.add(new Bot(700, 400, 1, 1,0));
                        bots.add(new Bot(850, 350, 1, 1,0));
                        bots.add(new Bot(700, 550, 1, 1,0));
                        bots.add(new Bot(850, 500, 1, 1,0));
                        bots.add(new Bot(600, 50, 1, 1 ,0));
                        bots.add(new Bot(600, 180, 1, 1,0));
                        bots.add(new Bot(600, 350, 1, 1,0));
                        bots.add(new Bot(600, 500, 1, 1,0));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
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

                if (wave == 9) {
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 50, 1, 1 ,0));
                        bots.add(new Bot(850, 50, 1, 1 ,0));
                        bots.add(new Bot(700, 200, 1, 1,0));
                        bots.add(new Bot(850, 200, 1, 1,0));
                        bots.add(new Bot(700, 350, 1, 1,0));
                        bots.add(new Bot(850, 350, 1, 1,0));
                        bots.add(new Bot(700, 500, 1, 1,0));
                        bots.add(new Bot(850, 500, 1, 1,0));
                        bots.add(new Bot(550, 50, 1, 1 ,0));
                        bots.add(new Bot(550, 200, 1, 1,0));
                        bots.add(new Bot(550, 350, 1, 1,0));
                        bots.add(new Bot(550, 500, 1, 1,0));
                        bots.add(new Bot(450, 130, 1, 1,0));
                        bots.add(new Bot(450, 280, 1, 1,0));
                        bots.add(new Bot(450, 430, 1, 1,0));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
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

                if (wave == 10) {
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 50, 1, 1 ,0));
                        bots.add(new Bot(850, 50, 1, 1 ,0));
                        bots.add(new Bot(700, 200, 1, 1,0));
                        bots.add(new Bot(850, 200, 1, 1,0));
                        bots.add(new Bot(700, 350, 1, 1,0));
                        bots.add(new Bot(850, 350, 1, 1,0));
                        bots.add(new Bot(700, 500, 1, 1,0));
                        bots.add(new Bot(850, 500, 1, 1,0));
                        bots.add(new Bot(550, 50, 1, 1 ,0));
                        bots.add(new Bot(550, 200, 1, 1,0));
                        bots.add(new Bot(550, 350, 1, 1,0));
                        bots.add(new Bot(550, 500, 1, 1,0));
                        bots.add(new Bot(450, 130, 1, 1,0));
                        bots.add(new Bot(450, 280, 1, 1,0));
                        bots.add(new Bot(450, 430, 1, 1,0));
                        bots.add(new Bot(350, 200, 1, 1,0));
                        bots.add(new Bot(350, 350, 1, 1,0));
                        bots.add(new Bot(250, 280, 1, 1,0));

                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
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
/////////////////////////////////////////////////////////////////////
                    if (wave == 11) {
                        delay++;
                        if (delay == 100) {
                            bots.add(new Bot(700,100,1,1,1));
                            bots.add(new Bot(700,250,1,1,1));
                            bots.add(new Bot(700,400,1,1,1));
                            for (Bot i : bots) {
                                if (i.getJenisbot() == 1) {
                                    i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
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

                if (wave == 12){
                    delay++;
                    if (delay == 100) {
//                        bots.add(new Bot(850, 50, 1, 1 ,1));
//                        bots.add(new Bot(700, 250, 1, 1,1));
//                        bots.add(new Bot(850, 200, 1, 1,1));
//                        bots.add(new Bot(700, 400, 1, 1,1));
//                        bots.add(new Bot(850, 350, 1, 1,1));
//                        bots.add(new Bot(850, 500, 1, 1,1));
//                        bots.add(new Bot(850, 500, 1, 1,1));

                        bots.add(new Bot(700, 100, 1, 1,1));
                        bots.add(new Bot(850, 50, 1, 1,1));
                        bots.add(new Bot(700, 250, 1, 1,1));
                        bots.add(new Bot(850, 200, 1, 1,1));
                        bots.add(new Bot(700, 400, 1, 1,1));
                        bots.add(new Bot(850, 350, 1, 1,1));
                        bots.add(new Bot(850, 500, 1, 1,1));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-1-removebg-preview.png")));
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

                if (wave == 13){
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 100, 1, 1,1));
                        bots.add(new Bot(850, 50, 1, 1 ,1));
                        bots.add(new Bot(700, 250, 1, 1,1));
                        bots.add(new Bot(850, 200, 1, 1,1));
                        bots.add(new Bot(700, 400, 1, 1,1));
                        bots.add(new Bot(850, 350, 1, 1,1));
                        bots.add(new Bot(700, 550, 1, 1,1));
                        bots.add(new Bot(850, 500, 1, 1,1));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-1-removebg-preview.png")));
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

                if (wave == 14){
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 100, 1, 1,1));
                        bots.add(new Bot(850, 50, 1, 1 ,1));
                        bots.add(new Bot(700, 250, 1, 1,1));
                        bots.add(new Bot(850, 200, 1, 1,1));
                        bots.add(new Bot(700, 400, 1, 1,1));
                        bots.add(new Bot(850, 350, 1, 1,1));
                        bots.add(new Bot(700, 550, 1, 1,1));
                        bots.add(new Bot(850, 500, 1, 1,1));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-1-removebg-preview.png")));
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

                if (wave == 15){
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(850, 50, 1, 1 ,1));
                        bots.add(new Bot(850, 200, 1, 1,1));
                        bots.add(new Bot(850, 350, 1, 1,1));
                        bots.add(new Bot(850, 500, 1, 1,1));
                        bots.add(new Bot(700, 150, 1, 1,1));
                        bots.add(new Bot(700, 300, 1, 1,1));
                        bots.add(new Bot(700, 450, 1, 1,1));
                        bots.add(new Bot(600, 200, 1, 1,1));
                        bots.add(new Bot(600, 350, 1, 1,1));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-1-removebg-preview.png")));
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

                if (wave == 16){
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(850, 50, 1, 1 ,1));
                        bots.add(new Bot(850, 200, 1, 1,1));
                        bots.add(new Bot(850, 350, 1, 1,1));
                        bots.add(new Bot(850, 500, 1, 1,1));
                        bots.add(new Bot(700, 150, 1, 1,1));
                        bots.add(new Bot(700, 300, 1, 1,1));
                        bots.add(new Bot(700, 450, 1, 1,1));
                        bots.add(new Bot(600, 200, 1, 1,1));
                        bots.add(new Bot(600, 350, 1, 1,1));
                        bots.add(new Bot(500, 260, 1, 1,1));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-1-removebg-preview.png")));
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

                if (wave == 17){
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 100, 1, 1,1));
                        bots.add(new Bot(850, 50, 1, 1 ,1));
                        bots.add(new Bot(700, 250, 1, 1,1));
                        bots.add(new Bot(850, 200, 1, 1,1));
                        bots.add(new Bot(700, 400, 1, 1,1));
                        bots.add(new Bot(850, 350, 1, 1,1));
                        bots.add(new Bot(700, 550, 1, 1,1));
                        bots.add(new Bot(850, 500, 1, 1,1));
                        bots.add(new Bot(600, 180, 1, 1,1));
                        bots.add(new Bot(600, 320, 1, 1,1));
                        bots.add(new Bot(600, 500, 1, 1,1));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-1-removebg-preview.png")));
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

                if (wave == 18){
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 100, 1, 1,1));
                        bots.add(new Bot(850, 50, 1, 1 ,1));
                        bots.add(new Bot(700, 250, 1, 1,1));
                        bots.add(new Bot(850, 200, 1, 1,1));
                        bots.add(new Bot(700, 400, 1, 1,1));
                        bots.add(new Bot(850, 350, 1, 1,1));
                        bots.add(new Bot(700, 550, 1, 1,1));
                        bots.add(new Bot(850, 500, 1, 1,1));
                        bots.add(new Bot(600, 50, 1, 1 ,1));
                        bots.add(new Bot(600, 180, 1, 1,1));
                        bots.add(new Bot(600, 350, 1, 1,1));
                        bots.add(new Bot(600, 500, 1, 1,1));
                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-1-removebg-preview.png")));
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

                if (wave == 19){
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 50, 1, 1 ,1));
                        bots.add(new Bot(850, 50, 1, 1 ,1));
                        bots.add(new Bot(700, 200, 1, 1,1));
                        bots.add(new Bot(850, 200, 1, 1,1));
                        bots.add(new Bot(700, 350, 1, 1,1));
                        bots.add(new Bot(850, 350, 1, 1,1));
                        bots.add(new Bot(700, 500, 1, 1,1));
                        bots.add(new Bot(850, 500, 1, 1,1));
                        bots.add(new Bot(550, 50, 1, 1 ,1));
                        bots.add(new Bot(550, 200, 1, 1,1));
                        bots.add(new Bot(550, 350, 1, 1,1));
                        bots.add(new Bot(550, 500, 1, 1,1));
                        bots.add(new Bot(450, 130, 1, 1,1));
                        bots.add(new Bot(450, 280, 1, 1,1));
                        bots.add(new Bot(450, 430, 1, 1,1));

                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-1-removebg-preview.png")));
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

                if (wave == 20){
                    delay++;
                    if (delay == 100) {
                        bots.add(new Bot(700, 50, 1, 1 ,1));

                        for (Bot i : bots) {
                            if (i.getJenisbot() == 1) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-1-removebg-preview.png")));
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

                for (boss i : bos) {
                    if (i.getJenisbos() == 1) {
                        this.remove(i.getSprite());
                        i.setSprite(new JLabel(new ImageIcon("res/foto/boss1.png")));
                        i.getSprite().setSize(640, 640);
                        i.getSprite().setLocation(i.getXbos(), i.getYbos());
                        this.add(i.getSprite());
                        i.setDelaybos(i.getDelaybos() + 1);
                    } else if (i.getJenisbos() == 2) {
                        this.remove(i.getSprite());
                        i.setSprite(new JLabel(new ImageIcon("res/foto/boss2.png")));
                        i.getSprite().setSize(640, 640);
                        i.getSprite().setLocation(i.getXbos(), i.getYbos());
                        this.add(i.getSprite());
                        i.setDelaybos(i.getDelaybos() + 1);
                    } else if (i.getJenisbos() == 3) {
                        this.remove(i.getSprite());
                        i.setSprite(new JLabel(new ImageIcon("res/foto/boss3.png")));
                        i.getSprite().setSize(640, 640);
                        i.getSprite().setLocation(i.getXbos(), i.getYbos());
                        this.add(i.getSprite());
                        i.setDelaybos(i.getDelaybos() + 1);
                    } else if (i.getJenisbos() == 4) {
                        this.remove(i.getSprite());
                        i.setSprite(new JLabel(new ImageIcon("res/foto/boss4.png")));
                        i.getSprite().setSize(640, 640);
                        i.getSprite().setLocation(i.getXbos(), i.getYbos());
                        this.add(i.getSprite());
                        i.setDelaybos(i.getDelaybos() + 1);
                    } else if (i.getJenisbos() == 5) {
                        this.remove(i.getSprite());
                        i.setSprite(new JLabel(new ImageIcon("res/foto/boss5.png")));
                        i.getSprite().setSize(640, 640);
                        i.getSprite().setLocation(i.getXbos(), i.getYbos());
                        this.add(i.getSprite());
                        i.setDelaybos(i.getDelaybos() + 1);
                    } else if (i.getJenisbos() == 6) {
                        this.remove(i.getSprite());
                        i.setSprite(new JLabel(new ImageIcon("res/foto/boss6.png")));
                        i.getSprite().setSize(640, 640);
                        i.getSprite().setLocation(i.getXbos(), i.getYbos());
                        this.add(i.getSprite());
                        i.setDelaybos(i.getDelaybos() + 1);
                    } else if (i.getJenisbos() == 7) {
                        this.remove(i.getSprite());
                        i.setSprite(new JLabel(new ImageIcon("res/foto/boss7.png")));
                        i.getSprite().setSize(640, 640);
                        i.getSprite().setLocation(i.getXbos(), i.getYbos());
                        this.add(i.getSprite());
                        i.setDelaybos(i.getDelaybos() + 1);
                    } else if (i.getJenisbos() == 8) {
                        this.remove(i.getSprite());
                        i.setSprite(new JLabel(new ImageIcon("res/foto/boss8.pngww")));
                        i.getSprite().setSize(640, 640);
                        i.getSprite().setLocation(i.getXbos(), i.getYbos());
                        this.add(i.getSprite());
                        i.setDelaybos(i.getDelaybos() + 1);
                    }

                    if (i.getDelaybos() == 5) {
                        if (i.getJenisbos() == 1) {
                            i.setJenisbos(2);
                        } else if (i.getJenisbos() == 2) {
                            i.setJenisbos(3);
                        } else if (i.getJenisbos() == 3) {
                            i.setJenisbos(4);
                        } else if (i.getJenisbos() == 4) {
                            i.setJenisbos(5);
                        } else if (i.getJenisbos() == 5) {
                            i.setJenisbos(6);
                        } else if (i.getJenisbos() == 6) {
                            i.setJenisbos(7);
                        } else if (i.getJenisbos() == 7) {
                            i.setJenisbos(8);
                        } else if (i.getJenisbos() == 8) {
                            i.setJenisbos(1);
                        }
                        i.setDelaybos(1);
                    }
                }

                for (Bot i : bots) {
                    if (i.getTipebot() == 0){
                        if (i.getJenisbot() == 1) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/1.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        } else if (i.getJenisbot() == 2) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/2.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);

                        } else if (i.getJenisbot() == 3) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/3.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);

                        } else if (i.getJenisbot() == 4) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/4.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);

                        } else if (i.getJenisbot() == 5) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/5.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);

                        } else if (i.getJenisbot() == 6) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/6.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);

                        } else if (i.getJenisbot() == 7) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/7.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);

                        } else if (i.getJenisbot() == 8) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/8.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        }
                    } else {
                        if (i.getJenisbot() == 1) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-1-removebg-preview.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        } else if (i.getJenisbot() == 2) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-2-removebg-preview.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(),i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        } else if (i.getJenisbot() == 3) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-3-removebg-preview.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        } else if (i.getJenisbot() == 4) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-4-removebg-preview.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        } else if (i.getJenisbot() == 5) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-5-removebg-preview.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        } else if (i.getJenisbot() == 6) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-6-removebg-preview.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        } else if (i.getJenisbot() == 7) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-7-removebg-preview.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        } else if (i.getJenisbot() == 8) {
                            this.remove(i.getSprite());
                            i.setSprite(new JLabel(new ImageIcon("res/foto/botlevel2-8-removebg-preview.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getXbot(), i.getYbot());
                            this.add(i.getSprite());
                            i.setDelaybot(i.getDelaybot() + 1);
                        }
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
                if (cekwave[0] == 3) { //2
                    if (nyawa != 0) {
                        score = score * nyawa;
                    }
                    misil += 2;
                    wave = 2;
                    cekwave[0] = 0;
                    cek++;
                    jumlahbarrier++;
                }
                if (cekwave[1] == 7) { //3
                    if (nyawa != 0) {
                        score = score * nyawa;
                    }
                    misil += 2;
                    wave = 3;
                    cekwave[1] = 0;
                    cek++;
                    jumlahbarrier++;
                }
                if (cekwave[2] == 8) { //4
                    if (nyawa != 0) {
                        score = score * nyawa;
                    }
                    misil += 2;
                    wave = 4;
                    cekwave[2] = 0;
                    cek++;
                    jumlahbarrier++;
                }
                if (cekwave[3] == 8) { //5
                    if (nyawa != 0) {
                        score = score * nyawa;
                    }
                    misil += 2;
                    wave = 5;
                    cekwave[3] = 0;
                    cek++;
                    jumlahbarrier++;
                }

                if (cekwave[4] == 9) { //6
                    if (nyawa != 0) {
                        score = score * nyawa;
                    }
                    misil += 2;
                    wave = 6;
                    cekwave[4] = 0;
                    cek++;
                    jumlahbarrier++;
                }

                if (cekwave[5] == 10) {//7
                    if (nyawa != 0) {
                        score = score * nyawa;
                    }
                    misil += 2;
                    wave = 7;
                    cekwave[5] = 0;
                    cek++;
                    jumlahbarrier++;
                }

                if (cekwave[6] == 11) { //8
                    if (nyawa != 0) {
                        score = score * nyawa;
                    }
                    misil += 2;
                    wave = 8;
                    cekwave[6] = 0;
                    cek++;
                    jumlahbarrier++;

                }

                if (cekwave[7] == 12) { //9
                    if (nyawa != 0) {
                        score = score * nyawa;
                    }
                    misil += 2;
                    wave = 9;
                    cekwave[7] = 0;
                    cek++;
                    jumlahbarrier++;
                }

                if (cekwave[8] == 15) { //10
                    if (nyawa != 0) {
                        score = score * nyawa;
                    }
                    misil += 2;
                    wave = 10;
                    cekwave[8] = 0;
                    cek++;
                    jumlahbarrier++;
                }
                if (cekwave[9] == 18) { //11
                    if (nyawa != 0) {
                        score = score * nyawa;
                    }
                    misil += 2;
                    wave = 11;
                    cekwave[9] = 0;
                    cek++;
                    jumlahbarrier++;
                    }
//////////////////////////////////////////////////////
                    if (cekwave[10] == 3) { //11 ke 12
                        if (nyawa != 0) {
                            score = score * nyawa;
                        }
                        misil += 2;
                        wave = 12;
                        cekwave[10] = 0;
                        cek++;
                        jumlahbarrier++;
                    }
                    if (cekwave[11] == 7) { //12 ke 13
                        if (nyawa != 0) {
                            score = score * nyawa;
                        }
                        misil += 2;
                        wave = 13;
                        cekwave[11] = 0;
                        cek++;
                        jumlahbarrier++;
                    }
                    if (cekwave[12] == 8) { //14
                        if (nyawa != 0) {
                            score = score * nyawa;
                        }
                        misil += 2;
                        wave = 14;
                        cekwave[12] = 0;
                        cek++;
                        jumlahbarrier++;
                    }
                    if (cekwave[13] == 8) { //15
                        if (nyawa != 0) {
                            score = score * nyawa;
                        }
                        misil += 2;
                        wave = 15;
                        cekwave[13] = 0;
                        cek++;
                        jumlahbarrier++;
                    }
                    if (cekwave[14] == 9) { //16
                        if (nyawa != 0) {
                            score = score * nyawa;
                        }
                        misil += 2;
                        wave = 16;
                        cekwave[14] = 0;
                        cek++;
                        jumlahbarrier++;
                    }
                    if (cekwave[15] == 10) { //17
                        if (nyawa != 0) {
                            score = score * nyawa;
                        }
                        misil += 2;
                        wave = 17;
                        cekwave[15] = 0;
                        cek++;
                        jumlahbarrier++;
                    }
                    if (cekwave[16] == 11) { //18
                        if (nyawa != 0) {
                            score = score * nyawa;
                        }
                        misil += 2;
                        wave = 18;
                        cekwave[16] = 0;
                        cek++;
                        jumlahbarrier++;
                    }
                    if (cekwave[17] == 12) { //19
                        if (nyawa != 0) {
                            score = score * nyawa;
                        }
                        misil += 2;
                        wave = 19;
                        cekwave[17] = 0;
                        cek++;
                        jumlahbarrier++;
                    }

                    if (cekwave[18] == 15) { //20
                        if (nyawa != 0) {
                            score = score * nyawa;
                        }
                        misil += 2;
                        wave = 20;
                        cekwave[18] = 0;
                        cek++;
                        jumlahbarrier++;
                    }
                    missileDesign();


                    if (TEMBAK == 1) {
                    bullet.add(new peluru(xp + 15, yp - 25, 0));
                    TEMBAK = 0;
                    for (peluru i : bullet) {
                        if (i.getPeluruaktif() == 0) {
                            i.setSprite(new JLabel(new ImageIcon("res/foto/unnamed.png")));
                            i.getSprite().setSize(100, 100);
                            i.getSprite().setLocation(i.getPelurux(), i.getPeluruy());
                            this.add(i.getSprite());
                            i.setPeluruaktif(1);
                        }
                    }
                }

                if (TEMBAK == 2) {
                        bullet.add(new peluru(xp + 15, yp - 35, 0));
                        bullet.add(new peluru(xp + 15, yp - 15, 0));
                        bullet.add(new peluru(xp + 15, yp - -5, 0));
                        bullet.add(new peluru(xp + 15, yp - 55, 0));
                        bullet.add(new peluru(xp + 15, yp - -25, 0));
                        TEMBAK = 0;
                        for (peluru i : bullet) {
                            if (i.getPeluruaktif() == 0) {
                                i.setSprite(new JLabel(new ImageIcon("res/foto/unnamed.png")));
                                i.getSprite().setSize(120, 120);
                                i.getSprite().setLocation(i.getPelurux(), i.getPeluruy());
                                this.add(i.getSprite());
                                i.setPeluruaktif(1);
                            }
                        }
                }


                for (Bot i : bots) {

                    int randomizer = rn.nextInt(100) + 1;
                    if (randomizer == 1 || randomizer == 2) {
                        tembakanbot = 1;
                        bulletM.add(new peluruMusuh(i.getXbot() - 50, i.getYbot() - 25, 1));

                    }
                }
                for (peluruMusuh i : bulletM) {
                    if (i.getPeluruaktif() == 1) {
                        i.setPelurux(i.getPelurux() - 15);
                        i.setSprite(new JLabel(new ImageIcon("res/foto/lasergreen.png")));
                        i.getSprite().setSize(100, 100);
                        i.getSprite().setLocation(i.getPelurux(), i.getPeluruy());
                        this.add(i.getSprite());
                        i.setPeluruaktif(0);
                    }
                    if (i.getPeluruaktif() == 0) {
                        i.setPelurux(i.getPelurux() - 15);
                        this.remove(i.getSprite());
                        i.setSprite(new JLabel(new ImageIcon("res/foto/lasergreen.png")));
                        i.getSprite().setSize(100, 100);
                        i.getSprite().setLocation(i.getPelurux(), i.getPeluruy());
                        this.add(i.getSprite());
                        if (only != 2) {
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

                                }
                            }
                        }
                    }
                    if (i.getPelurux() < 15) {
                        i.setPeluruaktif(2);
                    }
                }
                for (peluruMusuh i : bulletM) {
                    if (i.getPeluruaktif() == 2) {
                        this.remove(i.getSprite());
                        bulletM.remove(i);
                        break;
                    }
                }
                if (Start == 0) {
                    for (peluru i : bullet) {
                        this.remove(i.getSprite());
                        i.setSprite(new JLabel(new ImageIcon("res/foto/unnamed.png")));
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
                                score += 2;
                                this.remove(j.getSprite());
                                bots.remove(j);
                                cekwave[cek]++;
                                break;
                            }
                        }
                    }
                    if (cheat == 1) {
                        for (Bot j : bots) {

                            score += 2;
                            this.remove(j.getSprite());
                            bots.remove(j);
                            cekwave[cek]++;
                            break;

                        }
                        cheat = 0;
                    }
                    this.remove(pesawat);
                    pesawat = new JLabel(new ImageIcon("res/foto/hero.png"));
                    pesawat.setSize(50, 50);
                    pesawat.setLocation(xp, yp);
                    this.add(pesawat);
                    this.remove(Background);
                    Background = new JLabel(new ImageIcon("res/foto/bg.png"));
                    Background.setSize(1000, 700);
                    Background.setLocation(0, 0);
                    this.add(Background);
                }
            }
        }
        }

    }

    public void movebos(){
        for (boss i : bos){
            if(atasbawah==0){
                i.setYbos(i.getYbos()+5);
            }
            if(atasbawah==1){
                i.setYbos(i.getYbos()-5);
            }
        }
        for (boss i : bos){
            if(atasbawah==0){
                if(i.getYbos()==200){
                    atasbawah=1;
                }
            }
            if(atasbawah==1){
                if(i.getYbos()==-200){
                    atasbawah=0;
                }
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
        if(yp >= 600) {
            yp=600;
        }
        if(yp <= 20) {
            yp=20;
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
            if (pause == 0){
                moveBot();
                tubruk();
            try {
                sound();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
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

            if (e.getKeyCode() == KeyEvent.VK_F){
                if (misil - 1 >= 0){
                    misil -= 1;
                    if (delayp == 1) {
                        delayp = 0;
                        TEMBAK = 2;
                        shoot = 1;
                }
                    missileDesign();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_K){
                nyawa = 0;
                score *= 2;
                kamikazee = true;
            }

            switch (e.getKeyChar()){
                case 'w':
                    yp-=15;
                    break;
                case 's':
                    yp+=15;
                    break;
                case 'c':
                    if(jumlahbarrier>0){
                        if(only==0){
                            only=1;
                        }
                        jumlahbarrier-= 1;
                    }
                    break;

                case 'd':
                    if(xp<=200){
                        xp+=15;
                    }
                    break;
                case 'a':
                    if(xp>=30){
                        xp-=15;
                    }
                    break;

                case 'x':
                    cheat=1;
                    break;

                case 'p':
                    if(pause==0){
                        pause=1;
                    }else if(pause==1){
                        pause=0;
                    }
                    break;


            }

        }


    }
}