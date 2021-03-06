import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jason Kuo
 * 8/31/2015
 * TestPaintComponent paints several objects to a window
 */
public class TestPaintComponent extends JFrame {
	public TestPaintComponent() {
		NewPanel panel = new NewPanel();
		panel.setBackground(Color.WHITE);
		add(panel);
	}

	public static void main(String[] args) {
		TestPaintComponent frame = new TestPaintComponent();
		frame.setTitle("TestPaintComponent");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class NewPanel extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 255; i+=5) {
			g.setColor(new Color(i, 100, 100));
			g.drawOval(22+i, 50, 200, 200);
		}
		g.setColor(Color.LIGHT_GRAY);
		int[] xPoints = {21, 473, 473, 21};
		int[] yPoints = {50, 50, 250, 250};
		g.drawPolygon(xPoints, yPoints, 4);
		Image img = null;
		try {
		    img = ImageIO.read(new File("dota2_io_sticker.png"));
		} catch (IOException e) {
			System.exit(0);
		}
		img = img.getScaledInstance(100, 100, 0);
		g.drawImage(img, -10, 400, null);
		g.setColor(Color.BLACK);
		g.drawString("Colors with IO", 200, 400);
	}
}