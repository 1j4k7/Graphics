import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Jason Kuo
 * 11/05/15
 */
public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private ImageView sun = new ImageView(new Image("dota2_io_sticker.png"));
	private ImageView quas = new ImageView(new Image("Quas.png"));
	private ImageView wex = new ImageView(new Image("Wex.png"));
	private ImageView exort = new ImageView(new Image("Exort.png"));
	
	@Override
	public void start(Stage stage) {
		sun.setFitHeight(100);
		sun.setFitWidth(100);
		sun.setX(200);
		sun.setY(200);
		quas.setFitHeight(50);
		quas.setFitWidth(50);
		wex.setFitHeight(50);
		wex.setFitWidth(50);
		exort.setFitHeight(50);
		exort.setFitWidth(50);
		
		Circle orbit1 = new Circle();
		orbit1.setRotate(-90);
		orbit1.setRadius(100);
		orbit1.setCenterX(250);
		orbit1.setCenterY(250);
		PathTransition path1 = new PathTransition();
		path1.setPath(orbit1);
		path1.setNode(quas);
		path1.setDuration(Duration.seconds(5));
		path1.setCycleCount(Timeline.INDEFINITE);
		
		Circle orbit2 = new Circle();
		orbit2.setRotate(30);
		orbit2.setRadius(100);
		orbit2.setCenterX(250);
		orbit2.setCenterY(250);
		PathTransition path2 = new PathTransition();
		path2.setPath(orbit2);
		path2.setNode(wex);
		path2.setDuration(Duration.seconds(5));
		path2.setCycleCount(Timeline.INDEFINITE);
		
		Circle orbit3 = new Circle();
		orbit3.setRotate(150);
		orbit3.setRadius(100);
		orbit3.setCenterX(250);
		orbit3.setCenterY(250);
		PathTransition path3 = new PathTransition();
		path3.setPath(orbit3);
		path3.setNode(exort);
		path3.setDuration(Duration.seconds(5));
		path3.setCycleCount(Timeline.INDEFINITE);
		
		ComboBox<String> invoke = new ComboBox<String>();
		invoke.setEditable(false);
		invoke.getItems().addAll("Cold Snap", "Ghost Walk", "Tornado", "EMP", "Alacrity", "Chaos Meteor", "Sun Strike", "Forge Spirit", "Ice Wall", "Deafening Blast");
		invoke.setOnAction(e -> {
			switch (invoke.getValue()) {
			case "Cold Snap": 
				path1.setNode(quas);
				path2.setNode(quas);
				path3.setNode(quas);
				break;
			case "Ghost Walk":
				path1.setNode(quas);
				path2.setNode(quas);
				path3.setNode(wex);
				break;
			case "Tornado":
				path1.setNode(wex);
				path2.setNode(wex);
				path3.setNode(quas);
				break;
			case "EMP":
				path1.setNode(wex);
				path2.setNode(wex);
				path3.setNode(wex);
				break;
			case "Alacrity":
				path1.setNode(wex);
				path2.setNode(wex);
				path3.setNode(exort);
				break;
			case "Chaos Meteor":
				path1.setNode(exort);
				path2.setNode(exort);
				path3.setNode(wex);
				break;
			case "Sun Strike":
				path1.setNode(exort);
				path2.setNode(exort);
				path3.setNode(exort);
				break;
			case "Forge Spirit":
				path1.setNode(exort);
				path2.setNode(exort);
				path3.setNode(quas);
				break;
			case "Ice Wall":
				path1.setNode(quas);
				path2.setNode(quas);
				path3.setNode(exort);
				break;
			case "Deafening Blast":
				path1.setNode(quas);
				path2.setNode(wex);
				path3.setNode(exort);
				break;
			default:
				path1.setNode(quas);
				path2.setNode(wex);
				path3.setNode(exort);
				break;
			}
		});
		
		path1.play();
		path2.play();
		path3.play();
		
		Pane pane = new Pane();
		pane.getChildren().addAll(quas, wex, exort, sun, invoke);
		stage.setScene(new Scene(pane, 500, 500));
		stage.setTitle("Spell Combinations");
		stage.show();
	}

}
