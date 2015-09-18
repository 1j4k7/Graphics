import javax.swing.JFrame;

/**
 * @author Jason Kuo
 * 9/11/2015
 * Main is the class that contains the main method for the Fractals project
 */
public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MandelbrotCanvas panel = new MandelbrotCanvas();
		frame.setTitle("Fractals");
		frame.setSize(417, 453);
		frame.add(panel);
		panel.setSize(500, 500);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}