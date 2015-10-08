import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jason Kuo
 * 10/3/15
 * This class draws two Vengeful Spirits, one using the even-odd winding rule
 * and one with the non-zero winding rule. The even-odd winding rule checks if
 * a point is within the region defined by a path by drawing a line through the point.
 * If the line has an odd number of crossings, it is in the region. If it has an even number,
 * it is outside the region. The non-zero rule also draws a line. There is also a winding number
 * that starts at zero. When the line crosses the path in a certain direction, the winding
 * number is incremented. It is decremented when the line crosses in the opposite direction.
 * If the winding number is not equal to zero, it is in the region. 
 * It also draws two six sided stars, one using the even-odd rule and one using the
 * non-zero rule.
 */
public class WindingPath extends JFrame {
	public WindingPath() {
		NewPanel panel = new NewPanel();
		panel.setBackground(Color.BLACK);
		add(panel);
	}

	public static void main(String[] args) {
		WindingPath frame = new WindingPath();
		frame.setTitle("Winding Paths");
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
		
		Graphics2D G2D = (Graphics2D) g;
		
		GeneralPath leftArmor = new GeneralPath();
		leftArmor.moveTo(50.0f, 50.0f);
		leftArmor.lineTo(60.0f, 100.0f);
		leftArmor.lineTo(100.0f, 150.0f);
		leftArmor.lineTo(90.0f, 100.0f);
		leftArmor.lineTo(80.0f, 50.0f);
		leftArmor.lineTo(80.0f, 90.0f);
		leftArmor.closePath();
		
		GeneralPath centerPlate = new GeneralPath();
		centerPlate.moveTo(100.0f, 50.0f);
		centerPlate.quadTo(120.0f, 75.0f, 120.0f, 100.0f);
		centerPlate.lineTo(112.0f, 98.0f);
		centerPlate.lineTo(125.0f, 115.0f);
		centerPlate.lineTo(135.0f, 102.0f);
		centerPlate.lineTo(130.0f, 100.0f);
		centerPlate.quadTo(137.0f, 80.0f, 130.0f, 50.0f);
		centerPlate.quadTo(132.0f, 80.0f, 126.0f, 85.0f);
		centerPlate.quadTo(110.0f, 60.0f, 100.0f, 50.0f);
		
		GeneralPath rightArmor = new GeneralPath();
		rightArmor.moveTo(145.0f, 125.0f);
		rightArmor.quadTo(140.0f, 140.0f, 130.0f, 150.0f);
		rightArmor.quadTo(137.0f, 155.0f, 135.0f, 165.0f);
		rightArmor.closePath();
		
		GeneralPath face = new GeneralPath();
		face.moveTo(90.0f, 110.0f);
		face.quadTo(125.0f,70.0f, 148.0f, 105.0f);
		face.lineTo(145.0f, 125.0f);
		face.quadTo(140.0f, 140.0f, 130.0f, 150.0f);
		face.lineTo(118.0f, 160.0f);
		face.quadTo(113.0f, 163.0f, 108.0f, 155.0f);
		face.lineTo(90.0f,140.0f);
		face.closePath();
		
		GeneralPath leftEye = new GeneralPath();
		leftEye.moveTo(102.0f, 115.0f);
		leftEye.quadTo(108.0f, 112.0f, 115.0f, 120.0f);
		leftEye.quadTo(105.0f, 125.0f, 102.0f, 115.0f);
		
		GeneralPath rightEye = new GeneralPath();
		rightEye.moveTo(130.0f, 120.0f);
		rightEye.quadTo(134.0f, 116.0f, 143.0f, 115.0f);
		rightEye.curveTo(138.0f, 125.0f, 133.0f, 119.0f, 130.0f, 120.0f);
		
		GeneralPath hair = new GeneralPath();
		hair.moveTo(90.0f, 110.0f);
		hair.quadTo(50.0f, 60.0f, 25.0f, 45.0f);
		hair.quadTo(100.0f, 30.0f, 148.0f, 105.0f);
		
		GeneralPath path = new GeneralPath();
		path.moveTo(50.0f, 50.0f);
		path.lineTo(100.0f, 50.0f);
		path.lineTo(75.0f, 80.0f);
		path.closePath();
		path.moveTo(75.0f, 40.0f);
		path.lineTo(100.0f, 70.0f);
		path.lineTo(50.0f, 70.0f);
		path.closePath();

		hair.setWindingRule(GeneralPath.WIND_EVEN_ODD);
		G2D.setColor(new Color(230, 230, 255));
		G2D.draw(hair);
		G2D.fill(hair);
		
		face.setWindingRule(GeneralPath.WIND_EVEN_ODD);
		G2D.setColor(new Color(200, 200, 255));
		G2D.draw(face);
		G2D.fill(face);
		
		leftEye.setWindingRule(GeneralPath.WIND_EVEN_ODD);
		G2D.setColor(Color.BLACK);
		G2D.draw(leftEye);
		G2D.setColor(new Color(255, 50, 130));
		G2D.fill(leftEye);
		
		rightEye.setWindingRule(GeneralPath.WIND_EVEN_ODD);
		G2D.setColor(Color.BLACK);
		G2D.draw(rightEye);
		G2D.setColor(new Color(255, 50, 130));
		G2D.fill(rightEye);
		
		leftArmor.setWindingRule(GeneralPath.WIND_EVEN_ODD);
		G2D.setColor(Color.WHITE);
		G2D.draw(leftArmor);
		G2D.setColor(new Color(0, 30, 80));
		G2D.fill(leftArmor);
		
		centerPlate.setWindingRule(GeneralPath.WIND_EVEN_ODD);
		G2D.setColor(Color.WHITE);
		G2D.draw(centerPlate);
		G2D.setColor(new Color(0, 30, 80));
		G2D.fill(centerPlate);
		
		rightArmor.setWindingRule(GeneralPath.WIND_EVEN_ODD);
		G2D.setColor(Color.WHITE);
		G2D.draw(rightArmor);
		G2D.setColor(new Color(0, 30, 80));
		G2D.fill(rightArmor);
		
		G2D.setColor(Color.WHITE);
		G2D.drawString("Even-Odd", 75, 190);
		G2D.drawString("Even-Odd", 75, 250);
		
		Image img = null;
		try {
			img = ImageIO.read(new File("dota2_io_sticker.png"));
		} catch (IOException e) {
			System.exit(0);
		}
		img = img.getScaledInstance(100, 100, 0);
		G2D.drawImage(img, getWidth()/2 - 50, getHeight()*3/4 - 50, null);
		G2D.drawString("? ? ?", getWidth()/2 - 10, getHeight()*3/4 - 60);
		
		G2D.translate(300, 0);
		
		hair.setWindingRule(GeneralPath.WIND_NON_ZERO);
		G2D.setColor(new Color(230, 230, 255));
		G2D.draw(hair);
		G2D.fill(hair);
		
		face.setWindingRule(GeneralPath.WIND_NON_ZERO);
		G2D.setColor(new Color(200, 200, 255));
		G2D.draw(face);
		G2D.fill(face);
		
		leftEye.setWindingRule(GeneralPath.WIND_NON_ZERO);
		G2D.setColor(Color.BLACK);
		G2D.draw(leftEye);
		G2D.setColor(new Color(255, 50, 130));
		G2D.fill(leftEye);
		
		rightEye.setWindingRule(GeneralPath.WIND_NON_ZERO);
		G2D.setColor(Color.BLACK);
		G2D.draw(rightEye);
		G2D.setColor(new Color(255, 50, 130));
		G2D.fill(rightEye);
		
		leftArmor.setWindingRule(GeneralPath.WIND_NON_ZERO);
		G2D.setColor(Color.WHITE);
		G2D.draw(leftArmor);
		G2D.setColor(new Color(0, 30, 80));
		G2D.fill(leftArmor);
		
		centerPlate.setWindingRule(GeneralPath.WIND_NON_ZERO);
		G2D.setColor(Color.WHITE);
		G2D.draw(centerPlate);
		G2D.setColor(new Color(0, 30, 80));
		G2D.fill(centerPlate);
		
		rightArmor.setWindingRule(GeneralPath.WIND_NON_ZERO);
		G2D.setColor(Color.WHITE);
		G2D.draw(rightArmor);
		G2D.setColor(new Color(0, 30, 80));
		G2D.fill(rightArmor);
		
		G2D.setColor(Color.WHITE);
		G2D.drawString("Non-Zero", 75, 190);
		G2D.drawString("Non-Zero", 75, 250);
		
		G2D.translate(-300, 300);
		
		path.setWindingRule(GeneralPath.WIND_EVEN_ODD);
		G2D.setColor(Color.RED);
		G2D.draw(path);
		G2D.setColor(Color.CYAN);
		G2D.fill(path);
		G2D.translate(300, 0);
		path.setWindingRule(GeneralPath.WIND_NON_ZERO);
		G2D.setColor(Color.RED);
		G2D.draw(path);
		G2D.setColor(Color.CYAN);
		G2D.fill(path);

	}
}
