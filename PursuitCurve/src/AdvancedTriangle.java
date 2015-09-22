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
 * 9/22/15
 * This class draws a pursuit curve.
 */
public class AdvancedTriangle extends JFrame {
	public AdvancedTriangle() {
		NewPanel panel = new NewPanel();
		panel.setBackground(Color.BLACK);//sets the panel background white
		add(panel);//when the Advanced Triangle class is instantiated, it adds a NewPanel to the frame
	}

	public static void main(String[] args) {
		AdvancedTriangle frame = new AdvancedTriangle();//create a frame
		frame.setTitle("Pursuit Curves");//set the title of the frame
		frame.setSize(500, 500);//set the size of the frame
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//makes sure the frame closes properly
		frame.setVisible(true);//show the frame
	}
}

class NewPanel extends JPanel {
	double maxX, maxY, minMaxXY, xCenter, yCenter;
	
	/**
	 * Initializes all constants
	 */
	void initgr() {
		maxX = getWidth() - 1;//set maxX to the width of the panel - 1
		maxY = getHeight() - 1;//set maxY to the height of the panel - 1
		minMaxXY = Math.min(maxX, maxY);//sets minMaxXY to the shorter side
		xCenter = maxX / 2;//xCenter is halfway to maxX
		yCenter = maxY / 2;//yCenter is halfway to maxY
	}
	
	/**
	 * Rounds from a float to an integer
	 * @param x
	 * @return the rounded integer from x
	 */
	int iX(float x) {
		return Math.round(x);
	}
	
	/**
	 * Rounds from a float to an integer but also returns y from the bottom of the panel
	 * @param yCenter2
	 * @return the rounded integer from y
	 */
	int iY(double yCenter2) {
		return (int) (maxY - Math.round(yCenter2));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		initgr();//initializes the constants
		float side = (float) minMaxXY;//sets the side length of the largest rectangle to fit the screen
		float sideHalf = 0.5F * side;//finds half of the side length
		float h = side;//sets the height of the largest rectangle to the side length
		float q = 0.03F;//q affects how much the points change for each iteration
		float p = 1 - q;//opposite weighting of q
		//A, B, C, and D are the points of the largest rectangle
		float xA = (float) (xCenter - sideHalf);//centers the rectangle horizontally
		float yA = (float) (yCenter - 0.5 * h);//centers the rectangle vertically
		float xB = (float) (xCenter + sideHalf);//centers the rectangle horizontally
		float yB = (float) (yCenter - 0.5 * h);//centers the rectangle vertically
		float xC = (float) (xCenter + sideHalf);//centers the rectangle horizontally
		float yC = (float) (yCenter + 0.5F * h);//centers the rectangle vertically
		float xD = (float) (xCenter - sideHalf);//centers the rectangle horizontally
		float yD = (float) (yCenter + 0.5F * h);//centers the rectangle vertically
		Image img = null;
		try {
		    img = ImageIO.read(new File("dota2_io_sticker.png"));
		} catch (IOException e) {
			System.exit(0);
		}
		img = img.getScaledInstance(100, 100, 0);
		g.drawImage(img, iX((float) (xCenter - 50)), iY((float)(yCenter + 50)), null);
		for (int i = 0; i < 60; i++) {
			g.setColor(new Color((int) (Math.abs(Math.sin((double)i/50) * 100)) + 100, 100, 50));//sets the colors to random colors
			//connects the points of the rectangle
			g.drawLine(iX(xA), iY(yA), iX(xB), iY(yB));
			g.drawLine(iX(xB), iY(yB), iX(xC), iY(yC));
			g.drawLine(iX(xC), iY(yC), iX(xD), iY(yD));
			g.drawLine(iX(xD), iY(yD), iX(xA), iY(yA));
			//rotates and shrinks the rectangle
			float xA1 = p * xA + q * xB;
			float yA1 = p * yA + q * yB;
			float xB1 = p * xB + q * xC;
			float yB1 = p * yB + q * yC;
			float xC1 = p * xC + q * xD;
			float yC1 = p * yC + q * yD;
			float xD1 = p * xD + q * xA;
			float yD1 = p * yD + q * yA;
			xA = xA1;
			xB = xB1;
			xC = xC1;
			xD = xD1;
			yA = yA1;
			yB = yB1;
			yC = yC1;
			yD = yD1;
		}
		//A, B, C, and D are the points of the largest rectangle
		xA = (float) (xCenter + sideHalf);//centers the rectangle horizontally
		yA = (float) (yCenter - 0.5 * h);//centers the rectangle vertically
		xB = (float) (xCenter - sideHalf);//centers the rectangle horizontally
		yB = (float) (yCenter - 0.5 * h);//centers the rectangle vertically
		xC = (float) (xCenter - sideHalf);//centers the rectangle horizontally
		yC = (float) (yCenter + 0.5F * h);//centers the rectangle vertically
		xD = (float) (xCenter + sideHalf);//centers the rectangle horizontally
		yD = (float) (yCenter + 0.5F * h);//centers the rectangle vertically
		for (int i = 0; i < 60; i++) {
			g.setColor(new Color(75, (int) (Math.abs(Math.sin((double)i/20) * 20)) + 140, 175));//sets the colors to random colors
			//connects the points of the rectangle
			g.drawLine(iX(xA), iY(yA), iX(xB), iY(yB));
			g.drawLine(iX(xB), iY(yB), iX(xC), iY(yC));
			g.drawLine(iX(xC), iY(yC), iX(xD), iY(yD));
			g.drawLine(iX(xD), iY(yD), iX(xA), iY(yA));
			//rotates and shrinks the rectangle
			float xA1 = p * xA + q * xB;
			float yA1 = p * yA + q * yB;
			float xB1 = p * xB + q * xC;
			float yB1 = p * yB + q * yC;
			float xC1 = p * xC + q * xD;
			float yC1 = p * yC + q * yD;
			float xD1 = p * xD + q * xA;
			float yD1 = p * yD + q * yA;
			xA = xA1;
			xB = xB1;
			xC = xC1;
			xD = xD1;
			yA = yA1;
			yB = yB1;
			yC = yC1;
			yD = yD1;
		}
		//g.setColor(Color.WHITE);
		//g.drawString("Trippiness Intensifies", iX((float) xCenter), iY(yCenter));
	}
}