package space.impact.source;

import java.awt.*;

public interface Path {

    // basic attributes
    int WIDTH = 1000;
    int HEIGHT = 700;
    Dimension frameSize = new Dimension(WIDTH, HEIGHT);
    String mainFont = "res/font/nasalization.ttf";

    // button sfx
//    String forwardClick = "res/sound/click_forward.wav";
//    MusicPlay clickForward = new MusicPlay();
//    String backwardClick = "res/sound/click_backward.wav";
//    MusicPlay clickBackward = new MusicPlay();

    // main menu
    String bgMainMenu="res/foto/bg.jpg";
    String mainMenuPath = "res/foto/judul.png";
    String mainMenuMusicPath = "res/sound/ConquerorsOfSpace.wav";
    MusicPlay mainMenuMusic = new MusicPlay();

    // Standard values
//    final int mapRow = 6, mapCol = 5;
//    final int paddleWidth = 100, paddleHeight = 25;

    // instruction mode
    String instructionBgPath = "res/foto/bg_zen.jpg";
    String instructionArrowPath = "res/foto/arrow.png";
    String instructionSkill1Path = "res/foto/kamikaze.png";
    String instructionSkill2Path = "res/foto/bg_zen.jpg";
    String instructionSkill3Path = "res/foto/bg_zen.jpg";
    String instructionMusicPath = "res/sound/ZenMode.wav";
    String instructionBack = "Back";
    MusicPlay instructionMusic = new MusicPlay();

    // level selector
//    String levelLabel = "LEVELS";
//    String lvselBGPath = "res/image/bg_lvselect.jpg";
//    String lvselMusicPath = "res/sound/LevelSelectMusic.wav";
//    MusicPlay lvselMusic = new MusicPlay();

    // normal mode
//    final int timeLimit = 100;
//    String normalButton = "NORMAL";
//    String normalBGPath = "res/image/bg_level.jpg";
//    MusicPlay normalMusic = new MusicPlay();
//    String normalMusicPath = "res/sound/NormalMode.wav";
//    String finalText = "<html><center>Congratulations!<br>"
//            + "You have finished the game!";
//    MusicPlay brickBreak = new MusicPlay();
//    String brickBreakPath = "res/sound/brick-break.wav";

    // credits
//    String creditsText = "<html><center>BRIX<br>"
//            + "by JKDev:<br>"
//            + "PBO - H<br>"
//            + "Jason - 05111940000085<br>"
//            + "Kevin - 05111940000157<br>"
//            + "thanks for playing</center>";
//    MusicPlay creditsMusic = new MusicPlay();
//    String creditsMusicPath = "res/sound/CreditMusic.wav";
}
