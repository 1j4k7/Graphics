import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Jason Kuo
 * 10/23/15
 */
public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private ImageView image = new ImageView(new Image("dota2_io_sticker.png"));
	private double movement = 50;
	
	@Override
	public void start(Stage stage) {
		image.setFitHeight(100);
		image.setFitWidth(100);
		image.setX(200);
		image.setY(200);
		Button left = new Button("Left");
		Button right = new Button("Right");
		Button up = new Button("Up");
		Button down = new Button("Down");
		left.setMinWidth(75);
		right.setMinWidth(75);
		up.setMinWidth(75);
		down.setMinWidth(75);
		left.setOnAction(new LeftEventHandler());
		right.setOnAction(new RightEventHandler());
		up.setOnAction(new UpEventHandler());
		down.setOnAction(new DownEventHandler());
		HBox buttonRow = new HBox(left, right, up, down);
		buttonRow.setSpacing(50);
		buttonRow.setTranslateX(20);
		BorderPane pane = new BorderPane();
		pane.getChildren().add(image);
		pane.setBottom(buttonRow);
		stage.setScene(new Scene(pane, 500, 500));
		stage.setTitle("Movement");
		stage.show();
	}
	
	class LeftEventHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			System.out.println("Left");
			image.setX(image.getX() - movement);
		}
		
	}
	
	class RightEventHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			System.out.println("Right");
			image.setX(image.getX() + movement);
		}
		
	}
	
	class UpEventHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			System.out.println("Up");
			image.setY(image.getY() - movement);
		}
		
	}
	
	class DownEventHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			System.out.println("Down");
			image.setY(image.getY() + movement);
		}
		
	}

}
