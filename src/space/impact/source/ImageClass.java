package space.impact.source;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class ImageClass {

    private static BufferedImage img = null;
    private static double scale;

    public ImageClass(){
        //
    }

    public static Image scaleImage(String path, double perbesaran){
        scale = perbesaran;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int lebar,tinggi;

        lebar = (int) (img.getWidth() * perbesaran);
        tinggi = (int) (img.getHeight() * perbesaran);

        Image dimg = img.getScaledInstance(lebar, tinggi, Image.SCALE_SMOOTH);

        return dimg;
    }

    public static int imgWidth(){
        return (int) (img.getWidth()*scale);
    }

    public static int imgHeight(){
        return (int) (img.getHeight()*scale);
    }
}
