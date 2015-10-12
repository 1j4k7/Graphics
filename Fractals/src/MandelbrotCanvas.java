import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Jason Kuo
 * 9/11/2015
 * MandelbrotCanvas is the class that draws the Mandelbrot fractals to the screen.
 */
class MandelbrotCanvas extends JPanel {
	
	final static int COUNT_LIMIT = 60; 

	@Override 
	/** Paint a Mandelbrot image */ 
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		for (double x = -2.0; x < 2.0; x += 0.01)
			for (double y = -2.0; y < 2.0; y += 0.01) { 
				int c = count(new Complex(x, y)); 
				if (c == COUNT_LIMIT) 
					g.setColor(Color.BLACK); // c is in a Mandelbrot set
				else
					g.setColor(new Color(c * 196 % 255, c * 92 % 255, c * 24 % 255)); 
				g.drawRect((int) (x * 100) + 200, (int) (y * 100) + 200, 1, 1); // Fill a tiny rectangle with a specified color.  
			}
		Image img = null;
		try {
		    img = ImageIO.read(new File("dota2_io_sticker.png"));
		} catch (IOException e) {
			System.exit(0);
		}
		img = img.getScaledInstance(100, 100, 0);
		g.drawImage(img, 130, 150, null);
	} 

	/** Returns the iteration count */
	static int count(Complex c) { 
		Complex z = new Complex(0, 0); // z0
		for (int i = 0; i < COUNT_LIMIT; i++) {
			z = z.times(z).add(c); // Get z1, z2, ...
			if (z.abs() > 2)
				return i; // The sequence is unbounded
		}
		return COUNT_LIMIT; // Indicates a bounded sequence 
	}
}