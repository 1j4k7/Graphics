import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		ImageView image1 = new ImageView(new Image("dota2_io_sticker.png"));
		image1.setFitHeight(400);
		image1.setFitWidth(400);
		ImageView image2 = new ImageView(new Image("io2.jpg"));
		image2.setFitHeight(400);
		image2.setFitWidth(400);
		ImageView image3 = new ImageView(new Image("io3.png"));
		image3.setFitHeight(400);
		image3.setFitWidth(400);
		ImageView image4 = new ImageView(new Image("io4.png"));
		image4.setFitHeight(400);
		image4.setFitWidth(400);
		GridPane gridPane = new GridPane();
		gridPane.add(image1, 0, 0);
		gridPane.add(image2, 0, 1);
		gridPane.add(image3, 1, 0);
		gridPane.add(image4, 1, 1);
		Scene scene = new Scene(gridPane, 800, 800);
		stage.setScene(scene);
		stage.setTitle("IO.jpg.html.wav.png");
		stage.show();
	}

}
