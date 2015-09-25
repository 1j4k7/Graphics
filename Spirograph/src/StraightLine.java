import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jason Kuo
 * 9/22/15
 * This class draws a graph.
 */
public class StraightLine extends JFrame {
	public StraightLine() {
		PlotFunctions panel = new PlotFunctions();
		panel.setSize(900, 900);
		panel.setBackground(Color.BLACK);
		add(panel);
	}

	public static void main(String[] args) {
		StraightLine frame = new StraightLine();
		frame.setSize(900, 900);
		frame.setTitle("Spirograph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
	}
}

class PlotFunctions extends JPanel {
	
	public double R = 50;
	public double r = 92;
	public double a = 100;
	
	double sin(double x) {
		return Math.sin(x);
	}

	double cos(double x) {
		return Math.cos(x);
	}
	
	double spiroX(double t) {
		return (R+r)*cos(t) + a*cos((R+r)*(t/r));
	}
	
	double spiroY(double t) {
		return (R+r)*sin(t) + a*sin((R+r)*(t/r));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
	    g2.translate(getWidth()/2, getHeight()/2);
	    
	    Image img = null;
		try {
			img = ImageIO.read(new File("dota2_io_sticker.png"));
		} catch (IOException e) {
			System.exit(0);
		}
		img = img.getScaledInstance(100, 100, 0);
		g.drawImage(img, -50, -50, null);
		
	    g2.rotate(Math.toRadians(180));

		Polygon p = new Polygon();
		
		p.reset();
		for (double t = -1000 * Math.PI; t <= 1000 * Math.PI; t+=.1) {
			p.addPoint((int) spiroX(t), (int) spiroY(t));
			t += .1;
		}
		g.setColor(Color.RED);
		g.drawPolygon(p);
	}
}