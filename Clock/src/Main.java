import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jason Kuo
 * 9/4/2015
 * Main is the class that contains the main method for the Clock project
 */
public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		GraphicsPanel panel = new GraphicsPanel();
		frame.setTitle("Clock");
		frame.setSize(518, 555);
		frame.add(panel);
		panel.setSize(500, 500);
		panel.setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		while(true) {
			panel.repaint();
		}
	}

}