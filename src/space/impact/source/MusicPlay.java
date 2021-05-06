package space.impact.source;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlay {
	int clicked=0;
	private File musicPath;
	private AudioInputStream audioInput;
	Clip clip;
	
	public void playMusic(String musicLocation) {
		
		try {
			musicPath = new File(musicLocation);
			
			if(musicPath.exists()) {
				audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			} else {
				System.out.println("Sorry, can't find the music");
			}
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public void stopMusic() {
			clip.stop();
	}
	public void startMusicFromStop() {
			clip.start();
	}
	public void musicLoop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
