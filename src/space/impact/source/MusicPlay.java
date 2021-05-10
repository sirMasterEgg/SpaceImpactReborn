package space.impact.source;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

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
			System.out.println("Check: " + musicPath + "\n");
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
	public float getVolume() {
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		return (float) Math.pow(10f, gainControl.getValue() / 20f);
	}
	public void setVolume(float volume) {
		if (volume < 0f || volume > 1f)
			throw new IllegalArgumentException("Volume not valid: " + volume);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(20f * (float) Math.log10(volume));
	}
}
