package space.impact.source;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Background {

	// fields
	private BufferedImage image;
	private double x, moveScale, targetx;
	
	public Background(String file, double moveScale) {
		
		x = 0; 
		this.moveScale = moveScale;
		try{
			image = ImageIO.read(new File(file));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update() { 
		x = (targetx - x) * .1;
		if(x > Path.WIDTH) {
			x = 0;
		}
		if(x < -Path.WIDTH) {
			x = 0;
		}
	}
	
	public void draw(Graphics2D g) {
		
		int x = (Path.WIDTH - this.image.getWidth(null)) / 2;
	    int y = (Path.HEIGHT - this.image.getHeight(null)) / 2;
	    g.drawImage(this.image, x, y - 50, null);

	}
	
	public void mouseMoved(int x) {
		targetx = moveScale * x;
	}
}
