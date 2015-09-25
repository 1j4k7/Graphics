import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
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
	}
}

class GeometryPanel extends JPanel {
	
	double angle = 0;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		g2.translate(getWidth()/2, getHeight()/2);
		g2.rotate(angle);
		angle += .01;

		Shape s1 = new Ellipse2D.Double(-getWidth()/2, -getHeight()/2, getWidth(), getHeight());
		Shape r1 = new Rectangle2D.Double(-getWidth()/2, -getHeight()/2, getWidth()/2, getHeight());
		Shape s2 = new Ellipse2D.Double(-getWidth()/4, -getHeight()/2, getWidth()/2, getHeight()/2);
		Shape s3 = new Ellipse2D.Double(-getWidth()/4, 0, getWidth()/2, getHeight()/2);
		
		Shape s4 = new Ellipse2D.Double(-getWidth()/16, getWidth()/4 - getWidth()/32, getWidth()/16, getHeight()/16);
		Shape s5 = new Ellipse2D.Double(-getWidth()/16, getWidth()*3/4 - getWidth()/32, getWidth()/16, getHeight()/16);
		
		Area a1 = new Area(s1);
		Area a2 = new Area(s2);
		Area ar1 = new Area(r1);
		Area a3 = new Area(s3);
		
		Area a4 = new Area(s4);
		Area a5 = new Area(s5);
		
		ar1.intersect(a1);
		ar1.subtract(a3);
		ar1.subtract(a4);
		//a2.subtract(a4);
		
		g2.setColor(Color.RED);
		g2.fill(a1);
		g2.fill(a3);
		//g2.fill(a4);
		g2.setColor(Color.WHITE);
		g2.fill(a2);
		g2.fill(ar1);
		//g2.fill(a5);
		
		Image img = null;
		try {
			img = ImageIO.read(new File("dota2_io_sticker.png"));
		} catch (IOException e) {
			System.exit(0);
		}
		img = img.getScaledInstance(getWidth()/16 + 32, getHeight()/16 + 32, 0);
		g2.rotate(-angle);
		g2.drawImage(img, (int) (getHeight()/4*Math.cos(angle)), (int) (getHeight()/4*Math.sin(angle)), null);
		g2.drawImage(img, (int) (getHeight()/4*Math.cos(angle)), (int) (getHeight()/4*Math.sin(angle)), null);
		repaint();
	}
}