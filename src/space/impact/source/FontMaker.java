package space.impact.source;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class FontMaker {
	
	private Font font;
	
	public FontMaker(String fontType) {
		try {
			this.font = Font.createFont(Font.TRUETYPE_FONT, new File(fontType)).deriveFont(50f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontType)));
		} catch (IOException|FontFormatException e) { }
	}

	public Font getFont() {
		return this.font;
	}
	
}
