import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Jason Kuo
 * 11/3/15
 */
public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private ImageView io = new ImageView(new Image("dota2_io_sticker.png"));
	private ImageView dolla = new ImageView(new Image("DollaMan.png"));
	private ImageView axe = new ImageView(new Image("Berserker's Call.png"));
	
	@Override
	public void start(Stage stage) {
		io.setFitHeight(300);
		io.setFitWidth(300);
		io.setX(100);
		io.setY(100);
		dolla.setFitHeight(300);
		dolla.setFitWidth(300);
		dolla.setX(100);
		dolla.setY(100);
		axe.setFitHeight(600);
		axe.setFitWidth(600);
		axe.setX(-50);
		axe.setY(-50);
		
		RadioButton rb1 = new RadioButton("Nope.avi");
		RadioButton rb2 = new RadioButton("Some rat");
		RadioButton rb3 = new RadioButton("Chop Chop");
		ToggleGroup group = new ToggleGroup();
		rb1.setToggleGroup(group);
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		
		Pane pane = new Pane();
		
		rb1.setOnAction(e -> {
			if (rb1.isSelected()) {
				pane.getChildren().removeAll(io, dolla, axe);
				pane.getChildren().add(io);
			}
		});
		rb2.setOnAction(e -> {
			if (rb2.isSelected()) {
				pane.getChildren().removeAll(io, dolla, axe);
				pane.getChildren().add(dolla);
			}
		});
		rb3.setOnAction(e -> {
			if (rb3.isSelected()) {
				pane.getChildren().removeAll(io, dolla, axe);
				pane.getChildren().add(axe);
			}
		});
		
		HBox buttonPane = new HBox(30);
		buttonPane.getChildren().addAll(rb1, rb2, rb3);
		buttonPane.setTranslateX(100);
		buttonPane.setTranslateY(470);
		Pane mainPane = new Pane();
		mainPane.getChildren().addAll(pane, buttonPane);
		stage.setScene(new Scene(mainPane, 500, 500));
		stage.setTitle("You have Options...");
		stage.show();
	}

}
