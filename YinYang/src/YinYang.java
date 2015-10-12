import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jason Kuo
 * 9/22/15
 * This class draws a yin yang symbol.
 */
public class YinYang extends JFrame {
	public YinYang() {
		GeometryPanel panel = new GeometryPanel();
		panel.setSize(900, 900);
		panel.setBackground(Color.BLACK);
		add(panel);
	}

	public static void main(String[] args) {
		YinYang frame = new YinYang();
		frame.setSize(900, 900);
		frame.setTitle("Yin Yang");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
		while (true) {
			frame.repaint();
		}
	}
}

class GeometryPanel extends JPanel {
	
	double angle = 0;
	int side = 800;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		g2.translate(getWidth()/2, getHeight()/2);
		g2.rotate(angle);
		angle += .05;
		side = (int) (Math.abs(800*Math.sin(angle)) + 32);

		Shape s1 = new Ellipse2D.Double(-side/2, -side/2, side, side);
		Shape r1 = new Rectangle2D.Double(-side/2, -side/2, side/2, side);
		Shape s2 = new Ellipse2D.Double(-side/4, -side/2, side/2, side/2);
		Shape s3 = new Ellipse2D.Double(-side/4, 0, side/2, side/2);
		
		Area a1 = new Area(s1);
		Area a2 = new Area(s2);
		Area ar1 = new Area(r1);
		Area a3 = new Area(s3);
		
		ar1.intersect(a1);
		ar1.subtract(a3);
		
		g2.setColor(new Color(200,200, 200));
		g2.fill(a1);
		g2.fill(a3);
		g2.setColor(new Color(100, 0, 0));
		g2.fill(a2);
		g2.fill(ar1);
		
		Image img = null;
		try {
			img = ImageIO.read(new File("dota2_io_sticker.png"));
		} catch (IOException e) {
			System.exit(0);
		}
		img = img.getScaledInstance(side/10, side/10, 0);
		g2.rotate(-angle);
		double rotatedAngle = angle+Math.toRadians(90);
		g2.drawImage(img, (int) (side/4*Math.cos(rotatedAngle) - side/20), (int) (side/4*Math.sin(rotatedAngle) - side/20), null);
		g2.drawImage(img, (int) (-side/4*Math.cos(rotatedAngle) - side/20), (int) (-side/4*Math.sin(rotatedAngle) - side/20), null);
		//repaint();
	}
}