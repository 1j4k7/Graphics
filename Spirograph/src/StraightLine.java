import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jason Kuo
 * 9/22/15
 * This class draws a graph.
 */
public class StraightLine extends JFrame {
	public StraightLine() {
		setLayout(new BorderLayout());
		PlotFunctions panel = new PlotFunctions();
		panel.setSize(500, 500);
		add(panel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		StraightLine frame = new StraightLine();
		frame.setSize(500, 500);
		frame.setTitle("");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
	}
}

class PlotFunctions extends JPanel {
	double f1(double x) {
		return Math.sin(x);
	}

	double f2(double x) {
		return Math.cos(x);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
	    g2.translate(getWidth()/2, getHeight()/2);
	    g2.rotate(Math.toRadians(180));
	    
	    int leftBorder = -getWidth()/2;
	    int rightBorder = getWidth()/2;

		g.drawLine(leftBorder, 0, rightBorder, 0);
		g.drawLine(0, -getHeight()/2, 0, getHeight()/2);

		Polygon p = new Polygon();

		// Draw cosine function
		g.setColor(Color.BLUE);
		p.reset();
		double scaleFactor = 0.1;
		for (int x = leftBorder; x <= rightBorder; x++) {
			p.addPoint(x, (int) (50*f1(x)));
		}

		g.drawPolygon(p);
	}
}