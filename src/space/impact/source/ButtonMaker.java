package space.impact.source;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;

public class ButtonMaker {
	
	private JButton button = new JButton();
	
	public ButtonMaker(String name, Rectangle r) {
		// Set the label and size
		button.setText(name);
		button.setBounds(r);
		// Set the background transparent and the font color
		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFocusable(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
	
	// Return the button
	public JButton getButton() {
		return this.button;
	}
	
}
