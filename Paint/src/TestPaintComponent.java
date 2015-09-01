import java.awt.Color;
import java.awt.Graphics;

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
		panel.setBackground(Color.MAGENTA);
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
		g.setColor(Color.RED);
		g.fillOval(140, 43, 92, 21);
		g.setColor(Color.GREEN);
		g.fillRect(392, 400, 10, 40);
		g.setColor(Color.CYAN);
		g.fillRoundRect(14, 370, 200, 40, 20, 20);	
		g.setColor(Color.BLACK);
		g.drawString("An attractive artistic display here", 5, 40);
		g.drawString("I swear it's abstract art", 300, 400);
	}
}