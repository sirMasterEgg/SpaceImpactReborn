package space.impact.source;

import java.awt.*;

public interface Path {

    // basic attributes
    int WIDTH = 1000;
    int HEIGHT = 700;
    Dimension frameSize = new Dimension(WIDTH, HEIGHT);
    String mainFont = "res/font/nasalization.ttf";
    String pixelFont = "res/font/PixelMplus10-Regular.ttf";
    String saveHighscore = "res/highscore.txt";
    String pemisahHighscore = "|";

    // main menu
    String bgMainMenu="res/foto/bg.jpg";
    String mainMenuPath = "res/foto/judul.png";
    String mainMenuMusicPath = "res/sound/ConquerorsOfSpace.wav";
    MusicPlay mainMenuMusic = new MusicPlay();

    // Standard values
//    final int mapRow = 6, mapCol = 5;
//    final int paddleWidth = 100, paddleHeight = 25;

    // instruction mode
    String instructionArrowPath = "res/foto/arrow.png";
    String instructionSkill1Path = "res/foto/dead.png";
    String instructionSkill2Path = "res/foto/launcher.png";
    String instructionSkill3Path = "res/foto/Barrier.png";
    String instructionSkill3Path2 = "res/foto/Barrier2.png";
    String InstructionPausePath = "res/foto/Pause.png";
    String pausePath = "res/foto/pausedGame.png";

    // level selector
//    String levelLabel = "LEVELS";
//    String lvselBGPath = "res/image/bg_lvselect.jpg";
//    String lvselMusicPath = "res/sound/LevelSelectMusic.wav";
//    MusicPlay lvselMusic = new MusicPlay();

    // game mode
    MusicPlay gameMusic = new MusicPlay();
    String gameMusicPath = "res/sound/NintendoRevolution.wav";
}
