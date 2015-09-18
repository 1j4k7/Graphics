import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Jason Kuo
 * 9/4/2015
 * GraphicsPanel is a subclass of JPanel that draws all the graphics
 */
public class GraphicsPanel extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Clock clock = new Clock();
		int xCenter = 250;
		int yCenter = 250;
		int circleRadius = 200;
		Image img = null;
		try {
		    img = ImageIO.read(new File("dota2_io_sticker.png"));
		} catch (IOException e) {
			System.exit(0);
		}
		img = img.getScaledInstance(2*circleRadius, 2*circleRadius, 0);
		g.drawImage(img, xCenter - circleRadius, yCenter - circleRadius, null);
		g.drawOval(xCenter - circleRadius, yCenter - circleRadius, 2*circleRadius, 2*circleRadius);
		int i = 3;
		for (int angleDegrees = 0; angleDegrees < 360; angleDegrees += 30) {
			double angle = Math.toRadians(angleDegrees);
			int x1 = (int)(circleRadius*Math.cos(angle) + xCenter);
			int y1 = (int)(circleRadius*-Math.sin(angle) + yCenter);
			int x2 = (int)(180*Math.cos(angle) + xCenter);
			int y2 = (int)(180*-Math.sin(angle) + yCenter);
			g.drawLine(x1, y1, x2, y2);
			g.drawString(""+i, (int)(165*Math.cos(angle) + xCenter - 3), (int)(165*-Math.sin(angle) + yCenter + 3));
			i--;
			if (i == 0) i = 12;
		}
		for (int angleDegrees = 0; angleDegrees < 360; angleDegrees += 6) {
			double angle = Math.toRadians(angleDegrees);
			int x1 = (int)(circleRadius*Math.cos(angle) + xCenter);
			int y1 = (int)(circleRadius*-Math.sin(angle) + yCenter);
			int x2 = (int)(190*Math.cos(angle) + xCenter);
			int y2 = (int)(190*-Math.sin(angle) + yCenter);
			g.drawLine(x1, y1, x2, y2);
		}
		double angleHour = Math.toRadians(((clock.getHours()+9)%12)*30);
		int xHour = (int) (100*Math.cos(angleHour) + xCenter);
		int yHour = (int) (100*Math.sin(angleHour) + yCenter);
		g.drawLine(xHour, yHour, xCenter, yCenter);
		double angleMinute = Math.toRadians(((clock.getMinutes()+45)%60)*6);
		int xMinute = (int) (175*Math.cos(angleMinute) + xCenter);
		int yMinute = (int) (175*Math.sin(angleMinute) + yCenter);
		g.drawLine(xMinute, yMinute, xCenter, yCenter);
		double angleSecond = Math.toRadians(((clock.getSeconds()+45)%60)*6);
		int xSecond = (int) (125*Math.cos(angleSecond) + xCenter);
		int ySecond = (int) (125*Math.sin(angleSecond) + yCenter);
		g.setColor(Color.RED);
		g.drawLine(xSecond, ySecond, xCenter, yCenter);
		g.setColor(Color.BLACK);
		String hours = clock.getHour_of_day()+"";
		if (Integer.parseInt(hours) < 10) hours = "0"+hours;
		String minutes = clock.getMinutes()+"";
		if (Integer.parseInt(minutes) < 10) minutes = "0"+minutes;
		String seconds = clock.getSeconds()+"";
		if (Integer.parseInt(seconds) < 10) seconds = "0"+seconds;
		g.drawString(hours+":"+minutes+":"+seconds, 230, 480);
	}
}
