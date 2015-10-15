import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		ImageView image = new ImageView(new Image("dota2_io_sticker.png"));
		image.setFitHeight(50);
		image.setFitWidth(50);
		image.setX(250);
		image.setY(250);
		Button left = new Button("Left");
		Button right = new Button("Right");
		Button up = new Button("Up");
		Button down = new Button("Down");
		Pane pane = new Pane(image, left, right, up, down);
		stage.setScene(new Scene(pane, 500, 500));
		stage.setTitle("Tether");
		stage.show();
	}

}
